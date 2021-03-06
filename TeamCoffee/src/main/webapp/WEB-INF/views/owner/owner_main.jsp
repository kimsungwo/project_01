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
.ownerInfo{
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
			<div class="card-header"><a class="side_menu" href="/owner/myPage?sideMenu=1">프로필 조회 및 변경</a></div>
			<div class="card-body">
				<h5 class="card-title"><span class="span-red">프로필 조회, 변경</span>을 할 수 있습니다</h5>
			</div>
		</div>
		<div class="card text-white col-2 iconBoard">
			<div class="card-header"><a class="side_menu" href="/owner/regCafe?sideMenu=2">매장등록</a></div>
			<div class="card-body">
				<h5 class="card-title"><span class="span-red">매장을 등록</span>할 수 있습니다</h5>
			</div>
		</div>
		<div class="card text-white col-2 iconBoard">
			<div class="card-header"><a class="side_menu" href="/owner/cafeManage?sideMenu=3">매장관리</a></div>
			<div class="card-body">
				<div><span class="ownerInfo">관리중 : ${owners.oprtCafes }곳</span></div>
				<div><span class="ownerInfo">승인중 : ${owners.aprCafes }곳</span></div>
			</div>
		</div>
	</div>
	<div class="row justify-content-center">		
		<div class="card text-white col-2 iconBoard">
			<div class="card-header"><a class="side_menu" href="/owner/regMenu">메뉴등록</a></div>
			<div class="card-body">
				<h5 class="card-title"><span class="span-red">메뉴를 등록</span>할 수 있습니다</h5>
			</div>
		</div>
		<div class="card text-white  col-2 iconBoard">
			<div class="card-header"><a class="side_menu" href="/owner/menuManage">메뉴관리</a></div>
			<div class="card-body">
				<h5 class="card-title"><span class="span-red">메뉴를 관리</span>할 수 있습니다</h5>
			</div>
		</div>
		<div class="card text-white  col-2 iconBoard">
			<div class="card-header"><a class="side_menu" href="/owner/orderConfirm">주문확인</a></div>
			<div class="card-body">
				<span class="ownerInfo">${owners.orders }건</span>
				<h5 class="card-title">진행중인 주문이 있습니다</h5>
			</div>
		</div>
	</div>
	<div class="row justify-content-center">
		<div class="card text-white  col-2 iconBoard">
			<div class="card-header"><a class="side_menu" href="/owner/qnaOwner">Q/A</a></div>
			<div class="card-body">
				<span class="ownerInfo">1건</span>
				<h5 class="card-title">의 답변이 완료된 질문이 있습니다</h5>
			</div>
		</div>
		<div class="card text-white col-2 iconBoard">
			<div class="card-header"><a class="side_menu" href="/owner/toDropOutForm">회원탈퇴</a></div>
			<div class="card-body">
				<h5 class="card-title"><span class="span-red">회원탈퇴</span>가 가능합니다</h5>
			</div>
		</div>
	</div>
</body>
</html>