package com.zyp.mapper;

import java.util.List;

import com.zyp.custom.SelectCustom;
import com.zyp.pojo.Driver;
import com.zyp.pojo.User;
import com.zyp.util.Pagination;

/***
 * 驾驶员mapper
 * @author zyp
 *
 */

public interface DriverMapper {
	/**
	 * 插入驾驶员
	 * @param user
	 */
	public void insertDriver(Driver driver);
	/**
	 * 获取驾驶员列表
	 * @param pagination 分页条件
	 * @return 驾驶员 json 数据
	 */
	public List<Driver> driverList(Pagination pagination);
	/**
	 * 获取驾驶员的个数
	 * @param pagination 分页条件
	 * @return 驾驶员个数
	 */
	 public int driverCount(Pagination pagination);
	 /**
		 * 删除驾驶员
		 * @param id
		 * @return
		 */
		public void deleteDriver(Driver driver);
		/**
		 * 根据Id查询驾驶员信息
		 * @param id 
		 * @return 驾驶员信息
		 */
		public Driver fingDriverById(String id);
		/**
		 * 根据id修改驾驶员信息
		 * @param Driver 驾驶员信息
		 */
		public void updateDriver(Driver driver);
		
		public List<SelectCustom> findIDAndNumber();
	
}
