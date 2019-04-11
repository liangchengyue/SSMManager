package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.pojo.User;
import com.ssm.service.UserService;
import com.ssm.util.SecurityUtil;
import com.ssm.util.Pagination;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	/**
	 * 跳转到注册页面
	 * @return
	 */
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "jsp/user/register";
	}
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "jsp/user/login";
	}
	/**
	 * 用户注册
	 */
	@RequestMapping("/register")
	@ResponseBody
	public String register(User user) {
		user.setPassword(SecurityUtil.strToMD5(user.getPassword()));
		userService.insert(user);
		return "ok";
	}
	/**
	 * 用户登录
	 * @param user 用户信息
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String login(User user,HttpServletRequest request){
		 user.setPassword(SecurityUtil.strToMD5(user.getPassword()));
		 User user2=userService.login(user);
		 if (user2==null) {//登录失败
			return "登录失败";
		}else {//登录成功
			request.getSession().setAttribute("user", user);
			if (user2.getType()=="0") {//管理员登录
				return "管理员";
			}else {//普通用户登录
				return "普通用户";
			}
		}
	}
	/**
	 * 退出
	 * @param request
	 * @return
	 */
	@RequestMapping("/loginOut")
	public String loginOut(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "jsp/user/login";
	}
	/**
	 * 进入用户列表
	 * @return
	 */
	@RequestMapping("/toList")
	public String toList() {
		return "jsp/user/list";
	};
	/**
	 * 返回用户数据
	 * @param pagination
	 * @return data
	 */
	@RequestMapping("/list")
	@ResponseBody
	public String list(Pagination pagination){
		String data=userService.list(pagination);
		return data;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/detele")
	@ResponseBody
	public String delete(User user){
		userService.delete(user);
		return "ok";
	}
	//通过id获取用户数据

	@RequestMapping("/findById")
	@ResponseBody
	public String findUserById(String id) {
		return userService.findById(id);
	}
	//通过用户数据跟新数据库
	@RequestMapping("/update")
	@ResponseBody
	public String update(User user) {
	userService.update(user);
		return "";
	}
}
