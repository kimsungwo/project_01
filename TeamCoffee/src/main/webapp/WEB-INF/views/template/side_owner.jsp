<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resources/js/common/side.js?ver=1"></script>
</head>
<body>
<div class="row">
	<div class="col">
		<div class="list-group">
			<a href="/owner/myPage?sideMenu=1" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 1 }">active</c:if>" aria-current="true">프로필 조회</a> 
			<a href="/owner/regCafe?sideMenu=2" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 2 }">active</c:if>">매장등록</a> 
			<a href="/owner/cafeManage?sideMenu=3" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 3 }">active</c:if>">매장관리</a> 
			<a href="/owner/regMenu" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 4 }">active</c:if>">메뉴등록</a>
			<a href="/owner/menuManage" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 5 }">active</c:if>">메뉴관리</a>
			<a href="/owner/orderConfirm" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 6}">active</c:if>">주문확인</a>
			<a href="/owner/qnaOwner" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 7}">active</c:if>">Q/A</a>
			<a href="/owner/toDropOutForm" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 8}">active</c:if>">회원탈퇴</a>
		</div>
	</div>
</div>
</body>
</html>