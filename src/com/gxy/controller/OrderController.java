package com.gxy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxy.entity.DangDangAddress;
import com.gxy.entity.DangDangBook;
import com.gxy.entity.DangDangUser;
import com.gxy.service.AddressService;
import com.gxy.service.OrderDetailService;
import com.gxy.service.OrderService;
import com.gxy.util.GeneralUtil;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private OrderDetailService orderDetailService;
	
	//生成订单，地址，订单详情条目
	@RequestMapping("/createOrder")
	@ResponseBody
	public boolean createOrder(HttpSession session,DangDangAddress address) {
		//获取总价
		double totalDDPrice = (double) session.getAttribute("totalDDPrice");
		//获取用户id
		DangDangUser user = (DangDangUser) session.getAttribute("user");
		//非空判断
		if(user == null) {
			return false;
		}
		int userId = user.getDdUserId();
		//获取购物车
		List<DangDangBook> cartList = (List<DangDangBook>) session.getAttribute("cartList");
		//生成订单号uuid
		String orderSSID = GeneralUtil.getUUID();
		//生成订单条目
		orderService.insertOrder(orderSSID,totalDDPrice, userId);
		//生成地址条目
		//address.setDdUserId(userId);
		//addressService.insertAddress(address);
		//生成订单详情条目
		orderDetailService.createOrderDetail(address, user,orderSSID,cartList);
		//存入订单号到session
		session.setAttribute("orderSSID", orderSSID);
		return true;
	}
}
