package com.ssm.mapper;

import java.util.List;

import com.ssm.pojo.Fee;
import com.ssm.pojo.User;
import com.ssm.util.Pagination;

public interface FeeMapper  {
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
	public List<Fee> list(Pagination pagination);
	
	/**
	 * 获取费用的个数
	 * @param pagination 分页条件
	 * @return 费用个数
	 */
	public int count(Pagination pagination);
	/**
	 * 删除费用
	 * @param id
	 * @return
	 */
	public void delete(Fee fee);
	/**
	 * 根据Id查询费用信息
	 * @param id 
	 * @return 用户信息
	 */
	public Fee findById(String id);
	/**
	 * 根据id修改费用信息
	 * @param user 费用信息
	 */
	public void update(Fee fee);
}
