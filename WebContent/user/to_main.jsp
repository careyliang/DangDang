<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript">
		var second=10;
		$(function() {
			$("#redirectToMain").text(second+"");
			var fuc = function(){
				second-=1;
				$("#redirectToMain").text(second+"");
				if(second == 0) {
					window.location.href="${pageContext.request.contextPath}/order/address_form.jsp";
				}else{
					setTimeout(fuc,1000);//这里必须传入函数名   不能传fuc()
				}
			};
			fuc();//开始倒计时
		});
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤: 1.填写信息 > 2.验证邮箱 >
			<span class="red_bold">3.注册成功</span>
		</div>


		<div class="login_success">
			<div class="login_bj">
				<div class="succ">
					<img src="${pageContext.request.contextPath}/images/login_success.jpg" />
				</div>
				<h5>
					<s:property value="#session.user.nickname"/>，已成功注册称为当当网的一员
				</h5>
				<div style="margin:auto;">
					<font style="color:red;font-size:10px;">
						页面在<span id="redirectToMain" style="color:blue;" ></span>秒后将重新转回填写地址的页面
				 	</font>
				 	<br />
				 	<a href="${pageContext.request.contextPath}/order/address_form.jsp">若转入失败，可以点击这里</a>
				 </div>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

