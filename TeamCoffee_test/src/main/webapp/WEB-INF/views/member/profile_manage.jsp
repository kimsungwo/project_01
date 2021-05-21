<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.card{
	height: 18rem;
}
.nickname{
	width: 11rem; 
	display: inline-block
}
.tel{
	width: 16rem;
}
.passwordBox{
	width: 20rem;
}
.post{
	width: 28rem;
}
.email{
	width: 30rem;
}
</style>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/member/profile_manage.js?ver=32" type="text/javascript"></script>
<script src="/resources/js/member/jquery.validate.js?ver=04" type="text/javascript"></script>
</head>
<body class="container-fluid">
	<h1>프로필 조회</h1>
	<form action="/member/myPageUpdate" method="post" id="updateForm">
		<table class="table table-hover">
			<colgroup>
				<col width="5%">
				<col width="15%">
				<col width="*">
			</colgroup>
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">목록</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">*</th>
					<td>아이디</td>
					<td>${memberInfo.memId}</td>
				</tr>
				<tr>
					<th scope="row">*</th>
					<td>회원등급</td>
					<td>${memberInfo.memGrade}</td>
				</tr>
				<tr>
					<th scope="row">*</th>
					<td>닉네임</td>
					<td>${memberInfo.memNickname}
						<input type="text" class="form-control nickname" name="memNickname">
					<%-- 	<input type="hidden" id="memNickname1" value="${memberInfo.memNickname}"> --%>
						<small id="passwordHelpBlock" class="form-text text-muted">20자 이하로 써주세요.</small>
					</td>
				</tr>
				<tr>
					<th scope="row">*</th>
					<td>전화번호</td>
					<td>${memberInfo.memTel}
					<input type="tel"  class="form-control tel" name="memTel">
						<small id="passwordHelpBlock" class="form-text text-muted">
							변경하실 전화번호를 -없이 이어서 입력해주세요.</small></td>					
				</tr>
				<tr>
					<th scope="row">*</th>
					<td>기존 비밀번호</td>
					<td><input type="password" name="password" class="form-control passwordBox" id="login_password">
						<small id="passwordHelpBlock" class="form-text text-muted">
							기존비밀번호를 입력해주세요.</small></td>
				</tr>
				<tr>
					<th scope="row">*</th>
					<td>변경할 비밀번호</td>
					<td><input type="password" name="memPw" class="form-control passwordBox pw" id="password_1">
						<small id="passwordHelpBlock" class="form-text text-muted">
							변경할 비밀번호를 입력해주세요. </small></td>
				</tr>
				<tr>
					<th scope="row">*</th>
					<td>변경할 비밀번호 확인</td>
					<td><input type="password" name="memPw1" class="form-control passwordBox pw" id="password_2">
						<small id="passwordHelpBlock" class="form-text text-muted">
							변경할 비밀번호를 한번 더 입력해주세요. </small>
						 <span id="alert-success" style="display: none;">비밀번호가 일치합니다.</span>
   						 <span id="alert-danger" style="display: none; color: #d92742; font-weight: bold; ">
   						 	비밀번호가 일치하지 않습니다.</span>
					</td>
				</tr>
				<tr>
					<th scope="row">*</th>
					<td>기존 주소</td>
					<td>"${memberInfo.memAddr} +${memberInfo.memAddrDetail}"</td>
				</tr>
				<tr>
					<th scope="row">*</th>
					<td>변경할 주소</td>
					<td><input type="text" class="form-control" id="inputAddr" name="memAddr" 
						placeholder="주소를 입력하시려면 이 곳을 클릭해주세요 (도로명주소)" 
						onclick="openPostCode();" readonly>
						<input type="text" class="form-control" id="memAddrDetail" name="memAddrDetail">
					</td>
					
				</tr>
				<tr>
					<th scope="row">*</th>
					<td>기존 이메일</td>
					<td>"${memberInfo.memEmail}"</td>
				</tr>
				<tr>
					<th scope="row">*</th>
					<td>변경할 이메일</td>
					<td><input type="text" class="form-control email" id="email" name="memEmail"></td>
				</tr>
				<tr>
					<th scope="row">*</th>
					<td>가입일</td>
					<td>"${memberInfo.memRegDate}"</td>
				</tr>
			</tbody>
		</table>
		<input type="hidden" name="memId" value="${memberInfo.memId}">
		<button type="button" class="btn btn-secondary" id="updateBtn" data-password0="${memberInfo.memPw}">수정완료</button>
	</form>
</body>
</html>