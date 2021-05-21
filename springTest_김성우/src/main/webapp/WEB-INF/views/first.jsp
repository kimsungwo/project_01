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
 	<form action="/sample/login" method="post" name="loginInfo">      
 		I.D. : <input type="text" name="id">
		PASSWORD : <input type="password"  name="password">
	<input type="submit" value="Login">
      	</form>
</body>
</html>