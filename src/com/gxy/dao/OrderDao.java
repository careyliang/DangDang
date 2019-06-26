package com.gxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gxy.entity.DangDangOrder;

public interface OrderDao {

	//查询
	public List<DangDangOrder> selectList();
	//生成订单
	public int insertOrder(@Param("uuid")String uuid,
						@Param("orderTotalPrice")double orderTotalPrice,
						@Param("ddUserId")int ddUserId);
	
}
