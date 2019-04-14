package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ssm.mapper.*;
import com.ssm.pojo.*;
import com.ssm.service.*;
import com.ssm.service.*;
import com.ssm.util.Pagination;
import com.ssm.util.Util;

import net.sf.json.JSONObject;

public class RepairServiceImpl implements RepairService {
	@Autowired
	@Qualifier("repairMapper")
	private RepairMapper repairMapper;
	
	public void insert(Repair info) {
		repairMapper.insert(info);
	}

	public String list(Pagination pagination) {
		List<Repair> datas=repairMapper.list(pagination);
		pagination.setCount(repairMapper.count(pagination));
		Util<Repair> util=new Util<Repair>();
		return util.SplitPage(datas, pagination.getCount());
	}
	
	public void delete(Repair data) {
		repairMapper.delete(data);
		
	}
	
	public String findById(String id) {
		Repair data=repairMapper.findById(id);
		JSONObject jsonObject=JSONObject.fromObject(data);
		return jsonObject.toString();
	}
	
	public void update(Repair data) {
		repairMapper.update(data);
	}
	
}
