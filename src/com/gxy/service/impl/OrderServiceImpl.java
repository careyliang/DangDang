package com.gxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxy.dao.OrderDao;
import com.gxy.entity.DangDangOrder;
import com.gxy.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	
	//查询
	public List<DangDangOrder> selectList(){
		return orderDao.selectList();
	}
	
	//生成订单
	public int insertOrder(String uuid,double totalPrice,int ddUserId) {
		int i = orderDao.insertOrder(uuid,totalPrice, ddUserId);
		return i;
	}
}
