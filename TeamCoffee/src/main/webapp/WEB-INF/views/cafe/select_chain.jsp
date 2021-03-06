
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
.state_0 {
	font-size: 12px;
	border: 1px solid #25C72A;
	color: white;
	background-color: #25C72A;
	border-radius: 3px;
	padding: 0 2px;
}
.state_1 {
	font-size: 12px;
	border: 1px solid olive;
	color: white;
	background-color: olive;
	border-radius: 3px;
	padding: 0 2px;
}
.state_2 {
	font-size: 12px;
	border: 1px solid red;
	color: white;
	background-color: red;
	border-radius: 3px;
	padding: 0 2px;
}
.yellow-star {
	color: #FFD732;
}
.gray-star {
	color: #8c8c8c;
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
.subDetailTitle{
	float: right;
	font-size: 0.85rem;
}
.distance {
	color: blue;
}
.cafeListDiv{
	height: 500px;
	overflow-y: auto;
}
#reviewViewModal .modal-body{
	padding-top: 32px;
	padding-bottom: 32px;
}
.reviewDiv:not(:last-of-type){
	border-bottom: 1px solid #D8D8D8 ;
	padding-bottom: 20px;
	margin-bottom: 20px;
}
<<<<<<< .mine
.mapInfo {
	margin-top: 50px;
}

