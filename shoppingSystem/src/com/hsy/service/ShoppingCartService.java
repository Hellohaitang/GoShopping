package com.hsy.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsy.base.BaseService;
import com.hsy.beanFactory.BeanFactory;
import com.hsy.dao.ShoppingCartDao;
import com.hsy.daoImp.ShoppingCartDaoImp;
import com.hsy.entity.Commodity;
import com.hsy.entity.ShoppingCart;
import com.hsy.entity.User;

import net.sf.json.JSONObject;

public class ShoppingCartService implements BaseService{

	private ShoppingCartDao shoppingCartDao=BeanFactory.getInstance(ShoppingCartDaoImp.class);
	/**
	 * 将购物车添加到数据库中
	 * @param request
	 * @param response
	 * @return
	 */
	public String addShoppingCart(HttpServletRequest request, HttpServletResponse response) {

//		// 获取前端传过来的数据
//		String commodityId=request.getParameter("commodityId");
//		String number=request.getParameter("number");
//		// 从session获取用户
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("username");
		String commodityId="4";
		String number="2";
		User user=new User(4,"","","",null);
		//将订单明细存储到数据库
		ShoppingCart shoppingCart=new ShoppingCart(0,user.getUserId(),Integer.parseInt(commodityId),Integer.parseInt(number));
		boolean flag = shoppingCartDao.insert(shoppingCart);
		String dataRes=(flag==true)?"1":"0";
		return dataRes;
	}
	/**
	 * 得到用户所有的购物车的商品信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String getAllShoppingCart(HttpServletRequest request,HttpServletResponse response){
		// 从session获取用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("username");
		List<Commodity> list=shoppingCartDao.getAllShoppingCart(user.getUserId());
		return JSONObject.fromObject(list).toString();
	}
	
	/**
	 * 删除用户的购物车
	 * @param request
	 * @param response
	 * @return
	 */
	public String deleteShoppingCart(HttpServletRequest request,HttpServletResponse response){
		//从前端取得数据
		String commodityId=request.getParameter("commodityId");
		// 从session获取用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("username");
		int flag=shoppingCartDao.deleteShoppingCart(user.getUserId(),Integer.parseInt(commodityId));
		String dataRes=(flag>0)?"1":"0";
		return dataRes;
	}
	
	public static void main(String[] args) {
		ShoppingCartService cartService=new ShoppingCartService();
		System.out.println(cartService.addShoppingCart(null, null));
	}
}
