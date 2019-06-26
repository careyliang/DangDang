package com.gxy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxy.dao.Category2Dao;
import com.gxy.entity.DangDangCategory2;
import com.gxy.service.Category2Service;

@Service
public class Category2ServiceImpl implements Category2Service{
	
	@Autowired
	private Category2Dao category2Dao;
	
	//查询
	public List<DangDangCategory2> selectList(){
		List<DangDangCategory2> list = category2Dao.selectList();
		return list;
	}
	
	//统计二级分类数量
	public Map<String,Integer> selectCountCategory2(){
		List<Map<String, Object>> list = category2Dao.selectCountCategory2();
		//初始化一级分类Map
		Map<String, Integer> map = new HashMap<String,Integer>();
		for(Map<String, Object> m : list) {
			//获取一级分类ID
			String ddCategory1Id = m.get("ddCategory2Id").toString();
			//获取一级分类数量
			int category1Count = Integer.parseInt(m.get("category2Count").toString());
			//放入map
			map.put(ddCategory1Id, category1Count);
		}
		return map;
	}

}
