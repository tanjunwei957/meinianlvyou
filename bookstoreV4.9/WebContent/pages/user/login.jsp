<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>尚硅谷会员登录页面</title>
<jsp:include page="/WEB-INF/common/base.jsp"></jsp:include>
<script type="text/javascript">
	/* $(function(){
		//获取登录按钮并给它绑定单击响应函数
		$("#sub_btn").click(function(){
			//获取用户输入的用户名和密码
			var userName = $("#username").val();
			var password = $("#password").val();
			if(userName == ""){
				alert("用户名不能为空！");
				//取消默认行为
				return false;
			}
			if(password == ""){
				alert("密码不能为空！");
				return false;
			}
		});
	}); */
</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>尚硅谷会员</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<%-- <span class="errorMsg">${requestScope.errorMsg == null ? "请输入用户名和密码" : requestScope.errorMsg}</span> --%>
								<span class="errorMsg"><c:out value="${requestScope.errorMsg}" default="请输入用户名和密码"></c:out></span>
							</div>
							<div class="form">
								<form action="UserServlet?method=login" method="post">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>