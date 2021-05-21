<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/member/find_id.js?ver=01" type="text/javascript"></script>
<style type="text/css">
.container{
	width: 35rem;
}
.inlineBlock{
	display: inline-block;
}
.profileTable{
	margin-top: 3rem;
}
</style>
</head>
<body>
	<div class="container">
		<h1>아이디 찾기 결과[일반회원]</h1>
		<div class="findResultDiv">
		<form action="/member/find_pwForm" method="get">
			<table class="table profileTable">
				<colgroup>
					<col width="18%">
				</colgroup>
				<c:choose>
				<c:when test="${not empty findId}">
				<tr>
					<td>
						ID
					</td>
					<td>
						${findId.memId}
						<input type="hidden" name="memId" value="${findId.memId}">
					</td>
					<td>
						<button type="submit" id="findBtn" class="btn btn1 btn-primary">비밀번호 찾기</button>
					</td>
				</tr>
				</c:when>
					<c:otherwise>
						<div class="findBtnDiv">
							<p class="subMenuInfo">이메일을 정확하게 입력해주세요.</p>
							<button type="button" onclick="history.go(-1);"class="btn btn-primary">뒤로가기</button>
						</div>
					</c:otherwise>
				</c:choose>
			</table>
		</form>
		</div>
	</div>
</body>
</html>


