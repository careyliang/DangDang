package com.gxy.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxy.dao.Category1Dao;
import com.gxy.dao.Category2Dao;
import com.gxy.entity.DangDangCategory1;
import com.gxy.entity.DangDangCategory2;
import com.gxy.service.Category1Service;

@Service
public class Category1ServiceImpl implements Category1Service{

	@Autowired
	private Category1Dao category1Dao;
	@Autowired
	private Category2Dao category2Dao;
	
	//查询
	public List<DangDangCategory1> selectList(){
		List<DangDangCategory1> list = category1Dao.selectList();
		return list;
	}
	
	//分类关联
	public List<DangDangCategory1> selectCategory(){
		List<DangDangCategory1> list = category1Dao.selectCategory();
		return list;
	}
	
	//统计一级分类数量
	public Map<String,Integer> selectCountCategory1(){
		List<Map<String, Object>> list = category1Dao.selectCountCategory1();
		//初始化一级分类Map
		Map<String, Integer> map = new HashMap<String,Integer>();
		for(Map<String, Object> m : list) {
			//获取一级分类ID
			String  ddCategory1Id = m.get("ddCategory1Id").toString();
			//获取一级分类数量
			int category1Count = Integer.parseInt(m.get("category1Count").toString());
			//放入map
			map.put(ddCategory1Id, category1Count);
		}
		return map;
	}
	
}
