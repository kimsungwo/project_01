<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/js/student_manage.js?ver=11"></script>
<style type="text/css">
.contentDiv{
	margin: 0 auto;
	padding: 10px;
}
table{
	width:600px;
	margin: 0 auto;
	border: 1px solid black;
	border-collapse: collapse;
}
tr,td{
	border: 1px solid black;
	border-collapse: collapse;
}
.btnDiv{
	width:600px;
	text-align:right;
	margin: 0 auto;
	margin-bottom: 10px;
}
</style>



</head>
<body>
<select>
	<option value="all" <c:if test="${classCode eq 'all'}">selected</c:if> >전체선택</option>
		<c:forEach items="${classList}" var="classInfo">
			<option value="${classInfo.classCode }"class="select" <c:if test="${ classCode eq classInfo.classCode}">selected</c:if>>${classInfo.className}</option>
		
		</c:forEach>
</select>
<div  class="btnDiv">
<input type="button" class ="add" value="추가" id="addRow">
</div >
<div class="contentDiv">
<table id="listTable">
	<tr>
		<td>이름</td>
		<td>나이</td>
		<td>주소</td>
		<td>삭제</td>
	</tr>
<%--   	<c:forEach items="${classList}" var="classinfo">
	<tr>
		<td class="codeTd">${classinfo.classCode}</td>
		<td>${classinfo.className}</td>
		<td><a href="/class/deleteClass?classCode=${classinfo.classCode}">삭제</a></td>
	</tr>
	</c:forEach> --%>

</table>
</div>
</body>
</html>