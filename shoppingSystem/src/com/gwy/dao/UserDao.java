package com.gwy.dao;

import com.gwy.base.BaseDao;
import com.gwy.entity.User;

public interface UserDao extends BaseDao<User>{

	/**
	 * 根据用户名得到该用户
	 * @param name
	 * @return
	 */
	 User login(String phone);
	 
	 /**
	  * 修改用户的信息
	  * @param username
	  * @param password
	  * @param phone
	  * @return
	  */
	 int updateUser(User user);
	 
	 /**
	  * 查询用户名是否已被注册
	  * @param name
	  * @return
	  */
	 User checkByName(String name);
}
