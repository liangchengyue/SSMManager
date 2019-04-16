package com.ssm.service;

import java.util.List;

import com.ssm.pojo.Floor;
import com.ssm.util.Pagination;
import com.ssm.util.SelectCustom;

public interface FloorService {
	/**
	 * 添加楼房
	 * @param info
	 */
	public void insert(Floor floor);
	/**
	 * 获取楼房列表
	 * @param pagination 分页条件
	 * @return 楼房 json 数据
	 */
	public String list(Pagination pagination);
	
	/**
	 * 删除楼房
	 * @param id
	 * @return
	 */
	public void delete(Floor floor);
	/**
	 * 根据Id查询楼房信息
	 * @param id 
	 * @return 楼房信息
	 */
	public String findById(String id);
	/**
	 * 根据id修改楼房信息
	 * @param user 楼房信息
	 */
	public void update(Floor floor);
	
	/**
	 * 获取下拉信息
	 * @return
	 */
	public String findIDAndNumber();
	/**
	 * 获取未使用的房屋
	 * @return
	 */
	public String findFloorSelect();
}
