package com.ssm.service;

import java.util.List;

import com.ssm.pojo.Place;
import com.ssm.util.Pagination;
import com.ssm.util.SelectCustom;

public interface PlaceService {
	/**
	 * 添加信息
	 * 
	 * @param info
	 */
	public void insert(Place data);


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
	public void delete(Place data);

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
	public void update(Place data);
	/**
	 * 获取空闲车位下拉列表
	 * @return
	 */
	public String findPlaceSelect();
}
