<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title"/></title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">
.content{
	margin-top: 10px;
	margin-bottom: 20px;
}
</style>
</head>
<body>
<div class="container-fluid">
	<div id="menuDiv">
		<tiles:insertAttribute name="menu"/>
	</div>
	<div class="content">
		<tiles:insertAttribute name="body"/>
	</div>
</div>	
</body>
</html>


