package com.ssm.service;

import java.util.List;

import com.ssm.pojo.Complaint;
import com.ssm.pojo.User;
import com.ssm.util.Pagination;

public interface ComplaintService {
	/**
	 * 添加投诉
	 * @param info
	 */
	public void insert(Complaint complaint);
	/**
	 * 获取投诉列表
	 * @param pagination 分页条件
	 * @return 投诉 json 数据
	 */
	public String list(Pagination pagination);
	
	/**
	 * 删除投诉
	 * @param id
	 * @return
	 */
	public void delete(Complaint complaint);
	/**
	 * 根据Id查询投诉信息
	 * @param id 
	 * @return 投诉信息
	 */
	public String findById(String id);
	/**
	 * 根据id修改投诉信息
	 * @param user 投诉信息
	 */
	public void update(Complaint complaint);

}
