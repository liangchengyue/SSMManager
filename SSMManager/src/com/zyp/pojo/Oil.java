package com.zyp.pojo;

import java.util.Date;
/**
 * 
 * @author zyp
 *油量表
 */
public class Oil {
   public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDriverid() {
		return driverid;
	}

	public void setDriverid(String driverid) {
		this.driverid = driverid;
	}

	public String getVnumber() {
		return vnumber;
	}

	public void setVnumber(String vnumber) {
		this.vnumber = vnumber;
	}

	public Date getPretime() {
		return pretime;
	}

	public void setPretime(Date pretime) {
		this.pretime = pretime;
	}

	public Date getNowtime() {
		return nowtime;
	}

	public void setNowtime(Date nowtime) {
		this.nowtime = nowtime;
	}

	public double getPreaoil() {
		return preaoil;
	}

	public void setPreaoil(double preaoil) {
		this.preaoil = preaoil;
	}

	public double getOil() {
		return oil;
	}

	public void setOil(double oil) {
		this.oil = oil;
	}

	public String getOiltype() {
		return oiltype;
	}

	public void setOiltype(String oiltype) {
		this.oiltype = oiltype;
	}

private String id ; //编号
   
   private String driverid ; //驾驶员编号
   
   private String vnumber; //车辆编号
   
   private Date pretime ; //上次加油时间
   
   private Date nowtime ; //本次加油时间
   
   private double preaoil ; //加油前油量
   
   private double oil ; //加油量
   
   private String oiltype ; //加油型号

   }
