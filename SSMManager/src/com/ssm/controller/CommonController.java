package com.ssm.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.pojo.User;

@Controller
@RequestMapping("/common")
public class CommonController {
	@RequestMapping("/toFrame")
	public String toFrame(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "redirect:/user/toLogin";
		}
		return "jsp/common/frame";
	}

	@RequestMapping("/toUser")
	public String toUser() {
		return "jsp/common/user";
	}
	@RequestMapping("/toAdmin")
	public String toAdmin() {
		return "jsp/common/admin";
	}
}
