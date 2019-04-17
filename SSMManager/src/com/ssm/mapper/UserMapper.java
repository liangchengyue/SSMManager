package com.ssm.mapper;

import java.util.List;

import com.ssm.pojo.User;
import com.ssm.util.Pagination;
import com.ssm.util.SelectCustom;
import com.ssm.vo.UserInfo;

public interface UserMapper  {
	/**
	 * 添加用户
	 * @param info
	 */
	public void insert(User user);
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User login(User user);
	/**
	 * 获取用户列表
	 * @param pagination 分页条件
	 * @return 用户 json 数据
	 */
	public List<User> list(Pagination pagination);
	
	/**
	 * 获取用户的个数
	 * @param pagination 分页条件
	 * @return 用户个数
	 */
	public int count(Pagination pagination);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public void delete(User user);
	/**
	 * 根据Id查询用户信息
	 * @param id 
	 * @return 用户信息
	 */
	public User findById(String id);
	/**
	 * 根据id修改用户信息
	 * @param user 用户信息
	 */
	public void update(User user);
	
	//获取用户信息
	public List<SelectCustom> findIDAndNumber();
	/**
	 * 获取用户信息
	 * @param user
	 * @return
	 */
	public UserInfo findUserInfo(User user);
}
