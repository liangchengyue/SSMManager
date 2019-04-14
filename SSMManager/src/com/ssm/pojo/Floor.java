package com.ssm.pojo;

/**
 * 楼房
 * @author 
 *
 */
public class Floor {
	//编号
	private int id;
	
	//门牌号
	private String numbers;
	
	//面积
	private double size;
	
	//户型
	private String type;
	
	//是否入住
	private String state;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumbers() {
		return numbers;
	}
	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
