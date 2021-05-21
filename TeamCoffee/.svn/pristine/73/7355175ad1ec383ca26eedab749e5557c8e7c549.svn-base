<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resources/js/common/side.js?ver=02"></script>
</head>
<body>
<div class="row">
	<div class="col">
		<div class="list-group">
			<c:if test="${sessionScope.ownerLoginInfo.isAdmin eq 'Y'}">
			<a href="/admin/qnaManage" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 1}">active</c:if>">Q/A</a> 
			<a href="/admin/cafeManage" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 2}">active</c:if>">매장신청목록</a> 
			<a href="/admin/memberManage" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 3}">active</c:if>">회원관리</a> 
			<a href="/admin/memberManage" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 5}">active</c:if>">게시판 관리</a> 
			</c:if>
		</div>
	</div>
</div>
</body>
</html>