<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.table th{
	background-color: #F2F2F2;
	text-align: center;
}
.form-control {
	border: none;
}
/* #radioDiv {
	margin-left: 1rem;
}
#radioDiv .form-check-label {
	font-size: 14px;
} */
.modal-header{
	border: none;
}
#categoryModal td{
	padding: 6px;
}
.cate-span{
	display: table-cell;
	vertical-align: middle;
	font-size: 0.8em;
}
h6{
	font-weight: bold;
}
</style>
<script src="/resources/js/owner/reg_menu.js?ver=67" type="text/javascript"></script>
</head>
<body>
<div class="container regMenuForm">
	<h1>메뉴등록</h1>
	<p class="subMenuInfo">메뉴를 등록 해 주세요.</p>
	<form action="/menu/insertMenu" method="post" enctype="multipart/form-data" id="insertMenuSubmit">
	<table class="table table-bordered">
		<colgroup>
			<col width="30%">
			<col width="*">
		</colgroup>
		<tbody>
			<tr>
				<th scope="col">매장명</th>
				<td>
					<select class="form-control form-control-sm" id="selectCafeList" name="cafeCode">
						<option value="">클릭하면 선택이 가능합니다</option>
						<c:forEach items="${selectCafeList }" var="cafeListInfo">
							<option value="${cafeListInfo.cafeCode }">${cafeListInfo.cafeName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</tbody>
	</table>
	<div class="row justify-content-center">
		<div class="col">
			<table class="table table-bordered">
				<colgroup>
					<col width="30%">
					<col width="*">
					<col width="5%">
				</colgroup>
				<tbody id="selectCategoryForm">
				</tbody>
			</table>
		</div>
	</div>
	<div class="row justify-content-center">
		<div class="col">
			<table class="table table-bordered">
				<col width="30%">
				<col width="*">
				<tbody id="insertMenuForm">
				</tbody>
			</table>
		</div>
	</div>
	<div class="row text-right insertMenuBtnDiv">
		<div class="col">
			<input type="button" value="등록" class="btn btn-primary" id="insertMenuBtn">
		</div>
	</div>
	</form>
</div>

<!-- 카테고리 추가 Model -->
<div class="modal fade" id="insertCategory" tabindex="-1"
	aria-labelledby="insertCategoryLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h6 class="modal-title" id="insertCategoryLabel"></h6><span class="cate-span">&nbsp;의 카테고리 추가</span>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<table class="table table-bordered">
					<colgroup>
						<col width="*">
						<col width="5%">
					</colgroup>
					<tr id="categoryModal">
						<td>
							<input type="text" class="form-control" name="categoryName" id="categoryName">
						</td>
						<td>
							<button type="button" class="btn btn-success btn-sm" id="insertCategoryBtn">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
								<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
								<path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
							</svg>
							</button>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>

</body>
</html>