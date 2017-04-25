package com.hsy.dao;

import com.hsy.base.BaseDao;
import com.hsy.entity.User;

public interface UserDao extends BaseDao<User>{

	/**
	 * 根据用户名得到该用户
	 * @param name
	 * @return
	 */
	 User login(String name);
	 
	 /**
	  * 修改用户的信息
	  * @param username
	  * @param password
	  * @param phone
	  * @return
	  */
	 int updateUser(User user);
}
