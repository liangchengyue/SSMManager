package com.zyp.mapper;

import java.util.List;

import com.zyp.pojo.User;
import com.zyp.pojo.VMaintenance;
import com.zyp.util.Pagination;

/***
 * 维修记录mapper
 * @author zyp
 *
 */
public interface VMaintenanceMapper {
	/**
	 * 插入维修记录
	 * @param vmaintenance
	 */
	public void insertVMaintenance(VMaintenance vmaintenance);
	
	/**
	 * 获取记录列表
	 * @param pagination 分页条件
	 * @return 获取记录 json 数据
	 */
	public List<VMaintenance> vmaintenanceList(Pagination pagination);
	
	/**
	 * 获取维修记录的个数
	 * @param pagination 分页条件
	 * @return 维修记录个数
	 */
	public int vmaintenanceCount(Pagination pagination);
	/**
	 * 删除维修记录
	 * @param id
	 * @return
	 */
	public void deleteVMaintenance(VMaintenance vmaintenance);
	
	/**
	 * 根据Id查询维修信息
	 * @param id 
	 * @return 维修信息
	 */
	public VMaintenance fingVMaintenanceById(String id);
	/**
	 * 根据id修改用户信息
	 * @param vmaintenance 维修信息
	 */
	public void updateVMaintenance(VMaintenance vmaintenance);
}
