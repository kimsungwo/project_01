<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	width : 300px;
	border: 1px solid black;
	border-collapse: collapse;
	margin: 0 auto;
	margin-top: 30px;
}
tr,td{
	border-collapse: collapse;
	border: 1px solid black;
	text-align: center;
}
.hiss{
	margin-top : 10px;
	margin-left: 49%;
}


</style>
</head>
<body>
<form action="boardWrite.bo" method="post"> 
<table>
	<tr>
		<td bgcolor="gray">title</td>
		<td><input type="text" name = "title" required autocomplete="off"></td>
	</tr>
	<tr>
		<td bgcolor="gray">content</td>
		<td><textarea rows="20" cols="60" name="content"></textarea></td>
	</tr>
</table>
<input type="button" value="목록가기" onclick="location.href='boardlist.bo'">
<input class="hiss" type="submit" value="등록" > 
</form>
</body>
</html>