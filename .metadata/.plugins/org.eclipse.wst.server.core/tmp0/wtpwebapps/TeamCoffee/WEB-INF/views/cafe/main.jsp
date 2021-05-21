<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet" />
<style type="text/css">
body{
   background-image: linear-gradient( rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5) ), url("/resources/img/main/main_page.jpg");
   background-size: cover;
}
.mainDiv{
   background-color: rgba( 0, 0, 0, 0.5 );
   color: #dddddd;
   border: 1px solid rgba( 255, 255, 255, 0.2 );
}
.mainBtnDiv{
	margin-top: 5rem;
}
.mainBtn{
	width: 12rem;
	background-color: rgba( 0, 0, 0, 0.2 );
}
.mainBtn:hover{
	color: rgba( 255, 255, 255, 0.5 );
}
.btn-first{
	color: white;
	border: 2px solid #FF8200;
}
.btn-second{
	color: white;
	border: 2px solid #343a40;
}
.btn:active,
.btn:focus,
.btn.active,
.btn:active:focus {
   background-image: none;
   outline: 0;
   -webkit-box-shadow: none;
   box-shadow: none;
}
.card{
	color: white;
	border-radius: 15px;
	background-color: rgba( 0, 0, 0, 0.5 );
	border: 1px solid rgba( 255, 255, 255, 0.2 );
}
.cafe-list-div{
	margin: 10px;
}
.card-img-top{
	margin-top: 20px;
	width: 50%;
}
.search-cafe{
	display: inline-block;
	width: 50%;
	margin-bottom: 20px;
}
.cafeListDiv{
	margin-top: 5rem;
}
.cafeListDiv img{
	border-radius: 10px;
	opacity: 0.9;
}
</style>
</head>
<body>
<div id="containerBody">
	<div class="container">
		<div class="row mainDiv">
			<img alt="" src="/resources/img/main/logo1.png" style=" width: 200px; height: 200px;">
			<div class="col title">
				<h1>Welcome to <span class="logoColor">Da Java</span></h1>
				<p>다자바 홈페이지에 오신 것을 환영합니다.</p>
				<p>간편하고 빠르게 원하는 카페정보를 찾아보세요.</p>
			</div>
		</div>
		<c:choose>
			<c:when test="${empty sessionScope.ownerLoginInfo and empty sessionScope.memberLoginInfo }">
				<div class="row justify-content-center mainBtnDiv">
					<div class="col-6 text-center">
						<input type="button" value="L O G I N" class="btn btn-first mainBtn" data-toggle="modal" data-target="#loginModal">
					</div>
					<div class="col-6 text-center">
						<input type="button" value="J O I N" class="btn btn-second mainBtn" onclick="location.href='/cafe/selectMemberType';">
					</div>
				</div>
			</c:when>
			<c:otherwise>
			<div class="row text-center cafeListDiv">
				<div class="col-3">
					<div class="card cafe-list-div">
						<a href="/cafe/selectChain?ChainCode=all"><img src="/resources/img/logo/noimage.jpg" class="card-img-top" alt="..."></a>
						<div class="card-body">
							<h6 class="card-title">전체보기</h6>
						</div>
					</div>
				</div>
				<c:forEach items="${chainList }" var="chainInfo">
					<div class="col-3">
						<div class="card cafe-list-div">
							<!-- 로고 이미지 추가 예정 -->
							<a href="/cafe/selectChain?chainCode=${chainInfo.chainCode }"><img src="/resources/img/logo/${chainInfo.chainLogo }" class="card-img-top" alt="..."></a>
							<div class="card-body">
								<h6 class="card-title">${chainInfo.chainName }</h6>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			</c:otherwise>
		</c:choose>
	</div>
	<!-- 슬라이드 이미지 -->
	<!-- <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
			<li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
			<li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="/resources/img/main/banner.jpg" class="mx-auto d-block" alt="...">
			</div>
			<div class="carousel-item">
				<img src="/resources/img/main/banner.jpg" class="mx-auto d-block" alt="...">
			</div>
			<div class="carousel-item">
				<img src="/resources/img/main/banner.jpg" class="mx-auto d-block" alt="...">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev"> 
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> 
			<span class="sr-only">Previous</span>
		</a> 
		<a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next"> 
			<span class="carousel-control-next-icon" aria-hidden="true"></span> 
			<span class="sr-only">Next</span>
		</a>
	</div> -->
</div>	
</body>
</html>