package com.zyp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zyp.custom.SelectCustom;
import com.zyp.mapper.DictionarieMapper;
import com.zyp.pojo.Dictionarie;
import com.zyp.pojo.User;
import com.zyp.service.DictionarieService;
import com.zyp.util.Pagination;
import com.zyp.util.Util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DictionarieServiceImpl implements DictionarieService {
	@Autowired
	private DictionarieMapper dictionarieMapper;

	public void addDictionarie(Dictionarie dictionarie) {
		dictionarieMapper.insertDictionarie(dictionarie);
		
	}

	public String dictionarieList(Pagination pagination) {
		List<Dictionarie> dictionaries=dictionarieMapper.dictionarieList(pagination);
		pagination.setCount(dictionarieMapper.dictionarieCount(pagination));
		Util<Dictionarie> util=new Util<Dictionarie>();
		return util.SplitPage(dictionaries, pagination.getCount());
	}
	
	public void deleteDictionarie(Dictionarie dictionarie) {
		dictionarieMapper.deleteDictionarie(dictionarie);
	}

	/**
	 * 获取下拉列表
	 */
	public String findIDAndNumber() {
		List<SelectCustom> list=dictionarieMapper.findIDAndNumber();
		String data=JSONArray.fromObject(list).toString();
		return data;
	}

	public String findDictionarieByID(String id) {
		Dictionarie dic=dictionarieMapper.fingUserById(id);
		JSONObject jsonObject=JSONObject.fromObject(dic);
		return jsonObject.toString();
	}
	
}
