<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="margin: 0 auto;">
	<ul style="list-style-type: none;">
		<li style="display: inline-block; margin-left: 150px;"><h1>${board.boardName }</h1></li>
		<li style="display: inline-block; margin-left: 150px;"><h3>${board.boardWriter }</h3></li>
		<li style="display: inline-block; margin-left: 150px;"><h3>${board.boardRegDate }</h3></li>
		<li style="display: inline-block; margin-left: 150px;"><h3>${board.boardViewCnt }</h3></li>
	</ul>
</div>
<hr>
<div style="margin: 100px 50px;">
	${board.boardContent }
</div>
<div align="center" style="padding-top: 100px;">
	<input type="button" style=" width: 100px; height: 30px;" value="목록" onclick="location.href='/cafe/community2'">
</div>
<form action="/board/deleteBoard1" method="post">
	<div>
		<input type="hidden" name="boardNum" value="${board.boardNum }">
		<c:if test="${not empty sessionScope.memberLoginInfo}">
			<c:choose>
				<c:when test="${board.boardWriter eq sessionScope.memberLoginInfo.memId}">
					<!-- loginInfo.memId와 게시글 boardWriter가 같을 때 -->
					<input type="button" class="btn btn-small" value="수 정" onclick="location.href='/board/updateBoardForm?boardNum=${board.boardNum}&&boardCode=${board.boardCode }'">
					<input type="submit" class="btn btn-small" value="삭 제">
				</c:when>
				<c:when test="${sessionScope.memberLoginInfo.memId eq 'admin' }">
					<!-- 세션 로그인정보의 memId가 관리자 계정 'admin'일 때 -->
					<input type="submit" class="btn btn-small" value="삭 제">
				</c:when>
			</c:choose>
		</c:if>	
	</div>
</form>
</body>
</html>