<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
<div id="page_nav" style="margin-top: 10px;">
	<c:if test="${page.pageNumber != 1}">
		<a href="${page.path}&pageNo=1">首页</a>
		<a href="${page.path}&pageNo=${page.pageNumber-1}">上一页</a>
	</c:if>
	
	<c:choose>
		<%--当总页数小于5，分页导航显示所有的页码 --%>
		<c:when test="${page.totalPageNo < 5}">
			<c:set var="begin" value="1"></c:set>
			<c:set var="end" value="${page.totalPageNo}"></c:set>
		</c:when>
		<c:when test="${page.pageNumber< 3}">
			<c:set var="begin" value="1"></c:set>
			<c:set var="end" value="5"></c:set>
		</c:when>
		<c:otherwise>
			<c:set var="begin" value="${page.pageNumber-2}"></c:set>
			<c:set var="end" value="${page.pageNumber+2}"></c:set>
			<c:if test="${end > page.totalPageNo}">
				<c:set var="begin" value="${page.totalPageNo-4}"></c:set>
				<c:set var="end" value="${page.totalPageNo}"></c:set>
			</c:if>
		</c:otherwise>
	</c:choose>
	
	<c:forEach begin="${begin}" end="${end}" var="i">
		<c:if test="${page.pageNumber == i}">[${i}]</c:if>
		<c:if test="${page.pageNumber != i}">
			<a href="${page.path}&pageNo=${i}">${i}</a>
		</c:if>		
	</c:forEach>		
	
	<c:if test="${page.pageNumber != page.totalPageNo}">
		<a href="${page.path}&pageNo=${page.pageNumber+1}">下一页</a>
		<a href="${page.path}&pageNo=${page.totalPageNo}">末页</a>
	</c:if>
	
	共${page.totalPageNo}页，${page.totalCount}条记录 到第<input value="${page.pageNumber+1 > page.totalPageNo ? page.totalPageNo : page.pageNumber+1}" name="pn" id="pn_input"/>页
	<input type="button" value="确定" id="btn">
</div>
<script type="text/javascript">
	$(function () {
		$("#btn").click(function () {
			var pageNo = $("#pn_input").val();
			location.href="${page.path}&pageNo="+pageNo;
		});
	});
</script>