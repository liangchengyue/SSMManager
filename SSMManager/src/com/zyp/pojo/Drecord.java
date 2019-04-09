package com.zyp.pojo;

import java.util.Date;

import com.zyp.util.Pagination;
/**
 * 
 * @author zyp
 *  行车记录表
 */
public class Drecord {
   private String id ; //编号
   
   private String vnumber ; //车辆编号
   
   private String driverid ; //驾驶员编号
   
   private double startmileage ; //起始公里数
   
   private double endmileage ; //结束公里数
   
   private String origin ; //出发地
   
   private String destination ; //目的地
   
   private Date starttime ;//出发时间
   
   private Date endtime ;//结束时间
   
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getVnumber() {
	return vnumber;
}
public void setVnumber(String vnumber) {
	this.vnumber = vnumber;
}
public String getDriverid() {
	return driverid;
}
public void setDriverid(String driverid) {
	this.driverid = driverid;
}
public double getStartmileage() {
	return startmileage;
}
public void setStartmileage(double startmileage) {
	this.startmileage = startmileage;
}
public double getEndmileage() {
	return endmileage;
}
public void setEndmileage(double endmileage) {
	this.endmileage = endmileage;
}
public String getOrigin() {
	return origin;
}
public void setOrigin(String origin) {
	this.origin = origin;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
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
