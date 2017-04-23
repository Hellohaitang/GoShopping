package com.hsy.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsy.base.BaseService;
import com.hsy.beanFactory.BeanFactory;
import com.hsy.dao.CommodityDao;
import com.hsy.dao.OrderDetailDao;
import com.hsy.daoImp.CommodityDaoImp;
import com.hsy.daoImp.OrderDetailDaoImp;
import com.hsy.daoImp.UserDaoImp;
import com.hsy.entity.Commodity;
import com.hsy.entity.OrderDetail;
import com.hsy.entity.ShoppingCart;
import com.hsy.entity.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 处理订单明细的service
 * 
 * @author haitang
 *
 */
public class OrderDetailService implements BaseService {

	private OrderDetailDao orderDetailDao = BeanFactory.getInstance(OrderDetailDaoImp.class);
	private CommodityDao commodityDao = BeanFactory.getInstance(CommodityDaoImp.class);

	/**
	 * 将订单明细添加到数据库中
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String addOrderDetail(HttpServletRequest request, HttpServletResponse response) {

		// 获取前端传过来的数据
		String commodityId = request.getParameter("commodityId");
		String number = request.getParameter("number");
		// 从session获取用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int flag = 0;
		// 先判断是否已存在该购物车
		OrderDetail orderDetail = orderDetailDao.findOrderDetailByUserIdAndCommodityId(user.getUserId(),
				Integer.parseInt(commodityId));
		if (orderDetail != null) {
			flag = orderDetailDao.updateOrderDetail(orderDetail.getOrderDetailId(),
					Integer.parseInt(number) + orderDetail.getNumber());
		} else {
			// 将订单明细存储到数据库
			orderDetail = new OrderDetail(0, user.getUserId(), Integer.parseInt(commodityId), Integer.parseInt(number));
			flag = orderDetailDao.insert(orderDetail);
		}
		// 商品的数量减少
		if (flag == 1) {
			Commodity commodity = commodityDao.selectById(Integer.parseInt(commodityId));
			flag = commodityDao.updateCommodityById(Integer.parseInt(commodityId),
					commodity.getNumber() - Integer.parseInt(number));
		}
		String dataRes = (flag > 0) ? "1" : "0";
		return dataRes;
	}

	/**
	 * 得到用户所有的订单明细
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String getAllOrderDetail(HttpServletRequest request, HttpServletResponse response) {
		// 从session获取用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Commodity> list = orderDetailDao.getAllOrderDetail(user.getUserId());
		return JSONArray.fromObject(list).toString();
	}
	

	/**
	 * 根据订单明细的id删除用户的购物车
	 * @param request
	 * @param response
	 * @return
	 */
	public String deleteShoppingCart(HttpServletRequest request,HttpServletResponse response){
		//从前端取得数据
		String orderDetailId=request.getParameter("orderDetailId");
		int flag=orderDetailDao.deleteById(orderDetailId);
		String dataRes=(flag>0)?"1":"0";
		return dataRes;
	}
	public static void main(String[] args) {
		
		OrderDetailService  orderDetailService=new OrderDetailService();
		System.out.println(orderDetailService.getAllOrderDetail(null, null));
		
	}
}
