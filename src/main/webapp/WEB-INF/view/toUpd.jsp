<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
${msg }
<body>
<form:form method="post" action="${pageContext.request.contextPath}/upd" modelAttribute="check">
	<tr>
		
		<td><input type="hidden" value="${check.id }" name="id"></td>
		<td>关键字 <input type="text" value="${check.keywords }"></td>
		<td>描述 <input type="text" style="width:500px" value="${check.description }"></td><br>
		<td>编号 <input type="text" value="${check.id }"></td>
		<td>公司名称 <input type="text" value="${check.companyName }"></td><br>
		<td>主营产品 <input type="text" value="${check.mainBusinessProducts }"></td>
		<td>地址 <input type="text" value="${check.address }"></td>
		<td>注册资本(万元) <input type="text" value="${check.registeredCapital }"></td>
		<td>成立时间 <input type="text" value="${check.foundingTime }"></td><br>
		<td>年检时间 <input type="text" value="${check.annualCheckDate }"></td>
		<td>年检状态 <form:input path="annualCheckStatus"/></td><br>
		<td>备注 <form:input path="rmk"/></td><br>
		<form:button>提交</form:button>
	</tr>
</form:form>
</body>
</html>