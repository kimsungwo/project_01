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
				<table class="table">
					<colgroup>
						<col width="20%">
						<col width="40%">
						<col width="*">
					</colgroup>
					<tbody>
						<c:forEach items="${likeCafeList }" var="cafeInfo">
							<tr>
								<td>
									<img alt="" src="/resources/img/logo/${cafeInfo.cafeLogo }" width="40px">
								</td>
								<td>
									${cafeInfo.cafeName }
								</td>
								<td>
									${cafeInfo.cafeAddr } ${cafeInfo.cafeAddrDetail }
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
	</c:choose>
</div>
</body>
</html>