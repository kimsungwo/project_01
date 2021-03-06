<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#profileBtn{
	margin-top:20px;
	text-align: center;
}
.profileTable td:first-of-type{
	text-align: center;
}
#profileTd {
	border-top: none;
}
</style>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/member/profile_manage.js?ver=39" type="text/javascript"></script>
<script src="/resources/js/common/jquery.validate.js?ver=05" type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<h1>프로필 조회</h1>
		<form action="/member/myPageUpdate" method="post" id="updateForm" enctype="multipart/form-data">
			<table class="table table-hover profileTable">
				<colgroup>
					<col width="18%">
					<col width="*">
					<col width="20%">
				</colgroup>
				<tbody>
					<tr>
						<td>아이디</td>
						<td>${memberInfo.memId}</td>
						<c:if test="${memberInfo.memProfileImg != null }">
							<td rowspan="4" id="profileTd">
								<img src="/resources/img/profile/${memberInfo.memProfileImg }" class="img-thumbnail" alt="...">
								<div id="profileBtn">
									<input type="hidden" value="${memberInfo.memProfileImg }" name="memProfileImg">
									<button type="button" class="btn btn-outline-dark btn-sm" id="regProfile">프로필등록</button>
								</div>
							</td>
						</c:if>
					</tr>
					<tr>
						<td>회원등급</td>
						<td>${memberInfo.gradeVO.gradeName }</td>
					</tr>
					<tr>
						<td>닉네임</td>
						<td>${memberInfo.memNickname}
						</td>
					</tr>
					<tr>
						<td>변경할 닉네임</td>
						<td>
							<input type="text" class="form-control nickname" name="memNickname">
						</td>
					</tr>
					<tr>
						<td>기존 전화번호</td>
						<td colspan="2">${memberInfo.memTel}</td>	
					</tr>
					<tr>
						<td>변경할 전화번호</td>
						<td colspan="2">
							<input type="tel"  class="form-control tel" name="memTel">
							<small id="passwordHelpBlock" class="form-text text-muted">
								변경하실 전화번호를 -없이 이어서 입력해주세요.
							</small>
						</td>					
					</tr>
					<tr>
						<td>변경할 비밀번호</td>
						<td colspan="2">
							<input type="password" name="memPw" class="form-control" id="memPw">
							<small id="passwordHelpBlock" class="form-text text-muted">
								변경할 비밀번호를 입력해주세요. </small></td>
					</tr>
					<tr>
						<td>변경할 비밀번호 확인</td>
						<td colspan="2">
							<input type="password" name="memPw1" class="form-control" id="memPw1">
							<small id="passwordHelpBlock" class="form-text text-muted">
								변경할 비밀번호를 한번 더 입력해주세요. </small>
						</td>
					</tr>
					<tr>
						<td>기존 주소</td>
						<td colspan="2">${memberInfo.memAddr} ${memberInfo.memAddrDetail}</td>
					</tr>
					<tr>
						<td>변경주소</td>
						<td colspan="2">
						<input type="text" class="form-control" id="inputAddr" name="memAddr" 
							placeholder="주소를 입력하시려면 이 곳을 클릭해주세요 (도로명주소)" 
							onclick="openPostCode();" readonly>
						</td>
					</tr>
					<tr>
						<td>상세주소</td>
						<td colspan="2">
							<input type="text" class="form-control" id="memAddrDetail" name="memAddrDetail">
						</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td colspan="2">${memberInfo.memEmail}</td>
					</tr>
					<tr>
						<td>가입일</td>
						<td colspan="2"><fmt:formatDate value="${memberInfo.memRegDate}" pattern="yyyy-MM-dd"/></td>
					</tr>
				</tbody>
			</table>
			<div class="profileBtnDiv">
				<input type="hidden" name="memId" value="${memberInfo.memId}">
				<button type="button" class="btn btn-secondary" id="updateBtn">수정완료</button>
			</div>
		</form>
	</div>
</body>
</html>