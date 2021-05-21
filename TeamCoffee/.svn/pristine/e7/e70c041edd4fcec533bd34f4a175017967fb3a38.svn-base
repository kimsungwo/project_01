<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<script src="/resources/js/member/find_id.js?ver=01" type="text/javascript"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
.container{
	width: 35rem;
}
</style>
</head>
<body>
	<div class="w3-content w3-container w3-margin-top container">
		<div class="w3-container w3-card-4">
			<form action="/member/find_pwForm" method="get">
				<div class="w3-center w3-large w3-margin-top">
					<h3>아이디 찾기 결과</h3>
				</div>
				<div>
					<c:choose>
					<c:when test="${not empty findId.memId}">
						<p>
						<label>ID : </label>
						${findId.memId}
						</p>
						<p class="w3-center">
							<input type="hidden" name="memId" value="${findId.memId}">
							<button type="submit" id="findBtn" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">비밀번호 찾기</button>
							<button type="button" onclick="history.go(-1);" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round">Cancel</button>
						</p>
					</c:when>				
					<c:otherwise>
						<p>
						이메일을 정확하게 입력해주세요.
						</p>
						<p class="w3-center">
							<button type="button" onclick="history.go(-1);" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round">뒤로갈것</button>
						</p>
					</c:otherwise>				
				</c:choose>
				</div>
			</form>
		</div>
	</div>
</body>



</html>