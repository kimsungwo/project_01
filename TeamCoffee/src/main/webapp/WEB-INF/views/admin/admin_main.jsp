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
.adminInfo{
	color: #C63D3D;
	font-size: 1.5rem;
	font-weight: bold;
	display: inline-block;
}
</style>
</head>
<body>
	<div class="row justify-content-center">
		<div class="text-center">
			<h1>Admin Page</h1>
		</div>		
	</div>
	<div class="row justify-content-center top1">		
		<div class="card text-white col-2 iconBoard">
			<div class="card-header"><a class="side_menu" href="/admin/qnaManage">Q/A</a></div>
			<div class="card-body">
				<span class="adminInfo">0건</span>
				<h5 class="card-title">의 문의가 있습니다</h5>
			</div>
		</div>
		<div class="card text-white col-2 iconBoard">
			<div class="card-header"><a class="side_menu" href="/admin/cafeManage">매장신청목록</a></div>
			<div class="card-body">
				<span class="adminInfo">${CreateReady} 건</span>
				<h5 class="card-title">의 매장신청이 있습니다</h5>
			</div>
		</div>
	</div>
	<div class="row justify-content-center">		
		<div class="card text-white col-2 iconBoard">
			<div class="card-header"><a class="side_menu" href="/admin/memberManage">회원관리</a></div>
			<div class="card-body">
				<div><span class="adminInfo">회원 : ${memberCount}명</span></div>
				<div><span class="adminInfo">매장주 : ${ownerCount}명</span></div>
			</div>
		</div>
		<div class="card text-white col-2 iconBoard">
			<div class="card-header"><a class="side_menu" href="#">게시판 관리</a></div>
			<div class="card-body">
				<h5 class="card-title">게시판 관리 페이지</h5>
			</div>
		</div>
	</div>
</body>
</html>