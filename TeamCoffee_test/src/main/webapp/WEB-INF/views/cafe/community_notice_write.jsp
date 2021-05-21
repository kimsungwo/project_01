<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="/board/noticeUpload" method="post">
<input type="hidden" name="boardWriter" value="admin">
<input type="hidden" name="boardCode" value="BOARD_1">

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
	</div>
	<div align="center" style="padding-top: 100px;">
		<input type="submit" style=" width: 100px; height: 30px;" value="확인">
	</div>
</form>
</body>
</html>