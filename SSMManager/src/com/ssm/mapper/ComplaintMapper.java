package com.ssm.mapper;

import java.util.List;

import com.ssm.pojo.Complaint;
import com.ssm.pojo.User;
import com.ssm.util.Pagination;

public interface ComplaintMapper  {
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
	public List<Complaint> list(Pagination pagination);
	
	/**
	 * 获取投诉的个数
	 * @param pagination 分页条件
	 * @return 投诉个数
	 */
	public int count(Pagination pagination);
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
	public Complaint findById(String id);
	/**
	 * 根据id修改投诉信息
	 * @param user 投诉信息
	 */
	public void update(Complaint complaint);
}
