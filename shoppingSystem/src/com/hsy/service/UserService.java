package com.hsy.service;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsy.base.BaseService;
import com.hsy.beanFactory.BeanFactory;
import com.hsy.daoImp.UserDaoImp;
import com.hsy.entity.User;

import net.sf.json.JSONObject;
import net.sf.json.JSONString;

/**
 * 操作user的事务
 * 
 * @author haitang
 *
 */
public class UserService implements BaseService{

	private UserDaoImp userDao =BeanFactory.getInstance(UserDaoImp.class); 
	
	public String updateUser(HttpServletRequest request,HttpServletResponse response){
		
		//从前端取到数据
	/**
	 * 
	 */
		User user=new User();
		User user2=userDao.updateUser(user);
		return JSONObject.fromObject(user2).toString();
	}
	
	/**
	 * 验证用户
	 * @param name
	 * @param password
	 * @return
	 */
	public String login(HttpServletRequest request,HttpServletResponse response) {
		
		//获取前端传过来的数据
		String dataReq=request.getParameter("data");
		JSONObject jsonObject=JSONObject.fromObject(dataReq);
		String name =jsonObject.getString("username");
		String password =jsonObject.getString("password");
//		User user = userDao.login(name);
//		String dataRes=null;
//		// 该用户不存在
//		if (null == user) {
//			dataRes="用户名错误";
//		}
//		// 该用户存在并且输入的密码不正确
//		if (!user.getPassword().equals(password)) {
//			dataRes="密码错误";
//		}
//		//如果用户输入的用户名和密码都正确，将用户名存进session
//		HttpSession session=request.getSession();
//		session.setAttribute("username",name);
//		return dataRes;
		
		String dataRes="登录失败";
		if(name.equals("aaa")&&password.equals("aaa")){
			dataRes="登录成功";
		}
		//如果用户输入的用户名和密码都正确，将用户名存进session
		HttpSession session=request.getSession();
		session.setAttribute("username",name);
		return dataRes;
	}
	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @return
	 */
	public String register(HttpServletRequest request,HttpServletResponse response){
//		String data=request.getParameter("data");
//		JSONObject jsonObject=JSONObject.fromObject(data);
//		jsonObject.put("userId",0);
//		User user=(User) JSONObject.toBean(jsonObject,User.class);
//		Boolean flag=userDao.insert(user);
//		return flag.toString();
		Boolean flag=true;
		return flag.toString();
	}
}