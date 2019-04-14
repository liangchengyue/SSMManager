package com.ssm.pojo;

import java.util.Date;

/**
 * 公告表
 * @author 
 *
 */
public class Notice {
	//编号
	private int id;
	//标题
	private String title;
	//内容
	private String content;
	//时间
	private Date time;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
