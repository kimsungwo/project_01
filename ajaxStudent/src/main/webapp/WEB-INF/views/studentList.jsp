<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.outer{
	width: 900px;
	height: 600px;
	margin: 0 auto;
	text-align: center;
	border: 1px solid black;
	border-collapse: collapse;
}
tr,td,th{
	border: 1px solid black;
	border-collapse: collapse;
}
.inner{
	width: 400px;
	margin: 0 auto;
	text-align: center;
	border: 1px solid black;
	border-collapse: collapse;	
}
.inner2{
	width: 400px;
	margin: 0 auto;
	margin-top:20px;
	text-align: center;
	border: 1px solid black;
	border-collapse: collapse;	
}
.menu{
	width: 400;
	margin: 0 auto;
	text-align: center;
	border: 1px solid black;
	border-collapse: collapse;	
}
</style>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/js/studentList.js?ver=129"></script>
</head>
<body>
<table class="outer">
	<colgroup>
		<col width="50%">
		<col width="50%">
	</colgroup>
	<tr>
		<td>
			<select id="classSelector">
				<c:forEach items="${classList}" var="classInfo" >
					<option value="${classInfo.classCode}">${classInfo.className}</option>
				</c:forEach>
			</select>
		<table class="inner">
			<tr>
				<td>이름</td>
				<td>나이</td>
				<td>주소</td>
				<td>삭제</td>
			</tr>
			<c:forEach items="${studentList }" var="stuInfo">
				<tr>
					<td><a  href="#"  onclick="selectScore('${stuInfo.stuNum}');">${stuInfo.stuName}</a></td>
					<td>${stuInfo.stuAge}</td>
					<td>${stuInfo.stuAddr}</td>
				<td><div class="deletS" data-stuNum="${stuInfo.stuNum}">삭제</div></td>
				<%-- <td><a href="#"  class="deletS" onclick="deletS();" data-stuNum="${stuInfo.stuNum }"> 삭제</a></td> --%>
				</tr>
			</c:forEach>
		</table>
		</td>
		<td id="scoreTd">
			
		</td>
	</tr>
</table>
</body>
</html>