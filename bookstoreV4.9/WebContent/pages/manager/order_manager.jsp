<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单管理</title>
<jsp:include page="/WEB-INF/common/base.jsp"></jsp:include>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>
			<jsp:include page="/WEB-INF/common/manager_head.jsp"></jsp:include>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>发货</td>
				
			</tr>		
			<c:forEach  items="${requestScope.orderListAll}" var="order">
			<tr>
				<td>${order.createtime }</td>
				<td>${order.totalAmount}</td>
				<td><a href="OrderClientServlet?method=getOrderItemByOrderId&orderId=${order.id}">查看详情</a></td>
				
				<td>
				<c:if test="${order.state==0 }">
				<a href="OrderManagerServlet?method=sendGoodsByOrderId&orderId=${order.id }">点击发货</a>
				</c:if>
				<c:if test="${order.state==1 }">等待收货</c:if>
				<c:if test="${order.state==2 }">结束交易</c:if>
				</td>
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