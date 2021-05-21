<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:choose>
	<c:when test="${not empty sessionScope.loginInfo}">
		<script type="text/javascript">
			location.href='${path}/board/boardList';
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("아이디와 비밀번호를 확인하세요.");
			location.href='${path}/member/login';    
		</script>
	</c:otherwise>
</c:choose>
</head>
<body>

</body>
</html>