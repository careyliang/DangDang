package com.gxy.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.gxy.entity.DangDangBook;


public interface CartService {

	//获取购物车
	public List<DangDangBook> getCart(HttpSession session);
	//购物车添加
	public List<DangDangBook> addCart(List<DangDangBook> cart, DangDangBook book);
	//计算购物车内商品价格
	public Map<String,Double> countPrice(List<DangDangBook> cartList);
	//删除到恢复区
	public List<DangDangBook> removeToStore(HttpSession session,DangDangBook book);
	
}
