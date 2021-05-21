<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resources/js/template/menu.js?ver=18"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
		<a class="navbar-brand" href="/cafe/main">로고</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/cafe/main">Home <span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="/cafe/cafeList">Cafe List</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Event</a></li>
				<li class="nav-item"><a class="nav-link" href="/cafe/community1">Community</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
			<ul class="navbar-nav mr-auto">
				<c:choose>
					<c:when test="${not empty sessionScope.ownerLoginInfo }">
						<li class="nav-item nav-link active">${sessionScope.ownerLoginInfo.ownerName }님 반갑습니다</li>
						<li class="nav-item"><a class="nav-link" href="/owner/myPage">My Page(매장주)</a></li>
					</c:when>
					<c:when test="${not empty sessionScope.memberLoginInfo }">
						<li class="nav-item nav-link active">${sessionScope.memberLoginInfo.memNickname }님 반갑습니다</li>
						<li class="nav-item"><a class="nav-link" href="/member/myPage">My Page(일반회원)</a></li>
					</c:when>				
				</c:choose>
				<c:choose>
					<c:when test="${empty sessionScope.ownerLoginInfo and empty sessionScope.memberLoginInfo}">
						<li class="nav-item"><a class="nav-link" href="#" data-toggle="modal" data-target="#exampleModal">Login</a></li>
						<li class="nav-item"><a class="nav-link" href="/cafe/selectMemberType">Join</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="#" onclick="logout();">Logout</a></li>
					</c:otherwise>				
				</c:choose>
			</ul>	
			</form>
		</div>
	</nav>
	<!-- 로그인 모달 -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Login</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="#" method="post" class="needs-validation" novalidate id="loginForm">
					<div class="modal-body">
						<div class="form-row">
							<div class="col">
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio"
										name="inlineRadioOptions" id="inlineRadio1" value="매장주" checked>
									<label class="form-check-label" for="inlineRadio1">매장주</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio"
										name="inlineRadioOptions" id="inlineRadio2" value="일반회원">
									<label class="form-check-label" for="inlineRadio2">일반회원</label>
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="col">
								<label for="validationCustom03">ID</label> 
								<input type="text" class="form-control" id="loginId" required>
								<div class="invalid-feedback">아이디를 입력해주세요</div>
							</div>
						</div>
						<div class="form-row">
							<div class="col">
								<label for="validationCustom03">PASSWORD</label> 
								<input type="password" class="form-control" id="loginPw" required>
								<div class="invalid-feedback">비밀번호를 입력해주세요</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary btn-block" onclick="loginProcess();">Login</button>
						<button type="button" class="btn btn-success btn-block" onclick="location.href='/cafe/selectMemberType';">Join</button>
						<button type="button" class="btn btn-outline-dark" onclick="location.href='/member/find_idForm';">아이디 찾기</button>
						<button type="button" class="btn btn-outline-dark" onclick="location.href='/member/find_pwForm';">비밀번호 찾기</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>