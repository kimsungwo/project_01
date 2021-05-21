<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
글번호 : ${boardInfo.boardNum}<br>
글제목 : ${boardInfo.title }<br>
글내용 : ${boardInfo.content }<br>
작성자 : ${boardInfo.memberId }<br>
작성일 : ${boardInfo.createDate }<br>
조회수 : ${boardInfo.readCnt }<br>
<input type="button" value="삭쩨" onclick="location.href='/board/delete?boardNum=${boardInfo.boardNum}';">

</body>
</html>