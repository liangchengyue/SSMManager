package com.zyp.pojo;

import java.util.Date;
/**
 * 
 * @author zyp
 *年审表
 */
public class VInspection {
 private String id ; //编号
 
 private String ytype ; //年审类型
 
 private String vnumber ; //车辆编号
 
 private Date carefutime; //年审时间
 
 private Date pretime ; //上次年审时间
 
 private String userid ; //用户编号
 
 private boolean state ; //年审状态
 
 private String desc ; //描述
 
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getYtype() {
	return ytype;
}
public void setYtype(String ytype) {
	ytype = ytype;
}
public String getVnumber() {
	return vnumber;
}
public void setVnumber(String vnumber) {
	this.vnumber = vnumber;
}
public Date getCarefutime() {
	return carefutime;
}
public void setCarefutime(Date carefutime) {
	this.carefutime = carefutime;
}
public Date getPretime() {
	return pretime;
}
public void setPretime(Date pretime) {
	this.pretime = pretime;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public boolean isState() {
	return state;
}
public void setState(boolean state) {
	this.state = state;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}

}
