package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.pojo.User;
import com.ssm.service.UserService;
import com.ssm.util.SecurityUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "jsp/user/register";
	}
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "jsp/user/login";
	}
	@RequestMapping("/register")
	public void register() {
		User user=new User();
		user.setUserName("admin");
		user.setPassword("123qwe");
		user.setType("0");
		user.setName("管理员");
		user.setAge(23);
		user.setSex("男");
		user.setPhone("13078507782");
		user.setPassword(SecurityUtil.strToMD5(user.getPassword()));
		userService.insert(user);
	}
}
