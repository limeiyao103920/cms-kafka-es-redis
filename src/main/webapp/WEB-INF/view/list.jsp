<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 引入 css -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/bootstrap.css">
<!-- 引入js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/jquery-3.2.1.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/search" method="post">
	<input name="key" value="${key }">
	<button>搜索</button>
</form>
<table>
	<tr>
		<th>id</th>
		<th>关键字</th>
		<th>描述</th>
		<th>公司全名</th>
		<th>主营产品</th>
		<th>地址</th>
		<th>注册资本</th>
		<th>成立时间</th>
		<th>年检日期</th>
		
		<th>年检状态</th>
		<th>备注</th>
		<th>操作</th>
		
	</tr>
	<c:forEach items="${info.list }" var="c">
		<tr>
			<td>${c.id }</td>
			<td>${c.keywords }</td>
			<td>${c.description }</td>
			<td>${c.companyName}</td>
			<td>${c.mainBusinessProducts}</td>
			<td>${c.address}</td>
			<td>${c.registeredCapital }</td>
			<td>${c.foundingTime }</td>
			<td>${c.annualCheckDate}</td>
			<td>${c.annualCheckStatus }</td>
			<td>${c.rmk }</td>
			<td><input type="button" value="操作" onclick="upd(${c.id})"></td>
		</tr>
	</c:forEach>
	
	<tr>
		<td colspan="10">
		<jsp:include page="/WEB-INF/view/pages2.jsp"></jsp:include>
		</td>
	</tr>
	
</table>
<!-- 这是一个最简单的分页 -->
	<%-- <a href="findAll?pageNum=${info.pageNum>1?info.pageNum-1:info.pageNum}">上一页</a>
	<a href="findAll?pageNum=${info.pageNum==info.pages?info.pageNum:info.pageNum+1 }">下一页</a>--%>
	
 </body>
 <script type="text/javascript">
 	function goPage(page) {
		location="list?pageNum="+page
	}
 	function upd(id) {
		location="toUpd?id="+id
	}
 </script>
</html>