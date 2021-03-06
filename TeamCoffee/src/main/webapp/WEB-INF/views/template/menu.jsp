<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resources/js/template/menu.js?ver=34"></script>
<script src="/resources/js/template/setInterval.js?ver=58" type="text/javascript"></script>
<style type="text/css">
.dropbtn {
  background-color: #343a40;
  color: black;
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
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.4);
  z-index: 1;
}
.dropdown-content a {
  color: #495057;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}
.dropdown:hover .dropdown-content {
	display: block;
}
#loginModal .modal-footer{
	border-top: none;
	padding-top: none;
	background-color: #FAFAFA;
}
.forgotDiv{
	color: #6c757d;
	font-size: 0.9rem;
}
.forgotDiv a{
	display: inline-block;
}
.forgotDiv a:hover{
	cursor: pointer;
	text-decoration: none;
}
.loginInput input{
	height: 3.5rem;
	margin: 10px 0px;
}
.loginModalBtn button{
	height: 3rem;
}
#loginLabel{
	color: rgba(0, 0, 0, 0.5);
	font-size: 0.95rem;
	font-weight: bold;
}
#loginModal .btn-light{
	border: 1px solid #343a40;
}
#loginModal .btn-primary{
	background-color: #343a40;
	border-color: #343a40;
}
#loginModal .btn-se{
	background-color: #FF8200;
	border-color: #FF8200;
}
.loginBox{
	display: inline-block;
}
.loginBox .custom-control-input:checked ~ .custom-control-label::before {
	background-image: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='14' height='14' viewBox='-3 -3 14 14'%3e%3cpath fill='%23fff' d='M6.564.75l-3.59 2.612-1.538-1.55L0 4.26l2.974 2.99L8 2.193z'/%3e%3c/svg%3e");
    background-color: #343a40;
    border-color: #343a40;
    box-shadow:0 0 3px #343a40;
}
.loginBox .custom-control-input:focus ~ .custom-control-label::before {
	border-color: #343a40;
    box-shadow:0 0 3px #343a40;
}
.loginBox .custom-control-input:active ~ .custom-control-label::before {
    box-shadow:0 0 3px #343a40;
    border-color: #343a40;
    background: rgba(0,0,0,.3);
}
.loginBox .custom-control-label::before {
    border-radius: 0.25rem;
}
.form-check{
	padding-left: 10px;
	margin-left: 10px;
}
.typeSwitch{
	display: inline-block;
	float: right;
}
#typeSwitchSpan{
	margin-right: 40px;
	color: red;
	font-size: 0.9rem;
	opacity: 0.8;
}
.typeSwitch .custom-control-input:checked~.custom-control-label::before {
    color: #fff;
    border-color: #343a40;
    background-color: #343a40;
}
.loginBox:checked{
	background-color: red;
    box-shadow:0 0 3px red;
}
.loginBox input{
	vertical-align: bottom;
}

