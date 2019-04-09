package com.zyp.mapper;

import java.util.List;

import com.zyp.pojo.User;
import com.zyp.pojo.VInspection;
import com.zyp.util.Pagination;

/***
 * 年审mapper
 * @author zyp
 *
 */
public interface VInspectionMapper {
	/**
	 * 插入用户
	 * @param vinspection
	 */
	public void insertVInspection(VInspection vinspection );
	
	/**
	 * 获取年审列表
	 * @param pagination 分页条件
	 * @return 年审json 数据
	 */
	public List<VInspection> vinspectionList(Pagination pagination);
	
	/**
	 * 获取年审的个数
	 * @param pagination 分页条件
	 * @return 年审个数
	 */
	public int vinspectionCount(Pagination pagination);
	/**
	 * 删除年审
	 * @param id
	 * @return
	 */
	public void deleteVInspection(VInspection vinspection);
	
	/**
	 * 根据Id查询年审信息
	 * @param id 
	 * @return 年审信息
	 */
	public VInspection fingVInspectionById(String id);
	/**
	 * 根据id修改年审信息
	 * @param vinspection 年审信息
	 */
	public void updateVInspection(VInspection vinspection);
}
