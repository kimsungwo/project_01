<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:choose>
	<c:when test="${not empty sessionScope.loginInfo}">
		<script type="text/javascript">
			alert("로그인 성공");
			location.href='/sample/boardList';
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("로그인 실패");
			location.href='/sample/first';    
		</script>
	</c:otherwise>
</c:choose>
</head>
<body>

</body>
</html>