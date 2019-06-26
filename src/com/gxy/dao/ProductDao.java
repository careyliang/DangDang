package com.gxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gxy.entity.DangDangProduct;

public interface ProductDao {

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
	public DangDangProduct selectById(@Param("ddProductId")int ddProductId);
	//根据二级分类查询图书
	public List<DangDangProduct> selectByCategory2(@Param("ddCategory2Id")int ddCategory2Id);
	//根据一级分类查询图书
	public List<DangDangProduct> selectByCategory1(@Param("ddCategory1Id")int ddCategory1Id);
	//模糊查询 
	public List<DangDangProduct> selectLike(@Param("ddProductName")String ddProductName,
										@Param("ddProductAuthor")String ddProductAuthor,
										@Param("ddProductPress")String ddProductPress);
	//去重查询出版社
	public List<String> selectDisPress();
}
