package com.zyp.service;



import com.zyp.pojo.Oil;
import com.zyp.pojo.User;
import com.zyp.util.Pagination;

/**
 * 油量 server
 * @author zyp
 * 定义操作油量的接口
 */
public interface OilService {
	
	//添加油量
	public void addOil(Oil oil);
	
	//分页获取油量
	public String oilList(Pagination pagination);
	//删除
	public void deleteOil(Oil oil);
	
	/**
	 * 根据Id查询油量信息
	 * @param id 
	 * @return 油量信息
	 */
	public String fingOilById(String id);
	/**
	 * 根据id修改油量信息
	 * @param oil 油量信息
	 */
	public void updateOil(Oil oil);
}
