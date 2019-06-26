package com.gxy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gxy.entity.DangDangAddress;

public interface AddressService {

	//查询
	public List<DangDangAddress> selectList(int addressId,int ddUserId);
	//插入
	public int insertAddress(DangDangAddress address);
}
