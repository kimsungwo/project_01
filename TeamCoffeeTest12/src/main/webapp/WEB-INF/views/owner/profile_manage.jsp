<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.card{
	height: 18rem;
}
</style>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/owner/profile_manage.js?ver=04" type="text/javascript"></script>
<script src="/resources/js/common/jquery.validate.js?ver=01" type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<h1>개인정보</h1>
		<form action="/owner/myPageUpdate" method="post" id="updateForm">
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
						<td>${ownerInfo.ownerId }</td>
					</tr>
					<tr>
						<th scope="row">*</th>
						<td>이름</td>
						<td>${ownerInfo.ownerName }</td>
					</tr>
					<tr>
						<th scope="row">*</th>
						<td>기존 전화번호</td>
						<td>${ownerInfo.ownerTel }</td>
					</tr>
				<tr>
					<th scope="row">*</th>
					<td>변경할 전화번호</td>
					<td>
					<input type="tel"  class="form-control tel" name="ownerTel">
						<small id="passwordHelpBlock" class="form-text text-muted">
							변경하실 전화번호를 -없이 이어서 입력해주세요.
						</small>
					</td>					
				</tr>
					<tr>
						<tr>
					<th scope="row">*</th>
						<td>변경할 비밀번호</td>
						<td>
							<input type="password" name="ownerPw" class="form-control passwordBox pw" id="password_1">
							<small id="passwordHelpBlock" class="form-text text-muted"> 
								변경할 비밀번호를 입력해주세요. 
							</small>
						</td>
					</tr>
					
				<tr>
					<th scope="row">*</th>
					<td>변경할 비밀번호 확인</td>
					<td><input type="password" name="ownerPw1" class="form-control passwordBox pw" id="password_2">
						<small id="passwordHelpBlock" class="form-text text-muted">
							변경할 비밀번호를 한번 더 입력해주세요. </small>
						 <span id="alert-success" style="display: none;">비밀번호가 일치합니다.</span>
   						 <span id="alert-danger" style="display: none; color: #d92742; font-weight: bold; ">
   						 	비밀번호가 일치하지 않습니다.</span>
					</td>
				</tr>
						
						<!-- <td>변경할 비밀번호</td>
						<td>
							<input type="password" name="" class="form-control">
							<small id="passwordHelpBlock" class="form-text text-muted"> 변경할 비밀번호를 입력해주세요. </small>
						</td>
					</tr>
					<tr>
						<th scope="row">*</th>
						<td>변경할 비밀번호 확인</td>
						<td>
							<input type="password" name="" class="form-control">
							<small id="passwordHelpBlock" class="form-text text-muted"> 변경할 비밀번호를 한번 더 입력해주세요. </small>
						</td>
					</tr> -->
					<tr>
						<th scope="row">*</th>
						<td>기존 주소</td>
						<td>${ownerInfo.ownerAddr } ${ownerInfo.ownerAddrDetail }</td>
					</tr>
					<tr>
						<th scope="row">*</th>
						<td>변경할 주소</td>
						<td>
							<input type="text" class="form-control" id="inputAddr" name="ownerAddr" 
							placeholder="주소를 입력하시려면 이 곳을 클릭해주세요 (도로명주소)" 
							onclick="openPostCode();" readonly> 
							<!-- <input type="text" class="form-control" id="inputAddrDetail" name="ownerAddrDetail"> -->
						</td>
					</tr>
					<tr>
						<th scope="row">*</th>
						<td>상세주소</td>
						<td><input type="text" class="form-control" id="ownerAddrDetail" name="ownerAddrDetail"></td>
					</tr>
					<tr>
						<th scope="row">*</th>
						<td>이메일</td>
						<td>${ownerInfo.ownerEmail }</td>
					</tr>
					<!-- <tr>
						<th scope="row">*</th>
						<td>변경할 이메일</td>
						<td><input type="text" class="form-control" id="inputCity"></td>
					</tr> -->
					<tr>
						<th scope="row">*</th>
						<td>가입일</td>
						<td><fmt:formatDate value="${ownerInfo.ownerRegDate }" pattern="yyyy-MM-dd" /> </td>
					</tr>
				</tbody>
			</table>
				<input type="hidden" name="ownerId" value="${ownerInfo.ownerId}">
			<button type="submit" class="btn btn-secondary" id="updateBtn" data-password0="${ownerInfo.ownerPw}">수정완료</button>
		</form>
	</div>
</body>
</html>