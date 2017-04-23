package com.hsy.service;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsy.base.BaseService;
import com.hsy.beanFactory.BeanFactory;
import com.hsy.dao.UserDao;
import com.hsy.daoImp.UserDaoImp;
import com.hsy.entity.User;

import net.sf.json.JSONObject;

/**
 * 操作user的事务
 * 
 * @author haitang
 *
 */
public class UserService implements BaseService{

	private UserDao userDao =BeanFactory.getInstance(UserDaoImp.class); 
	
	/**
	 * 验证用户
	 * @param name
	 * @param password
	 * @return
	 */
	public String login(HttpServletRequest request,HttpServletResponse response) {
		
		//获取前端传过来的数据
		String phone =request.getParameter("phone");
		String password =request.getParameter("password");
		
		User user = userDao.login(phone);
		String dataRes=null;
		// 该用户不存在
		if (null == user) {
			dataRes="0";
			return dataRes;
		}
		// 该用户存在并且输入的密码不正确
	    if (!user.getPassword().equals(password)) {
			dataRes="1";
			return dataRes;
		}
		//如果用户输入的用户名和密码都正确，将用户存进session
		HttpSession session=request.getSession();
		session.setAttribute("user",user);
		dataRes="2";
		return dataRes;
	}
	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @return
	 */
	public String register(HttpServletRequest request,HttpServletResponse response){
		
		//从前端获取数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		//查询该手机号码是否已被注册
		User user = userDao.login(phone);
		//如果被注册
		if(user!=null)
			return "0";
		
	    user=new User(0, username, phone, password);
		int flag=userDao.insert(user);
		String dataRes=(flag>0)?"1":"0";
		return dataRes;
	}
}