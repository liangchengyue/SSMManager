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
@RequestMapping("/owner")
public class OwnerController {
	@Autowired
	@Qualifier("ownerService")
	private OwnerService ownerService;
	
	/**
	 * 进入信息列表
	 * @return
	 */
	@RequestMapping("/toList")
	public String toList() {
		return "jsp/owner/list";
	};
	
	/**
	 * 返回信息数据
	 * @param pagination
	 * @return data
	 */
	@RequestMapping("/list")
	@ResponseBody
	public String list(Pagination pagination){
		String data=ownerService.list(pagination);
		return data;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/detele")
	@ResponseBody
	public String delete(Owner data){
		ownerService.delete(data);
		return "ok";
	}
	
	//通过id获取数据
	@RequestMapping("/findById")
	@ResponseBody
	public String findUserById(String id) {
		return ownerService.findById(id);
	}
	
	//通过更新数据
	@RequestMapping("/update")
	@ResponseBody
	public String update(Owner data) {
		ownerService.update(data);
		return "";
	}
	
	/**
	 * 添加数据
	 */
	@RequestMapping("/add")
	@ResponseBody
	public String add(Owner data) {
		data.setTime(new Date());
		ownerService.insert(data);
		return "ok";
	}
}
