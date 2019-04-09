package com.zyp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.zyp.mapper.OilMapper;
import com.zyp.pojo.Oil;
import com.zyp.service.OilService;
import com.zyp.util.Pagination;
import com.zyp.util.Util;
import net.sf.json.JSONObject;

public class OilServiceImpl implements OilService {
	@Autowired
	private OilMapper oilMapper;

	public void addOil(Oil oil) {
		oilMapper.insertOil(oil);
		
	}

	public String oilList(Pagination pagination) {
		List<Oil> oils=oilMapper.oilList(pagination);
		pagination.setCount(oilMapper.oilCount(pagination));
		Util<Oil> util=new Util<Oil>();
		return util.SplitPage(oils, pagination.getCount());
	}
	public void deleteOil(Oil oil) {
		oilMapper.deleteOil(oil);
	}
	
	public String fingOilById(String id) {
		// TODO Auto-generated method stub
		Oil oil=oilMapper.fingOilById(id);
		JSONObject jsonObject=JSONObject.fromObject(oil);
		return jsonObject.toString();
	}

	public void updateOil(Oil oil) {
		oilMapper.updateOil(oil);
		
	}

	
}
