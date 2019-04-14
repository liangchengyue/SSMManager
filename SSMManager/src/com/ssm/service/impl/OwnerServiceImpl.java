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

public class OwnerServiceImpl implements OwnerService {
	@Autowired
	@Qualifier("ownerMapper")
	private OwnerMapper ownerMapper;
	
	public void insert(Owner info) {
		ownerMapper.insert(info);
	}

	public String list(Pagination pagination) {
		List<Owner> datas=ownerMapper.list(pagination);
		pagination.setCount(ownerMapper.count(pagination));
		Util<Owner> util=new Util<Owner>();
		return util.SplitPage(datas, pagination.getCount());
	}
	
	public void delete(Owner data) {
		ownerMapper.delete(data);
		
	}
	
	public String findById(String id) {
		Owner data=ownerMapper.findById(id);
		JSONObject jsonObject=JSONObject.fromObject(data);
		return jsonObject.toString();
	}
	
	public void update(Owner data) {
		ownerMapper.update(data);
	}
	
}
