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
.card-title{
   margin-bottom: 0px;
}
.card-text{
   margin-bottom: 5px;
}
.card-body{
   padding-bottom: 5px;
   padding-top: 5px;
}
.col{
   margin-bottom: 20px;
}

</style>
</head>
<body>
<div class="row row-cols-6">
	<c:forEach items="${itemList}" var="itemInfo">
	   <div class="col text-center">
    	  <div class="card" > 
        	<img src="/resources/image/${itemInfo.imgName}" class="card-img-top" alt="...">
	        <div class="card-body">
    	      <h5 class="card-title">${itemInfo.itemName}</h5>
        	  <p class="card-text"><fmt:formatNumber value="${itemInfo.itemPrice}" pattern="#,###"/>원</p>
          	<a href="/item/itemDetail?itemCode=${itemInfo.itemCode}" class="btn btn-primary btn-sm">상세보기</a>
       	 </div>
      	</div>
   	</div>
	</c:forEach>
</div>
</body>
</html>
