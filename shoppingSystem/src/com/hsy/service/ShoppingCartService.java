package com.hsy.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsy.base.BaseService;
import com.hsy.beanFactory.BeanFactory;
import com.hsy.dao.CommodityDao;
import com.hsy.dao.ShoppingCartDao;
import com.hsy.daoImp.CommodityDaoImp;
import com.hsy.daoImp.ShoppingCartDaoImp;
import com.hsy.entity.Commodity;
import com.hsy.entity.ShoppingCart;
import com.hsy.entity.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ShoppingCartService implements BaseService{

	private ShoppingCartDao shoppingCartDao=BeanFactory.getInstance(ShoppingCartDaoImp.class);
	private CommodityDao commodityDao=BeanFactory.getInstance(CommodityDaoImp.class);
	/**
	 * 将购物车添加到数据库中
	 * @param request
	 * @param response
	 * @return
	 */
	public String addShoppingCart(HttpServletRequest request, HttpServletResponse response) {

		// 获取前端传过来的数据
		String commodityId=request.getParameter("commodityId");
		String number=request.getParameter("number");
		// 从session获取用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int flag=0;
		//先判断是否已存在该购物车
		ShoppingCart shoppingCart = shoppingCartDao.findShoppingCartByUserIdAndCommodityId(user.getUserId(), Integer.parseInt(commodityId));
		if(shoppingCart!=null){
			flag = shoppingCartDao.updateShoppingCart(shoppingCart.getShoppingCartId(), Integer.parseInt(number)+shoppingCart.getNumber());
		}else{
			//将订单明细存储到数据库
		    shoppingCart=new ShoppingCart(0,user.getUserId(),Integer.parseInt(commodityId),Integer.parseInt(number));
			flag = shoppingCartDao.insert(shoppingCart);
		}
		//商品的数量减少
		if(flag==1){
			Commodity commodity=commodityDao.selectById(Integer.parseInt(commodityId));
			flag=commodityDao.updateCommodityById(Integer.parseInt(commodityId), commodity.getNumber()-Integer.parseInt(number));
		}
		String dataRes=(flag>0)?"1":"0";
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
		User user = (User) session.getAttribute("user");
		List<Commodity> list=shoppingCartDao.getAllShoppingCart(user.getUserId());
		return JSONArray.fromObject(list).toString();
	}
	
	/**
	 * 根据购物车的di删除用户的购物车
	 * @param request
	 * @param response
	 * @return
	 */
	public String deleteShoppingCart(HttpServletRequest request,HttpServletResponse response){
		//从前端取得数据
		String shoppingCartId=request.getParameter("shoppingCartId");
		int flag=shoppingCartDao.deleteById(shoppingCartId);
		String dataRes=(flag>0)?"1":"0";
		return dataRes;
	}
	
	public static void main(String[] args) {
		ShoppingCartService cartService=new ShoppingCartService();
//		System.out.println(cartService.getAllShoppingCart(null, null));
//		System.out.println(cartService.deleteShoppingCart(null, null));
//		System.out.println(cartService.addShoppingCart(null, null));
	}
}
