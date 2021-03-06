<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/cart/cart_list.js?ver=8" type="text/javascript"></script>
<style type="text/css">
.optionList{
	font-size: 0.8em;
	color: gray;
}
.backBtn{
	float: right;
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
.deleteCartBtn{
	margin-left: 10px;
}
.totalPrice{
	font-size: 1.2em;
	color: red;
}
.cartPriceSpan .btn-sm{
	padding: 1px 2px;
}
.menuDiv input[type=number]{
	margin-left: 20px;
	display: inline-block;
	width: 60px;
}
.deleteCartAll{
	float: right;
	margin-right: 15px;
	cursor: pointer;
}
</style>
</head>
<body>
<div class="container">
	<div class="row justify-content-center">
		<div class="col-8">
			<h1>
				장바구니
				<input type="button" value="뒤로가기" class="btn btn-secondary btn-sm backBtn" onclick="history.back();">
			</h1><hr>
			<c:choose>
				<c:when test="${not empty cartList }">
				<h4>
					${cartList[0].cafeName }
					<span class="deleteCartAll deleteCartBtn text-right">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
							<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
							<path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
						</svg>
					</span>
				</h4><hr>
				<c:forEach items="${cartList }" var="cartInfo" varStatus="status">
					<c:if test="${cartList[status.index - 1].cartCode ne cartList[status.index].cartCode }">
						<div class="menuDiv">
							${cartInfo.menuName }
							<span>
								<input type="number" value="${cartInfo.buyQuantity }" class="form-control buyQuantity" data-cartCode="${cartInfo.cartCode }">
							</span>
							<span class="cartPriceSpan">
								<span class="cartPrice"><fmt:formatNumber value="${cartInfo.cartPrice }" type="number"></fmt:formatNumber></span>원
								<button type="button" class="btn btn-light btn-sm deleteCartBtn" data-cartCode="${cartInfo.cartCode }">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
									<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
								</svg>
								</button>
							</span>
						</div>
					</c:if>
					<span class="optionList">
						${cartInfo.menuOptionName }<c:if test="${cartList[status.index].cartCode eq cartList[status.index + 1].cartCode }">,&nbsp;</c:if>
					</span>
				</c:forEach>
				<hr>
				<div class="row justify-content-end">
					<div class="col-4 text-right">합계 : <span class="totalPrice"></span> 원</div>
				</div><hr>
				<div class="row justify-content-end">
					<div class="col-4 text-right">
						<input type="button" value="주문하기" class="btn btn-primary" onclick="location.href='/buy/buyConfirm';">
					</div>
				</div>
				</c:when>
				<c:otherwise>
					<div class="row justify-content-center">
						선택된 메뉴가 없습니다
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
</body>
</html>