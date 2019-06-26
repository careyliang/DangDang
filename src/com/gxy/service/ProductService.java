package com.gxy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gxy.entity.DangDangBook;
import com.gxy.entity.DangDangProduct;

public interface ProductService {
	
	//查询
	public List<DangDangProduct> selectList();
	//编辑推荐 
	public List<DangDangProduct> selectRecommend();
	//查询 热销图书 
	public List<DangDangProduct> selectHot();
	//查询 最新上架图书
	public List<DangDangProduct> selectNew();
	//查询 新书热卖榜 
	public List<DangDangProduct> selectHotBoard();
	//查询 新书热卖榜 更多
	public List<DangDangProduct> selectHotBoardMore();
	//查询单个商品
	public DangDangProduct selectById(int ddProductId);
	//根据二级分类查询图书
	public List<DangDangProduct> selectByCategory2(int ddCategory2Id);
	//根据二级分类查询图书
	public List<DangDangProduct> selectByCategory1(int ddCategory1Id);
	//模糊查询 
	public List<DangDangProduct> selectLike(String ddProductName,String ddProductAuthor,String ddProductPress);
	//去重查询出版社
	public List<String> selectDisPress();
	//查询图书列表
	public List<DangDangProduct> selectProductList(int id,String ddProductName,String ddProductAuthor,String ddProductPress);
	//Product对象DTO
	public DangDangBook transferProduct(DangDangProduct product);

}
