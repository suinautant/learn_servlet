<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="javax.servlet.http.HttpServletRequest" import="javax.servlet.http.HttpServletResponse" %>
<%
Object req = request.getAttribute("list");
%>
<%=req %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEPT 테이블 목록보기</title>
</head>
<body>
	<h1>DEPT 테이블 목록보기</h1>
	<table border="1">
		<tr>
			<td>사원번호</td>
			<td>사원이름</td>
			<td>직책</td>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.deptno}</td>
				<td>${dto.dname}</td>
				<td>${dto.loc}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>