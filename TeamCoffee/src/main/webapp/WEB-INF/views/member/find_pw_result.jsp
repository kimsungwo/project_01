<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
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
		<h1>비밀번호 찾기 결과[일반회원]</h1>
		<div class="findResultDiv">
		<c:choose>
			<c:when test="${not empty findPw}">
				<p class="subMenuInfo">가입하신 이메일로 임시비밀번호를 발급했습니다.</p>
				<button type="button" onclick="location.href='/cafe/main';" class="btn1 btn-primary">메인페이지</button>
			</c:when>
			<c:otherwise>
				<div class="findBtnDiv">
					<p class="subMenuInfo">이메일이나 ID를 정확하게 입력해주세요.</p>
					<button type="button" onclick="history.go(-1);" class="btn btn1 btn-primary">뒤로가기</button>
				</div>
			</c:otherwise>
		</c:choose>
		</div>
	</div>
</body>
</html>