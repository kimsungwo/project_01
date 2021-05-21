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
	

</table>                           <!-- not empty 해당 정보가 비어있지 않다면 -->
<div class="bitcoin">
	<input type="button" value="글작성" onclick="location.href='boardWriteForm.bo'"> 
</div>
</div>

</body>
</html>