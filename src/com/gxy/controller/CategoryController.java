package com.gxy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gxy.entity.DangDangCategory1;
import com.gxy.service.Category1Service;
import com.gxy.service.Category2Service;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private Category1Service category1Service;
	@Autowired
	private Category2Service category2Service;
	
	//查询关联分类
	@RequestMapping("/selectCategory")
	public String selectCategory(Model model) {
		//查询关联分类
		List<DangDangCategory1> list = category1Service.selectCategory();
		model.addAttribute("list", list);
		return "forward:/main/category.jsp";
	}
}
