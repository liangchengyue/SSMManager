package com.zyp.pojo;

import java.util.Date;

/**
 * 
 * @author zyp
 *驾驶员表
 */
public class Driver {
  private String id ;  //编号
  
  private String number ; //驾驶证号
 
  private String name ; //姓名
  
  private boolean denger ; //性别
 
  private int age ; //年龄
  
  private String idcard ; //身份证
  
  private String address ; //家庭地址
  
  private String phonenumber ; //电话号码
  
  private String drivercardid ; //驾驶证编号
  
  private String driving ; //驾龄
  
  private Date starttime ; //驾驶证有效开始时间
  
  private Date endtime ; //驾驶证失效时间

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getNumber() {
	return number;
}

public void setNumber(String number) {
	this.number = number;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public boolean isDenger() {
	return denger;
}

public void setDenger(boolean denger) {
	this.denger = denger;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getIdcard() {
	return idcard;
}

public void setIdcard(String idcard) {
	this.idcard = idcard;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getPhonenumber() {
	return phonenumber;
}

public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}

public String getDrivercardid() {
	return drivercardid;
}

public void setDrivercardid(String drivercardid) {
	this.drivercardid = drivercardid;
}

public String getDriving() {
	return driving;
}

public void setDriving(String driving) {
	this.driving = driving;
}

public Date getStarttime() {
	return starttime;
}

public void setStarttime(Date starttime) {
	this.starttime = starttime;
}

public Date getEndtime() {
	return endtime;
}

public void setEndtime(Date endtime) {
	this.endtime = endtime;
}




}
