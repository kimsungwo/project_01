<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
    width: 100%;
    font-family: "Noto Sans KR", sans-serif;
    border-collapse: collapse;
    border-spacing: 0;
}
thead tr th {
	text-align: center;
}

head {
    display: table-header-group;
    vertical-align: middle;
    border-color: inherit;
}

tbody tr td {
    text-align: center;
    color: #888;
    font-size: 15px;
}

tbody tr td.a {
    color: #888;
}


tbody tr.notice {
	background: #fcfbfb;
}

tbody tr.notice td a {
    color: #4c4c4c;
    font-size: 16px;
}

tbody tr.notice td span.noti {
    width: 42px;
    height: 30px;
    padding: 3px 0;
    background: #1A2680;
    color: #fff;
    display: inline-block;
}

.page-item.active .page-link {
	background: #6E777F;
	border-color: #6E777F;
}

.page-link {
	color: #6E777F;
}

.page-link:hover {
	color: black;
}
.searchFormDiv{
	float: right;
}
.imprtNoticeTable{
	margin-bottom: 0px;
}
.generalNoticeTable tr:last-of-type td{
	border-bottom: 1px solid #dee2e6;
}
.generalNoticeTable{
	margin-bottom: 50px;
}
#btnDiv{
	margin-bottom: 20px;
}
a:hover{
	text-decoration: none;
	color: #212529;
}
</style>
</head>
<body>
<div id="container">
	<div class="row">
		<div class="col">
			<table class="table imprtNoticeTable">
				<colgroup>
					<col style="width:100px;">
					<col>
					<col style="width:120px;">
					<col style="width:150px;">
					<col style="width:100px;">
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${noticeList2 }" var="notice" varStatus="status">
					<tr class="notice">
						<td><span class="noti">공지</span></td>
						<td class="title"><a href="/board/boardDetail?boardNum=${notice.boardNum }&boardCode=${notice.boardCode}">${notice.boardName}</a></td>
						<td>${notice.boardWriter }</td>
						<td>${notice.boardRegDate }</td>
						<td>${notice.boardViewCnt }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<table class="table generalNoticeTable">
				<colgroup>
					<col style="width:100px;">
					<col>
					<col style="width:120px;">
					<col style="width:150px;">
					<col style="width:100px;">
				</colgroup>
				<c:forEach items="${noticeList1 }" var="notice" varStatus="status">
				<tr>
					<td>${totalCnt -  (pageInfo.nowPage-1) * pageInfo.displayCnt - status.index}</td>
					<td><a href="/board/boardDetail?boardNum=${notice.boardNum}&boardCode=${notice.boardCode}">${notice.boardName}</a></td>
					<td>${notice.boardWriter }</td>
					<td>${notice.boardRegDate }</td>
					<td>${notice.boardViewCnt }</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<nav aria-label="...">
		<ul class="pagination justify-content-center my">
			<li class="page-item <c:if test="${!pageInfo.prev }">disabled</c:if>"><a class="page-link" href="/cafe/community1?nowPage=${pageInfo.beginPage - 1 }" tabindex="-1" aria-disabled="true">이전</a></li>
			<c:forEach begin="${pageInfo.beginPage }" end="${pageInfo.endPage }" step="1" var="index">
				<li class="page-item <c:if test="${pageInfo.nowPage eq index }">active</c:if>"><a class="page-link" href="/cafe/community1?nowPage=${index }">${index }</a></li>
			</c:forEach>
			<li class="page-item <c:if test="${!pageInfo.next }">disabled</c:if>"><a class="page-link" href="/cafe/community1?nowPage=${pageInfo.endPage + 1 }">다음</a></li>
		</ul>
	</nav>
	<div id="btnDiv" align="center">
		<c:choose>
			<c:when test="${not empty sessionScope.ownerLoginInfo and sessionScope.ownerLoginInfo.ownerId eq 'admin'}">
				<input type="button" class="btn btn-dark" value="글쓰기" onclick="location.href='/board/boardWriteForm?boardCode=BOARD_1'">
			</c:when>
			<c:when test="${not empty sessionScope.memberLoginInfo and sessionScope.memberLoginInfo.memId eq 'admin'}">
				<input type="button" class="btn btn-dark" value="글쓰기" onclick="location.href='/board/boardWriteForm?boardCode=BOARD_1'">
			</c:when>
		</c:choose>
	</div>
	<div id="searchDiv">
		<div class="col">
			<div class="searchFormDiv">
				<form action="/cafe/community1" method="get" class="form-inline"">
					<select name="searchKeyword" class="form-control">
						<option value="BOARD_NAME">제목</option>
						<option value="BOARD_CONTENT">내용</option>
						<option value="BOARD_WRITER">작성자</option>
					</select>
				
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search..." aria-label="Recipient's username" aria-describedby="button-addon2" name="searchValue">
						<div class="input-group-append">
							<button class="btn btn-outline-secondary" type="submit" id="button-addon2">검색</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>