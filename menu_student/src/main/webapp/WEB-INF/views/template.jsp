<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/common.css" rel="stylesheet">
<link href="/resources/css/template.css?ver=55" rel="stylesheet">
</head>
<body>
<div class="container" >
	<div class="menu">
		<jsp:include page="menu.jsp"/>
	</div><div class="sideMenu"><jsp:include page="${pageVO.sideMenu}.jsp"/>
	</div><div class="content"><jsp:include page="${pageVO.content}.jsp"/></div>
</div>
</body>
</html>