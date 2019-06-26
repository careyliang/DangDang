<%@page contentType="text/html;charset=utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
ul li {
	text-decoration: none;
	list-style-type: none;
	line-height: 20px;
}

body {
	font-family: 宋体, Arial, Helvetica, sans-serif;
	font-size: 12px;
	background: #769b72 url(../images/booksaleimg/bg_grad.gif) top center
		no-repeat;
	cursor: default;
	color: #404040;
	margin: 0;
	padding: 0;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script type="text/javascript">
	/* 购买时，点击添加进入订单项 传入一个bookid */
	function addCart(id) {
		$("#buy"+id).prop("src","${pageContext.request.contextPath}/cart/addBook.do?id="+id+"&time="+new Date().getTime());
		setTimeout("t1('"+id+"')",10);
		setTimeout("t2('"+id+"')",1000);
		setTimeout("t3('"+id+"')",1500);
	}
	/*0秒   从点击购买小图标           1秒  到反应小图标          1.5秒 到购买成功的对勾小图标*/
	function t1(id) {
		$("#buy"+id).prop("src","${pageContext.request.contextPath}/images/load.gif");
	}
	function t2(id) {
		$("#buy"+id).prop("src","${pageContext.request.contextPath}/images/label3.gif");
	}
	function t3(id) {
		$("#buy"+id).prop("src","${pageContext.request.contextPath}/images/buttom_goumai.gif");
	}
	</script>
</head>
<body>
	<div style="width: 60%;margin:20px auto;">
		<div style="width:100%;float: left;">
			<h1>
				${product.ddProductName }
			</h1>
			<div>
				<div style="float: left;width:20%;">
					<img
						src="${pageContext.request.contextPath}/productImages/${product.ddProductImg }"
						border=0 />
				</div>
				<div style="float: left;width:80%">
					<ul class="info">
						<li>作&nbsp;者：${product.ddProductAuthor }</li>
						<li>出版社：${product.ddProductPress }</li>
						<li style="float:left;width:50%;">
							出版时间：${product.ddProductPresstime }
						</li>
						<li style="float:left;width:50%;">
							字数：${product.ddProductWordcount }
						</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">
							版本号：${product.ddProductEdition }
						</li>
						<li style="float:left;width:50%;">
							页数：${product.ddProductPagecount }
						</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">
							印刷时间：${product.ddProductPrinttime }
						</li>
						<li style="float:left;width:50%;">
							页面规格：${product.ddProductFormat }
						</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">
							印次：${product.ddProductPrintcount }
						</li>
						<li style="float:left;width:50%;">
							纸张：${product.ddProductPaper }
						</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">
							ISBN：${product.ddProductIsbn }
						</li>
						<li style="float:left;width:50%;">
							包装：${product.ddProductPack }
						</li>
						<li>
							<div class='your_position'>
								您现在的位置:&nbsp; <a href='../main/main.jsp'>当当图书</a> &gt;&gt; 
								<font style='color: #cc3300'> 
									<strong> 图书展示
									</strong>
								</font>
							</div>
						</li>
						<li>定价：￥${product.ddProductPrice }&nbsp;&nbsp;
							当当价：￥${product.ddProductDdprice }&nbsp;&nbsp; 
							节省：￥${product.ddProductPrice -  product.ddProductDdprice}</li>
						<li><a href="javascript:void(0)"> <img
								src='../images/buttom_goumai.gif' class="abc"
								id="buy${product.ddProductId }"
								onclick="addCart('${product.ddProductId }')" />
								
						</a></li>
					</ul>
				</div>
				<div style="float: clear;"></div>
			</div>
		</div>

		<div style="width:100%;float: left;">
			<hr width="" size="1">
				<div>
					<h2>编辑推荐</h2>
					${product.ddProductRecommend }
				</div>
			</hr>
			<hr width="" size="1">
				<div>
					<h2>内容简介</h2>
					${product.ddProductBrief }
				</div>
			</hr>
			<hr width="" size="1">
				<div>
					<h2>作者简介</h2>
					${product.ddProductAuthorbrief }
				</div>
			</hr>
			<hr width="" size="1">
				<div>
					<h2>目录</h2>
					${product.ddProductDirectory }
				</div>
			</hr>
			<hr width="" size="1">
				<div>
					<h2>媒体评论</h2>
					${product.ddProductMediacomment }
				</div>
			</hr>
			<hr width="" size="1">
				<div>
					<h2>书摘插图</h2>
					${product.ddProductExcerpt }
				</div>
			</hr>
			<div>
				<div style="float: clear"></div>
				<p>&nbsp;</p>
			</div>
		</div>
	</div>
	<!--页尾开始 -->
	<%@include file="../common/foot.jsp"%>
	<!--页尾结束 -->
</body>
</html>