<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script src="/resources/js/common/side.js" type="text/javascript"></script> -->
</head>
<body>
<div class="list-group">
  <a href="/admin/categoryManage?sideMenu=1" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 1}">active</c:if>" aria-current="true">카테고리 관리</a>
  <a href="/admin/insertItem?sideMenu=2 " class="list-group-item list-group-item-action <c:if test="${sideMenu eq 2}">active</c:if>">상품 등록</a>
  <a href="/admin/itemManage?sideMenu=3" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 3}">active</c:if>">상품 관리</a>
  <a href="#" class="list-group-item list-group-item-action">회원 관리</a>
  <a href="/admin/salesManage?sideMenu=5" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 5}">active</c:if>">매출 관리</a>
<!--   <a href="#" class="list-group-item list-group-item-action">ㅅㅅ</a> -->
</div>
</body>
</html>