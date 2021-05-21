<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#noticeDiv{
	float: right;
}
.star {
	color: red;
}

label.error {
	color: red;
	font-size: 0.8rem;
}
</style>

<!-- 우편번호 검색 js -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- js -->
<script src="/resources/js/owner/join_form.js?ver=7" type="text/javascript"></script>
<!-- validation -->
<script src="/resources/js/common/jquery.validate.js" type="text/javascript"></script>
</head>
<body>
<div class="container-sm">
	<div id="noticeDiv">
		<span class="star">*</span>필수 입력 사항
	</div>
	<form action="/owner/insertOwner" method="post" id="joinForm">
		<div class="form-group">
			<label for="inputId">아이디<span class="star">*</span></label> 
			<input type="text" class="form-control" id="inputId" name="ownerId">
		</div>
		<div class="form-group">
			<label for="inputName">이름<span class="star">*</span></label> 
			<input type="text" class="form-control" id="inputName" name="ownerName">
		</div>
		<div class="form-group">
			<label for="inputPassword">비밀번호<span class="star">*</span></label> 
			<input type="password" class="form-control" id="inputPassword" name="ownerPw">
		</div>
		<div class="form-group">
			<label for="inputAddr">주소<span class="star">*</span></label> 
			<input type="text" class="form-control" id="inputAddr" name="ownerAddr" placeholder="주소를 입력하시려면 이 곳을 클릭해주세요 (도로명주소)" onclick="openPostCode();" readonly>
		</div>
		<div class="form-group">
			<label for="inputAddrDetail">상세주소</label> 
			<input type="text" class="form-control" id="inputAddrDetail" name="ownerAddrDetail">
		</div>
		<div class="form-group">
			<label for="inputTel">전화번호<span class="star">*</span></label> 
			<input type="text" class="form-control" id="inputTel" name="ownerTel">
		</div>
		<div class="form-group">
			<label for="inputEmail">이메일<span class="star">*</span></label> 
			<input type="email" class="form-control" id="inputEmail" name="ownerEmail">
		</div>
		<button type="submit" class="btn btn-primary">회원가입</button>
	</form>
</div>
</body>
</html>