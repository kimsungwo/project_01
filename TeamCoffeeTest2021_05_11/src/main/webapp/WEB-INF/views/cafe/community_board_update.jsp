<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 1200px;
	height: 600px;
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
	margin: 0 auto;
}

tr, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
<form action="/board/updateBoard" method="post">
<input type="hidden" value="${board.boardNum}" name="boardNum">
	<div>
		<table>
			<colgroup>
				<col width="15%">
				<col width="85%">
			</colgroup>
			<tr>
				<td>제목</td>
				<td><input type="text" style="width: 1000px;" name="boardName"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea style="width: 1000px; height: 550px;" name="boardContent"></textarea></td>
			</tr>
		</table>
		
		<c:if test="${board.boardCode eq 'BOARD_3'}">
			<div>
				이벤트 시작일 <input type="date" name="eventFromDate">
			</div>
			<div>
				이벤트 종료일 <input type="date" name="eventToDate">
			</div>
		</c:if>
	</div>
	
	<div style="padding-top: 100px; display: inline-block; float: left; position: relative; left: 300px;">
		<input type="button" style=" width: 100px; height: 30px;" value="뒤로" onclick="history.back()">
	</div>
	<div style="padding-top: 100px; display: inline-block; float: right; position: relative; right: 200px;">
		<input type="submit" style=" width: 100px; height: 30px;" value="확인">
	</div>
	
</form>
</body>
</html>