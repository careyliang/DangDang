package com.gxy.test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.code.kaptcha.Producer;
import com.gxy.dao.AddressDao;
import com.gxy.dao.Category1Dao;
import com.gxy.dao.OrderDao;
import com.gxy.entity.DangDangAddress;
import com.gxy.entity.DangDangBook;
import com.gxy.entity.DangDangCategory1;
import com.gxy.entity.DangDangCategory2;
import com.gxy.entity.DangDangOrder;
import com.gxy.entity.DangDangOrderDetail;
import com.gxy.entity.DangDangProduct;
import com.gxy.entity.DangDangUser;
import com.gxy.service.AddressService;
import com.gxy.service.Category1Service;
import com.gxy.service.Category2Service;
import com.gxy.service.OrderDetailService;
import com.gxy.service.OrderService;
import com.gxy.service.ProductService;
import com.gxy.service.UserService;
import com.gxy.util.GeneralUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:com/gxy/config/applicationContext.xml","classpath:com/gxy/config/springmvc-servlet.xml"})
public class TestJunit {

	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private Category1Service category1Service;
	@Autowired
	private Category2Service category2Service;
	@Autowired
	private OrderService orderService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private OrderDetailService orderDetailService;
	//自动装配验证码对象
	@Autowired
	private Producer producer;
	
	@Test
	public void method7() {
		//List<DangDangOrderDetail> list = orderDetailService.selectList();
		DangDangOrderDetail orderDetail = new DangDangOrderDetail();
		orderDetail.setDetailCount(2);
		orderDetail.setDetailDdprice(12.22);
		orderDetail.setDdProductId(2);
		orderDetail.setOrderSsid("order-abc");
		orderDetail.setAddressId(12);
		orderDetail.setDdUserId(1);
		int i = orderDetailService.insertDetail(orderDetail);
		System.out.println(i);
	}
	
	@Test
	public void method6() {
		//List<DangDangAddress> list = addressService.selectList();
		List<DangDangAddress> list = addressService.selectList(1, 0);
		System.out.println(list.size());
	}
	
	@Test
	public void method5() {
		String uuid = GeneralUtil.getUUID();
		orderService.insertOrder(uuid,123.00, 1);
		List<DangDangOrder> list = orderService.selectList();
		System.out.println(list);
	}
	
	@Test
	public void getKaptcha(){
		//获取验证码字符
		String kaptcha = producer.createText();
		System.out.println(kaptcha);
	}
	
	@Test
	public void method3() {
		Map<String, Integer> map = category2Service.selectCountCategory2();
		System.out.println(map);
	}
	
	@Test
	public void method2() {
		Map<String, Integer> map = category1Service.selectCountCategory1();
		System.out.println(map);
	}
	
	@Test
	public void method4() {
		List<DangDangCategory1> list = category1Service.selectCategory();
		System.out.println(list);
		for(DangDangCategory1 c1: list) {
			System.out.println(c1);
		}
	}
	
	@Test
	public void method() throws IOException {
		//List<DangDangProduct> list = productService.selectByCategory1(1);
		//List<DangDangProduct> list = productService.selectLike(null, "1", null);
		List<String> list = productService.selectDisPress();
		DangDangProduct product = productService.selectById(53);
		DangDangBook book = productService.transferProduct(product);
		System.out.println(book);
	}
	
	@Test
	public void method1() throws IOException {
		DangDangUser user = userService.selectUser("user", "123456");
		userService.insertUser(user);
		System.out.println(user);
	}
	
}
