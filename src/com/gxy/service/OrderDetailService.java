package com.gxy.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;

import com.gxy.entity.DangDangAddress;
import com.gxy.entity.DangDangBook;
import com.gxy.entity.DangDangOrderDetail;
import com.gxy.entity.DangDangUser;

public interface OrderDetailService {

	//查询
	public List<DangDangOrderDetail> selectList();
	//插入
	public int insertDetail(DangDangOrderDetail orderDetail);
	//生成订单详情条目
	public boolean createOrderDetail(DangDangAddress address,DangDangUser user,String orderSSID,List<DangDangBook> cartList);
}
