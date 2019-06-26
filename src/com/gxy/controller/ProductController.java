package com.gxy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxy.entity.DangDangCategory1;
import com.gxy.entity.DangDangCategory2;
import com.gxy.entity.DangDangProduct;
import com.gxy.service.Category1Service;
import com.gxy.service.Category2Service;
import com.gxy.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private Category1Service category1Service;
	@Autowired
	private Category2Service category2Service;
	
	//查询单个商品
	@RequestMapping("/selectById")
	public String selectById(Model model,int ddProductId) {
		DangDangProduct product = productService.selectById(ddProductId);
		model.addAttribute("product", product);
		return "forward:/main/product.jsp";
	}
	
	//查询-编辑推荐
	@RequestMapping("/selectRecommed")
	public String selectRecommend(Model model) {
		List<DangDangProduct> list = productService.selectRecommend();
		model.addAttribute("list", list);
		return "forward:/main/recommend.jsp";
	}
	
	//查询-热卖榜
	@RequestMapping("/selectHot")
	public String selectHot(Model model) {
		List<DangDangProduct> list = productService.selectHot();
		model.addAttribute("list", list);
		return "forward:/main/hot.jsp";
	}
	
	//查询 新书热卖榜 
	@RequestMapping("/selectHotBoard")
	public String selectHotBoard(Model model){
		List<DangDangProduct> list = productService.selectHotBoard();
		model.addAttribute("list", list);
		return "forward:/main/hotBoard.jsp";
	}
	
	//查询 新书热卖榜 
	@RequestMapping("/selectHotBoardMore")
	@ResponseBody
	public List<DangDangProduct> selectHotBoardMore(){
		List<DangDangProduct> list = productService.selectHotBoardMore();
		return list;
	}
	
	//查询-最新上架
	@RequestMapping("/selectNew")
	public String selectNew(Model model) {
		List<DangDangProduct> list = productService.selectNew();
		model.addAttribute("list", list);
		return "forward:/main/new.jsp";
	}
	
	//查询商品和分类
	@RequestMapping("/selectProductAndCategory")
	public String selectCategory2(Model model,int id,String ddProductName,String ddProductAuthor,String ddProductPress) {
		//获取图书list
		List<DangDangProduct> productList = productService.selectProductList(id, ddProductName, ddProductAuthor, ddProductPress);
		//放入图书list
		model.addAttribute("productList", productList);
		//放入历史查询数据
		model.addAttribute("ddProductName", ddProductName);
		model.addAttribute("ddProductAuthor", ddProductAuthor);
		model.addAttribute("ddProductPress", ddProductPress);
		
		
		//统计一级分类数量
		Map<String, Integer> c1Map = category1Service.selectCountCategory1();
		//统计二级分类数量
		Map<String, Integer> c2Map = category2Service.selectCountCategory2();
		//初始化全部分类数量
		int totalCategoryCount = 0;
		//查询关联分类
		List<DangDangCategory1> categoryList = category1Service.selectCategory();
		//遍历关联分类
		for(DangDangCategory1 c1 : categoryList) {
			//获取一级分类id
			String category1Id = String.valueOf(c1.getDdCategory1Id());
			//获取一级分类数量
			Integer category1Count = c1Map.get(category1Id);
			//空值处理
			if(category1Count == null) {
				category1Count = 0;
			}
			//叠加全部量
			totalCategoryCount = totalCategoryCount+category1Count;
			//放入一级分类数量
			c1.setDdCategory1Count(category1Count);
			//遍历二级分类
			for(DangDangCategory2 c2 : c1.getListCategory2()) {
				//获取二级分类id
				String category2Id = String.valueOf(c2.getDdCategory2Id());
				//获取二级分类数量
				Integer category2Count = c2Map.get(category2Id);
				//空值处理
				if(category2Count == null) {
					category2Count = 0;
				}
				//放入二级分类数量
				c2.setDdCategory2Count(category2Count);
			}
			
		}
		//放入分类list
		model.addAttribute("categoryList", categoryList);
		//放入选中id
		model.addAttribute("chooseId", id);
		//放入全部分类量
		model.addAttribute("totalCategoryCount", totalCategoryCount);
		return "forward:/main/book_list.jsp";
	}
	
	//动态加载查询-出版社
	@RequestMapping("/searchPress")
	@ResponseBody
	public List<String> searchPress(){
		List<String> list = productService.selectDisPress();
		return list;
	}
	
	//查询功能
/*	@RequestMapping("/searchBook")
	@ResponseBody
	public List<DangDangProduct> searchBook(String ddProductName,String ddProductAuthor,String ddProductPress){
		List<DangDangProduct> list = productService.selectLike(ddProductName, ddProductAuthor, ddProductPress);
		return list;
	}*/
	
}
