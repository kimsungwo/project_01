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
.insertReplyForm {
	margin-top: 100px;
}
.boardContent {
	margin: 100px 50px;
}
.content {
	margin-left: 100px;
	margin-right: 100px;
	text-align: left;
}
.btns {
	margin: 30px;
	border-radius: 30px;
}
#commentTable {
	width: 100%;
	border-bottom: 1px solid #dedede;
	margin-bottom: 5px;
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
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
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
	<pre class="content">${board.boardContent }</pre>
</div>
<div class="btnDiv">
	<form action="/board/deleteBoard" method="post">
	<input type="button" class="btn btn-secondary btns" value="목 록" onclick="location.href='/cafe/community3'">
	<c:if test="${not empty sessionScope.memberLoginInfo or not empty sessionScope.ownerLoginInfo}">
		<c:choose>
			<c:when test="${board.boardWriter eq sessionScope.memberLoginInfo.memId or board.boardWriter eq sessionScope.ownerLoginInfo.ownerId}">
				<!-- loginInfo.memId와 게시글 boardWriter가 같을 때 -->
				<input type="button" class="btn btn-secondary btns" value="수 정" onclick="location.href='/board/updateBoardForm?boardNum=${board.boardNum}&&boardCode=${board.boardCode }'">
				<input type="button" class="btn btn-secondary btns" data-boardCode="${board.boardCode }" data-boardNum="${board.boardNum }" value="삭 제">
			</c:when>
			<c:when test="${sessionScope.memberLoginInfo.memId eq 'admin' or sessionScope.ownerLoginInfo.ownerId eq 'admin' }">
				<!-- 세션 로그인정보의 Id가 관리자 계정 'admin'일 때 -->
				<input type="button" class="btn btn-secondary btns" data-boardCode="${board.boardCode }" data-boardNum="${board.boardNum }" value="삭 제">
			</c:when>
		</c:choose>
	</c:if>	
	</form>
</div>
<hr>
<div class="insertReplyForm">
	<c:choose>
		<c:when test="${not empty sessionScope}">
			<form action="/comment/commentUpload" method="post">
				<input type="hidden" name="boardNum" value="${board.boardNum }">
				<c:choose>
					<c:when test="${not empty sessionScope.ownerLoginInfo }">
						<input type="hidden" name="commentWriter" value="${sessionScope.ownerLoginInfo.ownerId }">
					</c:when>
					<c:when test="${not empty sessionScope.memberLoginInfo }">
						<input type="hidden" name="commentWriter" value="${sessionScope.memberLoginInfo.memId }">
					</c:when>
				</c:choose>
				<div class="form-group">
					<textarea class="form-control form-control-sm" id="exampleFormControlTextarea1" rows="3" name="commentContent" placeholder="댓글을 입력하세요" style="width: 89%; display: inline; float: left;"></textarea>
					<input type="submit" class="btn btn-primary" style="width: 10%; height: 73px; display: inline; margin-left: 1%" value="등 록">
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<div class="form-group">
				<textarea class="form-control form-control-sm" id="exampleFormControlTextarea1" rows="3" name="commentContent" placeholder="댓글을 입력하세요" style="width: 89%; display: inline; float: left;"></textarea>
				<button type="button" class="btn btn-primary" onclick="location.href='#'" data-toggle="modal" data-target="#loginModal" style="width: 10%; height: 73px; display: inline; margin-left: 1%;">등록</button>
			</div>				
		</c:otherwise>
	</c:choose>
</div>
<div class="commentList">
	<c:forEach items="${commentList }" var="comment">
		<table id="commentTable">
		<tr>
			<td><div class = "idDiv">${comment.commentWriter }</div></td>
		</tr>
		<tr>
			<td><div class = "dateDiv">${comment.commentDate }</div></td>
		</tr>
		<tr>
			<td><div class="contentDiv" style="display: inline-block;">${comment.commentContent }</div></td>
			<c:if test="${comment.commentWriter eq sessionScope.memberLoginInfo.memId or comment.commentWriter eq sessionScope.ownerLoginInfo.ownerId
			or sessionScope.memberLoginInfo.memId eq admin or sessionScope.ownerLoginInfo.ownerId eq admin }">
			<td>
				<div style="display: inline-block; float: right">
					<button class="btn btn-secondary" id="deleteComment" data-boardNum = "${comment.boardNum }" data-commentCode = "${comment.commentCode }">삭제</button>
				</div>
			</td>
			</c:if>
		</tr>
		</table>
	</c:forEach>
</div>
</body>
</html>