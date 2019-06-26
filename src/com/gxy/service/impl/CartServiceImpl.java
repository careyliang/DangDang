package com.gxy.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.gxy.entity.DangDangBook;
import com.gxy.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	//获取购物车
	public List<DangDangBook> getCart(HttpSession session) {
		//初始化购物车
		List<DangDangBook> cart = null;
		//尝试获取session中的购物车
		cart = (List<DangDangBook>) session.getAttribute("cartList");
		if(cart == null) {
			cart = new ArrayList<DangDangBook>();
		}
		return cart;
	}

	//购物车添加
	public List<DangDangBook> addCart(List<DangDangBook> cart,DangDangBook book) {
		//获取图书id
		int bookId = book.getBookId();
		for(DangDangBook b : cart) {
			//表示商品重复
			if(bookId == b.getBookId()) {
				//不添加商品，仅叠加数量
				int count = b.getBookCount();
				b.setBookCount(++count);
				return cart;
			}
		}
		//判断是否是新书
		int bookCount = book.getBookCount();
		//新书数量置1
		if(bookCount == 0) {
			book.setBookCount(1);
		}
		//恢复原数量
		else {
			book.setBookCount(bookCount);
		}
		//无重复，添加该图书
		cart.add(book);
		return cart;
	}
	
	//计算购物车内商品价格
	public Map<String,Double> countPrice(List<DangDangBook> cartList){
		//初始化反参
		HashMap<String, Double> map = new HashMap<String,Double>();
		//初始化市场总价
		double totalPrice = 0.0;
		//初始化当当总价
		double totalDDPrice = 0.0;
		if(cartList != null) {
			for(DangDangBook book : cartList) {
				totalPrice = totalPrice + book.getBookPrice()*book.getBookCount();
				totalDDPrice = totalDDPrice + book.getBookDdprice()*book.getBookCount();
			}
		}
		map.put("totalPrice", totalPrice);
		map.put("totalDDPrice", totalDDPrice);
		return map;
	}
	
	//删除到恢复区
	public List<DangDangBook> removeToStore(HttpSession session,DangDangBook book){
		//初始化恢复区
		List<DangDangBook> cartList2 = null;
		//尝试获取session中的购物车
		cartList2 = (List<DangDangBook>) session.getAttribute("cartList2");
		if(cartList2 == null) {
			cartList2 = new ArrayList<DangDangBook>();
		}
		//重复，叠加数量
		for(DangDangBook b : cartList2) {
			//表示商品重复
			if(book.getBookId() == b.getBookId()) {
				//不删除商品，仅叠加数量
				int count = b.getBookCount();
				b.setBookCount(count+book.getBookCount());
				return cartList2;
			}
		}
		//不重复，直接添加
		cartList2.add(book);
		return cartList2;
	}
	

}
