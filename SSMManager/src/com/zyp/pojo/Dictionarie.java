package com.zyp.pojo;
/**
 * 
 * @author zyp
 *  车辆字典
 */
public class Dictionarie {
	private String id;
	//编号
	private int parentId;
	//父编号
	private String name;
    //名称
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
