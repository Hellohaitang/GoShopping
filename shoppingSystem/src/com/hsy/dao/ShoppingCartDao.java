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
    
    /**
     * 通过用户id和商品的id查找是否存在购物车
     * @param userId
     * @param commodityId
     * @return
     */
    ShoppingCart findShoppingCartByUserIdAndCommodityId(int userId,int commodityId);
    
    /**
     * 根据购物车的id修改已加入购物车的商品的数量
     * @param shoppingCartId
     * @param number
     * @return
     */
    int updateShoppingCart(int shoppingCartId,int number);
}
