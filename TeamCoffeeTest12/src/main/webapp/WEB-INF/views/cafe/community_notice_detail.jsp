<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="margin: 0 auto;">
	<ul style="list-style-type: none;">
		<li style="display: inline-block; margin-left: 150px;"><h1>${board.boardName }</h1></li>
		<li style="display: inline-block; margin-left: 150px;"><h3>${board.boardWriter }</h3></li>
		<li style="display: inline-block; margin-left: 150px;"><h3>${board.boardRegDate }</h3></li>
	</ul>
</div>
<hr>
<div style="margin: 100px 50px;">
	${board.boardContent }
</div>
<div align="center" style="padding-top: 100px;">
	<input type="button" style=" width: 100px; height: 30px;" value="목록" onclick="location.href='/cafe/community1'">
</div>

<form action="/board/deleteBoard1" method="post">
	<div>
	<!-- 관리자 계정 세션 확인여부 필요  -->
		<input type="hidden" name="boardNum" value="${board.boardNum }">
		<input type="button" value="수정" onclick="location.href='/board/updateBoardForm?boardNum=${board.boardNum}&&boardCode=${board.boardCode }'">
		<input type="submit" value="삭제" >
	</div>
</form>
</body>
</html>