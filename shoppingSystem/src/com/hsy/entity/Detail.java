package com.hsy.entity;

import java.io.Serializable;

/**
 * 对应表detail的实体类
 * @author haitang
 *
 */
public class Detail implements Serializable{

	private int detailId;
	private int userId;
	private int commodityId;
	private int number;
	
	public Detail(int detailId, int userId, int commodityId, int number) {
		super();
		this.detailId = detailId;
		this.userId = userId;
		this.commodityId = commodityId;
		this.number = number;
	}

	public Detail(){
		
	}

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
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
		return "Detail [detailId=" + detailId + ", userId=" + userId + ", commodityId=" + commodityId + ", number="
				+ number + "]";
	}
}
