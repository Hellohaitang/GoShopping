package com.hsy.entity;

import java.io.Serializable;

/**
 * 对应表shopping_cart的实体类
 * @author haitang
 *
 */
public class ShoppingCart implements Serializable{

	private int ShoppingCartId;
	private int userId;
	private int commodityId;
	public ShoppingCart(int shoppingCartId, int userId, int commodityId) {
		super();
		ShoppingCartId = shoppingCartId;
		this.userId = userId;
		this.commodityId = commodityId;
	}
	
	public ShoppingCart(){
		
	}

	public int getShoppingCartId() {
		return ShoppingCartId;
	}

	public void setShoppingCartId(int shoppingCartId) {
		ShoppingCartId = shoppingCartId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
}
