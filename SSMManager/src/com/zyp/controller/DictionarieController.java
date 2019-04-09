package com.zyp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyp.pojo.Dictionarie;
import com.zyp.service.DictionarieService;
import com.zyp.util.CreateNumber;
import com.zyp.util.Pagination;

/**
 * 字典 Controller
 * @author zyp
 * 负责转发和相应 dictionarie 的操作
 */
@Controller
@RequestMapping("/dictionarie")
public class DictionarieController {
	@Autowired
	private DictionarieService dictionarieService;

	/**
	 * 返回字典数据
	 * @return
	 */
	@RequestMapping("/toList")
	public String toList() {
		return "jsp/dictionarie/list";
	}
	
	/**
	 * 返回字典数据
	 * @param pagination
	 * @return data
	 */
	@RequestMapping("/list")
	@ResponseBody
	public String list(Pagination pagination){
		String data=dictionarieService.dictionarieList(pagination);
		return data;
	}
	
	/**
	 * 注册字典
	 * @param dictionarie
	 * @return 状态
	 */
	@RequestMapping("/regist")
	@ResponseBody
	public String regist(Dictionarie dictionarie) {
		dictionarieService.addDictionarie(dictionarie);
		return "ok";
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/detele")
	@ResponseBody
	public String delete(Dictionarie dictionarie){
		dictionarieService.deleteDictionarie(dictionarie);
		return "ok";
	}
	
	@RequestMapping("/findDictionarieById")
	@ResponseBody
	public String findUserById(String id) {
		return dictionarieService.findDictionarieByID(id);
	}
	
	@RequestMapping("/findIDAndNumberDictionarie")
	@ResponseBody
	public String findIDAndNumberdriver() {
		return dictionarieService.findIDAndNumber();
	}
	
}
