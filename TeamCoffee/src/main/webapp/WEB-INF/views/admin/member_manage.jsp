<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/admin/member_manage.js?ver=57" type="text/javascript"></script>
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
	width: 70%;
	display: inline-block;
}
#searchDateBtn{
	margin-top:1rem;
	margin-right: 0rem;
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
				<h1>회원 관리</h1>
				<table class="table table-bordered">
					<colgroup>
						<col width="30%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th scope="col">회원 타입</th>
							<td>
								<select class="form-control form-control-sm" id="selectManageList" name="memCode">
									<option value="member" >일반회원</option>
									<option value="owner">매장주</option>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="row justify-content-center">
					<div class="col text-center">
						<input type="date" class="form-control searchBox" name="preDate" value="${adminViewVO.preDate}" id="preDate">
						<span id="dateMargin">~</span>
						<input type="date" class="form-control" name="nowDate" value="${adminViewVO.nowDate}" id="nowDate">
						<div class="row">
							<div class="col-6 offset-6">
								<input type="text" class="form-control"	value="${adminViewVO.searchText}" name="searchText" placeholder="검색하실 아이디를 입력해주세요." id="searchText">
								<button type="button" class="btn btn-dark btn-sm" id="searchDateBtn" onclick="searchMembers();">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
										<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
									</svg>
								</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col text-center">
						<table class="table reserveTable">
							<colgroup>
								<col width="40%">
								<col width="*">
							</colgroup>
							<thead>
								<tr>
									<th>가입일자</th>								
									<th>아이디</th>								
								</tr>
							</thead>
							<tbody id="memberManageTable">
							<%-- <c:if test="${not empty ownerList}">
								<c:forEach items="${ownerList}" var="list">
								<tr>
									<td><fmt:formatDate value="${list.ownerRegDate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
									<td>
									<!-- 온클릭에 자바스크립트 함수선언영역 명령어 써줘야됨 -->
									<a href="#" 
										 data-toggle="modal" 
									     data-target="#ownerDetail"
										 onclick="selectDetailOwnerInfo('${list.ownerCode}');">${list.ownerId}</a>
									</td>
								</tr>
								</c:forEach>
								</c:if>
							</tbody>
							<tbody>
							<c:if test="${not empty memberList }">
								<c:forEach items="${memberList}" var="list2">
								<tr>
									<td><fmt:formatDate value="${list2.memRegDate}"   pattern = "yyyy-MM-dd HH:mm:ss"/></td>
									<td>
									<!-- 온클릭에 자바스크립트 함수선언영역 명령어 써줘야됨 -->
									<a href="#"
										data-toggle="modal" 
										data-target="#memberDetail" 
										onclick="selectDetailMemberInfo('${list2.memCode}');" >${list2.memId}</a>
									</td>
								</tr>
								</c:forEach>
								</c:if> --%>
							</tbody>
						</table> 
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--매장주 상세정보 modal -->
	<div class="modal fade" id="ownerDetail" tabindex="-1" aria-labelledby="orderDetailLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">상세조회</h4>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div><h5>매장주</h5></div><hr>
					<div>
						아이디
						<span class="ownerId detailResult" ></span>
						</div><hr>
					<div>
						이름
						<span class="ownerName detailResult"></span>
						</div><hr>
					<div>
						전화번호
						<span class="ownerTel detailResult"></span>
						</div><hr>
					<div>
						e메일
						<span class="ownerEmail detailResult"></span>
						</div><hr>
					<div>
						주소
						<span class="ownerAddr detailResult"></span>
					</div><hr>
					<div>
						상세주소
						<span class="ownerAddrDetail detailResult"></span>
					</div><hr>
				</div>
			</div>
		</div>
	</div>
	<!--일반회원 상세정보 modal -->
	<div class="modal fade" id="memberDetail" tabindex="-1" aria-labelledby="orderDetailLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">상세조회</h4>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div><h5>일반회원</h5></div><hr>
					<div>
						아이디
						<span class="memId detailResult"></span>
						</div><hr>
					<div>
						가명
						<span class="memNickname detailResult"></span>
						</div><hr>
					<div>
						전화번호
						<span class="memTel detailResult"></span>
						</div><hr>
					<div>
						e메일
						<span class="memEmail detailResult"></span>
						</div><hr>
					<div>
						주소
						<span class="memAddr detailResult"></span>
						</div><hr>
					<div>
						상세주소
						<span class="memAddrDetail detailResult"></span>
						</div><hr>
					<div>
						멤버등급
						<span class="gradeName detailResult"></span>
					</div><hr>
					<div>
						멤버포인트
						<span class="memPoint detailResult"></span>
					</div><hr>
				</div>
			</div>
		</div>
	</div>
</body>
</html>