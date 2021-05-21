<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.join{
	margin-top: 5.5rem;
	width:40rem;
	height: 18rem;
}
.eName{
	width: 32rem;
	height: 1.5rem;
}
.eNam{
	float : left;
	width:6rem;
	margin-left : 0.5rem;
	margin-right: 0.7rem;
}



</style>
</head>
<body>
<div class="bitcoin">
<div>
<form action="empInsert"  method="post">

<table class="join">
<colgroup>
		<col width = "16%">
		<col width = "28%">
		<col width = "28%">
		<col width = "28%">
	</colgroup>
	<tr>
		<td>사원명</td>
		
		<td colspan="3"><input type="text" class="eName" name="eName"></td>
	</tr>
	<tr>
		<td>직급</td>
		<td>
			<select name="job">
				<option  value="부장">부장</option>
				<option value="대리">대리</option>
				<option value="과장">과장</option>
				<option value="사원">사원</option>
			</select>
		</td>
		<td>부서</td>
		<td>
			 <select name="deptno">
				<c:forEach items="${deptNameList}" var="dn">
				<option value="${dn.deptno}">${dn.dName}</option>  
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>성별</td>
		<td>
			<input type="radio" checked="checked" name="gender" value="남">남
			<input type="radio" name="gender" value="여">여
		</td>
		<td>나이</td>
		<td><input type="number" value="20" name="age" min="1" max="70"> </td>
	</tr>
	<tr>
		<td>연락처</td>
		<td colspan="3">
			<input type="text" class="eNam" name="tels"> <input type="text" class="eNam" name="tels"> <input type="text" class="eNam" name="tels">
		</td>
	</tr>
	
</table>
<input type="submit" value="등록">
</form>
<%-- <input type="hidden" value=" ${deptNameList}"> --%>
</div>
</div>
</body>
</html>