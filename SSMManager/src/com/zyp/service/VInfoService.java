package com.zyp.service;
import java.util.List;

import com.zyp.custom.SelectCustom;
import com.zyp.pojo.User;
import com.zyp.pojo.VInfo;
import com.zyp.util.Pagination;

/**
 * 车辆 server
 * @author zyp
 * 定义操作车辆信息的接口
 */
public interface VInfoService {
	
	//添加车辆信息
	public void addVInfo(VInfo vinfo);
	
	//分页获取车车辆
	public String vinfoList(Pagination pagination);
	//删除
	public void deleteVInfo(VInfo vinfo);
	
	/**
	 * 根据Id查询车辆信息
	 * @param id 
	 * @return 车辆信息
	 */
	public String fingVInfoById(String id);
	/**
	 * 根据id修改车辆信息
	 * @param vinfo 车辆信息
	 */
	public void updateVInfo(VInfo vinfo);
	/**
	 * 获取车辆信息下来列表
	 * @return
	 */
	public String findIDAndNumber();
}
