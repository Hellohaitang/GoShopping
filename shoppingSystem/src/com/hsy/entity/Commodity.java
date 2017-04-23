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
	private String className;
	private String sort;
	private String size;
	private String color;
	private String detail;
	private String image;
	
	public Commodity() {
		
	}
	
	public Commodity(int commodityId, double price, int number, String className, String sort, String size,
			String color, String detail, String image) {
		super();
		this.commodityId = commodityId;
		this.price = price;
		this.number = number;
		this.className = className;
		this.sort = sort;
		this.size = size;
		this.color = color;
		this.detail = detail;
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
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Commodity [commodityId=" + commodityId + ", price=" + price + ", number=" + number + ", className="
				+ className + ", sort=" + sort + ", size=" + size + ", color=" + color + ", detail=" + detail
				+ ", image=" + image + "]";
	}


}
