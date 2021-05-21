<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 부트스트랩 css -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

<!-- 폰트 -->
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet" />

<!-- 부트스트랩 js -->
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
<style type="text/css">
#noticeDiv {
	text-align:center;
	margin-top: 10rem;
}

#noticeDiv img {
	width: 100px;
}

h1 {
	font-family: 'Lobster', cursive;
}
.bi {
	font-size: 100px;
}
p {
	font-size: 1.5rem;
}
</style>
</head>
<body>
<div class="container">
	<div id="noticeDiv">
		<img alt="" src="/resources/img/main/logo1.png">
		<h1>Da Java notice</h1>
	
		<c:if test="${requestScope['javax.servlet.error.status_code'] == 400}">
			<p>잘못 된 요청입니다.</p>    
		</c:if>	
		
		<c:if test="${requestScope['javax.servlet.error.status_code'] == 404}">
			<p>요청하신 페이지를 찾을 수 없습니다.</p>    
		</c:if>
		
		<c:if test="${requestScope['javax.servlet.error.status_code'] == 405}">
			<p>요청된 메소드가 허용되지 않습니다.</p>    
		</c:if>
		
		<c:if test="${requestScope['javax.servlet.error.status_code'] == 500}">
			<p>서버에 오류가 발생하여 요청을 수행할 수 없습니다.</p>
		</c:if>
		
		<c:if test="${requestScope['javax.servlet.error.status_code'] == 503}">
			<p>서비스를 사용할 수 없습니다.</p>
		</c:if>
		
		<button type="button" class="btn btn-primary" onclick="location.href='/';">메인으로 가기</button>
	</div>
</div>	
</body>
</html>