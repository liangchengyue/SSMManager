package com.zyp.mapper;

import java.util.List;

import com.zyp.pojo.Oil;
import com.zyp.pojo.User;
import com.zyp.util.Pagination;

/***
 * 油量mapper
 * @author zyp
 *
 */
public interface OilMapper {
	/**
	 * 插入用户
	 * @param vinspection
	 */
	public void insertOil(Oil oil );
	
	/**
	 * 获取油量列表
	 * @param pagination 分页条件
	 * @return 油量json 数据
	 */
	public List<Oil> oilList(Pagination pagination);
	
	/**
	 * 获取油量的个数
	 * @param pagination 分页条件
	 * @return 油量个数
	 */
	public int oilCount(Pagination pagination);
	/**
	 * 删除油量
	 * @param id
	 * @return
	 */
	public void deleteOil(Oil oil);
	
	/**
	 * 根据Id查询油量信息
	 * @param id 
	 * @return 油量信息
	 */
	public Oil fingOilById(String id);
	/**
	 * 根据id修改油量信息
	 * @param oil 油量信息
	 */
	public void updateOil(Oil oil);
}
