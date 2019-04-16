package com.ssm.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.service.FloorService;
import com.ssm.service.OwnerService;
import com.ssm.service.PlaceService;
import com.ssm.service.UserService;

import com.ssm.pojo.User;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/common")
public class CommonController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	@Autowired
	@Qualifier("floorService")
	private FloorService floorService;
	@Autowired
	@Qualifier("placeService")
	private PlaceService placeService;
	
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
	
	@RequestMapping("/findIDAndNumberUserId")
	@ResponseBody
	public String GetUserSelection() {
		return userService.findIDAndNumber();
	}
	
	@RequestMapping("/findIDAndNumberUserId2")
	@ResponseBody
	public String GetUserSelection2() {
		return floorService.findIDAndNumber();
	}
	@RequestMapping("/findFloorSelect")
	@ResponseBody
	public String findFloorSelect() {
		return floorService.findFloorSelect();
	}
	@RequestMapping("/findPlaceSelect")
	@ResponseBody
	public String findPlaceSelect() {
		return placeService.findPlaceSelect();
	}
}