/* 카페정보 인포창 */
.wrap {position: absolute;left: 0;bottom: 40px;width: 288px;height: 132px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
.wrap * {padding: 0;margin: 0;}
.wrap .info {width: 286px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
.wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
.info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
.info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
.info .close:hover {cursor: pointer;}
.info .body {position: relative;overflow: hidden;}
.info .desc {position: relative;margin: 13px 0 0 90px;height: 75px;}
.desc .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
.desc .jibun {font-size: 11px;color: #888;margin-top: -2px;}
.info .img {position: absolute;top: 6px;left: 5px;width: 63px;height: 60px;border: 1px solid #ddd;color: #888;overflow: hidden;}
.info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
.info .link {color: #5085BB;}
||||||| .r384
=======
table h5{
	font-size: 1.15rem;
}
.cafeInfo div {
	font-size: 1rem;	
}
>>>>>>> .r398
</style>
<script src="/resources/js/cafe/select_chain.js?ver=98" type="text/javascript"></script>
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
						<input type="hidden" value="${chainInfo.chainCode }" id="chainCode">
						<select class="form-control form-control-sm" name="order" id="selectOrder">
							<option value="CAFE_REG_DATE" <c:if test="${cafeVO.order eq 'CAFE_REG_DATE' }">selected</c:if>>선택안함</option>
  							<option value="CAFE_NAME" <c:if test="${cafeVO.order eq 'CAFE_NAME' }">selected</c:if>>이름순</option>
  							<option value="CAFE_REVIEW_CNT" <c:if test="${cafeVO.order eq 'CAFE_REVIEW_CNT' }">selected</c:if>>리뷰순</option>
  							<option value="CAFE_STAR" <c:if test="${cafeVO.order eq 'CAFE_STAR' }">selected</c:if>>별점순</option>
						</select>
					</div>
				</div>
				<div class="cafeListDiv mCustomScrollbar" data-mcs-theme="dark-3">
					<table class="table">
						<colgroup>
							<col width="30%">
							<col width="*">
						</colgroup>
						<tbody>
						<c:choose>
							<c:when test="${cafeOfChainList.size() eq 0 }">
								등록된 카페가 없습니다
							</c:when>
							<c:otherwise>
								<c:forEach items="${cafeOfChainList }" var="cafeInfo">
								<tr>
									<td>
										<a href="#" onclick="cafeClick('${cafeInfo.cafeCode}');"><img alt="" src="/resources/img/logo/${cafeInfo.cafeLogo }" width="100px"></a>
									</td>
									<td>
										<div class="cafeInfo">
											<div class="title">
												<h5>
												<a href="/cafe/cafeInfoAndMenu?cafeCode=${cafeInfo.cafeCode }">${cafeInfo.cafeName }</a>
												<c:choose>
													<c:when test="${cafeInfo.cafeState eq '0' }">
														<span class="state_0">영업중</span>	
													</c:when>
													<c:when test="${cafeInfo.cafeState eq '1' }">
														<span class="state_1">준비중</span>	
													</c:when>
													<c:when test="${cafeInfo.cafeState eq '2' }">
														<span class="state_2">휴업중</span>	
													</c:when>
												</c:choose>
												</h5>
 												<button type="button" class="btn btn-primary btn-sm" onclick="selectMapInfo('${cafeInfo.cafeCode}');">위치보기</button>
											</div>
											<div class="starInfo">
												<i class="bi bi-star-fill yellow-star"></i> ${cafeInfo.cafeStar }/5.0 
												<a href="#" data-toggle="modal" data-target="#reviewViewModal" onclick="selectReview('${cafeInfo.cafeCode}')"><span class="review">리뷰 ${cafeInfo.cafeReviewCnt }</span></a>
											</div>
											<div class="addInfo">
												<span class="distance">${cafeInfo.distance }</span>
												<span class="cafeAddr">${cafeInfo.cafeAddr }</span> ${cafeInfo.cafeAddrDetail }
											</div>
											<div class="telMapInfo">
											    ${cafeInfo.cafeTel }
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
												</div>
											</div>
										</div>
									</td>
								</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<!-- 지도정보 -->
		<div class="col-6 mapInfo">
			<div id="map" style="width:600px;height:500px;"></div>
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3e4301ac7e87ca3c730fd7d8a7002d1b&libraries=services"></script> 
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3e4301ac7e87ca3c730fd7d8a7002d1b"></script> 
			<script type="text/javascript">
				var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스 
				var options = { //지도를 생성할 때 필요한 기본 옵션 
						center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표. 
						level: 2 //지도의 레벨(확대, 축소 정도) 
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
						// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다 
						map.setCenter(coords);
					} 
				});
				
				var list = new Array();
				
				$('.cafeAddr').each(function(index, element){
					list.push($(element).text());
				});
				
				for (var i = 0; i < list.length; i++) {
					var position = "'" + list[i] + "'";
					var geocoder = new kakao.maps.services.Geocoder(); 
					geocoder.addressSearch(position, function (result, status) { 
						if (status === kakao.maps.services.Status.OK) {
							console.log(list.length);
							var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
							
							var marker = new kakao.maps.Marker({ 
								map: map, 
								position: coords });
							
							var id = 'wrap_' + result[0].y.replace('.', '') + '_' + result[0].x.replace('.', '');
							
							var content = '<div id="' + id + '" class="wrap"></div>';
							
							// 마커 위에 커스텀오버레이를 표시합니다
							// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
							var overlay = new kakao.maps.CustomOverlay({
							    content: content,
							    position: marker.getPosition()       
							});
							// 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
							kakao.maps.event.addListener(marker, 'click', function() {
								BBB(result[0].y, result[0].x);
							    overlay.setMap(map);
							    map.setCenter(coords);
							});
			
							// 커스텀 오버레이를 닫기 위해 호출되는 함수입니다 
							kakao.maps.event.addListener(map, 'click', function() {
							    overlay.setMap(null);
							});
							
						}	
						
					});
				}
				
			</script>
		</div>
	</div>		
</div>

<!-- 리뷰창 모달 -->
<div class="modal fade" id="reviewViewModal" tabindex="-1" aria-labelledby="reviewModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="reviewModalLabel">리뷰목록</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body" id="reviewModalBody">
				리뷰목록들
			</div>
		</div>
	</div>
</div>
</body>

<script>
    (function($){
        $(window).on("load",function(){
            $(".content").mCustomScrollbar();
        });
    })(jQuery);
</script>

</html>