package com.zyp.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.zyp.pojo.Drecord;
import com.zyp.pojo.User;
import com.zyp.service.DrecordService;
import com.zyp.service.DriverService;
import com.zyp.service.VInfoService;
import com.zyp.util.CreateNumber;
import com.zyp.util.Pagination;

/**
 * 行车记录 Controller
 * @author zyp
 * 负责转发和相应 drecord 的操作
 */
@Controller
@RequestMapping("/drecord")
public class DrecordController {
	@Autowired
	@Qualifier("drecordService")
	private DrecordService drecordService;
	@Autowired
	private VInfoService vinfoService;
	@Autowired
	private DriverService driverService;
	/**
	 * 返回行车记录数据
	 * @return
	 */
	@RequestMapping("/toList")
	public String toList() {
		return "jsp/drecord/list";
	}
	
	/**
	 * 返回行车记录数据
	 * @param pagination
	 * @return data
	 */
	@RequestMapping("/list")
	@ResponseBody
	public String list(Pagination pagination){
		String data=drecordService.drecordList(pagination);
		return data;
	}
	
	/**
	 * 注册行车记录
	 * @param user
	 * @return 状态
	 */
	@RequestMapping("/regist")
	@ResponseBody
	public String regist(Drecord drecord) {
		drecord.setVnumber(CreateNumber.generateRandomStr(8));
		drecordService.addDrecord(drecord);
		return "ok";
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/detele")
	@ResponseBody
	public String delete(Drecord drecord){
		drecordService.deleteDrecord(drecord);
		return "ok";
	}
	
	   //通过id获取行车记录数据

		@RequestMapping("/findDrecordById")
		@ResponseBody
		public String findDrecordById(String id) {
			return drecordService.fingDrecordById(id);
		}
		
		//通过用户数据跟新数据库
		@RequestMapping("/update")
		@ResponseBody
		public String updateDrecord(Drecord drecord) {
		drecordService.updateDrecord(drecord);
			return "";
		}
		
		//时间
		@org.springframework.web.bind.annotation.InitBinder
	    public void InitBinder(HttpServletRequest request,
	            ServletRequestDataBinder binder) {
	        // 不要删除下行注释!!! 将来"yyyy-MM-dd"将配置到properties文件中
	        // SimpleDateFormat dateFormat = new
	        // SimpleDateFormat(getText("date.format", request.getLocale()));
	        SimpleDateFormat dateFormat = new SimpleDateFormat(
	                "yyyy-MM-dd");
	        dateFormat.setLenient(false);
	        binder.registerCustomEditor(Date.class, null, new CustomDateEditor(
	                dateFormat, true));
	    }
		@RequestMapping("/findIDAndNumbervinfo")
		@ResponseBody
		public String findIDAndNumbervinfo() {
			return vinfoService.findIDAndNumber();
		}
		
		@RequestMapping("/findIDAndNumberdriver")
		@ResponseBody
		public String findIDAndNumberdriver() {
			return driverService.findIDAndNumber();
		}
}
