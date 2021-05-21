<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/common/menu.js?ver=14" type="text/javascript">

</script>
</head>	
<body>
<div class="row"> 
	<c:choose>
		<c:when test="${empty sessionScope.loginInfo}">
			<div class="col-12 text-right" >
				<a href="#" data-toggle="modal" data-target="#loginModal">Login</a> / 
				<a href="/member/join">Join</a> 
			</div>
		</c:when>
		<c:otherwise>
			<div class="offset-9 col-3 text-right" >
				${sessionScope.loginInfo.name }님 반갑슴.
				MyPage
				<a href="#" onclick="logout();" id ="logout">LOGOUT</a>
			</div>
		</c:otherwise>
	</c:choose>

</div>
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
      <c:forEach items="${categoryList}" var="categoryInfo">
      	<li class="nav-item">
        	<a class="nav-link" href="#">${categoryInfo.categoryName }</a>
      	</li>
      </c:forEach>
      <c:if test="${not empty sessionScope.loginInfo and sessionScope.loginInfo.isAdmin eq 'Y' }">
      	<li class="nav-item">
          <a class="nav-link" href="/admin/categoryManage">관리자메뉴</a>
	    </li>
      </c:if>
    </ul>
  </div>
</nav>






<!-- Modal -->
<div class="modal fade" id="loginModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">LOGIN</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
	  	<form action="/member/login" method="post" id="loginForm">      
      <div class="aaa">
	<div class="form-row">
		<div class="form-group col-md-12">
			<label for="id">I.D.</label> 
			<input type="text" class="form-control"id="login_id" name="id">
		</div>
	</div>
      	<div class="form-row">
		<div class="form-group col-md-12">
			<label for="password">PASSWORD</label> 
			<input type="password" class="form-control"id="login_password" name="password">
		</div>
	</div>
      </div>
	 <button type="button" class="btn btn-primary btn-block" onclick="login();">L O G I N</button>
      	</form>
      </div>

    </div>
  </div>
</div>

</body>
</html>