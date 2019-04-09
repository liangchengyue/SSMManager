package com.zyp.service.impl;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.zyp.custom.SelectCustom;
import com.zyp.mapper.UserMapper;
import com.zyp.pojo.User;
import com.zyp.service.UserService;
import com.zyp.util.Pagination;
import com.zyp.util.Util;
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;

	public void addUser(User user) {
		userMapper.insertUser(user);
		
	}

	public String userList(Pagination pagination) {
		List<User> users=userMapper.userList(pagination);
		pagination.setCount(userMapper.userCount(pagination));
		Util<User> util=new Util<User>();
		return util.SplitPage(users, pagination.getCount());
	}

	public void deleteUser(User user) {
		userMapper.deleteUser(user);
	}

	public String fingUserById(String id) {
		// TODO Auto-generated method stub
		User user=userMapper.fingUserById(id);
		JSONObject jsonObject=JSONObject.fromObject(user);
		return jsonObject.toString();
	}

	public void updateUser(User user) {
		userMapper.updateUser(user);
		
	}

	public String findIDAndNumber() {
		List<SelectCustom> list=userMapper.findIDAndNumber();
		String data=JSONArray.fromObject(list).toString();
		return data;
	}

	
}
