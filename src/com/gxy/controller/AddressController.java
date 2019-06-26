package com.gxy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxy.entity.DangDangAddress;
import com.gxy.entity.DangDangUser;
import com.gxy.service.AddressService;
import com.gxy.service.OrderDetailService;

@Controller
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	@Autowired
	private OrderDetailService orderDetailService;
	
	//保存收货地址
	@RequestMapping("/insertAddress")
	@ResponseBody
	public boolean insertAddress(DangDangAddress address,HttpSession session) {
		//获取用户id
		DangDangUser user = (DangDangUser) session.getAttribute("user");
		if(user == null) {
			return false;
		}
		int userId = user.getDdUserId();
		address.setDdUserId(userId);
		addressService.insertAddress(address);
		return true;
	}
	
	//查询收货地址
	@RequestMapping("/queryAddress")
	@ResponseBody
	public List<DangDangAddress> queryAddress(HttpSession session){
		//获取用户id
		DangDangUser user = (DangDangUser) session.getAttribute("user");
		if(user == null) {
			return null;
		}
		int userId = user.getDdUserId();
		List<DangDangAddress> list = addressService.selectList(0, userId);
		return list;
	}
	
	//选择地址事件
	@RequestMapping("/addressChange")
	@ResponseBody
	public DangDangAddress addressChange(int addressId) {
		DangDangAddress address = addressService.selectList(addressId, 0).get(0);
		return address;
	}
	
}
