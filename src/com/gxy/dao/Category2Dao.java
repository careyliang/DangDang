package com.gxy.dao;

import java.util.List;
import java.util.Map;

import com.gxy.entity.DangDangCategory2;

public interface Category2Dao {

	//查询
	public List<DangDangCategory2> selectList();
	//统计二级分类数量
	public List<Map<String,Object>> selectCountCategory2();
}
