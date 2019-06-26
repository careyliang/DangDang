<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>当当图书 – 全球最大的中文网上书店</title>
<link href="${pageContext.request.contextPath}/css/book.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/second.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/secBook_Show.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/list.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
$(function(){
	var x = 10;
	var y = 20;
	$("img.dang_img").mouseover(function(e){
		this.myTitle = this.title;
		this.title = "";	
		var imgTitle = this.myTitle? "<br/>" + this.myTitle : "";
		var tooltip = "<div id='tooltip'><img height='200px' width='150px' src='"+ this.src +"' alt='产品预览图'/>"+imgTitle+"<\/div>"; //创建 div 元素
		$("body").append(tooltip);	//把它追加到文档中						 
		$("#tooltip").css({
				"top": (e.pageY+y) + "px",
				"left":  (e.pageX+x)  + "px"
			}).show("fast");	  //设置x坐标和y坐标，并且显示
    	}).mouseout(function(){
			this.title = this.myTitle;	
			$("#tooltip").remove();	 //移除 
    	}).mousemove(function(e){
			$("#tooltip")
				.css({
					"top": (e.pageY+y) + "px",
					"left":  (e.pageX+x)  + "px"
				});
		});
	});




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
	&nbsp;

	<!-- 头部开始 -->
	<%@include file="../common/head.jsp"%>
	<!-- 头部结束 -->

	<div style="width: 962px; margin: auto;">
		<a href="#"><img src="${pageContext.request.contextPath}/images/default/book_banner_081203.jpg"
			border="0" /> </a>
	</div>
	<!-- 您的位置 -->
	<div class='your_position'>
		您现在的位置:&nbsp; <a href="${pageContext.request.contextPath}/main/main.jsp">当当图书</a>&gt;&gt; 
		<font style='color: #cc3300'> 
			<strong> 图书展示</strong>
		</font> 
	</div>

	<div class="book">

	<!--左栏开始-->
		<div id="left" class="book_left">
			<div id="__fenleiliulan">
				<div class=second_l_border2>
					<h2>分类浏览</h2>
					<ul>
						<!-- 全部 -->
						<li>
							<div>
								<div class=second_fenlei>
									&middot;<span id="span1">全部</span>&nbsp;
									(${totalCategoryCount })
								</div>
							</div>
						</li>
						<li>
							<div class="clear"></div>
						</li>
						<!-- 分类列表展示开始 -->
						<li>
							<c:forEach var='c1' items="${requestScope.categoryList }">
								<div>
									<div class="second_fenlei">&middot;
										<!-- 一级分类 -->
										<a href="${pageContext.request.contextPath}/product/selectProductAndCategory.do?id=${c1.ddCategory1Id}">
											<c:choose>
												<c:when test="${chooseId == c1.ddCategory1Id }">
													<!-- 名称 -->
													<strong style="color:red">${c1.ddCategory1Name }</strong>
													<!-- 数量 -->
													(${c1.ddCategory1Count })
												</c:when>
												<c:otherwise>
													<span id="">${c1.ddCategory1Name }</span>
													(${c1.ddCategory1Count })
												</c:otherwise>
											</c:choose>
										</a>
									</div>
									<br/>
									<!-- 二级分类 -->
									<ul class="ul_left_list">
										<c:forEach var='c2'  items="${c1.listCategory2 }">
											<a href="${pageContext.request.contextPath}/product/selectProductAndCategory.do?id=${c2.ddCategory2Id}">
												<c:choose>
													<c:when test="${chooseId == c2.ddCategory2Id }">
														<strong style="color:red">${c2.ddCategory2Name }</strong>
														<!-- 数量 -->
														(${c2.ddCategory2Count })
													</c:when>
													<c:otherwise>
														<span id="">${c2.ddCategory2Name} </span>
														(${c2.ddCategory2Count })
													</c:otherwise>
												</c:choose>
											</a><br/>
									</c:forEach>
									</ul>
								</div>
							</c:forEach>
						</li>
					</ul>
				</div>
			</div>
		</div>
	<!--左栏结束-->

		<!--中栏开始-->
		<div class="book_center">

			<!--图书列表开始-->
			<div id="divRight" class="list_right">

				<div id="book_list" class="list_r_title">
					<div class="list_r_title_text">
						图书名称：
						<input id="ddProductName" type="text" value="${ddProductName }"/>
						作者：
						<input id="ddProductAuthor" type="text" value="${ddProductAuthor }"/>
						出版社：
						<select id="ddProductPress" style="width:160px">
						
						</select>
						
						<button onclick="searchBook()">查询</button>
					</div>
					<div id="divTopPageNavi" class="list_r_title_text3">
					
					</div>
				</div>
				<!--分页导航结束-->
				
				
				
				<!--商品条目开始-->
				<div class="list_r_line"></div>
				<div class="clear"></div>
					<c:forEach var='s' items="${requestScope.productList }">
						<div class="list_r_list">
								<span class="list_r_list_book"> <a
									href="${pageContext.request.contextPath }/product/selectById.do?ddProductId=${s.ddProductId}"
									target='_blank'> <img 
										src="${pageContext.request.contextPath}/productImages/${s.ddProductImg }"
										border="0" /></a>
								</span>
								<h2>
									<a
										href="${pageContext.request.contextPath }/product/selectById.do?ddProductId=${s.ddProductId}"
										target='_blank'> 书名：${s.ddProductName }</a>
								</h2>
								<h3>
									顾客评分：
								</h3>
								<h4 class="list_r_list_h4">
									作 者: ${s.ddProductAuthor }
								</h4>
								<h4>
									出版社：${s.ddProductPress }
								</h4>
								<h4>
									出版时间：${s.ddProductPresstime }
								</h4>
								<h5>
									内容简介：${s.ddProductBrief }
								</h5>
								<div class="clear"></div>
								<h6>
									<span class="del">定价：￥${s.ddProductPrice }&nbsp;&nbsp;
									</span> <span class="red">当当价：￥${s.ddProductDdprice }&nbsp;&nbsp;
									</span> 节省：￥${s.ddProductPrice -  s.ddProductDdprice}
								</h6> 
								<span class="list_r_list_button">
								<a href="javascript:void(0)">
										<img src='${pageContext.request.contextPath}/images/buttom_goumai.gif' class="abc"
										id="buy${s.ddProductId }"
										onclick="addCart('${s.ddProductId }')" />
								</a>
								<span id="cartinfo"></span></span>
							</div>
					</c:forEach>
						
				<div class="clear"></div>
				<!--商品条目结束-->

				<div class="clear"></div>
				<div id="divBottomPageNavi" class="fanye_bottom"></div>

			</div>
			<!--图书列表结束-->

		</div>
		<!--中栏结束-->
		<div class="clear"></div>
	</div>

	<!--页尾开始 -->
	<%@include file="../common/foot.jsp"%>
	<!--页尾结束 -->
</body>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.0.js"></script>
	<script type="text/javascript">
		//全局加载
		$(function(){
			//动态加载查询-出版社
			searchPress();
			
		});
		
		
		//动态加载查询-出版社
		function searchPress(){
			$.ajax({
				url:"${pageContext.request.contextPath }/product/searchPress.do",
				type:"post",
				success:function(data){
					if(data){
						$("#ddProductPress").append("<option value="+0+"></option>");
						//动态添加选项
						for(var i=0;i<data.length;i++){
							var value = data[i];
							$("#ddProductPress").append("<option value="+value+">"+value+"</option>");
						}
					}
				},
				dataType:"json"
			});
		}
		
		//图书查询
		function searchBook(){
			var ddProductName = $("#ddProductName").val();
			var ddProductAuthor = $("#ddProductAuthor").val();
			var ddProductPress = $("#ddProductPress").val();
			//出版社空值处理
			if(ddProductPress == 0){
				ddProductPress = "";
			}
			window.location.href="${pageContext.request.contextPath}/product/selectProductAndCategory.do?ddProductName="+ddProductName+"&ddProductAuthor="+ddProductAuthor+"&ddProductPress="+ddProductPress+"&id=0";
		}
	</script>
</html>
