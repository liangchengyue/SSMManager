package com.zyp.pojo;

import java.util.Date;

/**
 * 
 * @author zyp
 *车辆信息表
 */
public class VInfo {
   private String id ; //编号
   
   private String carowner ; //车主
   
   private String vlicense ; //行驶证编号
   
   private String vnumber ; //车辆编号
   
   private String model ; //车型
   
   private String color ; //车色
   
   private String engine ; //发动机型号
   
   private String pcapacity ; //装载人数
   
   private Date createtime ; //制造日期
   
   private String displacement ;// 发动机排量
   
   private double quality ; //总质量

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getCarowner() {
	return carowner;
}

public void setCarowner(String carowner) {
	this.carowner = carowner;
}

public String getVlicense() {
	return vlicense;
}

public void setVlicense(String vlicense) {
	this.vlicense = vlicense;
}

public String getVnumber() {
	return vnumber;
}

public void setVnumber(String vnumber) {
	this.vnumber = vnumber;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public String getEngine() {
	return engine;
}

public void setEngine(String engine) {
	this.engine = engine;
}

public String getPcapacity() {
	return pcapacity;
}

public void setPcapacity(String pcapacity) {
	this.pcapacity = pcapacity;
}

public Date getCreatetime() {
	return createtime;
}

public void setCreatetime(Date createtime) {
	this.createtime = createtime;
}

public String getDisplacement() {
	return displacement;
}

public void setDisplacement(String displacement) {
	this.displacement = displacement;
}

public double getQuality() {
	return quality;
}

public void setQuality(double quality) {
	this.quality = quality;
}
   

}
