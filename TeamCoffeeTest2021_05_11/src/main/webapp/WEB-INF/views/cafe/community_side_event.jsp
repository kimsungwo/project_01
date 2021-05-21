<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a:hover {
	color: black;
}
</style>
</head>
<body>
<div id="container">
	<div class="row row-cols-1 row-cols-md-3 g-4">
		<c:forEach items="${eventList }" var="event">
			<div class="col">
				<div class="card">
					<img src="/resources/img/event/${event.boardUploadImgName }" class="card-img-top" alt="...">
					<div class="card-body" align="center">
						<h5 class="card-title"><a href="/board/eventDetail?boardNum=${event.boardNum}">${event.boardName }</a></h5>
						<p class="card-text">${event.boardContent }</p>
					</div>
					<p class="card-text" align="center" style="padding-bottom: 15px;">
					<small class="text-muted">${event.eventFromDate } ~ ${event.eventToDate } &nbsp;|&nbsp; 조회 ${event.boardViewCnt }</small>
					</p>
				</div>
			</div>
		</c:forEach>
	</div>
	<div id="btnDiv" align="center">
		<c:choose>
			<c:when test="${not empty sessionScope.ownerLoginInfo and sessionScope.ownerLoginInfo.ownerId eq 'admin'}">
				<input type="button" class="btn btn-primary" value="글쓰기" onclick="location.href='/board/boardWriteForm?boardCode=BOARD_3'">
			</c:when>
			<c:when test="${not empty sessionScope.memberLoginInfo and sessionScope.memberLoginInfo.memId eq 'admin'}">
				<input type="button" class="btn btn-primary" value="글쓰기" onclick="location.href='/board/boardWriteForm?boardCode=BOARD_3'">
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</div>
</div>
</body>
</html>