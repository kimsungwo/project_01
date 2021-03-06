<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.card{
	border-radius: 15px;
}
.cafe-list-div{
	margin: 10px;
}
.card-img-top{
	padding-top: 20px;
	width: 50%;
}
.search-cafe{
	display: inline-block;
	width: 50%;
	margin-bottom: 20px;
}
</style>
</head>
<body>
<div class="row justify-content-center text-center">
	<div class="col-8">
		<div class="row">
			<div class="col text-center">
				<form action="/cafe/cafeList" method="post">
					<input type="text" class="form-control search-cafe" placeholder="매장명을 입력해주세요..." name="chainName">
					<button type="submit" class="btn btn-dark btn-sm">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
						<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
					</svg>
					</button>
				</form>
			</div>		
		</div>
		<div class="row">
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
	</div>
</div>
</body>
</html>