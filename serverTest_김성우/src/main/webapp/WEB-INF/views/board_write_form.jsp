<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/js/id.js?ver=13" type="text/javascript"></script>
</head>
<body>
<div>
<form action="write" method="post" id="writer"> 
	<table>
		<colgroup>
			<col width=30%>
			<col width=*>
		</colgroup>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" id="ti"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name=memberId id="id"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="20px" cols="35px" name="content"></textarea></td>
		</tr>
	</table>
	<button type="button" onclick="id3();">작성완료</button>
</form>
</div>

</body>
</html>