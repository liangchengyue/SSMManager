package com.ssm.service;

import com.ssm.pojo.Fee;
import com.ssm.util.Pagination;

public interface FeeService {
	/**
	 * 添加费用
	 * @param info
	 */
	public void insert(Fee fee);
	
	/**
	 * 获取费用列表
	 * @param pagination 分页条件
	 * @return 费用 json 数据
	 */
	public String list(Pagination pagination);
	
	/**
	 * 删除费用
	 * @param id
	 * @return
	 */
	public void delete(Fee fee);
	/**
	 * 根据Id查询费用信息
	 * @param id 
	 * @return 费用信息
	 */
	public String findById(String id);
	/**
	 * 根据id修改费用信息
	 * @param user 费用信息
	 */
	public void update(Fee fee);

}
