package com.ssm.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.pojo.*;
import com.ssm.service.*;
import com.ssm.util.SecurityUtil;
import com.ssm.util.Pagination;

@Controller
@RequestMapping("/place")
public class PlaceController {
	@Autowired
	@Qualifier("placeService")
	private PlaceService placeService;
	
	/**
	 * 进入信息列表
	 * @return
	 */
	@RequestMapping("/toList")
	public String toList() {
		return "jsp/place/list";
	};
	
	/**
	 * 返回信息数据
	 * @param pagination
	 * @return data
	 */
	@RequestMapping("/list")
	@ResponseBody
	public String list(Pagination pagination,HttpServletRequest request){
		
		String data=placeService.list(pagination);
		return data;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/detele")
	@ResponseBody
	public String delete(Place data){
		placeService.delete(data);
		return "ok";
	}
	
	//通过id获取数据
	@RequestMapping("/findById")
	@ResponseBody
	public String findUserById(String id) {
		return placeService.findById(id);
	}
	
	//通过更新数据
	@RequestMapping("/update")
	@ResponseBody
	public String update(Place data) {
		placeService.update(data);
		return "";
	}
	
	/**
	 * 添加数据
	 */
	@RequestMapping("/add")
	@ResponseBody
	public String add(Place data) {
		placeService.insert(data);
		return "ok";
	}
}
