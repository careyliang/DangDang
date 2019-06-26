<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>登录 - 当当网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
    </head><body>
	<%@include file="../common/head1.jsp"%>
	<div class="enter_part">
	<%@include file="../common/introduce.jsp"%>
	<div class="enter_in">
				<div class="bj_top"></div>
				<div class="center">
					<div style="height: 30px; padding: 5px; color: red"1 id="divErrorMssage">
					
					</div>
					<div class="main">
						<h3>
							登录当当网
						</h3>
			<form  id="ctl00" >
				<ul>
					<li>
					<span>请输入Email地址：</span>
					<input type="text" name="ddUserEmail" id="txtUserName" class="textbox" />
					</li>
					<li>
					<span class="blank">密码：</span>
					<input type="password" name="ddUserPassword" id="txtPassword"
					class="textbox" />
					</li>
					<li>
					<!-- <input type="submit" id="btnSignCheck" class="button_enter"value="登 录" /> -->
					<input type="button" onclick="login()" id="btnSignCheck" class="button_enter" value="登 录" />
					</li>
				</ul>
					<input type="hidden" name="uri" value="${uri}" />
			</form>
				<a id="errorMsg" style="color:red;">${errorMsg } </a>
					</div>
					<div class="user_new">
						<p>
							您还不是当当网用户？
						</p>
						<p class="set_up">
							<a href="${pageContext.request.contextPath}/user/register1.jsp">创建一个新用户&gt;&gt;</a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>

	</body>
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.0.js"></script>
	<script type="text/javaScript">
		//登录逻辑
		function login(){
			console.log("login");
			//获取页面输入值
			var ddUserEmail = $("#txtUserName").val();
			var ddUserPassword = $("#txtPassword").val();
			//非空判断
			if(ddUserEmail == '' || ddUserPassword == ''){
				alert("用户名和账号不能为空");
			}
			else{
				//执行Ajax
				$.ajax({
					url:"${pageContext.request.contextPath }/user/login.do",
					type:"post",
					data:{"ddUserEmail":ddUserEmail,"ddUserPassword":ddUserPassword},
					success:function(data){
						console.log("the data is:"+data);
						if(data == "true"){
							//定位 商城主页面
							window.location.href='${pageContext.request.contextPath}/main/main.jsp';
						}
						else{
							alert("登录失败");
							$("#errorMsg").html("账号或密码错误");
						}
					},
					dataType:"json"
				});
			}
			
		}
	</script>
	
	
</html>

