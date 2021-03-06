<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.btnDiv {
	text-align: center;
}
.btns {
	margin: 30px;
	border-radius: 30px;
}
.boardContent {
	margin-top: 100px;
	margin-bottom: 100px;
	text-align: center;
	font: 600;
}
.content {
	margin: 100px;
	text-align: left;
}
#boardInfo {
	text-align: center;
	width: 100%;
}
#boardInfo > thead {
	border-bottom: 1px solid #E6E6E6;
	padding-bottom: 2%;
}
#boardInfo > tbody {
	border-bottom: 1px solid #E6E6E6;
	padding-top: 2%;
	padding-bottom: 2%;
}
</style>
<script src="/resources/js/board/board.js?ver=0"></script>
</head>
<body>
<table id="boardInfo">
	<colgroup>
	<col width="70%">
	<col width="18%">
	<col width="12%">
	</colgroup>
	<thead>
		<tr>
			<th colspan="3" style="text-align: left;"><h5 style="margin-left: 3%; margin-right: 3%;">${board.boardName }</h5></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><em style="position: relative; right: 40%;">${board.boardWriter }</em></td>
			<td>${board.boardRegDate }</td>
			<td>조회수 ${board.boardViewCnt }</td>
		</tr>
	</tbody>
</table>
<div class="boardContent">
	<img alt="" src="/resources/img/event/${board.boardUploadImgName }">
	<pre class="content">${board.boardContent }</pre>
</div>
<div class="btnDiv">
	<form action="/board/deleteBoard" method="post">
			<input type="button" class="btn btn-secondary btns" value="목 록" onclick="location.href='/cafe/community2'">
			<input type="hidden" name="boardNum" value="${board.boardNum }">
			<input type="hidden" name="boardCode" value="${board.boardCode }">
			<c:if test="${not empty sessionScope.memberLoginInfo or not empty sessionScope.ownerLoginInfo}">
				<c:choose>
					<c:when test="${sessionScope.memberLoginInfo.memId eq 'admin' or sessionScope.ownerLoginInfo.ownerId eq 'admin' }">
						<!-- 세션 로그인정보의 Id가 관리자 계정 'admin'일 때 -->
						<input type="button" class="btn btn-secondary btns" value="수 정" onclick="location.href='/board/updateBoardForm?boardNum=${board.boardNum}&&boardCode=${board.boardCode }'">
						<input type="button" class="btn btn-secondary btns" value="삭 제" data-boardNum="${board.boardNum }" data-boardCode="${board.boardCode }">
					</c:when>
				</c:choose>
			</c:if>	
	</form>
</div>
</body>
</html>