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

</style>
</head>
<body>
<div id="container">
	<div class="row">
		<div class="col">
			<table class="table">
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
						<td class="title"><a href="/board/noticeDetail?boardNum=${notice.boardNum }">${notice.boardName}</a></td>
						<td>${notice.boardWriter }</td>
						<td>${notice.boardRegDate }</td>
						<td>${notice.boardViewCnt }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<table class="table">
				<colgroup>
					<col style="width:100px;">
					<col>
					<col style="width:120px;">
					<col style="width:150px;">
					<col style="width:100px;">
				</colgroup>
				<c:forEach items="${noticeList1 }" var="notice" varStatus="status">
				<tr>
					<td>${noticeList1.size() - status.index}</td>
					<td><a href="/board/noticeDetail?boardNum=${notice.boardNum}">${notice.boardName}</a></td>
					<td>${notice.boardWriter }</td>
					<td>${notice.boardRegDate }</td>
					<td>${notice.boardViewCnt }</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div id="btnDiv" align="center">
		<c:choose>
			<c:when test="${not empty sessionScope.ownerLoginInfo and sessionScope.ownerLoginInfo.ownerId eq 'admin'}">
				<input type="button" class="btn btn-primary" value="글쓰기" onclick="location.href='/board/boardWriteForm?boardCode=BOARD_1'">
			</c:when>
			<c:when test="${not empty sessionScope.memberLoginInfo and sessionScope.memberLoginInfo.memId eq 'admin'}">
				<input type="button" class="btn btn-primary" value="글쓰기" onclick="location.href='/board/boardWriteForm?boardCode=BOARD_1'">
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</div>
	
	<div id="searchDiv" style="float: right;">
		<form action="/cafe/community1" method="get">
			<select name="searchKeyword">
				<option value="BOARD_NAME">제목</option>
				<option value="BOARD_CONTENT">내용</option>
				<option value="BOARD_WRITER">작성자</option>
			</select>
			<input type="search" name="searchValue" placeholder="검색">
			<button type="submit" class="btn btn-primary">Search</button>
		</form>
	</div>
</div>
</body>
</html>