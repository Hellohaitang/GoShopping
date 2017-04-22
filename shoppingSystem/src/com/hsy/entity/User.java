package com.hsy.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 对应表user的实体类
 * @author haitang
 *
 */
public class User implements Serializable{

	private int userId;
	private String name;
	private String phone;
	private String password;
	private Date createTime;
	
	public User(){
		
	}
	public User(int userId, String name, String phone, String password, Date createTime) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.createTime = createTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", phone=" + phone + ", password=" + password
				+ ", createTime=" + createTime + "]";
	}
	
}
