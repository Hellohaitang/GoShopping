package com.hsy.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsy.db.DBConnection;

/**
 * 执行sql语句的类
 * 
 * @author haitang
 *
 */
public class DaoHandel {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;

	/**
	 * 执行DML操作
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	public static int executeDML(String sql, Object[] parameters) {

		int count = -1;
		// 得到数据库连接对象
		connection = DBConnection.getConnection();
		if (null != connection) {
			try {
				// 初始化preparedStatement对象
				initPreparedStatement(sql, parameters);
				// 执行sql语句
				count = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBConnection.closeAll(connection, preparedStatement, resultSet);
			}
		}
		return count;
	}

	/**
	 * 查询获取单个对象
	 * 
	 * @param sql
	 * @param parameters
	 * @param objectClass
	 * @return
	 */
	public static <T> T executeQueryForSingle(String sql, Object[] parameters, Class<T> objectClass) {
		T t = null;

		// 得的到数据库连接对象
		connection = DBConnection.getConnection();

		if (null != connection) {
			try {
				// 初始化preparedStatement对象
				initPreparedStatement(sql, parameters);

				// 执行sql语句
				resultSet = preparedStatement.executeQuery();
				// 得到数据元对象
				ResultSetMetaData metaData = resultSet.getMetaData();

				// 得到所有的字段名
				String[] columnNames = getColumnNames(metaData);
				// 得到所有的方法
				Method[] methods = objectClass.getDeclaredMethods();
				while (resultSet.next()) {
					// 将查询的结果保存在实体类中
					t=initEntity(objectClass, columnNames, methods);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} finally {
				DBConnection.closeAll(connection, preparedStatement, resultSet);
			}
		}

		return t;
	}

	/**
	 * 查询表中所有的记录
	 * 
	 * @param sql
	 * @param parameters
	 * @param objectClass
	 * @return
	 */
	public static <T> List<T> executeQueryForAll(String sql, Object[] parameters, Class<T> objectClass) {

		List<T> list = new ArrayList<>();
		// 得的到数据库连接对象
		connection = DBConnection.getConnection();

		if (null != connection) {
			try {
				// 初始化preparedStatement对象
				initPreparedStatement(sql, parameters);
				// 执行sql语句
				resultSet = preparedStatement.executeQuery();
				// 得到数据元对象
				ResultSetMetaData metaData = resultSet.getMetaData();

				// 得到所有的字段名
				String[] columnNames = getColumnNames(metaData);
				// 得到所有的方法
				Method[] methods = objectClass.getDeclaredMethods();
				while (resultSet.next()) {
					T t = null;
					// 将查询的结果保存在实体类中
					t=initEntity(objectClass, columnNames, methods);
					list.add(t);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} finally {
				DBConnection.closeAll(connection, preparedStatement, resultSet);
			}
		}
		return list;
	}

	/**
	 * 查询有多少条语句
	 * @param sql
	 * @param parameters
	 * @return
	 */
	public static  int executeQueryForCount(String sql, Object[] parameters) {

		int count = 0;
		// 得的到数据库连接对象
		connection = DBConnection.getConnection();
		if (null != connection) {
			try {
				// 初始化preparedStatement对象
				initPreparedStatement(sql, parameters);
				// 执行sql语句
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					//得到多少条数据
					count = resultSet.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBConnection.closeAll(connection, preparedStatement, resultSet);
			}
		}
		return count;
	}

	/**
	 * 将查询到的数据保存到实体类中
	 * @param objectClass
	 * @param columnNames
	 * @param methods
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	private static <T> T initEntity(Class<T> objectClass, String[] columnNames, Method[] methods)
			throws InstantiationException, IllegalAccessException, SQLException, IllegalArgumentException,
			InvocationTargetException {

		// 得到实体类对象
		T t = objectClass.newInstance();
		for (int i = 0; i < columnNames.length; i++) {
			// 获取每一列的值
			Object value = null;
			value = resultSet.getObject(i + 1);
			for (Method m : methods) {
				if (null != value) {
					if (m.getName().equalsIgnoreCase("set" + columnNames[i])) {
						// 调用set方法
						m.invoke(t, value);
					}
				}
			}
		}
		return t;
	}

	/**
	 * 初始化PreparedStatement对象,并注入参数
	 * 
	 * @param sql
	 * @param parameters
	 * @throws SQLException
	 */
	private static void initPreparedStatement(String sql, Object[] parameters) throws SQLException {
		// 得到处理器
		preparedStatement = connection.prepareStatement(sql);

		// 注入参数
		if (parameters != null) {
			for (int i = 0; i < parameters.length; i++) {
				preparedStatement.setObject(i + 1, parameters[i]);
			}
		}
	}

	/**
	 * 得到表所有字段的名字
	 * 
	 * @param metaData
	 * @return
	 */
	private static String[] getColumnNames(ResultSetMetaData metaData) {
		String[] columnNames = null;
		try {
			// 获取有多少列
			int columnCount = metaData.getColumnCount();
			columnNames = new String[columnCount];

			for (int i = 0; i < columnCount; i++) {
				columnNames[i] = splitUnderline(metaData.getColumnName(i + 1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return columnNames;
	}

	/**
	 * 将下划线类型的字段转换成驼峰类型
	 * 
	 * @param columnName
	 * @return
	 */
	// private static String changeUnderlineToHump(String columnName) {
	//
	// for (int i = 0; i < columnName.length(); i++) {
	// char c = columnName.charAt(i);
	// if (c == '_') {
	// char ch = (char) (columnName.charAt(i + 1) - 32);
	// columnName = columnName.substring(0, i) + ch + columnName.substring(i +
	// 2, columnName.length());
	// i++;
	// }
	// }
	// return columnName;
	// }

	/**
	 * 删除掉所有的下划线
	 * 
	 * @param columnName
	 * @return
	 */
	private static String splitUnderline(String columnName) {
		String[] part = columnName.split("[_]");
		columnName = "";
		for (int i = 0; i < part.length; i++) {
			columnName += part[i];
		}
		return columnName;
	}
}
