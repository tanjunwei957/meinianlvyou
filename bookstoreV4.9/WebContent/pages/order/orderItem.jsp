<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详情</title>
<jsp:include page="/WEB-INF/common/base.jsp"></jsp:include>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单详情</span>
			<jsp:include page="/WEB-INF/common/client_head.jsp"></jsp:include>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>封面</td>
				<td>书名</td>
				<td>作者</td>
				<td>价格</td>
				<td>数量</td>
			</tr>		
			
			<c:forEach items="${requestScope.itemByOrderId}" var="orderItem">
			
				<tr>
					<td>
						<img style="width: 70px;" src="${orderItem.imgPath}">
					</td>
					<td>${orderItem.title}</td>
					<td>${orderItem.author}</td>
					<td>${orderItem.amount}</td>
					<td>${orderItem.count}</td>
				</tr>	
			
			</c:forEach>
				
		</table>
		
	
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>