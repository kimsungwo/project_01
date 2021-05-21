<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/admin/qna_admin_detail.js?ver=3" type="text/javascript"></script>
<style type="text/css">
.qnaTable tr:last-of-type th, .qnaTable tr:last-of-type td{
	border-bottom: 1px solid #dee2e6;
}
.qnaTable th{
	text-align: center;
	vertical-align: middle;
}
.qnaTable tr:last-of-type th{
	vertical-align: top;
}
.qnaRegDate{
	font-size: 0.95rem;
	color: #585858;
}
.qnaStatus{
	font-size: 0.95rem;
	font-weight: bold;
	color: red;
}
.qnaTable tr:first-of-type td, .qnaTable tr:nth-of-type(2) td{
	vertical-align: middle;
}
.commentDiv{
	border: 1px solid #dee2e6;
	padding: 30px 0px;
	margin: 30px 0px;
}
.commentDiv table{
	margin-left: 30px;
}
.adminSpan{
	font-weight: bold;
	color: #52568E;
}
.adminCommentSpan{
	font-size: 0.95rem;
}
.commentForm{
	margin: 20px 0px;
}
.commentTable{
	width: 100%;
}
#adminComment{
	width: 100%;
}
#commentBtn{
	margin: 5px;
	display: inline-block;
	width: 100px;
	height: 73px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col">
				<table class="table qnaTable">
					<colgroup>
						<col width="15%">
						<col width="*">
						<col width="15%">
						<col width="20%">
					</colgroup>
					<tr>
						<th>제목</th>
						<td>${qnaDetail.boardName }</td>
						<th>답변상태</th>
						<td class="qnaStatus">${qnaDetail.qnaIsAnswerName }</td>
					</tr>
					<tr>
						<th>글쓴이</th>
						<td>${qnaDetail.boardWriter }</td>
						<th>작성일</th>
						<td class="qnaRegDate">${qnaDetail.boardRegDate }</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3" style="height: 300px;">${qnaDetail.boardContent }</td>
					</tr>
				</table>
				<div class="commentDiv">
					<c:if test="${empty commentList }">
						<div class="text-center">작성된 답변이 없습니다</div>
					</c:if>
					<table>
						<c:forEach items="${commentList }" var="commentInfo">
							<tr>
								<td><span class="adminSpan">${commentInfo.commentWriter }</span> <span class="qnaRegDate">(${commentInfo.commentDate })</span></td>
							</tr>
							<tr>
								<td><span class="adminCommentSpan">${commentInfo.commentContent }</span></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="commentForm">
					<form action="/admin/insertQnAComment" method="post" id="adminCommentForm">
					<table class="commentTable">
						<colgroup>
							<col width="*">
							<col width="10%">
						</colgroup>
						<tr>
							<td>
								<textarea rows="3" class="form-control" id="adminComment" name="commentContent" placeholder="답변을 입력해주세요"></textarea>
							</td>
							<td class="text-center">
								<button type="button" class="btn btn-primary" id="commentBtn">등록</button>
							</td>
						</tr>
					</table>
					<input type="hidden" value="${qnaDetail.boardNum }" name="boardNum">
					</form>
				</div>
				<div class="btnDiv text-right">
					<button type="button" class="btn btn-dark" onclick="location.href='/admin/qnaManage';">목록</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>