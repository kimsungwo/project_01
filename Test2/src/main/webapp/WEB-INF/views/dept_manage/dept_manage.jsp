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
.container{
}
.menuName{
	margin-left: 27rem;
	margin-top: 2rem; 
	margin-bottom: 2rem;
}
.table1{
	border: 1px solid white;
	border-color: white;
	
}
.table7{
	width: 40rem;
}
</style>
</head>
<body>
<div class="container">
<div class="menuName">
	-부서등록
	</div>
	<div class="table1">
	<form action="deptInsert" method="post">
		<table class="table7">
			<tr>
				<td>부서명</td>
				<td><input type="text" name="dName"></td>
				<td>지역</td>
				<td>
					<select name="loc">
						<option value="서울">서울</option>
						<option value="부산">부산</option>
						<option value="대전">대전</option>
						<option value="대구">대구</option>
						<option value="인천">인천</option>
					</select>
				</td>
				<td>
					<input type="submit" value="등록">
				</td>
			</tr>
		</table>
	</form>
	</div>
	<br>
	<div class="menuName">
	-부서목록
	
	</div>
<div>
<table>
	<colgroup>
		<col width = "24%">
		<col width = "38%">
		<col width = "38%">
	</colgroup>
	<tr class="title">
		<td>부서번호</td>
		<td>부서명</td>
		<td>지역 </td>
	</tr>
		<c:forEach items="${deptList}" var="board"> 
	<tr>  
		<td>${board.deptno} </td>
		<td>${board.dName}</td>
		<td>${board.loc}</td>
	</tr>
		</c:forEach>
</table> 
</div>
</div>
</body>
</html>