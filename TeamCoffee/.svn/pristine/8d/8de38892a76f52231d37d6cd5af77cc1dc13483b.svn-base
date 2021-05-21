<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container{
	width: 35rem;
}
</style>
</head>
<body>
	<div class="w3-content w3-container w3-margin-top container">
		<div class="w3-container w3-card-4">
			<form action="/owner/toDropOut"  name="deleteform" id="deleteForm" method="post">
				<div class="w3-center w3-large w3-margin-top">
					<h3>프로필 변경 완료</h3>
				</div>
				<div>
					<p>
						<label>회원정보 수정이 성공적으로 이루어졌습니다.</label>
					</p>
					<c:choose>
				<c:when test="${not empty sessionScope.ownerLoginInfo and sessionScope.ownerLoginInfo.isAdmin eq 'Y' }">
						<a class="nav-link" href="/owner/admin">My Page(관리자) 이동</a>
					</c:when>
					<c:when test="${not empty sessionScope.ownerLoginInfo }">
						<a class="nav-link" href="/owner/main">My Page(매장주) 이동</a>
					</c:when>
					</c:choose>
				</div>
			</form>
		</div>
	</div>
</body>
</html>