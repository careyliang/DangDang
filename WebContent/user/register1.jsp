<%@page contentType="text/html;charset=utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户注册 - 当当网</title>
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.0.js"></script>
	<script type="text/javascript">
	
		//全局加载
		$(function(){
			//加载验证码
			$("#imgVcode").attr("src","${pageContext.request.contextPath}/user/validateCode.do");
			
		});
		
		//检查邮箱
        function checkEmail(){
		    var txtEmail = document.getElementById("txtEmail");
			if(txtEmail.value.indexOf("@")==-1 || txtEmail.value.indexOf(".")==-1){
				$("#emailInfo").html("<font color=red>邮箱地址格式错误</font>");
				return false;
			}
			$("#emailInfo").html("");
			return true;
		}
		
		//检查账号
		function checkName(){
			var ddUserNickName = $("#txtNickName").val();
			if(ddUserNickName == ''){
		   	 	$("#nameInfo").html("<font color=red>姓名必填</font>");
		      	return false;
		   	}
		  	else if(ddUserNickName.length < 4){
			   $("#nameInfo").html("<font color=red>命名不规则</font>");
		      	return false;
		   	} 
			$("#nameInfo").html("");
		   	return true;
		}
		   // 一次密码检查
		  function checkPassword(){
	       var pwdTxt = document.getElementById("txtPassword");
		   var spanobj=document.getElementById("password.info");
		   if(pwdTxt.value.length < 6){
		   spanobj.innerHTML="<font color=red>密码至少六位</font>";
		      return false;
		   }else
		   spanobj.innerText = "";
		   return true;
          }
          // 二次密码检查
		  function checkPassword1(){
		   var pwdTxt = document.getElementById("txtPassword");
	       var pwd1Txt = document.getElementById("txtRepeatPass");
		   var spanobj=document.getElementById("password1.info");
		   if(pwdTxt.value!=pwd1Txt.value){
		   		spanobj.innerHTML="<font color=red>两次输入的密码不同</font>";
		      	return false;
		   }else
		   spanobj.innerText = "";
		   return true;
          }
          
        //检查证码
		function checkVerifyCode(){
			var verifyCode = $("#txtVerifyCode").val();
			//非空判断
			if(verifyCode == ""){
				$("#codeInfo").html("验证码不能为空");
				return false;
			}
			return true;
		}
         
		//表单提交
		function submitForm(){
			if (checkEmail()==false || checkName()==false || 
				checkPassword()==false || checkPassword1()==false || checkVerifyCode()==false){
				alert("请完成必填项");
			}
			else{
				//获取参数值
				var ddUserEmail = $("#txtEmail").val();
				var ddUserNickName = $("#txtNickName").val();
				var ddUserPassword = $("#txtPassword").val();
				var verifyCode = $("#txtVerifyCode").val();
				//执行ajax
				$.ajax({
					url:"${pageContext.request.contextPath}/user/registUser.do",
					type:"post",
					data:{"ddUserEmail":ddUserEmail,"ddUserNickName":ddUserNickName,
							"ddUserPassword":ddUserPassword,"verifyCode":verifyCode},
					success:function(data){
						if(data == true){
							alert("注册成功，请继续下一步");
							window.location.href='${pageContext.request.contextPath}/user/register2.jsp';
						}
						else{
							$("#formInfo").html("注册失败，验证码错误");
						}
					},
					dataType:"json"
				});
			}
			
		}
		</script>
</head>
<body>
	<%@include file="../common/head1.jsp"%>
	<div class="login_step">
		注册步骤: <span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
	</div>
	<div class="fill_message">
		<%-- <form action="<s:url action="registUser" namespace="/aa"/>" --%>
		<form method="post" id="f">
			
			<h2>
				以下均为必填项 &nbsp&nbsp&nbsp&nbsp&nbsp
			</h2>
			<table class="tab_login">
				<tr>
					<td valign="top" class="w1">请填写您的Email地址：</td>
					<td><input onblur="checkEmail()" name="userEmail" type="text"
						id="txtEmail" class="text_input" />
						<div class="text_left" id="emailValidMsg">
							<p>请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。</p>
							<span id="emailInfo" style="color:red"></span>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">设置您在当当网的昵称：</td>
					<td><input onblur="checkName()" name="userNickName" type="text"
						id="txtNickName" class="text_input" />
						<div class="text_left" id="nickNameValidMsg">
							<p>您的昵称可以由小写英文字母、中文、数字组成，</p>
							<p>长度4－20个字符，一个汉字为两个字符。</p>
							<span id="nameInfo" style="color:red"></span>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">设置密码：</td>
					<td><input onblur="checkPassword()" name="userPassword"
						type="password" id="txtPassword" class="text_input" />
						<div class="text_left" id="passwordValidMsg">
							<p>您的密码可以由大小写英文字母、数字组成，长度6－20位。</p>
							<span id="password.info" style="color:red"></span>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">再次输入您设置的密码：</td>
					<td><input onblur="checkPassword1()" name="password1"
						type="password" id="txtRepeatPass" class="text_input" />
						<div class="text_left" id="repeatPassValidMsg">
							<span id="password1.info" style="color:red"></span>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">验证码：</td>
					<td>
						<img class="yzm_img" id='imgVcode' src="#" /> 
						<input name="code" type="text" id="txtVerifyCode" class="yzm_input" onblur="checkVerifyCode()"/>
						<div class="text_left t1">
							<p class="t1">
								<span id="vcodeValidMsg">请输入图片中的四个字母，不区分大小写。</span> <span
									id="number.info" style="color:red"></span> <a
									href="javascript:void(0)" 
									onclick="document.getElementById('imgVcode').src='${pageContext.request.contextPath}/user/validateCode.do?time='+(new Date()).getTime();">看不清楚？换个图片</a>
							</p>
							<a style="color:red;" id="codeInfo"></a>
						</div>
						
					</td>
				</tr>
			</table>

			<div class="login_in">

				<input onclick="submitForm()" id="btnClientRegister" class="button_1" name="submit"
					type="button" value="注 册" />
			</div>
		</form>
			<a style="color:red;" id="formInfo"></a>
	</div>
	<%@include file="../common/foot1.jsp"%>
</body>
</html>

