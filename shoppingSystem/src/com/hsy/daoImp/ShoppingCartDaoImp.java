package com.hsy.daoImp;

import java.util.List;

import com.hsy.dao.ShoppingCartDao;
import com.hsy.entity.Commodity;
import com.hsy.entity.Detail;
import com.hsy.entity.ShoppingCart;
import com.hsy.utils.DaoHandel;
import com.hsy.utils.Singleton;

public class ShoppingCartDaoImp implements ShoppingCartDao {

	@Override
	public boolean insert(ShoppingCart entity) {
		String insertSql="insert into shopping_cart values(null,?,?,?)";
		Object[] parameters=new Object[]{entity.getUserId(),entity.getCommodityId(),entity.getNumber()};
		boolean flag=DaoHandel.executeDML(insertSql, parameters)>0?true:false;
		return flag;
	}
	
	/**
	 * 根据用户id，得到用户所有的购物车
	 * @param id
	 * @return
	 */
	public List<ShoppingCart> selectByUserId(int userId){
		String selectSql="select *from shopping_cart where user_id=?";
		Object[] parameters=new Object[]{userId};
		List list=DaoHandel.executeQueryForAll(selectSql, parameters,ShoppingCart.class);
		return list;
	}
	
	/**
	 * 根据用户id获得到用户所有的购物车的商品信息
	 * @param userId
	 * @return
	 */
	public List<Commodity> getAllShoppingCart(int userId){
		String selectSql="select *from commodity where commodity_id in "
				+ "(select commodity_id from shopping_cart where user_id=?)";
		Object[] parameters=new Object[]{userId};
		List<Commodity> list=DaoHandel.executeQueryForAll(selectSql, parameters,Commodity.class);
		return list;
	}
	 /**
     * 根据商品id删除用户的购物车
     * @param userId
     * @param commodity
     * @return
     */
	@Override
	public int deleteShoppingCart(int userId, int commodityId) {
		String deleteSql="delete from shopping_cart where user_id=? and commodity_id=? ";
		Object[] parameters=new Object[]{userId,commodityId};
		int flag=DaoHandel.executeDML(deleteSql, parameters);
		return flag;
	}
	
	@Override
	public boolean deleteById(Object id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public ShoppingCart selectById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ShoppingCart> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
