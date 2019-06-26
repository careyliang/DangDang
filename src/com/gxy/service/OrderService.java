package com.gxy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gxy.entity.DangDangOrder;

public interface OrderService {

	//查询
	public List<DangDangOrder> selectList();
	//生成订单
	public int insertOrder(String uuid,double totalPrice,int ddUserId);
}
