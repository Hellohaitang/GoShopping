package com.hsy.entity;

import java.io.Serializable;

/**
 * 对应表shopping_cart的实体类
 * @author haitang
 *
 */
public class ShoppingCart implements Serializable{

	private int shoppingCartId;
	private int userId;    
	private int commodityId;
	private int number;

	public ShoppingCart(int shoppingCartId, int userId, int commodityId,int number) {
		super();
		this.shoppingCartId = shoppingCartId;
		this.userId = userId;
		this.commodityId = commodityId;
		this.number=number;
	}
	
	public ShoppingCart(){
		
	}

	public int getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(int shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
