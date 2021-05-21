<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/buy/buy_confirm.js?ver=15" type="text/javascript"></script>
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
</style>
</head>
<body>
<div class="container">
	<div class="row justify-content-center">
		<div class="col-8">
			<h1>주문하기
				<input type="button" value="뒤로가기" class="btn btn-secondary btn-sm backBtn" onclick="history.back();">
			</h1><hr>
			<div class="row justify-content-center">
				주문 내역
			</div><hr>
			<div class="row justify-content-center">
				<div class="col">
					<c:forEach items="${cartList }" var="cartInfo" varStatus="status">
						<c:if test="${cartList[status.index - 1].menuName ne cartList[status.index].menuName }">
							<div class="menuDiv">
								${cartInfo.menuName } x ${cartInfo.buyQuantity }
								<span class="cartPriceSpan">
									<span class="cartPrice">${cartInfo.cartPrice }</span>원
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
					<span class="pointSpan"><span id="point">${memberInfo.memPoint }</span>원 보유</span>
				</div>
				<div class="col-4 text-right">
					결제 금액 : <span class="buyPrice"></span>원
					<input type="hidden" class="hiddenBP">
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>