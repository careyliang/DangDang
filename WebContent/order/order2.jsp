<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>生成订单 - 当当网</title>
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script type="text/javascript">
		//全局加载
		$(function(){
			//动态加载查询-地址列表
			queryAddress();
			
		});
		
		//动态加载查询-地址列表
		function queryAddress(){
			$.ajax({
				url:"${pageContext.request.contextPath }/address/queryAddress.do",
				type:"post",
				success:function(data){
					if(data){
						//动态添加选项
						for(var i=0;i<data.length;i++){
							var addressAdd = data[i].addressAdd;
							var addressId = data[i].addressId;
							$("#address").append("<option value="+addressId+">"+addressAdd+"</option>");
						}
					}
				},
				dataType:"json"
			});
		}
		
		//选择地址事件
		function addressChange(obj){
			//获取地址id
			var addressId = obj.value;
			$.ajax({
				url:"${pageContext.request.contextPath }/address/addressChange.do",
				data:{"addressId":addressId},
				type:"post",
				success:function(data){
					/* alert(data.addressReceiveName);
					alert(data.addressAdd);
					alert(data.addressZipcode);
					alert(data.addressMobile); */
					$("#receiveName").val(data.addressReceiveName);
					$("#fullAddress").val(data.addressAdd);
					$("#postalCode").val(data.addressZipcode);
					$("#mobile").val(data.addressMobile);
				},
				dataType:"json"
			});
		}
		
 		//姓名验证
        function checkName(){
		   if($("#receiveName").val() == ""){
		   		$("#nameInfo").text("名字不能为空");
		      	return false;
		   }
		   //清空提示信息
		   $("#nameInfo").text("");
	   	   return true;
        }
 		//地址验证
        function checkeAddress(){
			var spanobj = document.getElementById("addressInfo");
			if($("#fullAddress").val() ==""){
				$("#addressInfo").text("地址不能为空");
				return false;
			}
			//清空提示信息
			$("#addressInfo").text("");
		   	return true;	
        }
        //邮政编码验证
		function checkPostalCode(){
		   if($("#postalCode").val() == ""){
		   	  $("#postalCodeInfo").text("邮编不能为空");
		      return false;
		   }
		 	//清空提示信息
			$("#postalCodeInfo").text("");
		   	return true;	
        }
		//手机验证
		function checkMobile(){
		 	if($("#mobile").val() == ""){
			   	  $("#mobileInfo").text("手机号不能为空");
			      return false;
		   }
		 	//清空提示信息
			$("#mobileInfo").text("");
		   	return true;
		}
			
		
		//表单提交
		function formSubmit(){
			if (checkName()==false 
					|| checkeAddress()==false 
					|| checkPostalCode()==false 
					|| checkMobile()==false){
				alert("请先完成必填项！");
			}
			else{
				//获取参数
				var addressReceiveName = $("#receiveName").val();
				var addressAdd = $("#fullAddress").val();
				var addressZipcode = $("#postalCode").val();
				var addressMobile = $("#mobile").val();
				
				//发送Ajax
				$.ajax({
					url:"${pageContext.request.contextPath}/order/createOrder.do",
					type:"POST",
					data:{"addressReceiveName":addressAdd,
						"addressAdd":addressAdd,
						"addressZipcode":addressZipcode,
						"addressMobile":addressMobile},
					success:function(data){
						console.log(data);
						if(data == true){
							alert("商品已出库，就是这么快！");
							window.location.href="${pageContext.request.contextPath}/order/order3.jsp";							
						}
						else{
							alert("订单生成失败");
							window.location.reload();
						}
					},
					dataType:"json"
				});
			}
			
		}
		
		//保存收货地址
		function insertAddress(){
			//获取参数
			var addressReceiveName = $("#receiveName").val();
			var addressAdd = $("#fullAddress").val();
			var addressZipcode = $("#postalCode").val();
			var addressMobile = $("#mobile").val();
			
			//发送Ajax
			$.ajax({
				url:"${pageContext.request.contextPath}/address/insertAddress.do",
				type:"POST",
				data:{"addressReceiveName":addressAdd,
					"addressAdd":addressAdd,
					"addressZipcode":addressZipcode,
					"addressMobile":addressMobile},
				success:function(data){
					console.log(data);
					if(data == true){
						alert("已保存当前地址！");
					}
					else{
						alert("保存地址失败！");
						window.location.reload();
					}
				},
				dataType:"json"
			});
		}
		
		
			

			
		</script>
</head>
<body>
	<%@include file="../common/head1.jsp"%>
	<div class="login_step">
		生成订单骤: 1.确认订单 ><span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
	</div>
	<div class="fill_message">
		<!-- 查询送货地址 -->
		<select id="address" onchange="addressChange(this)">
			<option value="0">选择地址：</option>
		</select>
		<br/>
		
		<!-- 新增送货地址 -->
		<form name="ctl00" method="post">
	
			<input type="hidden" name="address.id" id="addressId" />
			<table class="tab_login">
				<tr>
					<td valign="top" class="w1">收件人姓名：</td>
					<td><input onblur="checkName()" type="text" class="text_input"
						name="addressReceiveName" id="receiveName" />
						<div class="text_left" id="nameValidMsg">
							<p>请填写有效的收件人姓名</p>
							<span id="nameInfo" style="color:red"></span>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">收件人详细地址：</td>
					<td><input onblur="checkeAddress()" type="text"
						name="addressAdd" class="text_input" id="fullAddress" />
						<div class="text_left" id="addressValidMsg">
							<p>请填写有效的收件人的详细地址</p>
							<span id="addressInfo" style="color:red"></span>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">邮政编码</td>
					<td><input onblur="checkPostalCode()" type="text"
						class="text_input" name="addressZipcode" id="postalCode" />
						<div class="text_left" id="codeValidMsg">
							<p>请填写有效的收件人的邮政编码</p>
							<span id="postalCodeInfo" style="color:red"></span>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">手机</td>
					<td><input onblur="checkMobile()" type="text"
						class="text_input" name="addressMobile" id="mobile" />
						<div class="text_left" id="mobileValidMsg">
							<p>请填写有效的收件人的手机</p>
							<span id="mobileInfo" style="color:red"></span>
						</div></td>
				</tr>
				
		<%-- 		<!-- 隐藏域，保存地址ID -->
					<tr>
					<td valign="top" class="w1">地址ID</td>
					<td><input  type="hidden" 
						class="text_input" name="addressId" id="addressId" />
						<div class="text_left" id="mobileValidMsg">
							<p>自动生成地址ID</p>
							<span id="mobileInfo" style="color:red"></span>
						</div></td> --%>
				</tr>
			</table>
			<br/>
			<div class="login_in" style="margin-left:-40px;">
				</a> <input   onclick="insertAddress()" style="width:110px" id="submit" class="button_1" name="submit" type="button" 
				 value="保存收货地址" />
				</a> <input   onclick="formSubmit()" id="submit" class="button_1" name="submit" type="button" 
				 value="下一步" />
			</div>
		</form>
			<a href="${pageContext.request.contextPath}/cart/cart_list.jsp"><input id="btnClientRegister"
					class="button_1" name="submit" type="submit" value="取消" />
	</div>
	<%@include file="../common/foot1.jsp"%>
</body>
</html>

