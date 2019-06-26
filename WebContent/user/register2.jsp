<%@ taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
	
		<div class="login_step">
			注册步骤: 1.填写信息 >
			<span class="red_bold">2.验证邮箱</span> > 3.注册成功
		</div>
		<form method="post">
			<div class="validate_email">
				<h2>
					感谢您注册当当网！现在请按以下步骤完成您的注册!
				</h2>
				<div class="look_email">
					<h4>
						第一步：查看您的电子邮箱
					</h4>
					<div class="mess reduce_h">
						我们给您发送了验证邮件，邮件地址为：
						<span class="red">
							<span id="lblEmail">${sessionScope.registUser.ddUserEmail }</span>
						</span>
						<span class="t1"> 
						请登录您的邮箱收信。
						</span>
					</div>
					<h4>
						第二步：输入激活码 &nbsp;<span style="color:red" id="uuid"></span>
					</h4>
					<div class="mess">
						<span class="write_in">输入您收到邮件中的激活码：</span>
						<input name="randomcode" type="text" id="validatecode" class="yzm_text" />
						<input onclick="submitForm()" class="finsh" type="button" value="完 成" id="Button1" />
						<span id="formInfo" class="no_right"></span>
					</div>
				</div>
			</div>
		</form>
		<%@include file="../common/foot1.jsp"%>
	</body>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.0.js"></script>
	<script type="text/javascript">
		//邮箱验证完毕，注册用户信息导入数据库
		function submitForm(){
			//执行ajax
			$.ajax({
				url:"${pageContext.request.contextPath}/user/insertUser.do",
				type:"post",
				success:function(data){
					if(data == true){
						alert("添加成功，请继续下一步");
						window.location.href='${pageContext.request.contextPath}/user/register3.jsp';
					}
					else{
						$("#formInfo").html("添加失败，未知错误");
					}
				},
				dataType:"json"
			}); 
		}
	</script>
</html>

