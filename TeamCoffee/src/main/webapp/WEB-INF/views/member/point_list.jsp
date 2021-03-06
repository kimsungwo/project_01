<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/member/point_list.js?ver=16" type="text/javascript"></script>
<style type="text/css">
.pointChangeTd{
	border-right: 1px dotted #dee2e6;
}
.pointTr td{
	border-bottom: 10px solid #dee2e6;
	border-top: 10px solid #dee2e6;
}
.pointDate{
	color: #848484;
	font-size: 1rem;
}
.usePoint{
	color: red;
}
.rewardPoint{
	color: #31B404;
}
.cafeName{
	font-size: 0.85rem;
}
.pointTable tr{
	height: 96px;
}
.pointTable td{
	vertical-align: middle;
}
.pointSpan{
	font-weight: bold;
	font-size: 1.2rem;
}
.noPoint td{
	border-top: none;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col">
				<h1>포인트내역</h1><hr>
				<h6>현재 <span class="pointSpan">${memberInfo.memNickname }</span> 님의 포인트는 <span class="pointSpan"><fmt:formatNumber type="number" value="${memberInfo.memPoint }"></fmt:formatNumber>원</span> 입니다</h6><hr>
				<table class="table pointTable">
					<colgroup>
						<col width="15%">
						<col width="*%">
					</colgroup>
						<c:choose>
							<c:when test="${empty pointList }">
								<tr class="noPoint text-center">
									<td colspan="2" ><h4>포인트 내역이 없습니다</h4></td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${pointList }" var="pointInfo">
									<tr class="pointTr">
										<td class="pointChangeTd text-center">
											<div><span class="pointStatusTd"><span class="pointChange"><fmt:formatNumber value="${pointInfo.pointChange }" type="number"></fmt:formatNumber></span>원</span></div>
										</td>
										<td>
											<div class="pointDate">
												<fmt:formatDate pattern="yyyy.MM.dd" value="${pointInfo.pointDate }"/>
											</div>
											<div class="pointChangeName">
												${pointInfo.pointChangeName }
											</div>
											<div class="cafeName">
												${pointInfo.buyVO.cafeVO.cafeName }
											</div>
										</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
				</table>
			</div>
		</div>
	</div>
</body>
</html>