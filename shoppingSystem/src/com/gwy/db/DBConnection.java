package com.gwy.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {

	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	/**
	 * 防止对象在类外被创建
	 */
	private DBConnection() {
	}
	/**
	 * 加载数据库配置参数
	 */
	static {
		Properties properties = new Properties();
		try {
			String path=DBConnection.class.getClassLoader().getResource("db.properties").getPath();
			properties.load(new FileInputStream(path));
			driver = properties.getProperty("jdbc.driver");
			url = properties.getProperty("jdbc.url");
			user = properties.getProperty("jdbc.user");
			password = properties.getProperty("jdbc.password");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 得到数据库连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 关闭数据库连接
	 */
	public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
		
		if (null != resultSet) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resultSet=null;
		}
		
		if (null != statement) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			statement=null;
		}
		if (null != connection) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = null;
		}
	}

}
