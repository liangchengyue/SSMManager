package com.zyp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyp.pojo.Oil;
import com.zyp.pojo.User;
import com.zyp.service.DriverService;
import com.zyp.service.OilService;
import com.zyp.service.UserService;
import com.zyp.service.VInfoService;
import com.zyp.util.CreateNumber;
import com.zyp.util.Pagination;

/**
 * 油量 Controller
 * 
 * @author zyp 负责转发和相应 oil 的操作
 */
@Controller
@RequestMapping("/oil")
public class OilController {
	@Autowired
	private OilService oilService;

	@Autowired
	private VInfoService vinfoService;

	@Autowired
	private UserService userService;

	@Autowired
	private DriverService driverService;

	/**
	 * 返回油量数据
	 * 
	 * @return
	 */
	@RequestMapping("/toList")
	public String toList() {
		return "jsp/oil/list";
	}

	/**
	 * 返回油量数据
	 * 
	 * @param pagination
	 * @return data
	 */
	@RequestMapping("/list")
	@ResponseBody
	public String list(Pagination pagination) {
		String data = oilService.oilList(pagination);
		return data;
	}

	/**
	 * 注册油量
	 * 
	 * @param VInspection
	 * @return 状态
	 */
	@RequestMapping("/regist")
	@ResponseBody
	public String regist(Oil oil) {
		oil.setVnumber(CreateNumber.generateRandomStr(8));
		oilService.addOil(oil);
		return "ok";
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/detele")
	@ResponseBody
	public String delete(Oil oil) {
		oilService.deleteOil(oil);
		return "ok";
	}

	// 通过id获取油量数据
	@RequestMapping("/findOilById")
	@ResponseBody
	public String findOilById(String id) {
		return oilService.fingOilById(id);
	}

	// 通过油量数据跟新数据库
	@RequestMapping("/update")
	@ResponseBody
	public String updateOil(Oil oil) {
		oilService.updateOil(oil);
		return "";
	}

	// 时间
	@org.springframework.web.bind.annotation.InitBinder
	public void InitBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		// 不要删除下行注释!!! 将来"yyyy-MM-dd"将配置到properties文件中
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat(getText("date.format", request.getLocale()));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping("/findIDAndNumberVinfo")
	@ResponseBody
	public String findIDAndNumberVinfo() {
		return vinfoService.findIDAndNumber();
	}

	@RequestMapping("/findIDAndNumberDriver")
	@ResponseBody
	public String findIDAndNumberdriver() {
		return driverService.findIDAndNumber();
	}

	@RequestMapping("/findIDAndNumberUserId")
	@ResponseBody
	public String findIDAndNumberUser() {
		return userService.findIDAndNumber();
	}
}
