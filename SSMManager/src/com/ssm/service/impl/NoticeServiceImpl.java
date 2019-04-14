package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ssm.mapper.*;
import com.ssm.pojo.*;
import com.ssm.service.*;
import com.ssm.service.*;
import com.ssm.util.Pagination;
import com.ssm.util.Util;

import net.sf.json.JSONObject;

public class NoticeServiceImpl implements NoticeService {
	@Autowired
	@Qualifier("noticeMapper")
	private NoticeMapper noticeMapper;
	
	public void insert(Notice info) {
		noticeMapper.insert(info);
	}

	public String list(Pagination pagination) {
		List<Notice> notices=noticeMapper.list(pagination);
		pagination.setCount(noticeMapper.count(pagination));
		Util<Notice> util=new Util<Notice>();
		return util.SplitPage(notices, pagination.getCount());
	}
	
	public void delete(Notice notice) {
		noticeMapper.delete(notice);
		
	}
	
	public String findById(String id) {
		Notice notice=noticeMapper.findById(id);
		JSONObject jsonObject=JSONObject.fromObject(notice);
		return jsonObject.toString();
	}
	
	public void update(Notice notice) {
		noticeMapper.update(notice);
	}
	
}
