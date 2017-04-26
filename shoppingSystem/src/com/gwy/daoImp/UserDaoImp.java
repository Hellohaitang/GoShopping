package com.gwy.daoImp;

import java.util.List;

import com.gwy.dao.UserDao;
import com.gwy.entity.User;
import com.gwy.utils.DaoHandel;

public class UserDaoImp implements UserDao{
	
	/**
	 * 将用户得信息插入到数据库
	 */
	@Override
	public int insert(User entity) {
		String insertSql="insert into user values(?,?,?,?,?)";
		Object[] parameters=new Object[] {null,entity.getName(),entity.getPhone(),entity.getPassword()};
		int flag=DaoHandel.executeDML(insertSql, parameters);
		return flag;
	}
	
	/**
	 * 根据用户的id，删除用户的信息
	 */
	@Override
	public int  deleteById(Object id) {
		String deleteSql="delete from user where user_id=?";
		Object[] parameters=new Object[]{id};
		int flag=DaoHandel.executeDML(deleteSql, parameters);
		return flag;
	}
	
	/**
	 * 根据用户的id,查询用户的信息
	 */
	@Override
	public User selectById(Object id) {
		String selectSql="select *from user where user_id=?";
		Object[] parameters=new Object[]{id};
		User user=DaoHandel.executeQueryForSingle(selectSql, parameters,User.class);
		return user;
	}
	
	/**
	 * 查询所有的用户
	 */
	@Override
	public List<User> selectAll() {
		String selectSql="select *from user";
		List<User> list=DaoHandel.executeQueryForAll(selectSql,null,User.class);
		return list;
	}
	
	/**
	 * 根据用户注册的手机号码得到用户的信息
	 * @param name
	 * @return
	 */
	public User login(String phone){
		String selectSql="select *from user where phone=?";
		Object[] parameters=new Object[]{phone};
		User user=DaoHandel.executeQueryForSingle(selectSql, parameters,User.class);
		return user;
	}
	
	/**
	 * 修改用户的信息
	 */
	@Override
	public int updateUser(User user) {
		String updateSql="update user set name=?,password=?,phone=? where user_id=?";
		Object[] parameters=new Object[]{user.getName(),user.getPassword(),user.getPhone(),user.getUserId()};
		int flag=DaoHandel.executeDML(updateSql, parameters);
		return flag;
	}
	/**
	 * 查询用户名是否已被注册
	 */
	@Override
	public User checkByName(String name) {
		String selectSql="select *from user where name=?";
		Object[] parameters=new Object[]{name};
		User user=DaoHandel.executeQueryForSingle(selectSql, parameters,User.class);
		return user;
	}
}
