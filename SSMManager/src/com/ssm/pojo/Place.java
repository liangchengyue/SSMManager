package com.ssm.pojo;

/**
 * 停车位
 * 
 * @author
 *
 */
public class Place {
	// 编号
	private int id;
	// 地址
	private String address;
	// 费用
	private double money;
	// 用户id
	private int userid;
	// 是否使用
	private String state;
	// 用户名
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

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

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
