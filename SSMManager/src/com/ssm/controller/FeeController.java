package com.ssm.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.pojo.Fee;
import com.ssm.pojo.User;
import com.ssm.service.FeeService;
import com.ssm.util.Pagination;

@Controller
@RequestMapping("/fee")
public class FeeController {
	@Autowired
	@Qualifier("feeService")
	private FeeService feeService;

	/**
	 * 添加费用
	 */
	@RequestMapping("/add")
	@ResponseBody
	public String add(Fee fee,HttpServletRequest request) {
		User user=(User)request.getSession().getAttribute("user");
		if (user==null) {
			return "error";
		}
		fee.setUserId(user.getId());
		fee.setTime(new Date());
		feeService.insert(fee);
		return "ok";
	}

	/**
	 * 进入费用列表
	 * 
	 * @return
	 */
	@RequestMapping("/toList")
	public String toList() {
		return "jsp/fee/list";
	};

	/**
	 * 返回费用数据
	 * 
	 * @param pagination
	 * @return data
	 */
	@RequestMapping("/list")
	@ResponseBody
	public String list(Pagination pagination,HttpServletRequest request) {
		User user=(User)request.getSession().getAttribute("user");
		if(user.getType().equals("0")) {
			pagination.setUserId(user.getId());
		}
		String data = feeService.list(pagination);
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
	public String delete(Fee fee) {
		feeService.delete(fee);
		return "ok";
	}
	// 通过id获取费用数据

	@RequestMapping("/findById")
	@ResponseBody
	public String findById(String id) {
		return feeService.findById(id);
	}

	// 通过费用数据跟新数据库
	@RequestMapping("/update")
	@ResponseBody
	public String update(Fee fee) {
		feeService.update(fee);
		return "";
	}
}
