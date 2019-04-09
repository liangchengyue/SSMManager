package com.zyp.service;

import com.zyp.pojo.User;
import com.zyp.pojo.VMaintenance;
import com.zyp.util.Pagination;

/**
 * 维修记录 server
 * @author zyp
 * 定义操作维修记录的接口
 */
public interface VMaintenanceService {
	
	//添加维修记录
	public void addVMaintenance(VMaintenance vmaintenance);
	
	//分页获取维修记录
	public String vmaintenanceList(Pagination pagination);
	//删除
	public void deleteVMaintenance(VMaintenance vmaintenance);
	
	/**
	 * 根据Id查询维修记录信息
	 * @param id 
	 * @return 维修信息
	 */
	public String fingVMaintenanceById(String id);
	/**
	 * 根据id修改维修信息
	 * @param vmaintenance 维修信息
	 */
	public void updateVMaintenance(VMaintenance vmaintenance);
}
