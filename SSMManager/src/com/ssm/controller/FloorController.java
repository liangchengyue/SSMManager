package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.pojo.Floor;
import com.ssm.pojo.User;
import com.ssm.service.FloorService;
import com.ssm.service.UserService;
import com.ssm.util.SecurityUtil;
import com.ssm.util.Pagination;

@Controller
@RequestMapping("/floor")
public class FloorController {
	@Autowired
	@Qualifier("floorService")
	private FloorService floorService;

	/**
	 * 添加楼房
	 */
	@RequestMapping("/add")
	@ResponseBody
	public String add(Floor floor) {
		floorService.insert(floor);
		return "ok";
	}

	/**
	 * 进入楼房列表
	 * 
	 * @return
	 */
	@RequestMapping("/toList")
	public String toList() {
		return "jsp/floor/list";
	};

	/**
	 * 返回楼房数据
	 * 
	 * @param pagination
	 * @return data
	 */
	@RequestMapping("/list")
	@ResponseBody
	public String list(Pagination pagination) {
		String data = floorService.list(pagination);
		return data;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/detele")
	@ResponseBody
	public String delete(Floor floor) {
		floorService.delete(floor);
		return "ok";
	}
	// 通过id获取楼房数据

	@RequestMapping("/findById")
	@ResponseBody
	public String findById(String id) {
		return floorService.findById(id);
	}

	// 通过楼房数据跟新数据库
	@RequestMapping("/update")
	@ResponseBody
	public String update(Floor floor) {
		floorService.update(floor);
		return "";
	}
}
