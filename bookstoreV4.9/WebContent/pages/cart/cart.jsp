<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<jsp:include page="/WEB-INF/common/base.jsp"></jsp:include>
<script type="text/javascript">
			$(function(){
				$(".deletecartitem").click(function(){
				if(!confirm("你确认删除吗？")){	
					return false;	
					}		
				});
				$(".count").change(function(){
					var count=$(this).val();
					var bookId=$(this).attr("bookId");
					
					location.href="CartServlet?method=updateCount&count="+count+"&bookId="+bookId;
				});
			});

</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<jsp:include page="/WEB-INF/common/client_head.jsp"></jsp:include>
	</div>
	
	<div id="main">
	<c:if test="${empty sessionScope.cart.cartItemList}">
			<center style="margin-top: 200px;">
				<h3>购物车空空如也 <a href="index.jsp">去购物</a></h3>
			</center>
		</c:if>
		<c:if test="${not empty sessionScope.cart.cartItemList}">
		
			<table>
				<tr>
					<td>商品名称</td>
					<td>数量</td>
					<td>单价</td>
					<td>金额</td>
					<td>操作</td>
				</tr>	
				<c:forEach items="${sessionScope.cart.cartItemList}" var="cartitem">
					<tr>
						<td>${cartitem.book.title}</td>
						<td>
							<input style="width: 50px; text-align: center;" type="text" value="${cartitem.count}" bookId="${cartitem.book.id}" class="count" />
						</td>
						<td>${cartitem.book.price}</td>
						<td>${cartitem.amount}</td>
						<td><a class="deletecartitem" href="CartServlet?method=deletecartitem&bookId=${cartitem.book.id}">删除</a></td>
					</tr>	
				</c:forEach>	
				
			</table>
			
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalamount}</span>元</span>
				<span class="cart_span"><a href="CartServlet?method=clearCart">清空购物车</a></span>
				<span class="cart_span"><a href="OrderClientServlet?method=checkout">去结账</a></span>
			</div>
		
		</c:if>
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>