<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>	
<body>

<div class="row">
	<div class="col text-center">
		<h1>SHOP</h1>
	</div>
</div>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<!--   <a class="navbar-brand" href="#">Navbar</a> -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/item/itemList">Home<span class="sr-only">(current)</span></a>
      </li>
<%--       <c:forEach items="${categoryList}" var="categoryInfo">
      	<li class="nav-item">
        	<a class="nav-link" href="#">${categoryInfo.categoryName }</a>
      	</li>
      </c:forEach> --%>
    </ul>
  </div>
</nav>
</body>
</html>