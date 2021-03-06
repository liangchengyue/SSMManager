package com.ssm.service;

import com.ssm.pojo.Notice;
import com.ssm.util.Pagination;

public interface NoticeService {
	/**
	 * 添加信息
	 * 
	 * @param info
	 */
	public void insert(Notice notice);


	/**
	 * 获取用户分页数据
	 * 
	 * @param pagination
	 * @return
	 */
	public String list(Pagination pagination);

	/**
	 * 删除信息
	 * @param notice
	 */
	public void delete(Notice notice);

	/**
	 * 根据Id查询用户信息
	 * 
	 * @param id
	 * @return 查询信息
	 */
	public String findById(String id);

	/**
	 * 根据id修改信息
	 * 
	 * @param 信息
	 */
	public void update(Notice notice);

}
