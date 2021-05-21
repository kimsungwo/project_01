<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.aaa{
	background-color: #f8f9fa;
	border-radius: 10px;
	padding: 20px;
}
</style>
</head>
<body>
<div class="row justify-content-center">
<div class="col-8 aaa">
<form action="/admin/insertItem" method="post" enctype="multipart/form-data">
	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="categoryCode">카테고리</label> <!-- ID따라감 여기 for문은 -->
			<select class="form-control" id="categoryCode" name="categoryCode">
				<c:forEach items="${categoryList}" var="list">
				<option name="itemCode" value="${list.categoryCode}">${list.categoryName}</option>
				</c:forEach>
			</select>
	
		</div>
		<div class="form-group col-md-6">
			<label for="itemName">도서명</label> 
			<input type="text"class="form-control" id="itemName" name="itemName" >
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="itemPrice">가격</label> 
			<input type="text" class="form-control"id="itemPrice" name="itemPrice" >
		</div>
	</div>
	
	<div class="form-row">
		<label for="itemInfo">메인이미지</label> 
		<div class="input-group mb-3">
 			<div class="input-group-prepend">
  		 		<span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
 			</div>
  			<div class="custom-file">
  		    	<input type="file" name="mainImg" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
   			 	<label class="custom-file-label" for="inputGroupFile01">Choose file</label>
		  	</div>
		</div>
	</div>
	<div class="form-row">
		<label for="itemInfo">상세이미지</label> 
		<div class="input-group mb-3">
 			<div class="input-group-prepend">
  		 		<span class="input-group-text" id="inputGroupFileAddon02">Upload</span>
 			</div>
  			<div class="custom-file">
  		    	<input type="file" name="detailImg" class="custom-file-input" id="inputGroupFile02" aria-describedby="inputGroupFileAddon01">
   			 	<label class="custom-file-label" for="inputGroupFile02">Choose file</label>
		  	</div>
		</div>
	</div>
	
	<div class="form-row">
		<div class="form-group col-md-12">
			<label for="itemInfo">도서소개</label> 
			<textarea rows="3"  class="form-control" id="itemInfo" name="itemInfo" ></textarea>
		</div>
	</div>
	<button type="submit" class="btn btn-primary btn-block">상품등록</button>
</form>
</div>
</div>
</body>
</html>