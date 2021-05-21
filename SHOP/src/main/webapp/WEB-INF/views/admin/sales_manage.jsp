<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.bg-primary{
	color:white;
}
.table{
	text-align: center;
}
</style>

</head>
<body>
	<div class="row justify-content-center">
		<div class="col-10">
			<div class="row">검색 조건</div>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="collapse navbar-collapse">
					<form class="d-flex row justify-content-center" action="/admin/salesManage" method="post">
						<input type="date" class="mr-3 col-3" value="${buyViewVO.fromDate}" name="fromDate" />
						 ~ 
						 <input type="date" class="mr-3 col-3" value="${buyViewVO.toDate}" name="toDate" />
							<br>
						<button class="btn btn-outline-success" type="submit">Search</button>
						<div class="input-group mb-2">
							<input type="text" name="buyer" class="form-control" placeholder="ID로 검색" aria-label="Recipient's username" aria-describedby="button-addon2">
							<div class="input-group-append"></div>
						</div>
						<!-- 			<div class="input-group mb-2">
  							<input type="text" class="form-control" placeholder="이름으로 검색" aria-label="Recipient's username" aria-describedby="button-addon2">
  							<div class="input-group-append">
    							<button class="btn btn-outline-secondary" type="button" id="button-addon2">검색</button>
  							</div>
						</div> -->
					</form>
				</div>
			</nav>
			<div class="row">
				<div class="col text-right">
					${buyViewVO.fromDate} ~ ${buyViewVO.toDate}의 총 매출액은 
						<span id="totalPriceSpan" style="color: red; font-size: 1.2rem; font-weight: bold; font-style: italic;">
						</span> 
						입니다.
				</div>
			</div>
			<div class="row">
				<table class="table table-striped table-hover">
					<thead>
						<tr class="bg-primary">
							<th scope="col">No</th>
							<th scope="col">구매번호</th>
							<th scope="col">매출액</th>
							<th scope="col">구매자</th>
							<th scope="col">구매일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${buyLog}" var="log" varStatus="status">
							<tr>
								<td>${buyLog.size() - status.index}</td>
								<td>${log.buyCode}</td>
								<td><span class="salesSpan"> <fmt:formatNumber value="${log.totalPrice}" pattern="#,###" /></span></td>
								<td>${log.buyer}( ${log.name} ) 고객님</td>
								<td>${log.buyDate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-6"></div>
		<div class="col-6">
			<!-- col은 기본값이 12라 행에서 col-12를 오버하면 다음행으로 넘어가버림 -->
		</div>
	</div>
	<script src="/resources/js/admin/sales_manage.js?ver=24" type="text/javascript"></script>
</body>
</html>