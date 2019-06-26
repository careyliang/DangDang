package com.gxy.service;

import java.util.List;
import java.util.Map;

import com.gxy.entity.DangDangCategory1;

public interface Category1Service {

	//查询
	public List<DangDangCategory1> selectList();
	//分类关联
	public List<DangDangCategory1> selectCategory();
	//统计一级分类数量
	public Map<String,Integer> selectCountCategory1();
}
