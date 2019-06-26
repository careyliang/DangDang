package com.gxy.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Producer;
import com.gxy.entity.DangDangUser;
import com.gxy.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	//自动装配验证码对象
	@Autowired
	private Producer producer;
	
	//检查验证码
	@RequestMapping("/checkKaptcha")
	@ResponseBody
	public boolean checkKaptcha(String verifyCode,HttpSession session) {
		//获取session中的验证码
		String kaptcha = (String) session.getAttribute("kaptcha");
		if(verifyCode.equals(kaptcha)) {
			return true;
		}
		return false;
	}
	
	//登录
	@RequestMapping("/login")
	@ResponseBody
	public String login(String ddUserEmail,String ddUserPassword,HttpSession session) {
		DangDangUser user = userService.selectUser(ddUserEmail, ddUserPassword);
		//登录成功
		if(user != null) {
			//存入用户对象
			session.setAttribute("user", user);
			return "true";
		}
		//登录失败
		return "fail";
	}

	//用户注销，清除所有session
	@RequestMapping("/clearSessionUser")
	public String clearSession(HttpSession session){
		//session.removeAttribute("user");
		Enumeration<String> em = session.getAttributeNames();
		while(em.hasMoreElements()){
			String value = em.nextElement().toString();
			session.removeAttribute(value);
		}
		return "redirect:/user/login.jsp";
	}
	
	//获取验证码
	@RequestMapping("/validateCode")
	public void getKaptcha(HttpSession session,HttpServletResponse response){
		//获取验证码字符
		String kaptcha = producer.createText();
		//保留验证码，存储在session中
		session.setAttribute("kaptcha", kaptcha);
		//把字符加干扰线装进图片
		BufferedImage image = producer.createImage(kaptcha);
		//然后再用流的方式把图片响应给请求端
		try {
			ImageIO.write(image, "jpg", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//用户注册
	@RequestMapping("/registUser")
	@ResponseBody
	public boolean registUser(HttpSession session,String ddUserEmail,
							String ddUserNickName,String ddUserPassword,String verifyCode) {
		//获取session中的验证码
		String kaptcha = (String) session.getAttribute("kaptcha");
		if(verifyCode.equals(kaptcha)) {
			//拼接对象
			DangDangUser user = new DangDangUser();
			user.setDdUserEmail(ddUserEmail);
			user.setDdUserNickName(ddUserNickName);
			user.setDdUserPassword(ddUserPassword);
			//存入session
			session.setAttribute("registUser", user);
			return true;
		}
		return false;
	}
	
	//添加用户
	@RequestMapping("/insertUser")
	@ResponseBody
	public boolean insertUser(HttpSession session) {
		//获取session中的注册用户信息
		DangDangUser user = (DangDangUser) session.getAttribute("registUser");
		if(user != null) {
			int i = userService.insertUser(user);
			if(i>0) {
				return true;
			}
		}
		return false;
	}
	

}
