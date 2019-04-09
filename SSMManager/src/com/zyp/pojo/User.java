package com.zyp.pojo;
/**
 * 
 * @author zyp
 * 用户表
 */
public class User {
    private String id ; //编号
    
    private String number ; //职工编号
    
    private String username ; //登陆名
    
    private String password ; //密码
    
    private String name ; //真实姓名
    
    private boolean denger ; //性别
    
    private String idcard ; //身份证
    
    private String address ; //家庭住址
    
    private String phonenumber ; //电话号码

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

    
}
