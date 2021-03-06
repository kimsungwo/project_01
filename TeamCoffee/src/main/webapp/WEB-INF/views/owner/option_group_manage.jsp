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
	color: #212529;
}
.form-control {
	border: none;
}
.modal-header{
	border: none;
}
.optionList{
	font-size: 0.9rem;
	color: #585858;
}
</style>
<script src="/resources/js/owner/option_group_manage.js?ver=28" type="text/javascript"></script>
</head>
<body>
<div class="container">
	<h1>옵션그룹관리</h1>
	<p class="subMenuInfo">옵션그룹을 추가해서 등록 및 편집이 가능합니다</p>
	<p class="subMenuInfo">현재 선택된 매장은 <span>${cafeInfo.cafeName }</span>입니다</p>
	<div class="row justify-content-center">
		<div class="col-10">
			<div class="btnDiv text-right">
				<input type="button" class="btn btn-secondary btn-sm" value="뒤로가기" onclick="history.back();">
				<input type="button" class="btn btn-primary btn-sm" value="옵션그룹 추가" data-toggle="modal" data-target="#insertOptionGroup">
			</div>
			<table class="table table-bordered">
				<colgroup>
					<col width="*%">
					<col width="8%">
				</colgroup>
				<tbody id="selectOptionList">
					<c:choose>
						<c:when test="${not empty optionGroupList }">
							<c:forEach items="${optionGroupList }" var="optionGroupInfo">
								<tr>
									<td>
										<h3><a href="/owner/optionManage?menuOptionGroupCode=${optionGroupInfo.menuOptionGroupCode }">${optionGroupInfo.menuOptionGroupName }</a></h3>
										<h6 class="optionList" data-menuOptionGroupCode="${optionGroupInfo.menuOptionGroupCode }"></h6>
										<h5 class="menuList" data-menuOptionGroupCode="${optionGroupInfo.menuOptionGroupCode }"></h5>
									</td>
									<td class="text-center">
										<input type="button" value="삭제" class="btn btn-danger btn-sm deleteOptionGroupBtn" data-menuOptionGroupCode="${optionGroupInfo.menuOptionGroupCode }">
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr class="text-center">
								<td colspan="2">등록된 옵션그룹이 없습니다</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
</div>

<!-- 옵션그룹 추가 modal -->
<div class="modal fade" id="insertOptionGroup" tabindex="-1"
	aria-labelledby="insertOptionGroupLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="insertOptionGroupLabel">옵션그룹 추가</h5>
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
							<input type="text" class="form-control" name="menuOptionGroupName" id="menuOptionGroupName">
						</td>
						<td>
							<button type="button" class="btn btn-success btn-sm" id="insertOptionGroupBtn" data-cafeCode="${cafeInfo.cafeCode }">
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