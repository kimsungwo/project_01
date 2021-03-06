<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
<style type="text/css">
.card-text i {
	margin-right: 10px;
}

.card-text div {
	font-size: 17px;
}
.nav-link {
	color: black;
}

.tableClick {
	cursor: pointer;
}
.custom-control .optionPrice {
	display: inline-block;
	float: right;
	font-size: 0.8em;
}
h5:nth-of-type(n+2) {
	padding-top: 10px;
}
i{
	cursor: pointer;
}
.custom-control{
	margin: 5px 0px;
}
.buyStockForm i{
	margin-right: 0px;
}
#buyQuantity{
	width: 25%;
	text-align: center;
	margin: 0px 15px;
}
.menuOptionList span{
	font-size: 0.8em;
	margin-left: 10px;
}
.requiredOption{
	color: red;
}
.custom-control-label{
	font-size: 0.85em;
}
.totalPrice{
	text-align: right;
}
.tpSpan{
	float: right;
	color: red;
	font-size: 1.2em;
}
.menuList tr:first-of-type th, .menuList tr:first-of-type td{
	border-top: none;
}
.menuList tr th:first-of-type{
	text-align: center;
}
.menuList td{
	vertical-align: middle;
}
#buyWarning{
	font-size: 0.8rem;
	color: red;
}
a{
	color: #212529;
}
a:hover {
	color: #212529;
}
.menuInfo{
	color: #666666;
	font-size: 0.9rem;
}
.likeBtn{
	text-align: center;
	margin-top: 10px;
	border: 1px solid rgba(0,0,0,.125);
	padding: 0.5rem 1rem;
}
.bi-heart-fill {
	color: red;
}
</style>
<script src="/resources/js/cafe/cafe_info_and_menu.js?ver=2" type="text/javascript"></script>
</head>
<body>
<div class="container-sm">
	<div class="row">
		<div class="col-4">
			<div id="contentDiv">
				<div class="card" style="width: 18rem;">
				    <!-- cafeCode 데이터 -->
					<input type="hidden" value="${cafeInfo.cafeCode }" id="cafeCodeInfo">
					<!-- 카페정보 -->
					<img src="/resources/img/logo/${cafeInfo.cafeLogo }" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">${cafeInfo.cafeName }</h5>
						<div class="card-text">
							<div>
								<i class="bi bi-geo-alt"></i>${cafeInfo.cafeAddr } ${cafeInfo.cafeAddrDetail }
							</div>
							<div>
								<i class="bi bi-clock"></i>${cafeInfo.cafeHours }
							</div>
							<div>
								<i class="bi bi-telephone"></i>${cafeInfo.cafeTel }
							</div>
							<div class="likeBtn">
								<c:choose>
									<c:when test="${not empty sessionScope.memberLoginInfo }">
										<a href="#" onclick="like_func('${cafeInfo.cafeCode}', this);"><i class="like bi <c:choose><c:when test="${cafeInfo.likeCheck eq '1' }">bi-heart-fill</c:when><c:otherwise>bi-heart</c:otherwise></c:choose>"></i></a>
									</c:when>
									<c:when test="${not empty sessionScope.ownerLoginInfo }">
									</c:when>
									<c:otherwise>
										<a href="#" onclick="needLogin();" data-toggle="modal" data-target="#exampleModal"><i class="like bi bi-heart"></i></a>
									</c:otherwise>
								</c:choose>
								찜
								<span id="cafeLikeCnt">${likeCnt }</span>
							</div>
						</div>
					</div>
					<!-- <ul class="list-group list-group-flush">
						<li class="list-group-item">리뷰
							<ul class="list-group list-group-flush">
								<li class="list-group-item">맛있어요</li>
								<li class="list-group-item">분위기 좋아요</li>
							</ul>
						</li>
					</ul> -->
				</div>
			</div>
		</div>
		<div class="col-8">
			<div id="menuDiv">
				<!-- 메뉴바 -->
				<nav class="navbar navbar-light">
					<a class="navbar-brand">MENU</a>
					<div class="form-inline">
						<!-- 메뉴찾기 -->
						<input class="form-control mr-sm-2" type="search" placeholder="메뉴를 입력해주세요.." name="menuName" id="menuNameInfo" aria-label="Search">
						<button class="btn" type="button" onclick="searchMenu();"><i class="bi bi-search"></i></button>
						<!-- 장바구니 페이지 -->
						<c:if test="${not empty sessionScope.memberLoginInfo }">
							<a href="/cart/cartList"><i class="bi bi-bag"></i></a>
						</c:if>
					</div>
				</nav>
				<!-- 탭 -->
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item" role="presentation">
						<a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true" onclick="selectMenuTab();">전체</a>
					</li>
					<c:forEach items="${cafeCategoryList }" var="cafeCategory">
						<li class="nav-item" role="presentation">
							<a class="nav-link" id="profile-tab" data-toggle="tab" href="#home" role="tab" aria-controls="profile" aria-selected="false" onclick="selectMenuTab('${cafeCategory.menuCategoryCode}');">${cafeCategory.categoryName }</a>
						</li>
					</c:forEach>
				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<!-- 탭내용 -->
						<table class="table">
							<colgroup>
								<col width="20%">
								<col width="*">
								<col width="20%">
							</colgroup>
							<tbody class="menuList">
								<c:choose>
									<c:when test="${cafeMenuList.size() eq 0 }">
										<tr>
											<td colspan="3" class="text-center">등록된 메뉴가 없습니다.</td>
										</tr>
									</c:when>
									<c:otherwise>
											<c:forEach items="${cafeMenuList }" var="cafeMenu">
												<tr class="tableClick" data-toggle="modal" data-target="#menuInfoModal" onclick="menuInfoModal('${cafeMenu.menuCode}')">
													<th scope="row"><img src="/resources/img/menu/${cafeMenu.menuImgName }" width="70px"></th>
													<td>
														<h5>${cafeMenu.menuName }</h5>
														<h6 class="menuInfo">${cafeMenu.menuInfo }</h6>
														<fmt:formatNumber value="${cafeMenu.menuPrice }" type="number"></fmt:formatNumber>원
													</td>
													<td>${cafeMenu.status }</td>
												</tr>
											</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
					</div>
					<div class="tab-pane fade" id="profile" role="tabpanel"
						aria-labelledby="profile-tab"></div>
				</div>
			</div>
		</div>
	</div>
