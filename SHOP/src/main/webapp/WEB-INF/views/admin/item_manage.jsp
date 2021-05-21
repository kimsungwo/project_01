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
.vertical-center td{
	vertical-align: middle;
}
</style>
<script src="/resources/js/admin/item_manage.js?ver=40" type="text/javascript"></script>
</head>
<body>
<div class="row justify-content-center">
	<div class="col">
		<div class="row">
			<div class="col">
					<ul class="nav nav-tabs" id="myTab" role="tablist">
						<li class="nav-item" role="presentation">
							<a	class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" 
								aria-controls="home" aria-selected="true">간편검색</a>
						</li>                                                                                            
						<li class="nav-item" role="presentation">
							<a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" 
								ria-controls="profile" aria-selected="false">상세검색</a></li>

					</ul>
					<div class="tab-content" id="myTabContent">
						<div class="tab-pane fade show active" id="home" role="tabpanel"
							aria-labelledby="home-tab">
							<form action="/admin/itemManage" method="post">  <!-- form태그로 검색창에서 검색함. -->
								<table class="table table-borderless table-sm">
									<tbody class="vertical-center">
										<tr>
											<td>
												<div>상품카테고리</div>
											</td>
											<td>
												<div>
													<select class="form-control" name="categoryCode">
														<option value="">ALL</option>
														<c:forEach items="${categoryList}" var="categoryInfo">
															<option value="${categoryInfo.categoryCode}">${categoryInfo.categoryName}</option>
														</c:forEach>
													</select>
												</div>
											</td>
											<td>
												<div>상품카테고리</div>
											</td>
											<td>
												<div>
													<input type="text" class="form-control" name="itemName">
												</div>
											</td>
											<td>
												<div>
													<input type="submit" class="btn btn-primary btn-block" value="검색">
												</div>
											</td>
										</tr>
									</tbody>
								</table>
							</form>
						</div>
						<div class="tab-pane fade" id="profile" role="tabpanel"
							aria-labelledby="profile-tab">
							<form action="/admin/itemManage" method="post">
								<table class="table table-borderless table-sm">
									<tbody class="vertical-center">
										<tr>
											<td>
												<div>상품카테고리</div>
											</td>
											<td>
												<div>
													<select class="form-control" name="categoryCode">
														<option value="">ALL</option>
														<c:forEach items="${categoryList}" var="categoryInfo">
															<option value="${categoryInfo.categoryCode}">${categoryInfo.categoryName}</option>
														</c:forEach>
													</select>
												</div>
											</td>
											<td>
												<div>상품카테고리</div>
											</td>
											<td>
												<div>
													<input type="text" class="form-control" name="itemName">
												</div>
											</td>
											<td>
												<div>
													<input type="submit" class="btn btn-primary btn-block" value="검색">
												</div>
											</td>
										<tr>
											<td>
												<div>상품 상태</div>
											</td>
											<td>
												<div class="form-check form-check-inline">
													<input name="itemStatuses" class="form-check-input" type="checkbox" id="inlineCheckbox1" value="0"  checked>
														 <label class="form-check-label" for="inlineCheckbox1">판매준비</label>
												</div>
												<div class="form-check form-check-inline">
													<input name="itemStatuses" class="form-check-input" type="checkbox" id="inlineCheckbox2" value="1" checked> 
														<label class="form-check-label" for="inlineCheckbox2">판매중</label>
												</div>
												<div class="form-check form-check-inline">
													<input name="itemStatuses" class="form-check-input" type="checkbox" id="inlineCheckbox3" value="2" checked> 
														<label class="form-check-label" for="inlineCheckbox3">매진</label>
												</div>
											</td>
											<td>
												<div>정 렬</div>
											</td>
											<td colspan="2">
												<div class="form-check form-check-inline">
													<input name="order" class="form-check-input" type="radio"  id="inlineRadio1" value="ITEM_NAME" checked> 
														<label class="form-check-label" for="inlineRadio1">상품명순</label>
												</div>
												<div class="form-check form-check-inline">
													<input name="order" class="form-check-input" type="radio" id="inlineRadio2" value="ITEM_STOCK"> 
														<label class="form-check-label" for="inlineRadio2">재고순</label>
												</div>
												<div class="form-check form-check-inline">
													<input name="order" class="form-check-input" type="radio" id="inlineRadio3" value="ITEM_PRICE"> 
														<label class="form-check-label" for="inlineRadio3">가격순</label>
												</div>
												
												
												<div class="form-check form-check-inline">
													<input name="sort" class="form-check-input" type="radio" id="inlineRadio4" value="ASC" checked> 
														<label class="form-check-label" for="inlineRadio4">오름차순</label>
												</div>
												<div class="form-check form-check-inline">
													<input name="sort" class="form-check-input" type="radio" id="inlineRadio5" value="DESC"> 
														<label class="form-check-label" for="inlineRadio5">내림차순</label>
												</div>
											</td>
										</tr>
									</tbody>
								</table>
							</form>
						</div>
					</div>
				</div>
		</div>
		<div class="row">
				<div class="col">
					<div class="row">
						<div class="col">
							<table class="table table-striped table-hover">
							<colgroup>
								<col width="5%">
								<col width="20%">
								<col width="20%">
								<col width="20%">
								<col width="15%">
								<col width="20%">
							</colgroup>
								<thead>
									<tr class="bg-primary">
										<th scope="col">No</th>
										<th scope="col">상품이미지</th>
										<th scope="col">상품명</th>
										<th scope="col">가격</th>
										<th scope="col">재고</th>
										<th scope="col">상품상태</th>
									</tr>
								</thead>
								<tbody class="vertical-center">
									<c:forEach items="${selectSalesList}" var="salesInfo" varStatus="status">
										<tr>
											<td>${selectSalesList.size()-status.index}</td>

											<td><img src="/resources/image/${salesInfo.imgName}"
												width="25%;"></td>
											<td>${salesInfo.itemName}</td>
											<td>
												<div class="form-row">

													<input type="text" class="form-control col-7 priceRefresh" 
														value='<fmt:formatNumber value="${salesInfo.itemPrice}" pattern="#,##0"/>'>
													<input type="button" class="btn btn-success btn-sm offset-1 col-2 updatePriceBtn" 
														value="변경" data-itemCode="${salesInfo.itemCode }" >
												</div>
											</td>
											<td>
												<div class="form-row">
													<input type="number" class="form-control col-4" value="${salesInfo.itemStock}"> 
													<input type="button" class="btn btn-success btn-sm offset-1 col-2" 
														value="변경" onclick="updateItemStock(this,'${salesInfo.itemCode}');"> 
														<!--위에꺼 매개변수를 던져줘야 선언영역에서 쓸수있다. -->
												</div>		<!--위에꺼 매개변수 여러개 보낼수있고	문자타입을 던져줄땐 ''써야됨 -->
											</td>
											<td>
												<select class="form-control updateItemStatus"
													 data-itemStock="${salesInfo.itemStock}" data-itemCode="${salesInfo.itemCode}">
													<option <c:if test="${salesInfo.itemStatus eq 0}">selected</c:if> value ="0">판매준비</option>
													<option <c:if test="${salesInfo.itemStatus eq 1}">selected</c:if> value ="1">판매중</option>
													<option <c:if test="${salesInfo.itemStatus eq 2}">selected</c:if> value ="2">완판</option>
													<option <c:if test="${salesInfo.itemStatus eq 3}">selected</c:if> value ="3">절판</option>
												</select>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
	</div>
</div>
</body>
</html>