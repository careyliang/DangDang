package com.gxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxy.dao.UserDao;
import com.gxy.entity.DangDangUser;
import com.gxy.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	//查询
	public List<DangDangUser> selectList(){
		List<DangDangUser> list = userDao.selectList();
		return list;
	}
	
	//用户登录
	public DangDangUser selectUser(String ddUserEmail,String ddUserPassword) {
		DangDangUser user = userDao.selectUser(ddUserEmail,ddUserPassword);
		return user;
	}
	
	//插入用户
	public int insertUser(DangDangUser user) {
		return userDao.insertUser(user);
	}
}
