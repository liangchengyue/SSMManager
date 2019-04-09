package com.zyp.service;



import com.zyp.pojo.User;
import com.zyp.util.Pagination;

/**
 * 用户 server
 * @author zyp
 * 定义操作用户的接口
 */
public interface UserService extends ICommonServer {
	
	//添加用户
	public void addUser(User user);
	
	//分页获取用户
	public String userList(Pagination pagination);
	
	//删除
	public void deleteUser(User user);
	/**
	 * 根据Id查询用户信息
	 * @param id 
	 * @return 用户信息
	 */
	public String fingUserById(String id);
	/**
	 * 根据id修改用户信息
	 * @param user 用户信息
	 */
	public void updateUser(User user);
	
}
