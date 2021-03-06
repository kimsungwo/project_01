<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title"/></title>

<!-- 부트스트랩 css -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

<!-- 폰트 -->
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet" />

<style type="text/css">
.carousel-item img {
  width: 500px;
}
.logo h1 {
  font-family: 'Lobster', cursive;
}
.carousel {
  margin: 50px 0;
}
.card-deck{
	margin: 50px 0;
}
.carousel-control-prev-icon { 
	background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23000' viewBox='0 0 8 8'%3E%3Cpath d='M5.25 0l-4 4 4 4 1.5-1.5-2.5-2.5 2.5-2.5-1.5-1.5z'/%3E%3C/svg%3E"); 
} 
.carousel-control-next-icon { 
	background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23000' viewBox='0 0 8 8'%3E%3Cpath d='M2.75 0l-1.5 1.5 2.5 2.5-2.5 2.5 1.5 1.5 4-4-4-4z'/%3E%3C/svg%3E"); 
}
</style>

<!-- 부트스트랩 js -->
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
<script type="text/javascript">
//Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
	'use strict';
	window.addEventListener('load', function() {
		// Fetch all the forms we want to apply custom Bootstrap validation styles to
		var forms = document.getElementsByClassName('needs-validation');
		// Loop over them and prevent submission
		var validation = Array.prototype.filter.call(forms, function(form) {
			form.addEventListener('submit', function(event) {
				if (form.checkValidity() === false) {
					event.preventDefault();
					event.stopPropagation();
				}
				form.classList.add('was-validated');
			}, false);
		});
	}, false);
})();
</script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="/resources/css/common/common.css?ver=69" type="text/css">
</head>
<body>
<div class="container-fluid">
	<div class="menuDiv">
		<tiles:insertAttribute name="menu"/>
	</div>
	<div class="bodyDiv">
		<div class="row justify-content-center">
			<div class="col-10">
				<div class="row">
					<div class="col-2 offset-1">
						<div class="sideDiv">
							<tiles:insertAttribute name="side"/>
						</div>
					</div>
					<div class="col-8">
						<div class="mainDiv">
							<tiles:insertAttribute name="body"/>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>

<!-- 스크롤바 -->
<link rel="stylesheet" href="/resources/css/common/jquery.mCustomScrollbar.css" />
<script src="/resources/js/common/jquery.mCustomScrollbar.concat.min.js"></script>

</html>