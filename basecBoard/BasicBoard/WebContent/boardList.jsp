<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

div{
}
table{
	width:800px;
	border: 1px solid black;
	border-collapse: collapse;
	margin: 0 auto;
	
}
tr,td{
	border : 1px solid black;
	text-align: center;
}
.title{
	text-align: center;
	font-weight: bold;
}
.bitcoin{
	margin-top:15px;
	text-align: center;
}
.menu{
	width:800px;
	text-align: right;
	margin : 0 auto;	
}
a{
	color:black;
	text-decoration: none;
}
.left{
	text-align: left;
}
</style>
</head>
<body>
<div>
<div style="height: 30px;"></div>
<div class = "menu">
	<c:choose>
		<c:when test="${empty sessionScope.loginInfo }">
	<h3><a href = "loginForm.me">LOGIN </a> 
	<a href = "joinForm.me">JOIN</a></h3>		
		</c:when>
		<c:when test="${not empty sessionScope.loginInfo }">
		${sessionScope.loginInfo.name} 님 반갑소. 
		<a href="logout.me">LOGOUT</a>		
		</c:when>
	</c:choose>
	
</div>
<table>
	<colgroup>
		<col width = "10%">
		<col width = "*">
		<col width = "15%">
		<col width = "15%">
		<col width = "10%">
	</colgroup>
	<tr class="title">
		<td>No </td>
		<td>제목 </td>
		<td>작성자 </td>
		<td>작성일 </td>
		<td>조회수 </td>
	</tr>
		<c:forEach items="${list}" var="board"> 
	<tr>  
		<td>${board.boardNum } </td>
		<td class="left"><a href="boardDetail.bo?boardNum=${board.boardNum}">${board.title }</a></td>
		<td>${board.memberId}</td>
		<td>${board.createDate}</td>
		<td>${board.readCnt}</td>
	</tr>
		</c:forEach>

</table>                           <!-- not empty 해당 정보가 비어있지 않다면 -->
<div class="bitcoin">
	<c:if test="${not empty sessionScope.loginInfo }">
	<input type="button" value="글작성" onclick="location.href='boardWriteForm.bo'"> 
	</c:if>
</div>
</div>

</body>
</html>