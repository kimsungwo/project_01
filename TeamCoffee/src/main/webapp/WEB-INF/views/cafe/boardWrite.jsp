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
	width: 1200px;
	height: 600px;
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
	margin: 0 auto;
}

tr, td {
	border: 1px solid black;
	border-collapse: collapse;
}
.eventDate {
	float: left;
	margin-right: 50px;
}
.confirmBtn {
	text-align: center;
	padding-top: 50px; 
	display: inline-block; 
	position: relative;
	padding-left: 14%;
}
.confirmBtn >.btn {
	width: 100px;
	height: 33px;
}
.backBtn {
	text-align: center;
	padding-top: 50px; 
	display: inline-block;
	position: relative;
	padding-left: 30%;
}
.backBtn >.btn {
	width: 100px;
	height: 33px;
}
#radioSel {
	text-align: center;
}
</style>
<script src="/resources/js/board/board.js?ver=2"></script>
</head>
<body>
<form action="/board/boardUpload" method="post" enctype="multipart/form-data" id="uploadBoard">
<c:if test="${not empty sessionScope.memberLoginInfo }">
<input type="hidden" name="boardWriter" value="${sessionScope.memberLoginInfo.memId }">
</c:if>
<c:if test="${not empty sessionScope.ownerLoginInfo }">
<input type="hidden" name="boardWriter" value="${sessionScope.ownerLoginInfo.ownerId }">
</c:if>
<c:if test="${boardCode ne 'BOARD_1' }">
<input type="hidden" name="boardCode" value="${boardCode}">
</c:if>
	<input class="form-control form-control-lg" type="text" name="boardName" placeholder="제목을 입력하세요">
	<div class="form-group">
		<label for="exampleFormControlTextarea1"></label>
		<textarea class="form-control" id="exampleFormControlTextarea1" rows="14" name="boardContent" placeholder="내용을 입력하세요"></textarea>
	</div>
	
	<div id="radioSel">
		<c:if test="${boardCode eq 'BOARD_1'}">
			<div class="custom-control custom-radio custom-control-inline">
				<input type="radio" id="customRadioInline1" name="boardCode" class="custom-control-input" value="BOARD_1" checked>
				<label class="custom-control-label" for="customRadioInline1">일반공지</label>
			</div>
			<div class="custom-control custom-radio custom-control-inline">
				<input type="radio" id="customRadioInline2" name="boardCode" class="custom-control-input" value="BOARD_2"> 
				<label class="custom-control-label" for="customRadioInline2">중요공지</label>
			</div>
		</c:if>
	</div>
	
	<c:if test="${boardCode eq 'BOARD_3'}">
	<div class="input-group">
		<ul style="list-style: none; padding-inline-start: 0; ">
			<li class="eventDate">이벤트 시작일&nbsp;&nbsp;<input type="date" name="eventFromDate"></li> 
			<li class="eventDate">이벤트 종료일&nbsp;&nbsp;<input type="date" name="eventToDate"></li>
		</ul>
	</div>
	
	
	<div class="form-row">
		<label for="">메인 이미지</label>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="inputGroupFileAddon01">파일 선택</span>
			</div>
			<div class="custom-file">
				<input type="file" name="mainImg" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
				<label class="custom-file-label" for="inputGroupFile01">파일 이름</label>
			</div>
		</div>
	</div>
	<div class="form-row">
	<label for="">내용 이미지</label>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="inputGroupFileAddon02">파일 선택</span>
			</div>
			<div class="custom-file">
				<input type="file" name="detailImg" class="custom-file-input" id="inputGroupFile02" aria-describedby="inputGroupFileAddon02">
				<label class="custom-file-label" for="inputGroupFile02">파일 이름</label>
			</div>
		</div>
	</div>
	</c:if>
	
	<c:choose>
		<c:when test="${boardCode eq 'BOARD_1'}">
			<div class="backBtn">
				<input type="button" class="btn btn-secondary" value="뒤로" onclick="location.href='/cafe/community1'">
			</div>
		</c:when>
		<c:when test="${boardCode eq 'BOARD_3' }">
			<div class="backBtn">
				<input type="button" class="btn btn-secondary" value="뒤로" onclick="location.href='/cafe/community2'">
			</div>
		</c:when>
		<c:when test="${boardCode eq 'BOARD_4' }">
			<div class="backBtn">
				<input type="button" class="btn btn-secondary" value="뒤로" onclick="location.href='/cafe/community3'">
			</div>
		</c:when>
	</c:choose>
	<div class="confirmBtn">
		<input type="button" id="upload" class="btn btn-secondary" value="확인">
	</div>
</form>
</body>
</html>