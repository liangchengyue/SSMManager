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
import org.springframework.web.servlet.ModelAndView;

import com.zyp.pojo.Driver;
import com.zyp.pojo.User;
import com.zyp.service.DriverService;
import com.zyp.util.CreateNumber;
import com.zyp.util.Pagination;
import com.zyp.util.SecurityUtil;
/**
 * 驾驶员 Controller
 * @author zyp
 * 负责转发和相应 驾驶员 的操作
 */
@Controller
@RequestMapping("/driver")
public class DriverController {
	@Autowired
	@Qualifier("driverService")
	private DriverService driverService;

	/**
	 * 返回用户数据
	 * @return
	 */
	@RequestMapping("/toList")
	public String toList() {
		
		return "jsp/dirver/list";
	}
	
	/**
	 * 返回用户数据
	 * @param pagination
	 * @return data
	 */
	@RequestMapping("/list")
	@ResponseBody
	public String list(Pagination pagination){
		String data=driverService.driverList(pagination);
		return data;
	}
	
	/**
	 * 注册用户
	 * @param user
	 * @return 状态
	 */
	@RequestMapping("/regist")
	@ResponseBody
	public String regist(Driver driver) {
		driver.setNumber(CreateNumber.generateRandomStr(8));
		driverService.addDriver(driver);
		return "ok";
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/detele")
	@ResponseBody
	public String delete(Driver driver){
		driverService.deleteDriver(driver);
		return "ok";
	}
	 
	 //通过id获取驾驶员数据
	@RequestMapping("/findDriverById")
	@ResponseBody
	public String findDriverById(String id) {
		return driverService.fingDriverById(id);
	}
	
	 //通过驾驶员数据跟新数据库
	@RequestMapping("/update")
	@ResponseBody
	public String updateDriver(Driver driver) {
	driverService.updateDriver(driver);
		return "";
	}
	
	//时间
	@org.springframework.web.bind.annotation.InitBinder
    public void InitBinder(HttpServletRequest request,
            ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null, new CustomDateEditor(
                dateFormat, true));
    }
}
