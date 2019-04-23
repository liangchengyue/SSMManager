package com.ssm.service.impl;

import java.util.Date;
import java.util.List;

import javax.sound.midi.MidiDevice.Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.FloorMapper;
import com.ssm.mapper.OwnerMapper;
import com.ssm.mapper.PlaceMapper;
import com.ssm.mapper.UserMapper;
import com.ssm.pojo.Floor;
import com.ssm.pojo.Owner;
import com.ssm.pojo.Place;
import com.ssm.pojo.User;
import com.ssm.service.UserService;
import com.ssm.util.Pagination;
import com.ssm.util.SelectCustom;
import com.ssm.util.Util;
import com.ssm.vo.UserInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UserServiceImpl implements UserService {
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;
	@Autowired
	@Qualifier("ownerMapper")
	private OwnerMapper ownerMapper;
	@Autowired
	@Qualifier("floorMapper")
	private FloorMapper floorMapper;
	@Autowired
	@Qualifier("placeMapper")
	private PlaceMapper placeMapper;
	public void insert(User info) {
		userMapper.insert(info);
	}
	public User login(User user) {
		return userMapper.login(user);
	}
	public String list(Pagination pagination) {
		List<User> users=userMapper.list(pagination);
		pagination.setCount(userMapper.count(pagination));
		Util<User> util=new Util<User>();
		return util.SplitPage(users, pagination.getCount());
	}
	public void delete(User user) {
		userMapper.delete(user);
		
	}
	public String findById(String id) {
		User user=userMapper.findById(id);
		JSONObject jsonObject=JSONObject.fromObject(user);
		return jsonObject.toString();
	}
	public void update(User user) {
		userMapper.update(user);
	}
	
	public String findIDAndNumber() {
		List<SelectCustom> list=userMapper.findIDAndNumber();
		String data=JSONArray.fromObject(list).toString();
		return data;
	}
	public UserInfo findUserInfo(User user) {
		return userMapper.findUserInfo(user);
//		JSONObject jsonObject=JSONObject.fromObject(info);
//		return jsonObject.toString();
	}
	@Transactional
	public User updateInfo(UserInfo userInfo) {
		//更新用户信息
		User user=userMapper.findById(userInfo.getUserid()+"");
		user.setName(userInfo.getUname());
		user.setAge(userInfo.getAge());
		user.setSex(userInfo.getSex());
		user.setPhone(userInfo.getPhone());
		userMapper.update(user);
		Owner owner=ownerMapper.findById(user.getId()+"");
		if(owner==null)
		{
			owner=new Owner();
			owner.setId(user.getId());
			owner.setFloorid(userInfo.getFid());
			owner.setIdcard(userInfo.getIdcard());
			owner.setNumber(userInfo.getNumber());
			owner.setTime(new Date());
			owner.setPlaceid(userInfo.getPid());
			Floor floor=floorMapper.findById(userInfo.getFid()+"");
			floor.setState("是");
			floorMapper.update(floor);
			Place place=placeMapper.findById(userInfo.getPid()+"");
			place.setState("是");
			placeMapper.update(place);

			ownerMapper.insert(owner);
			
		}else {
			owner.setIdcard(userInfo.getIdcard());
			owner.setNumber(userInfo.getNumber());
			ownerMapper.update(owner);
		}
		return userMapper.findById(user.getId()+"");
	}
	
}
