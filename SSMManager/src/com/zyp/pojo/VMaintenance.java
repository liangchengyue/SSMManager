package com.zyp.pojo;

import java.util.Date;

/**
 * 
 * @author zyp
 *维修记录表
 */
public class VMaintenance {
  private String id ; //编号
  
  private String driverid ; //驾驶员编号
  
  private Date maintenancetime ; //维护时间
  
  private String vnumber ; //车牌号
  
  private String problem ; //故障原因
  
  private boolean state ;  //维护状态
  
  private String address ; //维护地点
  
  private String invoicenumber ; //维护发票编号
  
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
public Date getMaintenancetime() {
	return maintenancetime;
}
public void setMaintenancetime(Date maintenancetime) {
	this.maintenancetime = maintenancetime;
}
public String getVnumber() {
	return vnumber;
}
public void setVnumber(String vnumber) {
	this.vnumber = vnumber;
}
public String getProblem() {
	return problem;
}
public void setProblem(String problem) {
	this.problem = problem;
}
public boolean isState() {
	return state;
}
public void setState(boolean state) {
	this.state = state;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getInvoicenumber() {
	return invoicenumber;
}
public void setInvoicenumber(String invoicenumber) {
	this.invoicenumber = invoicenumber;
}

}
