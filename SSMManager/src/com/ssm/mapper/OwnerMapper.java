package com.ssm.mapper;

import java.util.List;

import com.ssm.pojo.Owner;
import com.ssm.util.Pagination;

public interface OwnerMapper  {
	/**
	 * 添加信息 
	 * @param info
	 */
	public void insert(Owner data );
	/**
	 * 获取信息列表
	 * @param pagination 分页条件
	 * @return 用户 json 数据
	 */
	public List<Owner> list(Pagination pagination);
	
	/**
	 * 获取个数
	 * @param pagination 分页条件
	 * @return 用户个数
	 */
	public int count(Pagination pagination);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public void delete(Owner data);
	/**
	 * 根据Id查询信息
	 * @param id 
	 * @return 信息
	 */
	public Owner findById(String id);
	/**
	 * 根据id修改信息
	 * @param notice 信息
	 */
	public void update(Owner data);
}
