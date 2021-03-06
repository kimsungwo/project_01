<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	background-color: #F2F2F2;
}
.iconBoard{
	height: 12rem;
}
.mx-auto{
	margin-left: 10rem;
}
.top1{
	margin-top: 5rem;
}
.text-center{
	margin-top: 1rem;
}
.side_menu{
	color: #000000;
}
.card-header{
	text-align: center;
	font-weight: bold;
}
a:hover{
	color: #343a40;
	text-decoration: none;
}
.card{
	margin: 10px 20px;
	padding: 0px;
}
.card-title{
	color: #343a40;
	font-size: 1rem;
}
.card-body{
	text-align: center;
}
.memberInfo{
	color: #C63D3D;
	font-size: 1.5rem;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="row justify-content-center">
		<div class="text-center">
			<h1>My Page</h1>
		</div>
	</div>
	<div class="row justify-content-center top1">
		<div class="card text-white col-2 iconBoard">
			<div class="card-header">
				<a class="side_menu" href="/member/myPage">프로필 조회 및 변경</a>
			</div>
			<div class="card-body">
				<h5 class="card-title"><span class="span-red">프로필 조회, 변경</span>을 할 수 있습니다.</h5>
			</div>
		</div>
		<div class="card text-white col-2 iconBoard">
			<div class="card-header">
				<a class="side_menu" href="/member/buyList">주문내역</a>
			</div>
			<div class="card-body">
				<span class="memberInfo">${members.buys }건</span>
				<h5 class="card-title">의 주문내역이 있습니다</h5>
			</div>
		</div>
		<div class="card text-white col-2 iconBoard">
			<div class="card-header"><a class="side_menu" href="/member/pointList">포인트내역</a></div>
			<div class="card-body">
				<span class="memberInfo">${members.points }점</span>
				<h5 class="card-title">의 포인트가 있습니다</h5>
			</div>
		</div>
	</div>
	<div class="row justify-content-center">
		<div class="card text-white col-2 iconBoard">
			<div class="card-header">
				<a class="side_menu" href="/cart/cartList">장바구니</a>
			</div>
			<div class="card-body">
				<span class="memberInfo">${members.carts }개</span>
				<h5 class="card-title">의 상품이 장바구니에 있습니다</h5>
			</div>
		</div>
		<div class="card text-white col-2 iconBoard">
			<div class="card-header">
				<a class="side_menu" href="/member/likeCafeList">찜한매장</a>
			</div>
			<div class="card-body">
				<span class="memberInfo">${members.likes }곳</span>
				<h5 class="card-title">의 매장을 찜했습니다</h5>
			</div>
		</div>
		<div class="card text-white col-2 iconBoard">
			<div class="card-header">
				<a class="side_menu" href="/member/likeCafeList">리뷰목록</a>
			</div>
			<div class="card-body">
				<span class="memberInfo">${members.reviews }건</span>
				<h5 class="card-title">의 리뷰를 등록했습니다</h5>
			</div>
		</div>
	</div>
	<div class="row justify-content-center">
		<div class="card text-white col-2 iconBoard">
			<div class="card-header">
				<a class="side_menu" href="/member/qnaMember">Q/A</a>
			</div>
			<div class="card-body">
				<span class="memberInfo">${members.qnas }건</span>
				<h5 class="card-title">의 답변이 완료된 질문이 있습니다</h5>
			</div>
		</div>
		<div class="card text-white col-2 iconBoard">
			<div class="card-header">
				<a class="side_menu" href="/member/toDropOutForm">회원탈퇴</a>
			</div>
			<div class="card-body">
				<h5 class="card-title"><span class="span-red">회원탈퇴</span>가 가능합니다</h5>
			</div>
		</div>
	</div>

</body>
</html>