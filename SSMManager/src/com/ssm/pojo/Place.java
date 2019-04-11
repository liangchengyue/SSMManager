package com.ssm.pojo;

/**
 * 停车位
 * @author 
 *
 */
public class Place {
	//编号
	private int id;
	//地址
	private String address;
	//费用
	private double money;
	//用户id
	private int userId;
	//是否使用
	private String state;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
