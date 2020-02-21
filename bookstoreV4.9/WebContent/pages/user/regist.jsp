<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>尚硅谷会员注册页面</title>
<jsp:include page="/WEB-INF/common/base.jsp"></jsp:include>
<style type="text/css">
.login_form {
	height: 420px;
	margin-top: 25px;
}
</style>
<script type="text/javascript">
	$(function() {

		/* 	$("#sub_btn").click(function () {
				var username = $("[name='username']").val();
				var password = $("[name='password']").val();
				var email = $("[name='email']").val();
			$.ajax({
				url:"UserServlet?method=regist",
				type:"POST",
				data:{username:username,password:password,email:email},
				dataType:"text",
				success:function(obj){
				
					if(obj == "username"){
						$(".errorMsg").text("用户名已存在");
					}
					if(obj == "success"){
						location.href = "pages/user/regist_success.jsp";
					}
				}
			});
			
		}); */

		//ajax省略表单提交， 
		$("#sub_btn")
				.click(
						function() {
							var username = $("[name='username']").val();
							var password = $("[name='password']").val();
							var email = $("[name='email']").val();
							var code = $("[name='code']").val();
							$
									.ajax({
										url : "UserServlet?method=regist",
										type : "POST",
										data : {
											username : username,
											password : password,
											email : email,
											code : code
										},
										dataType : "text",
										success : function(obj) {
											if (obj == "success") {
												//重定向
												location.href = "pages/user/regist_success.jsp";
											}
											if (obj == "username") {
												//失败：
												$(".errorMsg").text("用户名已重复");
												$("#codeImg")
														.attr(
																"src",
																"code.jpg?a="
																		+ Math
																				.random());
											}
											if (obj == "code") {
												$(".errorMsg").text("验证码不正确");
												$("#codeImg")
														.attr(
																"src",
																"code.jpg?a="
																		+ Math
																				.random());
											}
										}
									});

						});

		$("#codeImg").click(function() {
			$(this).attr("src", "code.jpg?a=" + Math.random());

		});

		/* var username=$("[name='username']").val();
		var password=$("[name='password']").val();
		$("#sub_btn").click(function(){
			//ajax有  url,data:传的数据,dateType:接受类型，type请求方式
			$.ajax({
				url:"UserServlet?method=regist",
				type:"POST",
				data:{"username":username,"password":password},
				dataType:"text",
				success:function(obj){
					if(obj=="username"){
						$(".errorMsg").text("用户名已存在");
					}
					if(obj=="success"){
						location.href= "pages/user/regist_success.jsp";
					}
				}
			});
		});   */
	});

	/* $(function(){
		//获取注册按钮并给它绑定单击响应函数
		$("#sub_btn").click(function(){
			//获取用户名、密码、确认密码、邮箱、验证码
			var userName = $("#username").val();
			var password = $("#password").val();
			var repwd = $("#repwd").val();
			var email = $("#email").val();
			var code = $("#code").val();
			//使用正则表达式对用户名、密码、邮箱进行验证
			var userReg = /^[a-zA-Z0-9_-]{3,16}$/;
			if(!userReg.test(userName)){
				alert("请输入3-16位的数字、字母、下划线或减号的用户名！");
				return false;
			};
			var pwdReg = /^[a-zA-Z0-9_-]{6,18}$/;
			if(!pwdReg.test(password)){
				alert("请输入6-18位的数字、字母、下划线或减号的密码！");
				return false;
			};
			if(repwd != password){
				alert("两次输入的密码不一致！");
				return false;
			}
			var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!emailReg.test(email)){
				alert("邮箱格式不正确！");
				return false;
			}
			if(code == ""){
				alert("验证码不能为空！");
				return false;
			}
		});
	}); */
</script>
</head>
<body>
	<div id="login_header">
		<img class="logo_img" alt="" src="static/img/logo.gif">
	</div>

	<div class="login_banner">

		<div id="l_content">
			<span class="login_word">欢迎注册</span>
		</div>

		<div id="content">
			<div class="login_form">
				<div class="login_box">
					<div class="tit">
						<h1>注册尚硅谷会员</h1>
						<span class="errorMsg">${requestScope.errorMsg}</span>
					</div>
					<div class="form">
						<form action="UserServlet?method=regist" method="post">
							<label>用户名称：</label> <input value="${requestScope.username}"
								class="itxt" type="text" placeholder="请输入用户名" autocomplete="off"
								tabindex="1" name="username" id="username" /> <br /> <br /> <label>用户密码：</label>
							<input class="itxt" type="password" placeholder="请输入密码"
								autocomplete="off" tabindex="1" name="password" 
								${requestScope.password}id="password" />
							<br /> <br /> <label>确认密码：</label> <input class="itxt"
								type="password" placeholder="确认密码" autocomplete="off"
								tabindex="1" name="repwd" id="repwd" /> <br /> <br /> <label>电子邮件：</label>
							<input value="${requestScope.email}" class="itxt" type="text"
								placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
								name="email" id="email" /> <br /> <br /> <label>验证码：</label>
							<input class="itxt" type="text" style="width: 150px;" name="code" />
							<img id=codeImg alt="" src="code.jpg"
								style="float: right; width: 100px; height: 40px; margin-right: 30px">
							<br /> <br /> <input type="button" value="注册" id="sub_btn" />

						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>