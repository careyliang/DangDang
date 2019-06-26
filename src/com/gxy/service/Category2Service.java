package com.gxy.service;

import java.util.List;
import java.util.Map;

import com.gxy.entity.DangDangCategory2;

public interface Category2Service {

	//查询
	public List<DangDangCategory2> selectList();
	//统计一级分类数量
	public Map<String,Integer> selectCountCategory2();
}
