package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ssm.mapper.*;
import com.ssm.pojo.*;
import com.ssm.service.*;
import com.ssm.service.*;
import com.ssm.util.Pagination;
import com.ssm.util.SelectCustom;
import com.ssm.util.Util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class PlaceServiceImpl implements PlaceService {
	@Autowired
	@Qualifier("placeMapper")
	private PlaceMapper placeMapper;
	
	public void insert(Place info) {
		placeMapper.insert(info);
	}

	public String list(Pagination pagination) {
		List<Place> notices=placeMapper.list(pagination);
		pagination.setCount(placeMapper.count(pagination));
		Util<Place> util=new Util<Place>();
		return util.SplitPage(notices, pagination.getCount());
	}
	
	public void delete(Place data) {
		placeMapper.delete(data);
		
	}
	
	public String findById(String id) {
		Place data=placeMapper.findById(id);
		JSONObject jsonObject=JSONObject.fromObject(data);
		return jsonObject.toString();
	}
	
	public void update(Place data) {
		placeMapper.update(data);
	}

	public String findPlaceSelect() {
		List<SelectCustom> list=placeMapper.findPlaceSelect();
		String data=JSONArray.fromObject(list).toString();
		return data;
	}
	
}
