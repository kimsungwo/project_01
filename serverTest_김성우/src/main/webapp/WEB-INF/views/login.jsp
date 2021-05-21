<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<form action="${path}/member/login" method="post">
	ID :       <input type="text" name="memberId"><br>
	PASSWORD : <input type="password" name="password"><br>
	<input type="submit" value="Login">
</form>
</body>
</html>