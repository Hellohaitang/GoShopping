package com.hsy.dao;

import java.util.List;

import com.hsy.base.BaseDao;
import com.hsy.entity.Commodity;
import com.hsy.entity.ShoppingCart;

public interface ShoppingCartDao extends BaseDao<ShoppingCart>{
	
	/**
	 * 根据用户id获得到用户所有的购物车的商品信息
	 * @param userId
	 * @return
	 */
	List<Commodity> getAllShoppingCart(int userId);
	
	/**
	 * 根据用户id获得用户所有的购物车
	 * @param userId
	 * @return
	 */
    List<ShoppingCart> selectByUserId(int userId);
    
    /**
     * 根据商品id删除用户的购物车
     * @param userId
     * @param commodity
     * @return
     */
    int deleteShoppingCart(int userId,int commodityId);
}
