package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ssm.mapper.ComplaintMapper;
import com.ssm.mapper.UserMapper;
import com.ssm.pojo.Complaint;
import com.ssm.pojo.User;
import com.ssm.service.ComplaintService;
import com.ssm.service.UserService;
import com.ssm.util.Pagination;
import com.ssm.util.Util;

import net.sf.json.JSONObject;

public class ComplaintServiceImpl implements ComplaintService {
	@Autowired
	@Qualifier("complaintMapper")
	private ComplaintMapper complaintMapper;
	public void insert(Complaint info) {
		complaintMapper.insert(info);
	}
	public String list(Pagination pagination) {
		List<Complaint> complaints=complaintMapper.list(pagination);
		pagination.setCount(complaintMapper.count(pagination));
		Util<Complaint> util=new Util<Complaint>();
		return util.SplitPage(complaints, pagination.getCount());
	}
	public void delete(Complaint complaint) {
		complaintMapper.delete(complaint);
		
	}
	public String findById(String id) {
		Complaint complaint=complaintMapper.findById(id);
		JSONObject jsonObject=JSONObject.fromObject(complaint);
		return jsonObject.toString();
	}
	public void update(Complaint complaint) {
		complaintMapper.update(complaint);
	}
	
}
