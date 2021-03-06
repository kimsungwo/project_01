<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/owner/order_confirm.js?ver=89" type="text/javascript"></script>
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
.buyRequestsModal, .memTelModal, .orderMessage{
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
#reserveList td:first-of-type{
	color: #848484;
	font-size: 1rem;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col">
				<h1>주문확인</h1>
				<table class="table table-bordered">
					<colgroup>
						<col width="30%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th scope="col">매장명</th>
							<td>
								<input type="hidden" value="${buyVO.cafeCode }" id="searchCafeCode">
								<select class="form-control form-control-sm" id="selectCafeList">
									<c:forEach items="${selectCafeList }" var="cafeListInfo">
										<option value="${cafeListInfo.cafeCode }">${cafeListInfo.cafeName }</option>
									</c:forEach>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="row justify-content-center">
					<div class="col text-center">
						<input type="date" class="form-control" value="${buyVO.preDate }" id="preDate">
						<span id="dateMargin">~</span>
						<input type="date" class="form-control" value="${buyVO.nowDate }" id="nowDate">
						<button type="button" class="btn btn-dark btn-sm" id="searchDateBtn" onclick="searchDateBtn();">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
								<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
							</svg>
						</button>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col text-center">
						<table class="table reserveTable">
							<colgroup>
								<col width="25%">
								<col width="*">
								<col width="12%">
								<col width="12%">
								<col width="12%">
								<col width="12%">
							</colgroup>
							<thead>
								<tr>
									<th>주문일자</th>								
									<th>주문정보</th>								
									<th>총 가격</th>								
									<th>주문승인</th>								
									<th>주문취소</th>								
									<th>주문상태</th>								
								</tr>
							</thead>
							<tbody id="reserveList">
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 구매 상세정보 Modal -->
	<div class="modal fade" id="orderDetail" tabindex="-1" aria-labelledby="orderDetailLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="orderDetailLabel"></h4>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div><h5 class="cafeNameModal"></h5></div><hr>
					<div class="buyDate">주문시간<span class="buyDateModal"></span></div><hr>
					<div class="buyDetails">
						<span class="detailTitle">주문내역</span>
						<div class="row justify-content-center buyMenuDetail">
						</div>
					</div><hr>
					<div class="allPriceDiv"><span class="detailTitle">총 가격</span><span class="allPrice"></span></div><hr>
					<div><span class="detailTitle">포인트사용</span><span class="usedPoint"></span></div><hr>
					<div><span class="detailTitle">결제금액</span><span class="totalPriceModal"></span></div><hr>
					<div><span class="detailTitle">요청사항</span><span class="buyRequestsModal"></span></div><hr>
					<div><span class="detailTitle">주문메시지</span><span class="orderMessage"></span></div><hr>
					<div>
						<span class="detailTitle">주문자 정보</span>
						<div><span class="subDetailTitle">연락처</span><span class="memTelModal">123</span></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 주문 승인 Modal -->
	<div class="modal fade" id="orderApr" tabindex="-1" aria-labelledby="orderAprLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="orderAprLabel">주문 승인</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<textarea rows="3" cols="" class="form-control" placeholder="메뉴 준비 예상 시간을 적어주세요" id="orderAprMessage"></textarea>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary btn-block orderAprModal">주문 승인</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 주문 취소 Modal -->
	<div class="modal fade" id="orderCancel" tabindex="-1" aria-labelledby="orderCancelLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="orderCancelLabel">주문 취소</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<textarea rows="3" cols="" class="form-control" placeholder="주문 취소 사유를 적어주세요" id="orderCancelMessage"></textarea>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger btn-block orderCancelModal" >주문 취소</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>