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
					<img src="/resources/img/event/eventSample.jpg" class="card-img-top" alt="...">
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
	<div class="Tools">
		<!-- <input type="button" value="글 쓰기" onclick="location.href='/board/eventWriteForm'"> -->
		<input type="button" value="글 쓰기" onclick="location.href='/board/boardWriteForm?boardCode=BOARD_3'">
	</div>
</div>
</body>
</html>