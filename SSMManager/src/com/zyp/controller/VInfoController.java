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
import com.zyp.pojo.VInfo;
import com.zyp.service.VInfoService;
import com.zyp.util.CreateNumber;
import com.zyp.util.Pagination;

/**
 * 车辆 Controller
 * @author zyp
 * 负责转发和相应 vinfo 的操作
 */
@Controller
@RequestMapping("/vinfo ")
public class VInfoController {
	@Autowired
	@Qualifier("vinfoService")
	private VInfoService vinfoService;

	/**
	 * 返回车辆数据
	 * @return
	 */
	@RequestMapping("/toList")
	public String toList() {
		return "jsp/vinfo/list";
	}
	
	/**
	 * 返回车辆数据
	 * @param pagination
	 * @return data
	 */
	@RequestMapping("/list")
	@ResponseBody
	public String list(Pagination pagination){
		String data=vinfoService.vinfoList(pagination);
		return data;
	}
	
	/**
	 * 注册车辆
	 * @param vinfo
	 * @return 状态
	 */
	@RequestMapping("/regist")
	@ResponseBody
	public String regist(VInfo vinfo) {
		vinfo.setVnumber(CreateNumber.generateRandomStr(8));
		vinfoService.addVInfo(vinfo);
		return "ok";
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/detele")
	@ResponseBody
	public String delete(VInfo vinfo){
		vinfoService.deleteVInfo(vinfo);
		return "ok";
	}
	
	 //通过id获取用户数据
	@RequestMapping("/findVInfoById")
	@ResponseBody
	public String findVInfoById(String id) {
		return vinfoService.fingVInfoById(id);
	}
	
	 //通过用户数据跟新数据库
	@RequestMapping("/update")
	@ResponseBody
	public String updateVInfo(VInfo vinfo) {
		vinfoService.updateVInfo(vinfo);
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
		
	}
	

