<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.profileTable td:first-of-type{
	text-align: center;
}
</style>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/owner/profile_manage.js?ver=25" type="text/javascript"></script>
<script src="/resources/js/common/jquery.validate.js?ver=01" type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<h1>프로필 조회</h1>
		<form action="/owner/myPageUpdate" method="post" id="updateForm">
			<table class="table table-hover profileTable">
				<colgroup>
					<col width="20%">
					<col width="*%">
				</colgroup>
				<tbody>
					<tr>
						<td>아이디</td>
						<td>${ownerInfo.ownerId }</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>${ownerInfo.ownerName }</td>
					</tr>
					<tr>
						<td>기존 전화번호</td>
						<td>${ownerInfo.ownerTel }</td>
					</tr>
					<tr>
						<td>변경할 전화번호</td>
						<td>
						<input type="tel"  class="form-control tel" name="ownerTel">
						<small class="form-text text-muted">
							변경하실 전화번호를 -없이 이어서 입력해주세요.
						</small>
					</td>					
				</tr>
					<tr>
						<td>변경할 비밀번호</td>
						<td>
							<input type="password" name="ownerPw" class="form-control" id="ownerPw">
							<small class="form-text text-muted"> 
								변경할 비밀번호를 입력해주세요. 
							</small>
						</td>
					</tr>
					<tr>
					<td>변경할 비밀번호 확인</td>
					<td><input type="password" name="ownerPw1" class="form-control" id="ownerPw1">
						<small class="form-text text-muted">
							변경할 비밀번호를 한번 더 입력해주세요.
						</small>
					</td>
				</tr>
					<tr>
						<td>기존 주소</td>
						<td>${ownerInfo.ownerAddr } ${ownerInfo.ownerAddrDetail }</td>
					</tr>
					<tr>
						<td>변경할 주소</td>
						<td>
							<input type="text" class="form-control" id="inputAddr" name="ownerAddr" placeholder="주소를 입력하시려면 이 곳을 클릭해주세요 (도로명주소)" onclick="openPostCode();" readonly> 
						</td>
					</tr>
					<tr>
						<td>상세주소</td>
						<td><input type="text" class="form-control" id="ownerAddrDetail" name="ownerAddrDetail"></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>${ownerInfo.ownerEmail }</td>
					</tr>
					<tr>
						<td>가입일</td>
						<td><fmt:formatDate value="${ownerInfo.ownerRegDate }" pattern="yyyy-MM-dd" /> </td>
					</tr>
				</tbody>
			</table>
			<div class="profileBtnDiv">
				<input type="hidden" name="ownerId" value="${ownerInfo.ownerId}">
				<button type="button" class="btn btn-dark" id="updateBtn" >수정완료</button>
			</div>
		</form>
	</div>
</body>
</html>