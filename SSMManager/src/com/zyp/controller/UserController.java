package com.zyp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zyp.pojo.User;
import com.zyp.service.UserService;
import com.zyp.util.Pagination;
import com.zyp.util.SecurityUtil;
/**
 * 用户 Controller
 * @author zyp
 * 负责转发和相应 user 的操作
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	/**
	 * 返回用户数据
	 * @return
	 */
	@RequestMapping("/toList")
	public String toList() {
		return "jsp/user/list";
	}
	
	/**
	 * 返回用户数据
	 * @param pagination
	 * @return data
	 */
	@RequestMapping("/list")
	@ResponseBody
	public String list(Pagination pagination){
		String data=userService.userList(pagination);
		return data;
	}
	
	/**
	 * 注册用户
	 * @param user
	 * @return 状态
	 */
	@RequestMapping("/regist")
	@ResponseBody
	public String regist(User user) {
		user.setPassword(SecurityUtil.strToMD5(user.getPassword()));
		userService.addUser(user);
		return "ok";
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/detele")
	@ResponseBody
	public String delete(User user){
		userService.deleteUser(user);
		return "ok";
	}
	//通过id获取用户数据

	@RequestMapping("/findUserById")
	@ResponseBody
	public String findUserById(String id) {
		return userService.fingUserById(id);
	}
	//通过用户数据跟新数据库
	@RequestMapping("/update")
	@ResponseBody
	public String updateUser(User user) {
	userService.updateUser(user);
		return "";
	}
}
