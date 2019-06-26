<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath }/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.0.js"></script>
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
			})
			
			$(function(){
				$("#globalSerch").change(function(){
					$("#selectName").prop("name",$(this).val());
					//alert($("#selectName").prop("name"));
					});
			});
		  	

			</script>
	</head>
	<body>
		&nbsp;
		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		
		<!-- 头部结束 -->
		
		<!-- 头部底下的一张图片 -->
		<div style="width: 962px; margin: auto;">
			<a href="${pageContext.request.contextPath }/main/main.jsp" target="_blank"><img
					src="${pageContext.request.contextPath }/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		
		<div class="book">
			<!--左栏开始-->
			<div id="left" class="book_left">
				<!-- 发送请求加载所有的分类 -->
				<c:import url="/category/selectCategory.do"></c:import>
			</div>
			<!--左栏结束-->

			<!--中栏开始：包括推荐图书、热销图书、最新上架图书-->
			<div class="book_center">
				<!--推荐图书开始-->
				<div class="second_c_border1" id="recommend">
					<!-- 发送请求，加载推荐图书 -->
					<c:import url="/product/selectRecommed.do"></c:import>
				</div>
				<!--推荐图书结束-->

				<!--热销图书开始-->
				<div class="book_c_border2" id="hot">
					<!-- 发送请求，加载热销图书 -->
					<c:import url="/product/selectHot.do"></c:import>
				</div>
				<!--热销图书结束-->

				<!--最新上架图书开始-->
				<div class="book_c_border2" id="new">
					<!-- 发送请求，加载最新上架图书 -->
					<c:import url="/product/selectNew.do"></c:import>
				</div>
				<!--最新上架图书结束-->

				<div class="clear">
				</div>
			</div>
			<!--中栏结束-->



			<!--右栏开始-->
			<div class="book_right">
				<div class="book_r_border2" id="__XinShuReMai">
					<div class="book_r_b2_1x" id="new_bang">
						<h2 class="t_xsrm">
							新书热卖榜
						</h2>
						<!-- 发送请求，加载新手热卖榜 -->
						<c:import url="/product/selectHotBoard.do"></c:import>
						
						<div id="moreList">
							
							<h3 class="second">
								<a id="more" onclick="more()">更多&gt;&gt;</a>
							</h3>
						</div>
					</div>
				</div>
			</div>
			<!--右栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<c:import url="/common/foot.jsp"></c:import>
		<!--页尾结束 -->
	</body>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.0.js"></script>
		<script type="text/javascript">
			//右侧栏-更多
		  	function more(){
				$.ajax({
					url:"${pageContext.request.contextPath}/product/selectHotBoardMore.do",
					type:"post",
					success:function(data){
						if(data){
							$.each(data,function(index,value){
								var ddProductId = value.ddProductId;
								console.log(ddProductId);
								$("#moreList").prepend("<li>"+
										"<a target='_blank' href='${pageContext.request.contextPath }/product/selectById.do?ddProductId="+ddProductId+"   '>"
										+value.ddProductName+
										"</a></li>"); 
								
							});
							
						}
					},
					dataType:"json"
				});
		  	}
		</script>
</html>
