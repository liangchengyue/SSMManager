package com.zyp.mapper;

import java.util.List;

import com.zyp.custom.SelectCustom;
import com.zyp.pojo.User;
import com.zyp.pojo.VInfo;
import com.zyp.util.Pagination;

/***
 * 车辆信息mapper
 * @author zyp
 *
 */
public interface VInfoMapper {
	/**
	 * 插入车辆信息
	 * @param VInfo
	 */
	public void insertVInfo(VInfo vinfo);
	
	/**
	 * 获取车辆列表
	 * @param pagination 分页条件
	 * @return 车辆 json 数据
	 */
	public List<VInfo> vinfoList(Pagination pagination);
	
	/**
	 * 获取车辆的个数
	 * @param pagination 分页条件
	 * @return 车辆个数
	 */
	public int vinfoCount(Pagination pagination);
	/**
	 * 删除车辆信息
	 * @param id
	 * @return
	 */
	public void deleteVInfo(VInfo vinfo);
	
	/**
	 * 根据Id查询车辆信息
	 * @param id 
	 * @return 车辆信息
	 */
	public VInfo fingVInfoById(String id);
	/**
	 * 根据id修改车辆信息
	 * @param vinfo 车辆信息
	 */
	public void updateVInfo(VInfo vinfo);
	/**
	 * 获取车辆信息下来列表
	 * @return
	 */
	public List<SelectCustom> findIDAndNumber();
}
