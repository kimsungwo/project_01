<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
<style type="text/css">
.search-cafe{
	display: inline-block;
	width: 50%;
	margin-bottom: 20px;
}
h5 {
	display: inline-block;
}

.title .btn-primary {
	float: right;
}
.state {
	font-size: 12px;
	border: 1px solid olive;
	color: white;
	background-color: olive;
	border-radius: 3px;
	padding: 0 2px;
}
.bi-star-fill {
	color: #FFD732;
}
.review {
	color: #8c8c8c;
}
a {
	color: black;
}
a:hover {
	color: black;
	text-decoration: none;
}
.likeBtn {
	float: right;
}
.bi-heart-fill {
	color: red;
}
</style>
<script src="/resources/js/cafe/select_chain.js?ver=35" type="text/javascript"></script>
</head>
<body>
<div class="row justify-content-center">
	<div class="col-8">
		<div class="row">
			<div class="col text-center">
				<form action="/cafe/selectChain" method="post">
					<input type="text" class="form-control search-cafe" placeholder="매장명을 입력해주세요..." name="cafeName">
					<input type="hidden" value="${chainInfo.chainCode }" name="chainCode">
					<button type="submit" class="btn btn-dark btn-sm">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
						<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
					</svg>
					</button>
				</form>
			</div>		
		</div>
	</div>
	
	<div class="row">
		<div class="col-6">	
			<div id="contentDiv">
				<div class="row">
					<div class="col-8">
						<c:choose>
							<c:when test="${empty chainInfo.chainName}">
								<h2>전체보기</h2>
							</c:when>
							<c:otherwise>
								<h2>${chainInfo.chainName }</h2>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="col-4">
						<select class="form-control form-control-sm" name="order" id="selectOrder">
							<option value="CAFE_REG_DATE" <c:if test="${cafeVO.order eq 'CAFE_REG_DATE' }">selected</c:if>>선택안함</option>
  							<option value="CAFE_NAME" <c:if test="${cafeVO.order eq 'CAFE_NAME' }">selected</c:if>>이름순</option>
  							<option value="CAFE_REVIEW_CNT" <c:if test="${cafeVO.order eq 'CAFE_REVIEW_CNT' }">selected</c:if>>리뷰순</option>
  							<option value="CAFE_STAR" <c:if test="${cafeVO.order eq 'CAFE_STAR' }">selected</c:if>>별점순</option>
						</select>
					</div>
				</div>
				<table class="table">
					<colgroup>
						<col width="30%">
						<col width="*">
					</colgroup>
					<tbody>
						<c:forEach items="${cafeOfChainList }" var="cafeInfo">
							<input type="hidden" value="${cafeInfo.chainCode }" class="chainCode">
							<tr>
								<td>
									<a href="#" onclick="cafeClick('${cafeInfo.cafeCode}');"><img alt="" src="/resources/img/logo/${cafeInfo.cafeLogo }" width="100px"></a>
								</td>
								<td>
									<div class="content" >
										<div class="title">
											<h5><a href="#" onclick="cafeClick('${cafeInfo.cafeCode}');">${cafeInfo.cafeName }</a></h5>
											<button type="button" class="btn btn-primary btn-sm" onclick="selectMapInfo('${cafeInfo.cafeCode}');">위치보기</button>
										</div>
										<div class="starInfo">
											<i class="bi bi-star-fill"></i> ${cafeInfo.cafeStar }/5.0 
											<span class="review">리뷰 ${cafeInfo.cafeReviewCnt }</span>
										</div>
										<div class="addInfo">
											${cafeInfo.cafeAddr } ${cafeInfo.cafeAddrDetail }
										</div>
										<div class="telMapInfo">
											${cafeInfo.cafeTel }
											<c:choose>
												<c:when test="${cafeInfo.cafeState eq '0' }">
													<span class="state">준비중</span>	
												</c:when>
												<c:when test="${cafeInfo.cafeState eq '1' }">
													<span class="state">영업중</span>	
												</c:when>
											</c:choose>
											
											<div class="likeBtn">
												<c:choose>
													<c:when test="${not empty sessionScope.ownerLoginInfo or not empty sessionScope.memberLoginInfo }">
														<a href="#" onclick="like_func('${cafeInfo.cafeCode}', this);"><i class="like bi <c:choose><c:when test="${cafeInfo.likeCheck eq '1' }">bi-heart-fill</c:when><c:otherwise>bi-heart</c:otherwise></c:choose>"></i></a>
													</c:when>
													<c:otherwise>
														<a href="#" onclick="needLogin();"><i class="like bi bi-heart"></i></a>
													</c:otherwise>
												</c:choose>
											</div>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-6 mapInfo">
			<div id="map" style="width:600px;height:500px;"></div>
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3e4301ac7e87ca3c730fd7d8a7002d1b&libraries=services"></script> 
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3e4301ac7e87ca3c730fd7d8a7002d1b"></script> 
			<script type="text/javascript"> 
				var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스 
				var options = { //지도를 생성할 때 필요한 기본 옵션 
						center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표. 
						level: 3 //지도의 레벨(확대, 축소 정도) 
				}; 
				// 지도를 생성합니다 
				var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴 
				// 주소-좌표 변환 객체를 생성합니다 
				var geocoder = new kakao.maps.services.Geocoder(); 
				// 주소로 좌표를 검색합니다 
				geocoder.addressSearch('울산광역시 남구 삼산로35번길 19', function (result, status) { 
					// 정상적으로 검색이 완료됐으면 
					if (status === kakao.maps.services.Status.OK) {
						var coords = new kakao.maps.LatLng(result[0].y, result[0].x); 
						// 결과값으로 받은 위치를 마커로 표시합니다
						var marker = new kakao.maps.Marker({ 
							map: map, 
							position: coords }); 
						// 인포윈도우로 장소에 대한 설명을 표시합니다 
						/* var infowindow = new kakao.maps.InfoWindow({ 
							content: '<div style="width:150px;text-align:center;padding:6px 0;"><div>마커를 클릭하시면</div><div>메뉴정보를</div><div>보실 수 있어요</div></div>'

							}); 
						infowindow.open(map, marker); */
						// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다 
						map.setCenter(coords);
						} 
					});
				
				</script>
		</div>
	</div>		
</div>
</body>
</html>