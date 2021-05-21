<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1{
	margin-top: 10rem;
}
</style>
</head>
<body>
<div class="bitcoin">
<table class="join">
<colgroup>
		<col width = "15%">
		<col width = "*">
		<col width = "15%">
		<col width = "15%">
		<col width = "15%">
		<col width = "15%">
		<col width = "15%">
	</colgroup>
	<tr>
		<td rowspan="2">No.</td>
		<td colspan="4">사원정보</td>
		<td colspan="2">부서정보</td>
	</tr>
	<tr>
		<td>사원명</td>
		<td>연락처</td>
		<td>성별</td>
		<td>나이</td>
		<td>부서명</td>
		<td>지역</td>
	</tr>
<c:forEach items="${empList}" var="emp" varStatus="status"> 
	<tr>  
		<td>${empList.size() - status.index} </td>
		<td>${emp.eName}</td>
		<td>${emp.tel}</td>
		<td>${emp.gender}</td>
		<td>${emp.age}</td>
		<td>${emp.dName}</td>
		<td>${emp.loc}</td>
	</tr>
</c:forEach> 

	
	
</table>
</div>
</body>
</html>