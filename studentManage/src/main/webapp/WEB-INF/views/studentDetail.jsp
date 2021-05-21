<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/js/studentDetail.js?ver=1112"></script>
</head>
<body>
<form action="/student/update" method="post">
<input type="hidden" name="stuNum" value="${detail.stuNum}"> 
<div>
<table>
	<tr>
		<td>이 름</td>
		<td>나 이</td>
		<td>주 소</td>
	</tr>
		<tr>
			<td>${detail.stuName}</td>
			<td>${detail.stuAge}</td>
			<td>${detail.stuAddr}</td>
		</tr>
	<tr>
		<td>국어 점수</td>
		<td>영어 점수</td>
		<td>수학 점수</td>
	</tr>
	<tr>
		<td><input type="text" name="korScore" value="${detail.korScore}" readonly></td>
		<td><input type="text" name="engScore" value="${detail.engScore}" readonly></td>
		<td><input type="text" name="mathScore" value="${detail.mathScore}" readonly></td>
	</tr>
</table>
	<input type="button" value="뒤로가기" onclick="location.href='/student/studentList';">
	<input type="button" value="점수수정" id="updateBtn">
</div>
</form>
</body>
</html>