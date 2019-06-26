package com.gxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gxy.entity.DangDangOrderDetail;

public interface OrderDetailDao {

	//查询
	public List<DangDangOrderDetail> selectList();
	//插入
	public int insertDetail(@Param("orderDetail")DangDangOrderDetail orderDetail);
}
