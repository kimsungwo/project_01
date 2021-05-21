<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.btnDiv{
	margin-bottom: 10px;
	
}
.bg-primary{
	color:white;
}
.table{
	text-align: center;
}
</style>
<script src="/resources/js/admin/category_manage.js?ver=06" type="text/javascript"></script>
</head>
<body>
<div class="row justify-content-center">
<div class="col-9">
<form action="/admin/insertCategory" method="post">
<div class = "row btnDiv">
	<div class="col text-right">
		<input type="submit" class="btn btn-primary" value="츄가" >
	</div>
</div>

<div class = "row">
	<div class="input-group mb-3">
		<div class="input-group-prepend">
    		<span class="input-group-text" id="basic-addon3">카테고리명</span>
   		 </div>
  		<input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3" name="categoryName">
	</div>

	<div class="col">
	
	</div>
</div>
</form>
<div class="row">
	<div class="col">
		<table class="table table-striped table-hover">
  			<thead>
			    <tr class="bg-primary">
  			 		<th scope="col">No</th>
   				    <th scope="col">카테고리 코드</th>
  				    <th scope="col">카테고리명</th>
  				    <th scope="col"></th>
  				 </tr>
 			</thead>
  			<tbody>
  				<c:forEach items="${categoryList}" var="List" varStatus="status">
  				<tr>
   			    	<td>${status.count}</td>
   			    	<td>${List.categoryCode}</td>
    			    <td>${List.categoryName}</td>
    			    <td><input type="button" class="btn btn-success btn-sm delete" value="삭제" onclick="deleteCategory('${List.categoryCode}');"></td>
  				</tr>
  				</c:forEach>
 				 </tbody>
			</table>
		</div>
	</div>
</div>
</div>
</body>
</html>