<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/member/buy_list.js?ver=145" type="text/javascript"></script>
<style type="text/css">
#noticeDiv {
	text-align:center;
}
.bi {
	font-size: 100px;
}
.cafeLogoImg{
	width: 80px;
}
.buyDate{
	color: #585858;
	font-size: 0.85rem;
}
td[class=buyDate]{
	padding: 6px;
	border-top: 10px solid #E6E6E6;
}
.buyStatus{
	color: red;
	float: right;
	font-weight: bold;
}
.menuName{
	color: #585858;
	font-size: 0.9rem;
	padding: 2px 0px;
}
.btn-light{
	border: 1px solid #BDBDBD;
}
a{
	color: #212529;
}
a:hover{
	color: #212529;
	text-decoration: none;
}
#buyDetailLabel{
	font-weight: bold;
}
.progress{
	margin: 6px 0px;
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
#reviewDiv {
	text-align: center;
}
.starR{
	font-size:30px;
	color:#8c8c8c;
	cursor: pointer;
}
.starR.on{
	color:#FFD732;
}
#regReviewBtn {
	text-align: center;
	margin-top: 30px;
}
</style>
</head>
<body>
	<div class="container">
	<c:choose>
		<c:when test="${empty buyList }">
			<div id="noticeDiv">
				<i class="bi bi-exclamation"></i>
				<h1>주문 내역이 없습니다.</h1>
			</div>
		</c:when>
		<c:otherwise>
			<div class="row justify-content-center">
				<div class="col">
				<h1>주문내역</h1>
					<table class="table">
						<colgroup>
							<col width="15%">
							<col width="*%">
						</colgroup>
					<c:forEach items="${buyList }" var="buyInfo" varStatus="status">
						<c:if test="${buyList[status.index -1].buyCode ne buyList[status.index].buyCode }">
							<tr>
								<td colspan="2" class="buyDate">${buyInfo.buyDate }<span class="buyStatus">${buyInfo.buyStatusName }</span></td>
							</tr>
							<tr>
								<td class="text-center"><a href="/cafe/cafeInfoAndMenu?menuCategoryCode=&cafeCode=${buyInfo.cafeCode }"><img src="/resources/img/logo/${buyInfo.cafeLogo }" class="cafeLogoImg"></a></td>
								<td>
									<div class="cafeName"><a href="/cafe/cafeInfoAndMenu?menuCategoryCode=&cafeCode=${buyInfo.cafeCode }">${buyInfo.cafeName }</a></div>
									<div class="menuName" data-buyCode="${buyInfo.buyCode }"></div>
									<div>
										<input type="button" class="btn btn-light btn-sm" value="주문상세" data-toggle="modal" data-target="#buyDetail" onclick="selectBuyDetail('${buyInfo.buyCode}');">
										<c:if test="${buyInfo.isReviewed eq 0 and buyInfo.buyStatus eq 3}">
											<input type="button" class="btn btn-light btn-sm" value="리뷰쓰기" data-toggle="modal" data-target="#reviewModal" onclick="regReviewForm('${buyInfo.buyCode}')">
										</c:if>
										<c:if test="${buyInfo.isReviewed eq 1 and buyInfo.buyStatus eq 3}">
											<input type="button" class="btn btn-light btn-sm completeReview" value="리뷰완료">
										</c:if>
									</div>
									<div class="progress">
										<div class="progress-bar progress-bar-striped buyStatusBar" role="progressbar" style="width: 0%" data-buyStatus="${buyInfo.buyStatus }"></div>
									</div>
								</td>
							</tr>
						</c:if>
					</c:forEach>
					</table>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	</div>
	
<!-- 구매 상세정보 Modal -->
<div class="modal fade" id="buyDetail" tabindex="-1" aria-labelledby="buyDetailLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="buyDetailLabel"></h4>
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

<!-- 리뷰작성 Modal -->
<div class="modal fade" id="reviewModal" tabindex="-1" aria-labelledby="reviewFormLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="reviewFormLabel">리뷰작성</h4>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="/review/insertReview" method="post" enctype="multipart/form-data" id="insertReviewForm">
					<div id=reviewDiv>
						<div id="reviewTitleDiv"></div>
						<div class="starRev">
							<span class="starR">★</span>
						  	<span class="starR">★</span>
						  	<span class="starR">★</span>
						  	<span class="starR">★</span>
						  	<span class="starR">★</span>
						</div>
						<div class="starCnt"></div>
					</div>
					<div id="reviewContent">
						<div class="mb-3">
							<textarea class="form-control" id="validationTextarea" placeholder="카페에 대한 솔직한 리뷰를 남겨주세요." required name="reviewContent"></textarea>
						</div>
					</div>
					<div class="regReviewImg">
						<button type="button" class="btn btn-outline-dark btn-sm" id="regImg">이미지등록</button>
					</div>
					<div id="regReviewBtn">
						<input type="submit" class="btn btn-light btn-sm" value="리뷰등록" onclick="insertReview();">
					</div>
				</form>
			</div>
		</div>
	</div>
</div>


</body>
</html>