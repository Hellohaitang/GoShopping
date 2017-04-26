package com.gwy.daoImp;

import java.util.List;

import com.gwy.dao.ShoppingCartDao;
import com.gwy.entity.Commodity;
import com.gwy.entity.OrderDetail;
import com.gwy.entity.ShoppingCart;
import com.gwy.utils.DaoHandel;
import com.gwy.utils.Singleton;

public class ShoppingCartDaoImp implements ShoppingCartDao {

	@Override
	public int insert(ShoppingCart entity) {
		String insertSql="insert into shopping_cart values(null,?,?,?)";
		Object[] parameters=new Object[]{entity.getUserId(),entity.getCommodityId(),entity.getNumber()};
		int flag=DaoHandel.executeDML(insertSql, parameters);
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
		List<ShoppingCart> list=DaoHandel.executeQueryForAll(selectSql, parameters,ShoppingCart.class);
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
	
	/**
     * 通过用户id和商品的id查找是否存在购物车
     * @param userId
     * @param commodityId
     * @return
     */
	public ShoppingCart findShoppingCartByUserIdAndCommodityId(int userId, int commodityId) {
		String selectSql="select *from shopping_cart where user_id=? and commodity_id=?";
		Object[] parameters=new Object[]{userId,commodityId};
		ShoppingCart shoppingCart=DaoHandel.executeQueryForSingle(selectSql, parameters,ShoppingCart.class);
		return shoppingCart;
	}
	/**
	 * 根据购物车的id删除购物车
	 */
	@Override
	public int deleteById(Object id) {
		String deleteSql="delete from shopping_cart where shopping_cart_id=?";
		Object[] parameters=new Object[]{id};
		int flag=DaoHandel.executeDML(deleteSql, parameters);
		return flag;
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
	
	/**
     * 根据购物车的id修改已加入购物车的商品的数量
     * @param shoppingCartId
     * @param number
     * @return
     */
	@Override
	public int updateShoppingCart(int shoppingCartId, int number) {
		String updateSql="update shopping_cart set number=? where shopping_cart_id=?";
		Object[] parameters=new Object[]{number,shoppingCartId};
		int flag = DaoHandel.executeDML(updateSql, parameters);
		return flag;
	}

}
