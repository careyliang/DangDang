package com.gxy.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxy.dao.AddressDao;
import com.gxy.entity.DangDangAddress;
import com.gxy.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressDao addressDao;
	
	//查询
	public List<DangDangAddress> selectList(int addressId,int ddUserId){
		return addressDao.selectList(addressId,ddUserId);
	}
	
	//插入
	public int insertAddress(DangDangAddress address) {
		return addressDao.insertAddress(address);
	}
}
