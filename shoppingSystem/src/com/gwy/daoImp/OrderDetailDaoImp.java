package com.gwy.daoImp;

import java.util.List;

import com.gwy.dao.OrderDetailDao;
import com.gwy.entity.Commodity;
import com.gwy.entity.OrderDetail;
import com.gwy.entity.ShoppingCart;
import com.gwy.utils.DaoHandel;
import com.gwy.utils.Singleton;

public class OrderDetailDaoImp implements OrderDetailDao {

	@Override
	public int insert(OrderDetail entity) {
		String insertSql="insert into order_detail values(null,?,?,?)";
		Object[] parameters=new Object[]{entity.getUserId(),entity.getCommodityId(),entity.getNumber()};
		int flag=DaoHandel.executeDML(insertSql, parameters);
		return flag;
	}

	@Override
	public int deleteById(Object id) {
		String selectSql="delete from order_detail where detail_id=?";
		Object[] parameters=new Object[]{id};
		int flag=DaoHandel.executeDML(selectSql, parameters);
		return flag;
	}
	/**
	 * 根据用户id，得到用户所有的订单明细
	 * @param id
	 * @return
	 */
	public List<OrderDetail> selectByUserId(int id){
		String selectSql="select *from order_detail where user_id=?";
		Object[] parameters=new Object[]{id};
		List list=DaoHandel.executeQueryForAll(selectSql, parameters,OrderDetail.class);
		return list;
	}
	
	
	@Override
	public OrderDetail selectById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetail> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 通过用户id,和商品id查询是否存在该订单明细
	 */
	@Override
	public OrderDetail findOrderDetailByUserIdAndCommodityId(int userId, int commodityId) {
		
		String selectSql="select *from order_detail where user_id=? and commodity_id=?";
		Object[] parameters=new Object[]{userId,commodityId};
		OrderDetail orderDetail=DaoHandel.executeQueryForSingle(selectSql, parameters,OrderDetail.class);
		return orderDetail;
	}
	
	/**
	 * 根据订单明细的id修改已加入订单明细的商品的数量
	 */
	@Override
	public int updateOrderDetail(int orderDetailId, int number) {
		String updateSql="update order_detail set number=? where order_detail_id=?";
		Object[] parameters=new Object[]{number,orderDetailId};
		int flag = DaoHandel.executeDML(updateSql, parameters);
		return flag;
	}
	/**
	 * 根据用户id，得到用户的订单明细的是所有的商品信息
	 */
	@Override
	public List<Commodity> getAllOrderDetail(int userId) {
		String selectSql="select *from commodity where commodity_id in "
				+ "(select commodity_id from order_detail where user_id=?)";
		Object[] parameters=new Object[]{userId};
		List<Commodity> list=DaoHandel.executeQueryForAll(selectSql, parameters,Commodity.class);
		return list;
	}
	

}
