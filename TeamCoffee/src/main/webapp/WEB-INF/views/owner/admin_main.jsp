<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.iconBoard{
	width: 18rem;
	height: 12rem;
}
.mx-auto{
	margin-left: 10rem;
}
.top1{
	margin-top: 5rem;
	margin-left: 26rem;
}
.card-deck{
	width: 60rem;
	margin-left: 26rem;
}
.text-center{
	margin-top: 1rem;
	margin-left: 50rem;
}
.side_menu{
	color: #000000;
}
.card-header{
	width: 15rem;
	margin-left: -1rem;
}
h1{
	margin-left: -3.5rem;
}
</style>
</head>
<body>
<div class="row">
			<div class="text-center">
				<h1>[관리자 메인페이지]</h1>
			</div>		
		</div>
	<div class="card-deck row justify-content-center top1">
		<div class="card text-white bg-secondary col-3 iconBoard">
			<div class="card-header"><a class="side_menu" href="/owner/myPage?sideMenu=1">프로필 조회 및 변경</a></div>
			<div class="card-body">
				<h5 class="card-title">프로필 조회 와 변경을 할 수 있습니다.</h5>
			</div>
		</div>
		<div class="card text-white bg-secondary col-3 iconBoard">
			<div class="card-header"><a class="side_menu" href="/owner/regCafe?sideMenu=2">매장등록</a></div>
			<div class="card-body">
				<h5 class="card-title">매장을등록할 수 있습니다.</h5>
			</div>
		</div>
		<div class="card text-white bg-secondary col-3 iconBoard">
			<div class="card-header"><a class="side_menu" href="/owner/cafeManage?sideMenu=3">매장관리</a></div>
			<div class="card-body">
				<h5 class="card-title">매장관리(@,@,@)</h5>
			</div>
		</div>
	</div>
	<div class="card-deck row justify-content-center">		
		<div class="card text-white bg-secondary col-3 iconBoard">
			<div class="card-header"><a class="side_menu" href="/owner/regMenu">메뉴등록</a></div>
			<div class="card-body">
				<h5 class="card-title">메뉴를 등록할 수 있습니다.</h5>
			</div>
		</div>
		<div class="card text-white bg-secondary col-3 iconBoard">
			<div class="card-header"><a class="side_menu" href="/owner/menuManage">메뉴관리</a></div>
			<div class="card-body">
				<h5 class="card-title">메뉴를 등록할 수 있습니다.</h5>
			</div>
		</div>
		<div class="card text-white bg-secondary col-3 iconBoard">
			<div class="card-header"><a class="side_menu" href="/owner/memberManage">회원관리</a></div>
			<div class="card-body">
				<h5 class="card-title">일반회원 관리메뉴</h5>
			</div>
		</div>
	</div>
</body>
</html>