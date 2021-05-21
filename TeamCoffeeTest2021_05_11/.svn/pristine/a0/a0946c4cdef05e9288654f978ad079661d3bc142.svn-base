<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
<style type="text/css">
#noticeDiv {
	text-align:center;
}
.bi {
	font-size: 100px;
}
.cafeLogoImg{
	width: 80px;
}
.cafeAddr{
	color: #585858;
	font-size: 0.9rem;
	padding: 2px 0px;
}
.btn-light{
	border: 1px solid #BDBDBD;
}
a{
	color: #212529;
}
a:hover{
	color: #212529;
	text-decoration: none;
}
.likeTable{
	border-top: 10px solid #dee2e6;
}
.likeTable td{
	border-bottom: 10px solid #dee2e6;
	border-top: 10px solid #dee2e6;
}
</style>
</head>
<body>
<div class="container">
	<c:choose>
		<c:when test="${likeCafeList.size() eq 0 }">
			<div id="noticeDiv">
				<i class="bi bi-exclamation"></i>
				<h1>찜한 매장이 없습니다.</h1>
			</div>
		</c:when>
		<c:otherwise>
			<h1>찜한 매장</h1>
				<table class="table likeTable">
					<colgroup>
						<col width="15%">
						<col width="*%">
					</colgroup>
				<c:forEach items="${likeCafeList }" var="cafeInfo">
						<tr>
							<td><a href="/cafe/cafeInfoAndMenu?&cafeCode=${cafeInfo.cafeCode }"><img src="/resources/img/logo/${cafeInfo.cafeLogo }" class="cafeLogoImg"></a></td>
							<td>
								<div class="cafeName"><a href="/cafe/cafeInfoAndMenu?&cafeCode=${cafeInfo.cafeCode }">${cafeInfo.cafeName }</a></div>
								<div class="cafeAddr">${cafeInfo.cafeAddr } ${cafeInfo.cafeAddrDetail }</div>
								<div>
									<input type="button" class="btn btn-light btn-sm" value="찜 해제" onclick="location.href='/like/dislike?cafeCode=${cafeInfo.cafeCode}';">
								</div>
							</td>
						</tr>
				</c:forEach>
				</table>
			</c:otherwise>
	</c:choose>
</div>
</body>
</html>