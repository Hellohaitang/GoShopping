package com.hsy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 对应表commidity的实体类
 * 
 * @author haitang
 *
 */
public class Commodity implements Serializable {

	private int commodityId;
	private double price;
	private int number;
	private String detail;
	private String image;

	public Commodity() {

	}

	public Commodity(int commodityId, double price, int number, String detail, String image) {
		super();
		this.commodityId = commodityId;
		this.price = price;
		this.number = number;
		this.detail = detail;
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Commodity [commodityId=" + commodityId + ", price=" + price + ", number=" + number + ", detail="
				+ detail + ", image=" + image + "]";
	}

}
