<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.qnaTable{
	text-align: center;
}
.btnDiv{
	margin-top: 50px;
	text-align: right;
}
.qnaTable td{
	vertical-align: middle;
}
.qnaTable tr:last-of-type td{
	border-bottom: 1px solid #dee2e6;
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
a{
	color: #212529;
}
a:hover{
	color: #212529;
	text-decoration: none;
}
</style>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col">
			<h1>Q/A</h1>
			<h6>현재까지 <span class="">3</span>건의 질문 내역이 있습니다</h6>
			<table class="table qnaTable">
				<colgroup>
					<col width="20%">
					<col width="*">
					<col width="20%">
				</colgroup>
				<thead>
					<tr>
						<th>상태</th>
						<th>제목</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody id="qnaList">
					<c:choose>
						<c:when test="${not empty qnaList }">
							<c:forEach items="${qnaList }" var="qnaInfo">
								<tr>
									<td class="qnaStatus">${qnaInfo.qnaIsAnswerName }</td>
									<td><a href="/member/qnaMemberDetail?boardNum=${qnaInfo.boardNum }">${qnaInfo.boardName }</a></td>
									<td class="qnaRegDate">${qnaInfo.boardRegDate }</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="3" class="text-center">작성한 질문이 없습니다</td>
							</tr>
						</c:otherwise>					
					</c:choose>
					
				</tbody>
			</table>
			<div class="btnDiv">
				<button type="button" class="btn btn-primary" onclick="location.href='/member/qnaMemberForm'">글작성</button>
			</div>
		</div>
	</div>
</div>
</body>
</html>