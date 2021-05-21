<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="/resources/js/member/to_drop_out.js?ver=14" type="text/javascript"></script>
<style type="text/css">
table td:first-of-type{
	text-align: center;
}
.subMenuInfo{
	font-size: 1rem;
}
</style>
</head>
<body>
	<div class="container">
		<h1>회원 탈퇴</h1>
		<p class="subMenuInfo">회원 탈퇴시 사용하고 계신 아이디(<span class="idSpan">${memberInfo.memId}</span>)는 <span class="warningSpan">재사용이 불가능</span>하며, <span class="warningSpan">회원정보, 주문내역 및 포인트는 복구가 불가능</span>합니다.</p>
		<form action="/member/toDropOut"  name="deleteform" id="deleteForm" method="post">
			<table class="table profileTable">
				<colgroup>
					<col width="18%">
					<col width="*%">
					<col width="20%">
				</colgroup>
				<tr>
					<td>
						비밀번호
					</td>
					<td>
						<input type="password"  id="login_password" name="memPw" class="form-control">
						<input type="hidden" name="memCode" value="${memberInfo.memCode}" > 
						<input type="hidden" name="memId" value="${memberInfo.memId}"> 
					</td>
					<td>
						<button type="button" id="deleteBtn" class="btn btn-danger">탈퇴하기</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>