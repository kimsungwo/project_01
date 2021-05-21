<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
.yellow-star {
	color: #FFD732;
}
.gray-star {
	color: #8c8c8c;
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
.detailTitle{
	font-size: 0.95rem;
}
#regImg {
	margin-top: 20px;
}
.reviewTable td{
	border-bottom: 10px solid #dee2e6;
	border-top: 10px solid #dee2e6;
}
</style>
<script type="text/javascript" src="/resources/js/member/review_list.js?ver=25"></script>
</head>
<body>
<div class="container">
	<c:choose>
		<c:when test="${reviewList.size() eq 0 }">
			<div id="noticeDiv">
				<i class="bi bi-exclamation"></i>
				<h1>등록된 리뷰가 없습니다.</h1>
			</div>
		</c:when>
		<c:otherwise>
			<h1>리뷰목록</h1>
				<table class="table reviewTable">
					<colgroup>
						<col width="15%">
						<col width="*%">
						<col width="30%">
					</colgroup>
					<c:forEach items="${reviewList }" var="reviewInfo" varStatus="status">
						<c:if test="${reviewList[status.index -1].buyCode ne reviewList[status.index].buyCode }">
							<tr>
								<td><a href="/cafe/cafeInfoAndMenu?&cafeCode=${reviewInfo.cafeCode }"><img src="/resources/img/logo/${reviewInfo.cafeLogo }" class="cafeLogoImg"></a></td>
								<td>
									<div class="cafeName"><a href="/cafe/cafeInfoAndMenu?&cafeCode=${reviewInfo.cafeCode }">${reviewInfo.cafeName }</a></div>
									<div class="menuName" data-buyCode="${reviewInfo.buyCode }"></div>
									<div>
										<c:choose>
											<c:when test="${reviewInfo.reviewStar eq 1 }">
												<span class="yellow-star">★</span><span class="gray-star">★★★★</span>
											</c:when>
											<c:when test="${reviewInfo.reviewStar eq 2 }">
												<span class="yellow-star">★★</span><span class="gray-star">★★★</span>
											</c:when>
											<c:when test="${reviewInfo.reviewStar eq 3 }">
												<span class="yellow-star">★★★</span><span class="gray-star">★★</span>
											</c:when>
											<c:when test="${reviewInfo.reviewStar eq 4 }">
												<span class="yellow-star">★★★★</span><span class="gray-star">★</span>
											</c:when>
											<c:when test="${reviewInfo.reviewStar eq 5 }">
												<span class="yellow-star">★★★★★</span>
											</c:when>
										</c:choose>	
									</div>
									<div>
										${reviewInfo.reviewContent }
									</div>
									<div>
										<input type="button" class="btn btn-light btn-sm" value="리뷰수정" data-toggle="modal" data-target="#reviewModal" onclick="goUpdateReviewModal('${reviewInfo.reviewCode }');">
										<input type="button" class="btn btn-light btn-sm" value="리뷰삭제" onclick="goDeleteReview('${reviewInfo.reviewCode }', '${reviewInfo.buyCode }', '${reviewInfo.cafeCode }');">
									</div>
								</td>
								<td>
									<c:if test="${reviewInfo.reviewImg ne null }">
										<img alt="" src="/resources/img/review/${reviewInfo.reviewImg }" style="width:200px;">
									</c:if>
								</td>
							</tr>
						</c:if>	
					</c:forEach>
				</table>
			</c:otherwise>
	</c:choose>
</div>

<!-- 리뷰작성 Modal -->
<div class="modal fade" id="reviewModal" tabindex="-1" aria-labelledby="reviewFormLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="reviewFormLabel">리뷰수정</h4>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="/review/updateReview" method="post" enctype="multipart/form-data" id="updateReviewForm">
					<div id=reviewDiv>
						<div id="reviewTitleDiv"></div>
						<div class="starRev"></div>
						<div class="starCnt"></div>
					</div>
					<div id="reviewContent">
						<div class="mb-3">
							<textarea class="form-control" id="validationTextarea" placeholder="카페에 대한 솔직한 리뷰를 남겨주세요." required name="reviewContent"></textarea>
						</div>
					</div>
					<div class="regReviewImg">
						<div>
							<button type="button" class="btn btn-outline-dark btn-sm" id="regImg">이미지변경</button>
						</div>
					</div>
					<div id="regReviewBtn">
						<input type="submit" class="btn btn-light btn-sm" value="수정완료" onclick="location.href='/review/updateReview'">
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

</body>
</html>