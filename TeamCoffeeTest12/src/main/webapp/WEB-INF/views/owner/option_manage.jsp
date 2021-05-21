<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a{
	color: black;
}
a:hover{
	text-decoration: none;
	color: black;
}
#selectOptionList td{
	vertical-align: middle;
}
.btnDiv{
	padding-bottom: 10px;
}
span {
	font-size: 1.2em;
	font-weight: bold;
}
.modal-header{
	border: none;
	padding-bottom: 0px;
}
.modal-footer{
	border: none;
}
.table td{
	border-top: none;
}
</style>
<script src="/resources/js/owner/option_manage.js?ver=49" type="text/javascript"></script>
</head>
<body>
<div class="container">
	<h1>옵션관리</h1>
	<p>옵션을 추가해서 등록 및 편집이 가능합니다</p>
	<p>현재 선택된 옵션그룹은 <span>${optionGroupType.menuOptionGroupName }</span>입니다</p>
	<div class="row justify-content-center">
		<div class="col-10">
			<div class="row">
				<div class="col-6">
					<div class="custom-control custom-switch">
						<input type="checkbox" class="custom-control-input" id="meunOptionGroupType" name="meunOptionGroupType" <c:if test="${optionGroupType.menuOptionGroupType == 1}">checked</c:if> data-menuOptionGroupCode="${menuOptionVO.menuOptionGroupCode }" >
						<label class="custom-control-label" for="meunOptionGroupType">필수/선택 설정</label>
					</div>
				</div>
				<div class="col-4 offset-2">
					<div class="btnDiv text-right">
						<input type="button" class="btn btn-secondary btn-sm" value="뒤로가기" onclick="history.back();">
						<input type="button" class="btn btn-primary btn-sm" value="옵션 추가" data-toggle="modal" data-target="#insertOption">
					</div>
				</div>
			</div>
			<table class="table table-bordered">
				<tr>
					<td>
						<h4>
							연결메뉴
							<a href="#" onclick="selectGroupMenuList('${menuOptionVO.menuOptionGroupCode}')" data-toggle="modal" data-target="#insertLinkMenu">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
									<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
									<path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
								</svg>
							</a>
							<a href="#" onclick="selectLinkedMenuList('${menuOptionVO.menuOptionGroupCode}')" data-toggle="modal" data-target="#deleteLinkMenu">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
									<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
									<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
								</svg>
							</a>
						</h4>
						<h6 id="linkedMenuList">
						</h6>
					</td>
				</tr>
			</table>
			<table class="table table-bordered">
				<colgroup>
					<col width="*%">
					<col width="8%">
				</colgroup>
				<tbody id="selectOptionList">
					<c:choose>
						<c:when test="${not empty optionList }">
							<c:forEach items="${optionList }" var="optionInfo">
								<tr>
									<td>
										<h5>${optionInfo.menuOptionName }</h5>
										<h6>${optionInfo.menuOptionPrice }원</h6>
									</td>
									<td class="text-center">
										<input type="button" value="삭제" class="btn btn-danger btn-sm deleteOptionBtn" data-menuOptionCode="${optionInfo.menuOptionCode }">
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr class="text-center">
								<td colspan="2">등록된 옵션이 없습니다</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
</div>

<!-- 옵션 추가 modal -->
<div class="modal fade" id="insertOption" tabindex="-1"
	aria-labelledby="insertOptionLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="insertOptionLabel">옵션 추가</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<table class="table">
					<tr>
						<td>
							 <label for="menuOptionName">옵션명</label>
							<input type="text" class="form-control" name="menuOptionName" id="menuOptionName">
						</td>
					</tr>
					<tr>
						<td>
							 <label for="menuOptionPrice">가격</label>
							<input type="text" class="form-control" name="menuOptionPrice" id="menuOptionPrice">
						</td>
					</tr>
				</table>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn-block insertOptionBtn" data-menuOptionGroupCode="${menuOptionVO.menuOptionGroupCode }">추가</button>
			</div>
		</div>
	</div>
</div>

<!-- 연결메뉴 추가 modal -->
<div class="modal fade" id="insertLinkMenu" tabindex="-1"
	aria-labelledby="insertLinkMenuLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="insertLinkMenuLabel">연결메뉴 추가</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<table class="table table-bordered">
					<colgroup>
						<col width="*">
						<col width="15%">
					</colgroup>
					<tbody id="insertMenuList">
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<!-- 연결메뉴 삭제 modal -->
<div class="modal fade" id="deleteLinkMenu" tabindex="-1"
	aria-labelledby="deleteLinkMenuLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="deleteLinkMenuLabel">연결메뉴 삭제</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<table class="table table-bordered">
					<colgroup>
						<col width="*">
						<col width="15%">
					</colgroup>
					<tbody id="deleteMenuList">
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

</body>
</html>