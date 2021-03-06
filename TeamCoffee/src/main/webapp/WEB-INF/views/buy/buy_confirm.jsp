<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/buy/buy_confirm.js?ver=60" type="text/javascript"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<style type="text/css">
.backBtn{
	float: right;
}
.options{
	color: gray;
	font-size: 0.8em;
}
.optionList{
	font-size: 0.8em;
	color: gray;
}
.menuDiv:nth-of-type(n+2){
	padding-top: 20px;
	margin-top: 20px;
	border-top: 1px solid #E6E6E6;
}
.cartPriceSpan{
	font-size: 1.2em;
	float: right;
}
.cartPriceSpan .btn-sm{
	padding: 1px 2px;
}
.totalPrice, .buyPrice{
	font-size: 1.2em;
	color: red;
}
input[id=memPoint]{
	display: inline-block;
	width: 100px;
	margin-left: 20px;
}
input[id=pointBtn]{
	width: 50px;
}
.pointSpan{
	margin-left: 15px;
	font-size: 0.9em;
	color: red;
}
.orderContainer{
	padding: 20px 0px;
	margin-bottom: 50px;
	border-top: 1px solid #E6E6E6;
	border-bottom: 1px solid #E6E6E6;
}
input[id=memTel]{
	display: inline-block;
	width: 40%;
	margin-left: 20px;
}
input[id=buyRequests]{
	display: inline-block;
	width: 80%;
	margin-left: 20px;
}
.orderDiv{
	margin: 10px 0px;
}
</style>
</head>
<body>
<div class="container">
	<div class="row justify-content-center">
		<div class="col-8">
			<h1>주문하기
				<input type="button" value="뒤로가기" class="btn btn-secondary btn-sm backBtn" onclick="history.back();">
			</h1>
			<div class="orderContainer">
				<div class="row justify-content-center">
					<h4>주문 내역</h4>
					<input type="hidden" value="${cartList[0].menuName }" id="buyMenu">
					<input type="hidden" value="${cartSize - 1}" id="buyListSize">
				</div><hr>
				<div class="row justify-content-center">
					<div class="col text-left">
						<h5>매장명 : ${cartList[0].cafeName }</h5>
					</div>
				</div><hr>
				<div class="row justify-content-center">
					<div class="col">
						<c:forEach items="${cartList }" var="cartInfo" varStatus="status">
							<c:if test="${cartList[status.index - 1].cartCode ne cartList[status.index].cartCode }">
								<div class="menuDiv">
									${cartInfo.menuName } x ${cartInfo.buyQuantity }
									<span class="cartPriceSpan">
										<span class="cartPrice"><fmt:formatNumber value="${cartInfo.cartPrice }" type="number"></fmt:formatNumber></span>원
									</span>
								</div>
							</c:if>
							<span class="optionList">
								${cartInfo.menuOptionName }<c:if test="${cartList[status.index].cartCode eq cartList[status.index + 1].cartCode }">,&nbsp;</c:if>
							</span>
						</c:forEach>
					</div>
				</div><hr>
				<div class="row justify-content-end">
					<div class="col-4 text-right">합계 : <span class="totalPrice"></span> 원</div>
				</div><hr>
				<div class="row justify-content-center">
					<div class="col-8">
						포인트 사용
						<input type="text" value="0" class="form-control" id="memPoint">
						<input type="text" value="사용" class="btn btn-primary btn-sm" id="pointBtn">
						<input type="hidden" id="usePoint">
						<span class="pointSpan"><span id="point">${memberInfo.memPoint }</span>원 보유 / <span id="usePointSpan">0</span>원 사용</span>
					</div>
					<div class="col-4 text-right">
						결제 금액 : <span class="buyPrice"></span>원
						<input type="hidden" class="hiddenBP">
					</div>
				</div>
			</div>
			<div class="orderContainer">
				<div class="row justify-content-center">
					<h4>주문자 정보</h4>
					<input type="hidden" value="${memberInfo.memEmail }" id="memEmail">
					<input type="hidden" value="${memberInfo.memNickname }" id="memNickname">
					<input type="hidden" value="${memberInfo.memAddr}" id="memAddr">
					<input type="hidden" value="${memberInfo.memAddrDetail}" id="memAddrDetail">
				</div><hr>
				<div class="row justify-content-center orderDiv">
					<div class="col-2 text-right">
						휴대폰 번호
					</div>
					<div class="col">
						<input type="text" class="form-control" value="${memberInfo.memTel }" id="memTel">
					</div>
				</div>
				<div class="row justify-content-center orderDiv">
					<div class="col-2 text-right">
						요청사항
					</div>
					<div class="col">
						<input type="text" class="form-control" id="buyRequests" placeholder="요청사항을 입력해주세요">
					</div>
				</div>
			</div>
			<div class="row justify-content-center">
			    <button id="ccc" type="button" class="btn btn-primary btn-block" onclick="insertBuyList();" data-cafeCode="${cartList[0].cafeCode }">결제하기</button>
			</div>
		</div>
	</div>
</div>
</body>
</html>