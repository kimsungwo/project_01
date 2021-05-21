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
</style>
<!-- 우편번호 검색 js -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- js -->
<script src="/resources/js/owner/cafe_update_page.js?ver=8" type="text/javascript"></script>
</head>
<body>
<div class="container">
	<h1>매장 정보 수정</h1>
	<p>매장의 정보를 수정할 수 있습니다.</p>
	<form action="/owner/cafeInfoUpdate?cafeCode=${cafeInfo.cafeCode }" method="post" enctype="multipart/form-data">
		<table class="table table-bordered">
			<colgroup>
				<col width="30%">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>카페 이름</th>
					<td><input class="form-control form-control-sm" type="text" value="${cafeInfo.cafeName }" name="cafeName"></td>
				</tr>
				<tr>
					<th scope="row">카페 폰번호</th>
					<td><input class="form-control form-control-sm" type="tel" value="${cafeInfo.cafeTel }" name="cafeTel"></td>
				</tr>
				<tr>
					<th scope="row">카페 주소</th>
					<td>
						<input class="form-control form-control-sm" type="text" value="${cafeInfo.cafeAddr }" id="inputAddr" name="cafeAddr" onclick="openPostCode();">
					</td>
				</tr>
				<tr>
					<th scope="row">카페 상세주소</th>
					<td><input class="form-control form-control-sm" type="text" value="${cafeInfo.cafeAddrDetail }" name="cafeAddrDetail"></td>
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
					<td><input class="form-control form-control-sm" type="text" value="${cafeInfo.cafeInfo }" name="cafeInfo"></td>
				</tr>
				
				<c:choose>
					<c:when test="${cafeInfo.chainCode eq 'CHAIN_999' }">
						<tr>
							<th scope="row">카페 로고</th>
							<td>
								<div class="img_wrap">
									<img alt="" id="img">
								</div>
								<div id="logoDiv">
									<img src="/resources/img/logo/${cafeInfo.cafeLogo }" width="200px">
									<input type="hidden" value="${cafeInfo.cafeLogo }" name="cafeLogo">
								</div>
								<button class="btn btn-secondary" type="button" id="logoUpdate">로고수정</button>
							</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<th scope="row">카페 로고</th>
							<td>
								<div id="logoDiv">
									<img src="/resources/img/logo/${cafeInfo.cafeLogo }" width="200px">
									<input type="hidden" value="${cafeInfo.cafeLogo }" name="cafeLogo">
								</div>
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<button type="submit" class="btn btn-primary">수정완료</button>
	</form>
</div>
</body>
</html>