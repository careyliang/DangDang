package com.gxy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxy.entity.DangDangBook;
import com.gxy.entity.DangDangProduct;
import com.gxy.service.CartService;
import com.gxy.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CartService cartService;
	
	//获取session中的购物车
	@RequestMapping("/getCart")
	@ResponseBody
	public Map<String,Double> getCart(HttpSession session) {
		List<DangDangBook> cartList = (List<DangDangBook>) session.getAttribute("cartList");
		Map<String, Double> map = cartService.countPrice(cartList);
		//当当总价存入session
		session.setAttribute("totalDDPrice", map.get("totalDDPrice"));
		return map;
	}
	
	//添加图书
	@RequestMapping("/addBook")
	public String addBook(int id,HttpSession session) {
		List<DangDangBook> cartList = cartService.getCart(session);
		//根据id查询对象
		DangDangProduct product = productService.selectById(id);
		//调用service方法，完成DTO
		DangDangBook book = productService.transferProduct(product);
		//添加对象进入购物车list
		cartService.addCart(cartList, book);
		//将购物车存入session
		session.setAttribute("cartList", cartList);
		return "redirect:/cart/cart_list.jsp";
	}
	
	//自定义图书数量
	@RequestMapping("/setBookCount")
	@ResponseBody
	public boolean setBookCount(HttpSession session,int id, int count) {
		List<DangDangBook> cartList = (List<DangDangBook>) session.getAttribute("cartList");
		for(DangDangBook book : cartList) {
			int bookId = book.getBookId();
			if(bookId == id) {
				book.setBookCount(count);
				//将购物车存入session
				session.setAttribute("cartList", cartList);
				//跳出循环
				break;
			}
		}
		return true;
	}
	
	//删除图书
	@RequestMapping("/deleteBook")
	public String deleteBook(HttpSession session,int id) {
		List<DangDangBook> cartList = (List<DangDangBook>) session.getAttribute("cartList");
		for(DangDangBook book : cartList) {
			int bookId = book.getBookId();
			if(bookId == id) {
				//删除到恢复区
				List<DangDangBook> cartList2 = cartService.removeToStore(session, book);
				//将恢复区放入session
				session.setAttribute("cartList2", cartList2);
				//删除目标图书
				cartList.remove(book);
				//将购物车存入session
				session.setAttribute("cartList", cartList);
				//跳出循环
				break;
			}
		}
		return "redirect:/cart/cart_list.jsp";
	}
	
	//删除图书恢复
	@RequestMapping("/restoreBook")
	public String restoreBook(HttpSession session,int id) {
		//获取cartList
		List<DangDangBook> cartList = (List<DangDangBook>) session.getAttribute("cartList");
		//获取cart2List
		List<DangDangBook> cartList2 = (List<DangDangBook>) session.getAttribute("cartList2");
		//初始化恢复对象
		DangDangBook targetBook = null;
		//获取恢复对象
		for(DangDangBook book2 : cartList2) {
			if(id == book2.getBookId()) {
				targetBook = book2;
			}
		}
		//cartList添加商品
		cartService.addCart(cartList, targetBook);
		//cartList2删除商品
		cartList2.remove(targetBook);
		//放回session
		session.setAttribute("cartList", cartList);
		session.setAttribute("cartList2", cartList2);
		return "redirect:/cart/cart_list.jsp";
	}
	
	//彻底删除
	@RequestMapping("/removeBook")
	public String removeBook(HttpSession session,int id) {
		//获取cart2List
		List<DangDangBook> cartList2 = (List<DangDangBook>) session.getAttribute("cartList2");
		//获取恢复对象
		for(DangDangBook book2 : cartList2) {
			if(id == book2.getBookId()) {
				cartList2.remove(book2);
				session.setAttribute("cartList2", cartList2);
				break;
			}
		}
		return "redirect:/cart/cart_list.jsp";
	}
}
