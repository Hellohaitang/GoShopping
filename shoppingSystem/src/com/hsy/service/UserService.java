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
		String name =request.getParameter("username");
		String password =request.getParameter("password");
		
		User user = userDao.login(name);
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
		session.setAttribute("username",user);
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
		//先根据用户名查找该用户名是否存在
		User user = userDao.login(username);
		//该用户已存在
		if(user!=null)
			return "0";
		
	    user=new User(0, username, phone, password, new Date());
		Boolean flag=userDao.insert(user);
		String dataRes=(flag==true)?"1":"0";
		return dataRes;
	}
	
//	public static void main(String[] args) {
//		UserService service=new UserService();
//		System.out.println(service.register(null, null));
//	}
}