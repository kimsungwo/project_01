<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resources/js/template/menu.js?ver=21"></script>
<script src="/resources/js/template/setInterval.js?ver=58" type="text/javascript"></script>
<style type="text/css">
.dropbtn {
  background-color: #343a40;
  color: black;
  padding: 16px;
  font-size: 16px;
  border: none;
}

/* .dropdown {
  position: relative;
  display: inline-block;
} */

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #343a40;}

.img_link{
	margin-top: -0.9rem;
}

</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
		<a class="navbar-brand" href="/cafe/main"><img alt="" src="/resources/img/main/dajavalogo.png" style="width: 50px"></a>
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
				<c:when test="${not empty sessionScope.ownerLoginInfo and sessionScope.ownerLoginInfo.isAdmin eq 'Y' }">
						<li class="nav-item nav-link active">${sessionScope.ownerLoginInfo.ownerName }님 반갑습니다</li>
						<li class="nav-item dropdown img_link">
							<button class="dropbtn nav-link">
								<a class="nav-link" href="/owner/admin">My Page(관리자)
								</a>
							</button>
							<div class="dropdown-content">
								<a href="/owner/myPage?sideMenu=1" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 1 }">active</c:if>" aria-current="true">프로필 조회</a> 
								<a href="/owner/regCafe?sideMenu=2" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 2 }">active</c:if>">매장등록</a> 
								<a href="/owner/cafeManage?sideMenu=3" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 3 }">active</c:if>">매장관리</a> 
								<a href="/owner/regMenu" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 4 }">active</c:if>">메뉴등록</a>
								<a href="/owner/menuManage" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 5 }">active</c:if>">메뉴관리</a> 
								<a href="/owner/memberManage" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 6 }">active</c:if>">회원관리</a>
							</div>
						</li>
					</c:when>
					<c:when test="${not empty sessionScope.ownerLoginInfo }">
						<li class="nav-item nav-link active">${sessionScope.ownerLoginInfo.ownerName }님 반갑습니다
							<input type="hidden" value="${sessionScope.ownerLoginInfo.ownerCode }" id="isOwner">
						</li>
						<li class="nav-item dropdown img_link">
							<button class="dropbtn nav-link">
								<a class="nav-link" href="/owner/main">My Page(매장주)</a>
							</button>
							<div class="dropdown-content">
								<a href="/owner/myPage?sideMenu=1" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 1 }">active</c:if>" aria-current="true">프로필 조회</a> 
								<a href="/owner/regCafe?sideMenu=2" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 2 }">active</c:if>">매장등록</a> 
								<a href="/owner/cafeManage?sideMenu=3" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 3 }">active</c:if>">매장관리</a> 
								<a href="/owner/regMenu" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 4 }">active</c:if>">메뉴등록</a>
								<a href="/owner/menuManage" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 5 }">active</c:if>">메뉴관리</a> 
								<a href="/owner/orderConfirm" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 6 }">active</c:if>">예약확인</a>
							</div>
						</li>
					</c:when>
					<c:when test="${not empty sessionScope.memberLoginInfo }">
							<li class="nav-item nav-link active">${sessionScope.memberLoginInfo.memNickname }님 반갑습니다
								<input type="hidden" value="${sessionScope.memberLoginInfo.memCode }" id="isMem">
							</li>
							<li class="nav-item dropdown img_link">
									<button class="dropbtn nav-link">
										<a class="nav-link" href="/member/memberMain">
									My Page
								</a>
									</button>
									<div class="dropdown-content">
										<a href="/member/myPage" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 1 }">active</c:if>" aria-current="true">프로필 조회</a> 
										<a href="/member/buyList" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 2 }">active</c:if>">주문내역</a> 
										<a href="/member/pointList" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 3 }">active</c:if>">포인트내역</a> 
										<a href="/member/likeCafeList" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 4 }">active</c:if>">찜한 매장</a> 
										<a href="/member/reviewList" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 5 }">active</c:if>">리뷰목록</a>
								</div>  
							</li>
							<li class="nav-item"><a class="nav-link" href="/cart/cartList">장바구니</a></li>
					</c:when>				
				</c:choose>
				<c:choose>
					<c:when test="${empty sessionScope.ownerLoginInfo and empty sessionScope.memberLoginInfo}">
						<li class="nav-item"><a class="nav-link" href="#" data-toggle="modal" data-target="#exampleModal">Login</a></li>
						<li class="nav-item"><a class="nav-link" href="/cafe/selectMemberType">Join</a></li>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${not empty sessionScope.ownerLoginInfo }">
								<li class="nav-item"><a class="nav-link" href="#" onclick="ownerLogout();">Logout</a></li>
							</c:when>
							<c:when test="${not empty sessionScope.memberLoginInfo }">
								<li class="nav-item"><a class="nav-link" href="#" onclick="memberLogout();">Logout</a></li>
							</c:when>
						</c:choose>
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
								<input type="text" class="form-control" id="loginId" name="loginId" required>
								<div class="invalid-feedback">아이디를 입력해주세요</div>
							</div>
						</div>
						<div class="form-row">
							<div class="col">
								<label for="validationCustom03">PASSWORD</label> 
								<input type="password" class="form-control" id="loginPw" name="loginPw" required>
								<div class="invalid-feedback">비밀번호를 입력해주세요</div>
							</div>
						</div>
						<div class="form-group form-check">
							<input type="checkbox" class="form-check-input" id="useCookie" name="useCookie" value="useCookie"> 
							<label class="form-check-label" for="useCookie">로그인 유지</label>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary btn-block" onclick="loginProcess();">Login</button>
						<button type="button" class="btn btn-success btn-block" onclick="location.href='/cafe/selectMemberType';">Join</button>
						<small>
							<a class="form-text text-muted" onclick="location.href='/owner/find_idFormOwner';" style="display: inline-block;">매장주 아이디 찾기</a> / 
							<a class="form-text text-muted"onclick="location.href='/owner/find_pwFormOwner';" style="display: inline-block;" >매장주 비밀번호 찾기</a><br>
							<a class="form-text text-muted" onclick="location.href='/member/find_idForm';" style="display: inline-block;">일반회원 아이디 찾기</a> / 
							<a class="form-text text-muted"onclick="location.href='/member/find_pwForm';"style="display: inline-block;">일반회원 비밀번호 찾기</a>
						</small>
						<!-- <button type="button" class="btn btn-outline-dark" onclick="location.href='/member/find_idForm';">아이디 찾기</button>
						<button type="button" class="btn btn-outline-dark" onclick="location.href='/member/find_pwForm';">비밀번호 찾기</button> -->
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>