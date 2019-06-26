<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户生成订单 - 当当网</title>
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单步骤: 1.确认订单 > 2.填写送货地址 >
			<span class="red_bold">3.订单成功</span>
		</div>


		<div class="login_success">
			<div class="login_bj">
				<div class="succ">
					<h1>购物成功！</h1>
				</div>
				<h5>
					订单已经生成
				</h5>
				<h6>
					您刚刚生成的订单号是：
					<span class="red_bold">${sessionScope.orderSSID }</span>
					<br/>
					金额总计:
					<span class="red_bold">${sessionScope.totalDDPrice }</span>
				</h6>

				<ul>
					<li class="nobj">
						您现在可以：
							<br/>
							<a href="#">微信支付</a>
							<a href="#">支付宝支付</a>
							<a href="#">在线银联卡支付</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/main/main.jsp">继续浏览并选购商品</a>
					</li>
				</ul>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

