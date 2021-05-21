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
				<col width="25%">
				<col width="25%">
				<col width="25%">
				<col width="25%">
			</colgroup>
			<tr class="title">
				<td>홈</td>
				<td>부서관리</td>
				<td>사원등록</td>
				<td>사원목록</td>
			</tr>


		</table>
		<div class="bitcoin">
			<input type="button" value="글작성"
				onclick="location.href='boardWriteForm.bo'">
		</div>
	</div>

</body>
</html>