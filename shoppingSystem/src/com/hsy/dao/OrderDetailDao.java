package com.hsy.dao;

import java.util.List;

import com.hsy.base.BaseDao;
import com.hsy.entity.Commodity;
import com.hsy.entity.OrderDetail;

public interface OrderDetailDao extends BaseDao<OrderDetail>{
	
	/**
	 * 通过用户id,和商品id查询是否存在该订单明细
	 * @param userId
	 * @param commodityId
	 * @return
	 */
	OrderDetail findOrderDetailByUserIdAndCommodityId(int userId,int commodityId);
	
	/**
	 * 根据订单明细的id修改已加入订单明细的商品的数量
	 * @param orderDetailId
	 * @param number
	 * @return
	 */
	int updateOrderDetail(int orderDetailId,int number);
	
	/**
	 * 根据用户id，得到用户的订单明细的是所有的商品信息
	 * @param userId
	 * @return
	 */
	List<Commodity> getAllOrderDetail(int userId);
}
