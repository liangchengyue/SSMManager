package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ssm.mapper.FeeMapper;
import com.ssm.mapper.UserMapper;
import com.ssm.pojo.Fee;
import com.ssm.pojo.User;
import com.ssm.service.FeeService;
import com.ssm.service.UserService;
import com.ssm.util.Pagination;
import com.ssm.util.Util;

import net.sf.json.JSONObject;

public class FeeServiceImpl implements FeeService {
	@Autowired
	@Qualifier("feeMapper")
	private FeeMapper feeMapper;
	public void insert(Fee fee) {
		feeMapper.insert(fee);
	}
	public String list(Pagination pagination) {
		List<Fee> fees=feeMapper.list(pagination);
		pagination.setCount(feeMapper.count(pagination));
		Util<Fee> util=new Util<Fee>();
		return util.SplitPage(fees, pagination.getCount());
	}
	public void delete(Fee fee) {
		feeMapper.delete(fee);
		
	}
	public String findById(String id) {
		Fee fee=feeMapper.findById(id);
		JSONObject jsonObject=JSONObject.fromObject(fee);
		return jsonObject.toString();
	}
	public void update(Fee fee) {
		feeMapper.update(fee);
		
	}
	
}
