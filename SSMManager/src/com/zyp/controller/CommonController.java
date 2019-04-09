package com.zyp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CommonController {
	@RequestMapping("/toFrame")
	public String toFrame() {
		return "jsp/frame";
	}
	@RequestMapping("/toDataServer")
	public String toDataServer() {
		return "jsp/data_server";
	}
}
