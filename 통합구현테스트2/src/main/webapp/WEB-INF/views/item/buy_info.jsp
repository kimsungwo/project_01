<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.layer{
	background-color: #f8f9fa;
	border: 1px solid #f8f9fa;
	border-radius: 10px;
	margin: 5px;
	margin-top: 0px;
	padding: 10px;
}
</style>
<script src="/resources/js/item/buy_info.js?ver=02" type="text/javascript"></script>
</head>
<body>
구매정보확인페이지<br>
<br>	
<%-- 상품명: ${buyViewVO.itemName}<br>
카테고리:${buyViewVO.categoryName}<br>
가격:${buyViewVO.itemPrice}<br>
수량:${buyViewVO.buyQuantity}<br>
총가격:${buyViewVO.totalPrice}<br>
아이디 : ${memberInfo.id} <br>
구매자명 : ${memberInfo.name}<br>
연락처 : ${memberInfo.tel}<br>
주소 :${memberInfo.addr} <br>
주소2:  ${memberInfo.addrDetail} <br> --%>
<div>

	<div class="row justify-content-center">
		<div class="col-8">
			<div class="row">
				<div class="col-12">
					<h2>Order Info</h2>
				</div>
			</div>
			<div class="row layer">
				<div class="col-5">도서 카테고리</div>
				<div class="col-7" >${buyViewVO.categoryName}</div>
				<div class="col-5">도서명</div>
				<div class="col-7" >${buyViewVO.itemName}</div>
				<div class="col-5">가격</div> 
				<div class="col-7" ><fmt:formatNumber value="${buyViewVO.itemPrice}" pattern="#,###"/> 원</div>
				<div class="col-5">수량</div>
				<div class="col-7" ><fmt:formatNumber value="${buyViewVO.buyQuantity}" pattern="#,###"/> 개</div>
				<div class="col-5">총가격</div>
				<div class="col-7" ><fmt:formatNumber value="${buyViewVO.totalPrice}" pattern="#,###"/> 원</div>
			</div>
			<div style="height: 30px;"> </div>
			<div class="row">
				<div class="col-12">
					<h2>Black Cow</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-5">구매자 ID</div>
				<div class="col-7">${memberInfo.id}</div>
				<div class="col-5">구매자명</div>
				<div class="col-7">${memberInfo.name}</div>
				<div class="col-5">연락처</div>
				<div class="col-7">${memberInfo.tel}</div>
				<div class="col-5">배송지</div>
				<div class="col-7">${memberInfo.addr} ${memberInfo.addrDetail}</div>
			</div>
			<div class="row">
				<div class="col-12 text-center">
					<form action="/buy/insertBuy" method="post" id="buyPage">
					<input type="hidden" name="itemCode" value="${buyViewVO.itemCode}">
					<input type="hidden" name="buyQuantity" value="${buyViewVO.buyQuantity}">
					<input type="button" class="btn btn-primary" value="구 매" onclick="goPage('${sessionScope.loginInfo.id}');">
						</form>
				</div>
			</div>
		</div>
	</div>

</div>
</body>
</html>	















		