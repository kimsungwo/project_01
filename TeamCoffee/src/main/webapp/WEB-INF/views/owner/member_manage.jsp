<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script src="/resources/js/owner/member_manage.js?ver=05" type="text/javascript"></script> -->
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
</style>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col">
				<h1>멤버 확인</h1>
				<form action="/owner/memberManageResult" method="get">
				<table class="table table-bordered">
					<colgroup>
						<col width="30%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th scope="col">매장주, 회원목록관리</th>
							<td>
								<select class="form-control form-control-sm" id="selectManageList" name="memCode">
									<option value="owner">매장주</option>
									<option value="member">일반회원</option>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="row justify-content-center">
					<div class="col text-center">
						<input type="date" class="form-control" name="preDate" value="${ownerManageViewVO.preDate}" id="preDate">
						<span id="dateMargin">~</span>
						<input type="date" class="form-control" name="nowDate" value="${ownerManageViewVO.nowDate}" id="nowDate">
						<input type="submit" value="검색" class="btn btn-primary btn-sm" id="searchDateBtn">
					</div>
				</div>
				</form>
				<div class="row justify-content-center">
					<div class="col text-center">
						<table class="table reserveTable">
							<colgroup>
								<col width="25%">
								<col width="*">
								<col width="18%">
								<col width="18%">
								<col width="18%">
							</colgroup>
							<thead>
								<tr>
									<th>가입일자</th>								
									<th>아이디</th>								
									<th>닉네임</th>								
									<th>이메일</th>								
									<th>전화번호</th>								
								</tr>
							</thead>
							<tbody>
							<c:if test="${not empty ownerList}">
								<c:forEach items="${ownerList}" var="list">
								<tr>
									<td><fmt:formatDate value="${list.ownerRegDate}" pattern="yyyy-MM-dd"/> </td>
									<td>${list.ownerId}</td>
									<td>${list.ownerName}</td>
									<td>${list.ownerEmail}</td>
									<td>${list.ownerTel}</td>
								</tr>
								</c:forEach>
								</c:if>
							</tbody>
							<tbody>
							<c:if test="${not empty memberList }">
								<c:forEach items="${memberList}" var="list2">
								<tr>
									<td><fmt:parseDate value="${list2.memRegDate}"   pattern = "yyyy-MM-dd"/></td>
									<td>${list2.memId}</td>
									<td>${list2.memNickname}</td>
									<td>${list2.memEmail}</td>
									<td>${list2.memTel}</td>
								</tr>
								</c:forEach>
								</c:if>
							</tbody>
						</table> 
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>