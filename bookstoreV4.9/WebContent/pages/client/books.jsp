<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书城首页</title>
<jsp:include page="/WEB-INF/common/base.jsp"></jsp:include>
<script type="text/javascript">
	$(function () {
		$("#searchBtn").click(function () {
			var min = $("[name='min']").val();
			var max = $("[name='max']").val();
			location.href="${page.path}&min="+min+"&max="+max;
		});
		$(".addCartBtn").click(function () {
			var bookId = $(this).val();
			location.href = "CartServlet?method=addBookToCart&bookId="+bookId;
		});
	});
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<jsp:include page="/WEB-INF/common/client_head.jsp"></jsp:include>
	</div>
	
	<div id="main">
		<div id="book">
			<div class="book_cond">
				价格：<input type="text" name="min" value="${param.min}"> 元 - <input type="text" name="max" value="${param.max}"> 元 <button id="searchBtn">查询</button>
			</div>
			<c:if test="${not empty sessionScope.cart.cartItemList}">
			<div style="text-align: center">
				<span>您的购物车中有${sessionScope.cart.totalCount }件商品</span>
				<div>
					您刚刚将<span style="color: red">${sessionScope.bookName}</span>加入到了购物车中
				</div>
			</div>
			</c:if>
			<c:if test="${empty sessionScope.cart.cartItemList}">
			<div style="text-align: center">
				<span>您的购物车寂寞如雪</span>
			</div>
			</c:if>
			
			<c:forEach items="${requestScope.page.list}" var="book">
			
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="${book.imgPath}" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span>
							<span class="sp2">${book.title}</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span>
							<span class="sp2">${book.author}</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">￥${book.price}</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${book.sales}</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span>
							<span class="sp2">${book.stock}</span>
						</div>
						<div class="book_add">
							<button class="addCartBtn" value="${book.id}" >加入购物车</button>
						</div>
					</div>
				</div>
			
			</c:forEach>
			
		</div>
		
		<jsp:include page="/WEB-INF/common/page.jsp"></jsp:include>
	
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>