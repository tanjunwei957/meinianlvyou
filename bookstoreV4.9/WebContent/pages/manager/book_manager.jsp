<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理</title>
<jsp:include page="/WEB-INF/common/base.jsp"></jsp:include>
<script type="text/javascript">
	function deleteBook(id) {
		if(confirm("您确认要删除图书编号为【"+id+"】的图书信息吗？")){
			//location对象在JavaScript中代表地址对象，可以实现页面跳转和页面刷新
			//location.href="路径"或location="路径"实现页面跳转
			//location.reload()实现页面刷新
			location.href="BookManagerServlet?method=deleteBook&bookId="+id;
		}
	}
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<jsp:include page="/WEB-INF/common/manager_head.jsp"></jsp:include>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td></td>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>	
			
			<c:forEach items="${requestScope.page.list}" var="book" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${book.title}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a href="BookManagerServlet?method=getBookById&bookId=${book.id}">修改</a></td>
					<td><a href="javascript:deleteBook(${book.id})">删除</a></td>
				</tr>
			</c:forEach>	
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>	
		</table>
		
		<jsp:include page="/WEB-INF/common/page.jsp"></jsp:include>
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>