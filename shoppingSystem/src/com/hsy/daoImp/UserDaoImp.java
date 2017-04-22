package com.hsy.daoImp;

import java.util.Date;
import java.util.List;

import com.hsy.beanFactory.BeanFactory;
import com.hsy.dao.UserDao;
import com.hsy.entity.User;
import com.hsy.utils.DaoHandel;
import com.hsy.utils.Singleton;

public class UserDaoImp implements UserDao{

	@Override
	public boolean insert(User entity) {
		boolean flag=false;
		String insertSql="insert into user values(?,?,?,?,?)";
		Object[] parameters=new Object[] {null,entity.getName(),entity.getPhone(),entity.getPassword(),entity.getCreateTime()};
		flag=DaoHandel.executeDML(insertSql, parameters)>0?true:false;
		return flag;
	}

	@Override
	public boolean deleteById(Object id) {
		boolean flag=false;
		String deleteSql="delete from user where user_id=?";
		Object[] parameters=new Object[]{id};
		flag=DaoHandel.executeDML(deleteSql, parameters)>0?true:false;
		return flag;
	}

	@Override
	public User selectById(Object id) {
		String selectSql="select *from user where user_id=?";
		Object[] parameters=new Object[]{id};
		User user=DaoHandel.executeQueryForSingle(selectSql, parameters,User.class);
		return user;
	}

	@Override
	public List<User> selectAll() {
		String selectSql="select *from user";
		List<User> list=DaoHandel.executeQueryForAll(selectSql,null,User.class);
		return list;
	}
	
	/**
	 * 根据用户名得到该用户
	 * @param name
	 * @return
	 */
	public User login(String name){
		String selectSql="select *from user where name=?";
		Object[] parameters=new Object[]{name};
		User user=DaoHandel.executeQueryForSingle(selectSql, parameters,User.class);
		return user;
	}
}
