<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/board_list.css?ver=011" rel="stylesheet">
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap');

a{
	text-decoration: none;
}
.potal{
	text-align: left;
	margin-left: 1290px;
}
#container{
	text-align: center;
	font : fantasy;
	font-family: 'Sunflower', sans-serif;
	font-size: 20px;
}
.table{
	width:1000px;
	margin: 0 auto;
	
}
.table tr td{
	border: 1px solid #F5A9BC;
	border-radius: 6px;
	
}
.title{
	padding-left:10px;
	text-align: left;
}
</style>
</head>
<body id="container">
<div class = "potal">
	<a href="../member/login">Login</a> 
	<a href="../member/join">join</a>
</div>
<div>
	<table class="table">
		<colgroup>
			<col width="8%">
			<col width="*">
			<col width="10%">
			<col width="25%">
			<col width="8%">
		</colgroup>
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${list}" var="board">
			<tr>
				<td>${board.boardNum }</td>
				<td class="title"><a href="/board/detail?boardNum=${board.boardNum}">${board.title }</a></td>
				<td>${board.memberId }</td>
				<td>${board.createDate }</td>
				<td>${board.readCnt }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>