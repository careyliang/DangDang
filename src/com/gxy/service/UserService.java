package com.gxy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gxy.entity.DangDangUser;

public interface UserService {
	
	//查询
	public List<DangDangUser> selectList();
	//用户登录
	public DangDangUser selectUser(String ddUserEmail,String ddUserPassword);
	//插入用户
	public int insertUser(DangDangUser user);

}
