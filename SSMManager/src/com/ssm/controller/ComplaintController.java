package com.ssm.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.pojo.Complaint;
import com.ssm.pojo.User;
import com.ssm.service.ComplaintService;
import com.ssm.util.Pagination;

@Controller
@RequestMapping("/complaint")
public class ComplaintController {
	@Autowired
	@Qualifier("complaintService")
	private ComplaintService complaintService;
	/**
	 * 添加投诉
	 */
	@RequestMapping("/add")
	@ResponseBody
	public String add(Complaint complaint,HttpServletRequest request) {
		complaint.setTime(new Date());
		User user=(User)request.getSession().getAttribute("user");
		if(user==null)
			return "error";
		complaint.setUserId(user.getId());
		complaintService.insert(complaint);
		return "ok";
	}
	/**
	 * 进入投诉列表
	 * @return
	 */
	@RequestMapping("/toList")
	public String toList() {
		return "jsp/complaint/list";
	};
	/**
	 * 返回投诉数据
	 * @param pagination
	 * @return data
	 */
	@RequestMapping("/list")
	@ResponseBody
	public String list(Pagination pagination,HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("user");
		if(user.getType().equals("0")) {
			pagination.setUserId(user.getId());
		}
		String data=complaintService.list(pagination);
		return data;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/detele")
	@ResponseBody
	public String delete(Complaint complaint){
		complaintService.delete(complaint);
		return "ok";
	}
	//通过id获取投诉数据

	@RequestMapping("/findById")
	@ResponseBody
	public String findById(String id) {
		return complaintService.findById(id);
	}
	//通过投诉数据跟新数据库
	@RequestMapping("/update")
	@ResponseBody
	public String update(Complaint complaint) {
	complaintService.update(complaint);
		return "";
	}
}
