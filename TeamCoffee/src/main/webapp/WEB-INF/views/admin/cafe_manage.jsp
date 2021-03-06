<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/admin/cafe_manage.js?ver=18" type="text/javascript"></script>
<style type="text/css">
.table th{
	text-align: center;
}
.form-control[id=selectCafeList] {
	border: none;
}
.form-control[type=date]{
	width: 35%;
	display: inline-block;
	text-align: center;
	font-size: 1.2rem;
}
#dateMargin{
	margin: 0px 10px;
}
#searchDateBtn{
	padding: 8px 40px;
	float: right;
	margin-right: 30px;
}
.reserveTable{
	margin-top: 20px;
}
a{
	color: #212529;
}
a:hover{
	color: #212529;
	text-decoration: none;
}
.buyDate{
	color: #585858;
	font-size: 0.85rem;
}
#buyDetailLabel{
	font-weight: bold;
}
.buyDateModal{
	float: right;
}
.buyRequestsModal, .memTelModal{
	float: right;
	font-size: 0.9rem;
}
.totalPriceModal{
	float: right;
	color: red;
}
.detailTitle{
	font-size: 0.95rem;
}
.subDetailTitle{
	font-size: 0.85rem;
}
.buyMenuDetail{
	font-size: 0.9rem;
	padding: 0px 5px;
}
.buyMenuName{
	font-size: 0.85rem;
}
.menuOption{
	font-size: 0.8rem;
	color: #848484;
	padding-left: 7px;
}
.allPrice{
	float: right;
}
.usedPoint{
	float: right;
	color: #FAAC58;
}
textarea{
	resize: none;
}
#searchText{
	margin-top:1rem;
	width: 20rem;
	display: inline-block;
	margin-left: 11rem;
}
#searchDateBtn{
	margin-top:1rem;
}
.detailResult{
	float: right;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col">
				<h1>매장신청관리</h1>
				<div class="row justify-content-center">
					<div class="col text-center">
						<table class="table reserveTable">
							<colgroup>
								<col width="30%">
								<col width="*">
								<col width="15%">
							</colgroup>
							<thead>
								<tr>
									<th>신청일자</th>								
									<th>카페명</th>								
									<th>승인여부</th>								
								</tr>
							</thead>
							<tbody>
							<c:choose>
								<c:when test="${not empty cafeList}">
									<c:forEach items="${cafeList}" var="list">
										<tr>
											<td>${list.cafeRegDate}</td>
											<td>
											<!-- 온클릭에 자바스크립트 함수선언영역 명령어 써줘야됨 -->
											<a href="#" 
												 class="codeBtn" 
												 data-toggle="modal" 
											     data-target="#cafeDetail"
												 data-cafeCode="${list.cafeCode}" 
												 onclick="selectDetailCafeInfo('${list.cafeCode}');">${list.cafeName}</a>
											</td>
											<td>
												<button type="button" class="btn btn-primary btn-sm y-buttom" onclick="newCafe('${list.cafeCode}');">승인</button>
											</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="3"><h4>신청중인 매장이 없습니다</h4></td>
									</tr>
								</c:otherwise>
							</c:choose>
							</tbody>
						</table> 
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--매장주 상세정보 modal -->
	<div class="modal fade" id="cafeDetail" tabindex="-1" aria-labelledby="orderDetailLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">상세조회</h4>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div><h5>신청카페정보</h5>
					</div><hr>
					<div><span class="detailTitle">카페명</span><span class="cafeName detailResult" ></span></div><hr>
					<div><span class="detailTitle">카페시간</span><span class="cafeHours detailResult"></span></div><hr>
					<div><span class="detailTitle">카페전화번호</span><span class="cafeTel detailResult"></span></div><hr>
					<div><span class="detailTitle">카페주소</span><span class="cafeAddr detailResult"></span></div><hr>
					<div><span class="detailTitle">카페 상세주소</span><span class="cafeAddrDetail detailResult"></span></div><hr>
					<div><span class="detailTitle">카페정보</span><span class="cafeInfo detailResult"></span></div><hr>
					<div><span class="detailTitle">세스코 유무</span><span class="cafeCesco detailResult"></span></div><hr>
					<div><span class="detailTitle">체인점 명</span><span class="chainName detailResult"></span></div><hr>
					<div><span class="detailTitle">카페신청날짜</span><span class="cafeRegDate detailResult"></span></div><hr>
					<div><h5>매장주</h5></div><hr>
					<div><span class="detailTitle">아이디</span><span class="ownerId detailResult" ></span></div><hr>
					<div><span class="detailTitle">이름</span><span class="ownerName detailResult"></span></div><hr>
					<div><span class="detailTitle">전화번호</span><span class="ownerTel detailResult"></span></div><hr>
					<div><span class="detailTitle">e메일</span><span class="ownerEmail detailResult"></span></div><hr>
				</div>
			</div>
		</div>
	</div>
	
	
	
</body>
</html>