</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
		<a class="navbar-brand" href="/cafe/main"><img alt="" src="/resources/img/main/dajavalogo.png" style="width: 64px"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/cafe/main">HOME <span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="/cafe/cafeList">CAFE LIST</a></li>
				<li class="nav-item"><a class="nav-link" href="#">EVENT</a></li>
				<li class="nav-item"><a class="nav-link" href="/cafe/community1">COMMUNITY</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
			<ul class="navbar-nav mr-auto">
				<c:choose>
				<c:when test="${not empty sessionScope.ownerLoginInfo and sessionScope.ownerLoginInfo.isAdmin eq 'Y' }">
						<li class="nav-item nav-link active">${sessionScope.ownerLoginInfo.ownerName }??? ???????????????</li>
						<li class="nav-item dropdown img_link">
							<a class="nav-link dropbtn" href="/admin/adminMain">
								My Page(?????????)
							</a>
							<div class="dropdown-content">
								<a href="/admin/qnaManage" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 1 }">active</c:if>">Q/A</a>
								<a href="/admin/cafeManage" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 2 }">active</c:if>">??????????????????</a>
								<a href="/admin/memberManage" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 3 }">active</c:if>">????????????</a>
								<a href="/admin/memberManage" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 5 }">active</c:if>">????????? ??????</a>
							</div>
						</li>
					</c:when>
					<c:when test="${not empty sessionScope.ownerLoginInfo }">
						<li class="nav-item nav-link active">${sessionScope.ownerLoginInfo.ownerName }??? ???????????????
							<input type="hidden" value="${sessionScope.ownerLoginInfo.ownerCode }" id="isOwner">
						</li>
						<li class="nav-item dropdown img_link">
							<a class="nav-link dropbtn" href="/owner/main">
								My Page(?????????)
							</a>
							<div class="dropdown-content">
								<a href="/owner/myPage?sideMenu=1" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 1 }">active</c:if>" aria-current="true">????????? ??????</a> 
								<a href="/owner/regCafe?sideMenu=2" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 2 }">active</c:if>">????????????</a> 
								<a href="/owner/cafeManage?sideMenu=3" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 3 }">active</c:if>">????????????</a> 
								<a href="/owner/regMenu" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 4 }">active</c:if>">????????????</a>
								<a href="/owner/menuManage" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 5 }">active</c:if>">????????????</a> 
								<a href="/owner/orderConfirm" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 6 }">active</c:if>">????????????</a>
								<a href="/owner/qnaOwner" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 7 }">active</c:if>">Q/A</a>
							</div>
						</li>
					</c:when>
					<c:when test="${not empty sessionScope.memberLoginInfo }">
							<li class="nav-item nav-link active">${sessionScope.memberLoginInfo.memNickname }??? ???????????????
								<input type="hidden" value="${sessionScope.memberLoginInfo.memCode }" id="isMem">
							</li>
							<li class="nav-item dropdown img_link">
								<a class="nav-link dropbtn" href="/member/memberMain">
									My Page
								</a>
									<div class="dropdown-content">
										<a href="/member/myPage" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 1 }">active</c:if>" aria-current="true">????????? ??????</a> 
										<a href="/member/buyList" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 2 }">active</c:if>">????????????</a> 
										<a href="/member/pointList" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 3 }">active</c:if>">???????????????</a> 
										<a href="/member/likeCafeList" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 4 }">active</c:if>">?????? ??????</a> 
										<a href="/member/reviewList" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 5 }">active</c:if>">????????????</a>
										<a href="/member/qnaMember" class="list-group-item list-group-item-action <c:if test="${sideMenu eq 6 }">active</c:if>">Q/A</a>
								</div>  
							</li>
							<li class="nav-item"><a class="nav-link" href="/cart/cartList">????????????</a></li>
					</c:when>				
				</c:choose>
				<c:choose>
					<c:when test="${empty sessionScope.ownerLoginInfo and empty sessionScope.memberLoginInfo}">
						<li class="nav-item"><a class="nav-link" href="#" data-toggle="modal" data-target="#loginModal">LOGIN</a></li>
						<li class="nav-item"><a class="nav-link" href="/cafe/selectMemberType">JOIN</a></li>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${not empty sessionScope.ownerLoginInfo }">
								<li class="nav-item"><a class="nav-link" href="#" onclick="ownerLogout();">LOGOUT</a></li>
							</c:when>
							<c:when test="${not empty sessionScope.memberLoginInfo }">
								<li class="nav-item"><a class="nav-link" href="#" onclick="memberLogout();">LOGOUT</a></li>
							</c:when>
						</c:choose>
					</c:otherwise>				
				</c:choose>
			</ul>	
			</form>
		</div>
	</nav>
	
	<!-- ????????? ?????? -->
	<div class="modal fade" id="loginModal" tabindex="-1"
		aria-labelledby="loginModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="loginModalLabel">LOGIN</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="#" method="post" class="needs-validation" novalidate id="loginForm">
					<div class="modal-body">
						<div class="form-row">
							<div class="col loginInput">
								<input type="text" class="form-control" id="loginId" name="loginId" required placeholder="ID">
								<div class="invalid-feedback">???????????? ??????????????????</div>
							</div>
						</div>
						<div class="form-row">
							<div class="col loginInput">
								<input type="password" class="form-control" id="loginPw" name="loginPw" required placeholder="PASSWORD">
								<div class="invalid-feedback">??????????????? ??????????????????</div>
							</div>
						</div>
						<div class="form-group form-check">
							<div class="loginBox">
								<input type="checkbox" class="custom-control-input form-check-input" id="useCookie" name="useCookie" value="useCookie"> 
								<label class="custom-control-label form-check-label" for="useCookie" ></label>
								<span id="loginLabel">????????? ??????</span>
							</div>
							<div class="custom-control custom-switch typeSwitch">
								<span id="typeSwitchSpan">??????????????????????</span>
								<input type="checkbox" class="custom-control-input" id="ownerSwitch">
								<label class="custom-control-label" for="ownerSwitch"></label>
							</div>
						</div>
						<div class="loginModalBtn">
							<button type="button" class="btn btn-primary btn-block btn-se" onclick="loginProcess();">L O G I N</button>
							<button type="button" class="btn btn-primary btn-block" onclick="location.href='/cafe/selectMemberType';">J O I N</button>
						</div>
					</div>
					<div class="modal-footer forgotDiv">
						<div>
							<a class="form-text text-muted" onclick="location.href='/member/find_idForm';" id="forgotId">????????? ??????</a> |
							<a class="form-text text-muted"onclick="location.href='/member/find_pwForm';" id="forgotPw">???????????? ??????</a><br>
						</div>
						<!-- <button type="button" class="btn btn-outline-dark" onclick="location.href='/member/find_idForm';">????????? ??????</button>
						<button type="button" class="btn btn-outline-dark" onclick="location.href='/member/find_pwForm';">???????????? ??????</button> -->
					</div>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>