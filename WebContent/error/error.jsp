<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript">
		var second=10;
		$(function() {
			$("#redirectToMain").text(second+"");
			var fuc = function(){
				second-=1;
				$("#redirectToMain").text(second+"");
				if(second == 0) {
					window.location.href="${pageContext.request.contextPath}/main/main.jsp";
				}else{
					setTimeout(fuc,1000);//这里必须传入函数名   不能传fuc()
				}
			};
			fuc();//开始倒计时
		});
		</script>
	</head>
	<body>
		&nbsp;
		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->
		<div style="width: 962px; margin: auto;">
			<a href="../main/main.jsp" target="_blank"><img
					src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div style="width: 962px; height:400px;margin:auto;">
					<font style="color:red;font-size:20px;">
						页面在<span id="redirectToMain" style="color:blue;" ></span>秒后将重新转回主界面
				 	</font>
				<center>
					<img src="../images/error.jpg" width="500px"/>
				</center>	
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
