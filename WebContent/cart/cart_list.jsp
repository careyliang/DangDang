<%@page contentType="text/html;charset=utf-8"%>
<%@page pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath}/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js" type="text/javascript"></script>
		<script type="text/javascript">
			//全局加载
			$(function(){
				//统计总价
				countTotalPrice();
				
			});
			
			//统计总价
			function countTotalPrice(){
				$.ajax({
					url:"${pageContext.request.contextPath}/cart/getCart.do",
					type:"POST",
					success:function(data){
						if(data){
							var totalPrice = data.totalPrice;
							var totalDDPrice = data.totalDDPrice;
							$("#totalSave").text(totalPrice - totalDDPrice);
							$("#totalDDPrice").text(totalDDPrice);
							
						}
					},
					dataType:"json"
				});
			}
			
			//初始检查购物车
			/* function initCart(){
				var state = "${empty sessionScope.cartList}";
				if(state == "true"){
					alert("亲，购物车是空的哦！");
				}
			} */
			
			
			//设置图书数量
			function updateCart(id){
				//获取数值值
				var value = $("#"+id+"").val();
				if(value <1){
					alert("请输入合法数量");
					return false;
				}
				$.ajax({
					url:"${pageContext.request.contextPath}/cart/setBookCount.do",
					type:"POST",
					data:{"id":id,"count":value},
					success:function(data){
						if(data){
							//重新计算总价
							countTotalPrice();
							//重新加载页面
							window.location.reload();
						}
					},
					dataType:"json"
				});
			}
			
			
		
		</script>
	</head>
	<body>

		
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="${pageContext.request.contextPath}/images/pic_myshopping.gif" />
		</div>
		
		<!-- 注释 -->
		<c:choose>
			
			<c:when test="${empty sessionScope.cartList}">
				<br/><br/><br/><br/><br/><br/><br/><br/><br/>
				<div class="choice_title"></div>
				<div class="no_select">
					亲，您的购物车是空的！
					<a href='${pageContext.request.contextPath}/main/main.jsp'> 继续挑选商品>></a>
				</div>
			</c:when>
			<c:otherwise>
				<div id="div_choice" class="choice_merch">
					<h2 id="cart_tips">
						您已选购以下商品
					</h2>
					<div class="choice_bord">
						<table class="tabl_buy" id="tbCartItemsNormal">
							<tr class="tabl_buy_title">
								<td class="buy_td_6">
									<span>封面</span>
								</td>
								<td>
									<span class="span_w1">商品名</span>
								</td>
								<td class="buy_td_5">
									<span class="span_w2">市场价</span>
								</td>
								<td class="buy_td_4">
									<span class="span_w3">当当价</span>
								</td>
								<td class="buy_td_1">
									<span class="span_w2">数量</span>
								</td>
								<td class="buy_td_2">
									<span>变更数量</span>
								</td>
								<td class="buy_td_1">
									<span>删除</span>
								</td>
							</tr>
							<tr class='objhide' over="no">
								<td colspan="8">
									&nbsp;
								</td>
							</tr>
							 
							<c:forEach var='c' items="${sessionScope.cartList }">
								<!-- 购物列表开始 -->
								<tr class='td_no_bord'>
									
									<td class="buy_td_6">
										<span><img src="${pageContext.request.contextPath}/productImages/${c.bookImg}" height="50px" width="58px"/></span>
									</td>
									<td>
										<span class="span_w1"><a href="#">${c.bookName}</a></span>
									</td>
									<td class="buy_td_5">
										<span class="c_gray">￥${c.bookPrice}</span>
									</td>
									<td class="buy_td_4">
										&nbsp;&nbsp;
										￥<span id="ddPrice">${c.bookDdprice}</span>
									</td>
									<!-- 商品数量 -->
									<td class="buy_td_1">
										&nbsp;&nbsp;${c.bookCount}
									</td>
		
									<td >
										<input id="${c.bookId}" class="del_num" type="text" size="3" maxlength="4" 
										value="${c.bookCount}" />
										<a onclick="updateCart('${c.bookId}')">变更</a>
									</td>
									<td>
										<a href="${pageContext.request.contextPath}/cart/deleteBook.do?id=${c.bookId}">删除</a>
									</td>
								</tr>
							</c:forEach>
		                      
						</table>
						
						<div class="choice_balance">
							<div class="select_merch">
								<a href='${pageContext.request.contextPath}/main/main.jsp'> 继续挑选商品>></a>
							</div>
							<div class="total_balance">
								<div class="save_total">
									您共节省：
									<span class="c_red">￥</span>
									<span id="totalSave" class="c_red"></span>
										
									<span style="font-size: 14px">|</span>
									<span class="t_add">商品金额总计：</span>
									<span class="c_red_b">￥</span>
									<span class="c_red_b" id="totalDDPrice"></span>
								</div>
								<div id="balance" class="balance">
									<a  name='checkout' href='${pageContext.request.contextPath}/order/order1.jsp' > 
										<img  src="${pageContext.request.contextPath}/images/butt_balance.gif" alt="结算" border="0" title="结算" />
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
		
		
		<!-- 用户删除恢复区 -->
		
		
		<c:if test="${empty sessionScope.cartList2 == false}">
		<br/><br/>
		<strong style="color: red;font-size:20px;text-align:center">《《《 恢  复   区 》》》</strong>
			<div id="divCartItemsRemoved" class="del_merch">
			<div class="del_title">
				您已删除以下商品，如果想重新购买，请点击“恢复”
			</div>
			<table class=tabl_del id=del_table>
				<tbody>
				<c:forEach var='c' items="${sessionScope.cartList2 }">
					<tr>
						<td width="58" class=buy_td_6>
							<span><img src="${pageContext.request.contextPath}/productImages/${c.bookImg}" height="50px" width="58px"/></span>
						</td>
						<td width="365" class=t2>
							<a href="#">${c.bookName}</a>
						</td>
						<td width="106" class=buy_td_5>
							￥${c.bookPrice}
						</td>
						<td width="134" class=buy_td_4>
							<span>￥${c.bookDdprice}</span>
						</td>
						<td width="134" class=buy_td_4>
							<span>数量：${c.bookCount}</span>
						</td>
						<td width="26" class=buy_td_1>
							<a href="${pageContext.request.contextPath}/cart/restoreBook.do?id=${c.bookId}">恢复</a>
						</td>
						<td width="26" class=buy_td_1>
							<a href="${pageContext.request.contextPath}/cart/removeBook.do?id=${c.bookId}">彻底删除</a>
						</td>
						<td width="16" class=objhide>
							&nbsp;
						</td>
					</tr>
				</c:forEach>
					<tr class=td_add_bord>
						<td colspan=8>
							&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
		</div> 
		</c:if>
		<br />
		<br />
		<br />
		<br />
		<!--页尾开始 -->
		<c:import url="/common/foot.jsp"></c:import>
		<!--页尾结束 -->
	</body>
</html>



