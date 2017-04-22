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
}
