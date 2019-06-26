package com.gxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gxy.entity.DangDangUser;

public interface UserDao {

	//查询
	public List<DangDangUser> selectList();
	//用户登录
	public DangDangUser selectUser(@Param("ddUserEmail")String ddUserEmail,
								@Param("ddUserPassword")String ddUserPassword);
	//插入用户
	public int insertUser(@Param("user")DangDangUser user);
	
}