</div>	

<!-- 메뉴모달 -->
<div class="modal fade" id="menuInfoModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<form action="" method="post" id="buyConfirmForm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<!-- 메뉴정보 -->
				<div class="row">
					<div class="col-6 text-center">
						<img alt="" src="" width="150px" id="menuImgName">
					</div>
					<div class="col-6 ">
						<h5 id="menuName"></h5>
						<h6 id="menuInfo" class="menuInfo"></h6>
						<span id="menuPrice"></span> 원
						<div class="form-inline buyStockForm">
							<i class="bi bi-dash-square-fill stockMinus"></i>
							<input type="text" class="form-control" value="1" id="buyQuantity" name="buyQuantity" readonly>
							<i class="bi bi-plus-square-fill stockPlus"></i>
						</div>
					</div>
				</div>
				<div class="menuOptionList">
				</div>
				<hr>
				<div class="totalPriceDiv">
					총 주문금액 : <span class="tpSpan"><span class="totalPrice"></span>원</span>
					<input type="hidden" name="totalPrice" id="hiddenTp">
					<input type="hidden" name="menuCode" id="menuCode">
					<input type="hidden" name="cafeCode" id="cafeCode">
				</div>
			</div>
			<div class="modal-footer">
				<c:choose>
					<c:when test="${empty sessionScope.memberLoginInfo }">
						<span id="buyWarning">비회원 및 매장주 회원은 일반회원으로 로그인하면 구매가 가능합니다</span>
					</c:when>
					<c:when test="${cafeInfo.cafeState eq 1 }">
						<span id="buyWarning">영업을 준비중입니다</span>
					</c:when>
					<c:when test="${cafeInfo.cafeState eq 2 }">
						<span id="buyWarning">오늘은 휴무일입니다</span>
					</c:when>
					<c:otherwise>
						<button type="button" class="btn btn-primary" id="insertCartBtn">장바구니 담기</button>
						<button type="button" class="btn btn-primary" id="buyFormBtn">바로 주문하기</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		</form>
	</div>
</div>
	
</body>
</html>