package com.zyp.service;
import java.util.List;
import com.zyp.pojo.Driver;
import com.zyp.pojo.User;
import com.zyp.util.Pagination;

/**
 * 驾驶员 server
 * @author zyp
 * 定义操作驾驶员的接口
 */
public interface DriverService {
	
	//添加驾驶员
	public void addDriver(Driver driver);
	
	
	//分页获取驾驶员
	public String driverList(Pagination pagination);
	//删除
	public void deleteDriver(Driver driver);
	
	/**
	 * 根据Id查询驾驶员信息
	 * @param id 
	 * @return 驾驶员信息
	 */
	public String fingDriverById(String id);
	/**
	 * 根据id修改驾驶员信息
	 * @param driver 驾驶员
	 */
	public void updateDriver(Driver driver);
	
	/**
	 * 获取下拉列表
	 * @return
	 */
	public String findIDAndNumber();
}
