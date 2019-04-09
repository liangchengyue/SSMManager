package com.zyp.service;



import com.zyp.pojo.User;
import com.zyp.pojo.VInspection;
import com.zyp.util.Pagination;

/**
 * 年审 server
 * @author zyp
 * 定义操作年审的接口
 */
public interface VInspectionService {
	
	//添加年审
	public void addVInspection(VInspection vinspection);
	
	//分页获取年审
	public String vinspectionList(Pagination pagination);
	//删除
	public void deleteVInspection(VInspection vinspection);
	
	/**
	 * 根据Id查询年审信息
	 * @param id 
	 * @return 年审信息
	 */
	public String fingVInspectionById(String id);
	/**
	 * 根据id修改年审信息
	 * @param vinspection 年审信息
	 */
	public void updateVInspection(VInspection vinspection);
}
