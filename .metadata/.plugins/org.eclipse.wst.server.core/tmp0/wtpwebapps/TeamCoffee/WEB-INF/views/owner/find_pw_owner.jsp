<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/owner/find_pw_owner.js?ver=12" type="text/javascript"></script>
<style type="text/css">
table td:first-of-type{
	text-align: center;
}
.container{
	width:35rem;
}
.subMenuInfo{
	font-size: 1rem;
}
</style>
</head>
<body>
</body>
	<div class="container">
		<h1>비밀번호 찾기[매장주]</h1>
		<p class="subMenuInfo">회원가입시 입력한 아이디와 이메일을 입력해주세요.</p>
		<form action="/owner/find_pw_owner" method="post" id="find_pw">
			<table class="table profileTable findTable">
				<colgroup>
					<col width="18%">
				</colgroup>
				<c:choose>
				<c:when test="${not empty OwnerVO.ownerId}">
					<tr>
						<td>ID</td>
						<td><input class="form-control" type="text" name="ownerId" value="${OwnerVO.ownerId}" id="ownerId"></td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td>ID</td>
						<td><input class="form-control" type="text" name="ownerId" id="ownerId"></td>
					</tr>
					</c:otherwise>
				</c:choose>
				<tr>
					<td>EMAIL</td>
					<td><input class="form-control email" type="text" id="email" name="ownerEmail" ></td>
				</tr>
			</table>
			<div class="findBtnDiv">
				<button type="button" id=findBtn class="btn btn1 btn-primary">F I N D</button>
			</div>
		</form>
	</div>
</html>