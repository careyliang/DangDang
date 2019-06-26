package com.gxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gxy.entity.DangDangAddress;

public interface AddressDao {

	//查询
	public List<DangDangAddress> selectList(@Param("addressId")int addressId,@Param("ddUserId")int ddUserId);
	//插入
	public int insertAddress(DangDangAddress address);
}
