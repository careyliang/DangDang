package com.gxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxy.dao.ProductDao;
import com.gxy.entity.DangDangBook;
import com.gxy.entity.DangDangProduct;
import com.gxy.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	//查询
	public List<DangDangProduct> selectList(){
		List<DangDangProduct> list = productDao.selectList();
		return list;
	}
	
	//查询单个商品
	public DangDangProduct selectById(int ddProductId) {
		DangDangProduct product = productDao.selectById(ddProductId);
		return product;
	}
	
	//编辑推荐 
	public List<DangDangProduct> selectRecommend(){
		List<DangDangProduct> list = productDao.selectRecommend();
		return list;
	}
	
	//查询 热销图书 
	public List<DangDangProduct> selectHot(){
		List<DangDangProduct> list = productDao.selectHot();
		return list;
	}
	
	//查询 新书热卖榜 
	public List<DangDangProduct> selectHotBoard(){
		List<DangDangProduct> list = productDao.selectHotBoard();
		return list;
	}
	
	//查询 新书热卖榜 更多
	public List<DangDangProduct> selectHotBoardMore(){
		List<DangDangProduct> list = productDao.selectHotBoardMore();
		return list;
	}
	
	//查询 最新上架图书
	public List<DangDangProduct> selectNew(){
		List<DangDangProduct> list = productDao.selectNew();
		return list;
	}
	
	//根据二级分类查询图书
	public List<DangDangProduct> selectByCategory2(int ddCategory2Id){
		return productDao.selectByCategory2(ddCategory2Id);
	}
	
	//根据二级分类查询图书
	public List<DangDangProduct> selectByCategory1(int ddCategory1Id){
		return productDao.selectByCategory1(ddCategory1Id);
	}
	
	//模糊查询 
	public List<DangDangProduct> selectLike(String ddProductName,String ddProductAuthor,String ddProductPress){
		return productDao.selectLike(ddProductName, ddProductAuthor, ddProductPress);
	}
	
	//去重查询出版社
	public List<String> selectDisPress(){
		return productDao.selectDisPress();
	}
	
	//查询图书列表
	public List<DangDangProduct> selectProductList(int id,String ddProductName,String ddProductAuthor,String ddProductPress){
		//初始化商品list
		List<DangDangProduct> productList = null;
		
		//搜索查询
		if(id==0) {
			productList = productDao.selectLike(ddProductName, ddProductAuthor, ddProductPress);
		}
		//区分一级或二级分类
		else if(id<10) {
			//查询一级分类图书
			productList = productDao.selectByCategory1(id);
		}
		else {
			//查询二级分类图书
			productList = productDao.selectByCategory2(id);
		}
		return productList;
	}
	
	//Product对象DTO Book
	public DangDangBook transferProduct(DangDangProduct product) {
		//初始化Book
		DangDangBook book = new DangDangBook();
		//图书编号，主键
		book.setBookId(product.getDdProductId());
		//图书名称
		book.setBookName(product.getDdProductName());
		//图书图片路径
		book.setBookImg(product.getDdProductImg());
		//图书市场价
		book.setBookPrice(product.getDdProductPrice());
		//图书市场价
		book.setBookDdprice(product.getDdProductDdprice());
		//图书购买数量
		//book.setBookCount();
		//状态
		//book.setBookState(0);
		return book;
	}
}
