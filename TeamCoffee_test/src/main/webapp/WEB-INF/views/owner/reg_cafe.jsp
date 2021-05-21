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
label.error {
	color: red;
	font-size: 0.8rem;
}
</style>
<!-- 우편번호 검색 js -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- js -->
<script src="/resources/js/owner/reg_cafe.js?ver=39" type="text/javascript"></script>
<!-- validation -->
<script src="/resources/js/common/jquery.validate.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
	<h1>매장등록</h1>
	<p>매장을 등록 해 주세요.</p>
	<form action="/owner/insertCafe" method="post" id="regForm" enctype="multipart/form-data">
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
					<th scope="row">카페 폰번호</th>
					<td><input class="form-control form-control-sm" type="tel" name="cafeTel"></td>
				</tr>
				<tr>
					<th scope="row">카페 주소</th>
					<td><input class="form-control form-control-sm" type="text" id="inputAddr" name="cafeAddr" placeholder="주소를 입력하시려면 이 곳을 클릭해주세요 (도로명주소)" onclick="openPostCode();" readonly></td>
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
		<button type="submit" class="btn btn-primary" onclick="regCafe();">매장등록</button>
	</form>
</div>
</body>
</html>