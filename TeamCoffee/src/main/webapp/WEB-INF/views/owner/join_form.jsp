<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#headDiv h1 {
	text-align: center;
	font-size: 5rem;
}

#noticeDiv{
	float: right;
}
.star {
	color: red;
}

#submitTr {
	text-align: center;
}

label.is-invalid {
	color: red;
	font-size: 0.8rem;
}

</style>

<!-- 우편번호 검색 js -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- js -->
<script src="/resources/js/owner/join_form.js?ver=25" type="text/javascript"></script>
<!-- validation -->
<script src="/resources/js/common/jquery.validate.js?ver=20" type="text/javascript"></script>
</head>
<body>
<div class="container-sm">
	<div id="headDiv">
		<h1>JOIN US</h1>
	</div>
	<div id="noticeDiv">
		<span class="star">*</span>필수 입력 사항
	</div>
	<form action="/owner/insertOwner" method="post" id="joinForm">
		<table class="table table-borderless">
			<colgroup>
				<col width="15%">
				<col width="*">
				<col width="20%">
			</colgroup>
			<tbody>
				<tr>
					<td>아이디<span class="star">*</span></td>
					<td><input type="text" class="form-control" id="inputId" name="ownerId"></td>
				</tr>
				<tr>
					<td>비밀번호<span class="star">*</span></td>
					<td><input type="password" class="form-control" id="inputPassword" name="ownerPw"></td>
				</tr>
				<tr>
					<td>비밀번호 확인<span class="star">*</span></td>
					<td><input type="password" class="form-control" id="confirm_pw" name="confirm_pw"></td>
				</tr>
				<tr>
					<td>이름<span class="star">*</span></td>
					<td><input type="text" class="form-control" id="inputName" name="ownerName"></td>
				</tr>
				<tr>
					<td>전화번호<span class="star">*</span></td>
					<td><input type="tel" class="form-control" id="inputTel" name="ownerTel"></td>
				</tr>
				<tr>
					<td>이메일<span class="star">*</span></td>
					<td><input type="email" class="form-control" id="inputEmail" name="ownerEmail"></td>
				</tr>
				<tr>
					<td>주소<span class="star">*</span></td>
					<td><input type="text" class="form-control" id="inputAddr" name="ownerAddr" placeholder="주소를 입력하시려면 이 곳을 클릭해주세요 (도로명주소)" onclick="openPostCode();"></td>
				</tr>
				<tr>
					<td>상세주소</td>
					<td><input type="text" class="form-control" id="inputAddrDetail" name="ownerAddrDetail"></td>
				</tr>
				<tr id="submitTr">
					<td colspan="4"><button type="submit" class="btn btn-primary">회원가입</button></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>