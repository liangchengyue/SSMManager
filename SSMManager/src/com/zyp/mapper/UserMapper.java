package com.zyp.mapper;

import java.util.List;

import com.zyp.custom.SelectCustom;
import com.zyp.pojo.User;
import com.zyp.util.Pagination;

/***
 * 用户mapper
 * @author zyp
 *
 */
public interface UserMapper {
	/**
	 * 插入用户
	 * @param user
	 */
	public void insertUser(User user);
	
	/**
	 * 获取用户列表
	 * @param pagination 分页条件
	 * @return 用户 json 数据
	 */
	public List<User> userList(Pagination pagination);
	
	/**
	 * 获取用户的个数
	 * @param pagination 分页条件
	 * @return 用户个数
	 */
	public int userCount(Pagination pagination);
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public void deleteUser(User user);
	/**
	 * 根据Id查询用户信息
	 * @param id 
	 * @return 用户信息
	 */
	public User fingUserById(String id);
	/**
	 * 根据id修改用户信息
	 * @param user 用户信息
	 */
	public void updateUser(User user);
	
	public List<SelectCustom> findIDAndNumber();
}
