<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.table th{
	text-align: center;
}
.form-control {
	border: none;
}
#radioDiv {
	margin-left: 1rem;
}
#radioDiv .form-check-label {
	font-size: 14px;
}
label.is-invalid {
	color: red;
	font-size: 0.8rem;
}
</style>
<!-- 우편번호 검색 js -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- js -->
<script src="/resources/js/owner/reg_cafe.js?ver=45" type="text/javascript"></script>
<!-- validation -->
<script src="/resources/js/common/jquery.validate.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
	<h1>매장등록</h1>
	<p>매장을 등록 해 주세요.</p>
	<form action="/owner/insertCafe" method="post" id="regForm" enctype="multipart/form-data">
	<input type="hidden" id="Latitude" name="cafeLatitude">
	<input type="hidden" id="Longitude" name="cafeLongitude">
		<table class="table table-bordered">
			<colgroup>
				<col width="30%">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th scope="col">체인점</th>
					<td>
						<select class="form-control form-control-sm" id="selectChain" name="chainCode">
							<option value="">클릭하면 선택이 가능합니다</option>
	  						<c:forEach items="${chainList }" var="chain">
	  							<option value="${chain.chainCode }">${chain.chainName }</option>
	  						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>카페 이름</th>
					<td><input class="form-control form-control-sm" type="text" name="cafeName"></td>
				</tr>
				<tr>
					<th scope="row">카페 번호</th>
					<td><input class="form-control form-control-sm" type="tel" name="cafeTel"></td>
				</tr>
				<tr>
					<th scope="row">카페 주소</th>
					<td><input class="form-control form-control-sm" type="text" id="inputAddr" name="cafeAddr" placeholder="주소를 입력하시려면 이 곳을 클릭해주세요 (도로명주소)" onclick="openPostCode();"></td>
				</tr>
				<tr>
					<th scope="row">카페 상세주소</th>
					<td><input class="form-control form-control-sm" type="text" name="cafeAddrDetail"></td>
				</tr>
				<tr>
					<th scope="row">세스코 유무</th>
					<td>
						<div id="radioDiv">
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="cafeCesco" id="yes" value="Y" checked>
								<label class="form-check-label" for="yes">네</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="cafeCesco" id="no" value="N">
								<label class="form-check-label" for="no">아니오</label>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row">카페 운영시간</th>
					<td>
						<div class="form-inline">
							 <div class="col-md-2">
		     					 <input type="time" class="form-control" id="inputZip" name="cafeHoursArray" value="10:00">
		   					 </div>
		   					 <div class="offset-1 col-md-2">
		   					 	  ~
		   					 </div>
		   					 <div class="col-md-2">
		     					 <input type="time" class="form-control" id="inputZip" name="cafeHoursArray" value="22:00">
		   					 </div>
	   					 </div>
	   				</td>	 
				</tr>
				<tr>
					<th scope="row">카페 정보</th>
					<td><input class="form-control form-control-sm" type="text" name="cafeInfo"></td>
				</tr>
				<tr>
					<th scope="row">카페 로고</th>
					<td>
						<div class="img_wrap">
							<img alt="" id="img">
						</div>
						<div id="logoDiv"></div>
					</td>
				</tr>
			</tbody>
		</table>
		<button type="button" class="btn btn-primary" onclick="regCafe();">매장등록</button>
	</form>
</div>
<div id="map"></div>
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3e4301ac7e87ca3c730fd7d8a7002d1b&libraries=services"></script> 
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3e4301ac7e87ca3c730fd7d8a7002d1b"></script> 
			<script type="text/javascript"> 
			function regCafe(){
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
				var addr = $('#inputAddr').val();
				geocoder.addressSearch(addr, function (result, status) { 
					// 정상적으로 검색이 완료됐으면 
					if (status === kakao.maps.services.Status.OK) {
						var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
						$('#Latitude').val(result[0].y);
						$('#Longitude').val(result[0].x);
						// 결과값으로 받은 위치를 마커로 표시합니다 
						var marker = new kakao.maps.Marker({ 
							map: map, 
							position: coords }); 
						
						map.setCenter(coords);
						$('#regForm').submit();
						} 
					});
			}
				</script>
</body>
</html>