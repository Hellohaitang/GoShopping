package com.hsy.entity;

import java.io.Serializable;

/**
 * 对应表detail的实体类
 * @author haitang
 *
 */
public class OrderDetail implements Serializable{

	private int orderDetailId;
	private int userId;
	private int commodityId;
	private int number;
	
	
	public OrderDetail() {
		super();
	}
	public OrderDetail(int orderDetailId, int userId, int commodityId, int number) {
		super();
		this.orderDetailId = orderDetailId;
		this.userId = userId;
		this.commodityId = commodityId;
		this.number = number;
	}
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
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
	@Override
	public String toString() {
		return "OrderDetail [orderDetailId=" + orderDetailId + ", userId=" + userId + ", commodityId=" + commodityId
				+ ", number=" + number + "]";
	}
	
	
}
