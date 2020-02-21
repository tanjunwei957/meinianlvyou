<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单</title>
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
			<span class="wel_word">我的订单</span>
			<jsp:include page="/WEB-INF/common/client_head.jsp"></jsp:include>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td style="width: 200px;">日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>		
			
			<c:forEach items="${requestScope.orderList}" var="order">
			
				<tr>
					<td>${order.createtime}</td>
					<td>${order.totalAmount}</td>
					<td>
					
						<c:if test="${order.state == 0}">等待发货</c:if>
						<c:if test="${order.state == 1}">
							<a href="OrderClientServlet?method=getGoods&orderId=${order.id}">点击收货</a>
						</c:if>
						<c:if test="${order.state == 2}">交易完成</c:if>
					
					</td>
					<td><a href="OrderClientServlet?method=getOrderItemByOrderId&orderId=${order.id}">查看详情</a></td>
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