<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
<style type="text/css">
.container{
	background-color: aqua;
	border: 1px solid black;
}
</style>
</head>
<body>
<div class="container">

	<div class="row">
		<div class="col">
			1 col
		</div>
		<div class="col">
			2 col
		</div>
	</div>
	<div class="row">
		<div class="col">
			1 col
		</div>
		<div class="col">
			2 col
		</div>
		<div class="col">
			3 col
		</div>
		<div class="col">
			4 col
		</div>
	</div>
	<div class="row">
		<div class="col-8">
			51111111111111
		</div>
		<div class="col-4">
			61111111111111
		</div>
	</div>
	<div class="row">
		<div class="col-4 offset-8">
			51111111111111
		</div>

	</div>
	<div class="row">
		<div class="col-2"> <!-- 12개영역중 앞두개씀 -->
			51111111111111
		</div>
		<div class="offset-2 col-4">  <!-- 2칸띄우고 4칸씀 -->
			51111111111111
		</div>

	</div>
</div>
</body>
</html>