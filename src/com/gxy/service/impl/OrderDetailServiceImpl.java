package com.gxy.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxy.dao.OrderDetailDao;
import com.gxy.entity.DangDangAddress;
import com.gxy.entity.DangDangBook;
import com.gxy.entity.DangDangOrderDetail;
import com.gxy.entity.DangDangUser;
import com.gxy.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

	@Autowired
	private OrderDetailDao orderDetailDao;
	
	//查询
	public List<DangDangOrderDetail> selectList(){
		return orderDetailDao.selectList();
	}
	
	//插入
	public int insertDetail(DangDangOrderDetail orderDetail) {
		return orderDetailDao.insertDetail(orderDetail);
	}
	
	//生成订单详情条目
	public boolean createOrderDetail(DangDangAddress address,DangDangUser user,String orderSSID,List<DangDangBook> cartList) {
		//获取参数
		int addressId = address.getAddressId();
		int userId = user.getDdUserId();
		//循环生成多个订单详情条目 后期应改为MyBatis的批量插入
		for(DangDangBook book : cartList) {
			//获取商品参数
			String bookName = book.getBookName();
			int bookCount = book.getBookCount();
			int bookDdprice = book.getBookDdprice();
			int bookId = book.getBookId();
			//准备对象
			DangDangOrderDetail orderDetail = new DangDangOrderDetail();
			orderDetail.setDetailProductName(bookName);
			orderDetail.setDetailCount(bookCount);
			orderDetail.setDetailDdprice(bookDdprice);
			orderDetail.setDdProductId(bookId);
			orderDetail.setOrderSsid(orderSSID);
			orderDetail.setAddressId(addressId);
			orderDetail.setDdUserId(userId);
			//生成条目
			int i = orderDetailDao.insertDetail(orderDetail);
		}
		
		return true;
	}
}
