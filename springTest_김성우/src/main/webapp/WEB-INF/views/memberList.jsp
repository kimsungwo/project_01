<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table tr td{
	border: 1px solid black;		
}
</style>
</head>
<body>
 <c:if test="${not empty sessionScope.loginInfo and sessionScope.loginInfo.id eq 'admin' }">
          <a href="/sample/Manage">관리자 페이지로 이동</a>
      </c:if>
<div>
	<table class="table">
<%-- 		<colgroup>
			<col width="20%">
			<col width="*">
			<col width="20%">
			<col width="20%">
			<col width="20%">
		</colgroup> --%>
		<tr>
			<td>회원ID</td>	
			<!-- <td>비번</td> -->
			<td>회원 이름</td>
			<td>회원 나이</td>
			<td>가입일자</td>
		</tr>
		 <c:forEach items="${SampleVO}" var="sample">
			<tr>
				<td>${sample.id}</td>
				<td>${sample.name}</td>
				<td>${sample.age}</td>
				<td>${sample.date}</td>
				</tr>
		 </c:forEach>
	</table>
</div>
</body>
</html>