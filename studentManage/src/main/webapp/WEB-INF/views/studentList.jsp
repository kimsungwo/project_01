<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/scc/studentList.css" rel='stylesheet'>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/js/studentList.js?ver=12"></script>
<style type="text/css">
.area{
	/* display: inline-block; */
	width: 1000px;
	margin: 80px auto;
	
	
}
.search1{
margin-left: 2px;
float: right;
	
}
.search2{
float: right;
	
}
.searchSpan{
}
table{
	width:1000px;
	border: 1px solid white;
	text-align: center;
}
tr td{
	border: 1px solid red;
}
.select{
	float : right;
	
	
}
</style>
</head>
<body>
<div class="area">
	<select id="classSelector">
		<option value="all" <c:if test="${classCode eq 'all'}">selected</c:if> >전체선택</option>
		<c:forEach items="${classList}" var="classInfo">
		<option value="${classInfo.classCode }"class="select" <c:if test="${ classCode eq classInfo.classCode}">selected</c:if> >${classInfo.className}</option>
		
		</c:forEach>
	</select >
	<span>
	<input type="text" > <input type="button" value="검색"></span>
	<br>
	<table>
		<tr>
			<td>이름</td>
			<td>나이</td>
			<td>주소</td>
		</tr>
  	<c:forEach items="${classList}" var="classinfo">
	<tr>
		<td>${classinfo.classCode}</td>
		<td>${classinfo.className}</td>
		<td><a href="/class/deleteClass?classCode=${classinfo.classCode}">삭제</a></td>
	</tr>
	</c:forEach>

	</table>
</div>
</body>
</html>