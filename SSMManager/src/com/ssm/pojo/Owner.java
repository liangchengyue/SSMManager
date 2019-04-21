package com.ssm.pojo;

import java.util.Date;

/**
 * 住户
 * 
 * @author
 *
 */
public class Owner {
	// 编号
	private int id;
	// 楼层号
	private int floorid;
	// 身份证
	private String idcard;
	// 家庭人数
	private int number;
	// 入住时间
	private Date time;
	// 备注
	private String remarks;
	// 用户名
	private String userName;
	//停车位
	private int  placeid;

	public int getPlaceid() {
		return placeid;
	}

	public void setPlaceid(int placeid) {
		this.placeid = placeid;
	}

	public String getUserName() {
		return userName;
	}

	private String floorName;

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
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

	public int getFloorid() {
		return floorid;
	}

	public void setFloorid(int floorid) {
		this.floorid = floorid;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
