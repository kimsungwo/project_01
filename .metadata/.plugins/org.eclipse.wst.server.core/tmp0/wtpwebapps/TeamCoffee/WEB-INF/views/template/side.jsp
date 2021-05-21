<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a {
	text-decoration: none;
	color: black;
}
</style>
<script type="text/javascript" src="/resources/js/common/side.js?ver=1"></script>
</head>
<body>
<div class="row">
	<div class="col">
		<div class="list-group">
			<a href="/cafe/community1" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 1 }">active</c:if>" aria-current="true">공지사항</a>
			<a href="/cafe/community2" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 2 }">active</c:if>" >이벤트</a>
			<a href="/cafe/community3" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 3 }">active</c:if>" >이용자게시판</a>
		</div>
	</div>
</div>
</body>
</html>