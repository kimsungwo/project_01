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
	text-align: center;
	background-color: #F2F2F2;
}
.form-control {
	border: none;
}
#selectMenuForm td{
	text-align: center;
	vertical-align: middle;
}
.modal-header{
	border: none;
}
.modal-footer{
	border: none;
	padding-top: 0px;
}
.menuImg{
	width: 100px;
}
.menuImgModal{
	width: 300px;
}
a{
	color: black;
}
a:hover{
	text-decoration: none;
	color: black;
}
.menuDetailModal th, .menuDetailModal td{
	vertical-align: middle;
}
.insertOptionBtn{
	display: inline-block;
}
.insertOptionDiv{
	padding-bottom: 10px;
}
#optionManageDiv{
	display: none;
}
.menuDetailModal tr:first-of-type td, .menuDetailModal tr:nth-of-type(2) th, .menuDetailModal tr:nth-of-type(2) td{
	border-top: none;
}
</style>
<script src="/resources/js/owner/menu_manage.js?ver=57" type="text/javascript"></script>
</head>
<body>
<div class="container">
	<h1>메뉴관리</h1>
	<p class="subMenuInfo">매장별로 메뉴 관리가 가능합니다.</p>
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
				</colgroup>
				<tbody id="selectCategoryForm">
				</tbody>
			</table>
		</div>
	</div>
	<div class="row justify-content-center">
		<div class="col">
			<table class="table table-bordered">
				<colgroup>
					<col width="15%">
					<col width="*%">
					<col width="12%">
					<col width="12%">
					<col width="12%">
				</colgroup>
				<tbody id="selectMenuForm">

				</tbody>
			</table>
			<div class="btnDiv text-right" id="optionManageDiv">
				<input type="button" class="btn btn-primary" id="optionManageBtn" value="옵션관리">
			</div>
		</div>
	</div>
</div>

<!-- 메뉴 상세정보 modal -->
<div class="modal fade" id="menuInfoDetail" tabindex="-1" aria-labelledby="menuInfoDetailLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="menuInfoDetailLabel">메뉴 상세정보</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<table class="table menuDetailModal">
					<colgroup>
						<col width="30%">
						<col width="20%">
						<col width="*%">
					</colgroup>
					<tr>
						<td rowspan="6">
							<img src="" class="menuImgModal" id="menuImg">
						</td>
					</tr>
					<tr>
						<th>메뉴명</th>
						<td>
							<input type="hidden" id="menuCode" name="menuCode">
							<input type="text" class="form-control" id="menuName" name="menuName">
						</td>
					</tr>
					<tr>
						<th>가격</th>
						<td><input type="text" class="form-control" id="menuPrice" name="menuPrice"></td>
					</tr>
					<tr>
						<th>카테고리</th>
						<td>
							<select class="form-control" id="menuCategoryCode" name="menuCategoryCode">
								
							</select>
						</td>
					</tr>
					<tr>
						<th>메뉴정보</th>
						<td><input type="text" class="form-control" id="menuInfo" name="menuInfo"></td>
					</tr>
					<tr>
						<th>판매상태</th>
						<td>
							<select class="form-control" id="menuStatus" name="menuStatus">
								<option value="0">판매중</option>
								<option value="1">판매준비</option>
								<option value="2">매진</option>
							</select>
						</td>
					</tr>
				</table>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
				<button type="button" class="btn btn-danger" id="deleteMenuBtn">삭제</button>
				<button type="button" class="btn btn-primary" id="updateMenuBtn">변경</button>
			</div>
		</div>
	</div>
</div>
</body>
</html>