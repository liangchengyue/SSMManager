package com.zyp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.zyp.custom.SelectCustom;
import com.zyp.mapper.DriverMapper;
import com.zyp.pojo.Drecord;
import com.zyp.pojo.Driver;
import com.zyp.pojo.User;
import com.zyp.service.DriverService;
import com.zyp.util.Pagination;
import com.zyp.util.Util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DriverServiceImpl implements DriverService {
	@Autowired
	@Qualifier("driverMapper")
	private DriverMapper driverMapper;

	public void addDriver(Driver driver) {
		driverMapper.insertDriver(driver);
		
	}

	public String driverList(Pagination pagination) {
		List<Driver> drivers=driverMapper.driverList(pagination);
		pagination.setCount(driverMapper.driverCount(pagination));
		Util<Driver> util=new Util<Driver>();
		return util.SplitPage(drivers, pagination.getCount());
	}
	public void deleteDriver(Driver driver) {
		driverMapper.deleteDriver(driver);
	}
	
	public String fingDriverById(String id) {
		// TODO Auto-generated method stub
		Driver driver=driverMapper.fingDriverById(id);
		JSONObject jsonObject=JSONObject.fromObject(driver);
		return jsonObject.toString();
	}

	public void updateDriver(Driver driver) {
		driverMapper.updateDriver(driver);
		
	}
    
	public String findIDAndNumber() {
		List<SelectCustom> list=driverMapper.findIDAndNumber();
		String data=JSONArray.fromObject(list).toString();
		return data;
	}
	
	
}
