<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
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
.cafeTable th{
	vertical-align: middle;
}
.cafeState{
	width: 30%;
}
</style>
<script src="/resources/js/owner/cafe_manage.js?ver=10" type="text/javascript"></script>
</head>
<body>
<div class="container">
	<c:choose>
		<c:when test="${cafeList.size() eq 0 }">
			<div id="noticeDiv">
				<i class="bi bi-exclamation"></i>
				<h1>등록된 매장이 없습니다.</h1>
				<p>매장을 등록 해 주세요.</p>
				<button type="button" class="btn btn-primary" onclick="location.href='/owner/regCafe';">매장등록 하러가기</button>
			</div>
		</c:when>
		<c:otherwise>
			<h1>매장관리</h1>
			<p class="subMenuInfo">소유하신 매장을 관리할 수 있습니다.</p>
				<c:forEach items="${cafeList }" var="cafeInfo">
					<div class="card-body">
						<div class="card mb-3" style="max-width: 1000px;">
							<div class="row no-gutters">
								<div class="col-lg-5 text-center">
									<img src="/resources/img/logo/${cafeInfo.cafeLogo }" alt="..." width="90%">
								</div>
								<div class="col-lg-7">
									<div class="card-body">
										<table class="table table-borderless cafeTable">
											<colgroup>
												<col width="25%">
												<col width="*">
											</colgroup>
											<tbody>
												<tr>
													<th scope="row">상호명</th>
													<td>${cafeInfo.cafeName }</td>
												</tr>
												<tr>
													<th scope="row">주소</th>
													<td>${cafeInfo.cafeAddr }</td>
												</tr>
												<tr>
													<th scope="row">상세주소</th>
													<td>${cafeInfo.cafeAddrDetail }</td>
												</tr>
												<tr>
													<th scope="row">전화번호</th>
													<td>${cafeInfo.cafeTel }</td>
												</tr>
												<tr>
													<th scope="row">영업시간</th>
													<td>${cafeInfo.cafeHours }</td>
												</tr>
												<tr>
													<th scope="row">카페정보</th>
													<td>${cafeInfo.cafeInfo }</td>
												</tr>
												<tr>
													<th scope="row">승인상태</th>
													<c:choose>
														<c:when test="${cafeInfo.createReady eq 'Y' }">
															<td>승인완료</td>
														</c:when>
														<c:when test="${cafeInfo.createReady eq 'N' }">
															<td>승인대기중</td>
														</c:when>
													</c:choose>
												</tr>
												<tr>
													<th scope="row">영업상태</th>
													<td>
														<select class="form-control cafeState" data-cafeCode="${cafeInfo.cafeCode }">
															<option value="0" <c:if test="${cafeInfo.cafeState == 0 }">selected</c:if> >영업중</option>
															<option value="1" <c:if test="${cafeInfo.cafeState == 1 }">selected</c:if>>준비중</option>
															<option value="2" <c:if test="${cafeInfo.cafeState == 2 }">selected</c:if>>휴업중</option>
														</select>
													</td>
												</tr>
											</tbody>
										</table>
										<p class="card-text">
											<small class="text-muted">등록일 : <fmt:formatDate value="${cafeInfo.cafeRegDate }" pattern="yyyy-MM-dd" /></small>
										</p>
										<div class="btnDiv">
											<button type="button" class="btn btn-primary" onclick="location.href='/owner/goCafeInfoUpdate?cafeCode=${cafeInfo.cafeCode}';">정보수정</button>
											<button type="button" class="btn btn-danger" id="goDeleteCafe">폐업</button>
											<input type="hidden" value="${cafeInfo.cafeCode }"> 
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
	</c:choose>
</div>
</body>
</html>