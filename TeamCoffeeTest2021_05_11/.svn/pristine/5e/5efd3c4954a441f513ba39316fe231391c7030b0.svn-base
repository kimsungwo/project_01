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
					<c:forEach items="${userBoardList }" var="boardInfo" varStatus="status">
					<tr>
						<td>${userBoardList.size() - status.index}</td>
						<td><a href="/board/userBoardDetail?boardNum=${boardInfo.boardNum }">${boardInfo.boardName }</a></td>
						<td>${boardInfo.boardWriter }</td>
						<td>${boardInfo.boardRegDate }</td>
						<td>${boardInfo.boardViewCnt }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="Tools">
		<!-- <input type="button" value="글 쓰기" onclick="location.href='/board/userBoardWriteForm'"> -->
		<input type="button" value="글 쓰기" onclick="location.href='/board/boardWriteForm?boardCode=BOARD_4'">
	</div>
</div>
</body>
</html>













