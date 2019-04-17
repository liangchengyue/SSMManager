package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ssm.mapper.FloorMapper;
import com.ssm.pojo.Floor;
import com.ssm.service.FloorService;
import com.ssm.util.Pagination;
import com.ssm.util.SelectCustom;
import com.ssm.util.Util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class FloorServiceImpl implements FloorService {
	@Autowired
	@Qualifier("floorMapper")
	private FloorMapper floorMapper;
	public void insert(Floor floor) {
		floorMapper.insert(floor);
	}
	public String list(Pagination pagination) {
		List<Floor> floors=floorMapper.list(pagination);
		pagination.setCount(floorMapper.count(pagination));
		Util<Floor> util=new Util<Floor>();
		return util.SplitPage(floors, pagination.getCount());
	}
	public void delete(Floor floor) {
		floorMapper.delete(floor);
		
	}
	public String findById(String id) {
		Floor floor=floorMapper.findById(id);
		JSONObject jsonObject=JSONObject.fromObject(floor);
		return jsonObject.toString();
	}
	public void update(Floor floor) {
		floorMapper.update(floor);
	}
	
	public String findIDAndNumber() {
		List<SelectCustom> list=floorMapper.findIDAndNumber();
		String data=JSONArray.fromObject(list).toString();
		return data;
	}
	public String findFloorSelect() {
		List<SelectCustom> list=floorMapper.findFloorSelect();
		String data=JSONArray.fromObject(list).toString();
		return data;
	
	}
	
}
