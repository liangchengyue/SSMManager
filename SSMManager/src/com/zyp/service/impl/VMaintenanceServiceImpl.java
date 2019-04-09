package com.zyp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.zyp.mapper.VMaintenanceMapper;
import com.zyp.pojo.Drecord;
import com.zyp.pojo.User;
import com.zyp.pojo.VMaintenance;
import com.zyp.service.VMaintenanceService;
import com.zyp.util.Pagination;
import com.zyp.util.Util;

import net.sf.json.JSONObject;

public class VMaintenanceServiceImpl implements VMaintenanceService {
	@Autowired
	private VMaintenanceMapper vmaintenanceMapper;

	public void addVMaintenance(VMaintenance vmaintenance) {
		vmaintenanceMapper.insertVMaintenance(vmaintenance);
		
	}

	public String vmaintenanceList(Pagination pagination) {
		List<VMaintenance> vmaintenances=vmaintenanceMapper.vmaintenanceList(pagination);
		pagination.setCount(vmaintenanceMapper.vmaintenanceCount(pagination));
		Util<VMaintenance> util=new Util<VMaintenance>();
		return util.SplitPage(vmaintenances, pagination.getCount());
	}

	public void deleteVMaintenance(VMaintenance vmaintenance) {
		vmaintenanceMapper.deleteVMaintenance(vmaintenance);
	}
	
	public String fingVMaintenanceById(String id) {
		// TODO Auto-generated method stub
		VMaintenance vmaintenance=vmaintenanceMapper.fingVMaintenanceById(id);
		JSONObject jsonObject=JSONObject.fromObject(vmaintenance);
		return jsonObject.toString();
	}

	public void updateVMaintenance(VMaintenance vmaintenance) {
		vmaintenanceMapper.updateVMaintenance(vmaintenance);
		
	}

	
}
