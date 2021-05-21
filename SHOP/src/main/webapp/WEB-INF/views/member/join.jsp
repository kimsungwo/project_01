<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script src="/resources/js/member/join.js?ver=30"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/common/jquery.validate.js?ver=02" type="text/javascript"></script>
</head>
<body>
<div class="row justify-content-center">
<div class="col-4 aaa">
<form action="/member/join" method="post" id="joinForm">
	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="id">I.D.</label> 
			<input type="text" class="form-control"id="id" name="id" >
		</div>
		<div class="form-group col-md-6">
			<label for="name">NAME</label> 
			<input type="text"class="form-control" id="name" name="name">
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-12">
			<label for="password">PASSWORD</label> 
			<input type="password" class="form-control"id="password" name="password">
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-12">
			<label for="confirm_pw">CONFIRM PASSWORD</label> 
			<input type="password" class="form-control"id="confirm_pw">
		</div>
	</div>
	<div class="form-row align-items-end" >
		<div class="form-group col-md-4">
			<label for="tel1">TEL</label>
			<select class="form-control" id="tel1" name="tels">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
			</select>
		</div>
		<div class="form-group col-md-4">
			<input type="text" class="form-control" name="tels" id="tel2">
		</div>
		<div class="form-group col-md-4">
			<input type="text" class="form-control" name="tels" id="tel3">
		</div>
	</div>
	<div class="form-row align-items-end">
		<div class="form-group col-md-8">
			<label for="addr">ADDRESS</label> 
			<input type="text" class="form-control"id="addr" name="addr" readonly onclick="openPostCode();">
		</div>
		<div class="form-group col-md-4">
			<input type="button" class="form-control btn btn-primary" value="주소검색" onclick="openPostCode();">
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-12">
			<label for="addrDetail">DETAIL ADDRESS</label> 
			<input type="text" class="form-control"id="addrDetail" name="addrDetail">
		</div>
	</div>
	<div class="form-row align-items-end">
		<div class="form-group col-md-6">
			<label for="email">EMAIL</label> 
			<input type="text" class="form-control"id="email" name="emails">
		</div>
		<div class="form-group col-md-6">
			<div class="input-group">
 				 <div class="input-group-prepend">
    				<span class="input-group-text" id="basic-addon1">@</span>
 				 </div>
  				 <input type="text" class="form-control" aria-describedby="basic-addon1" name="emails">
			</div>
		</div>
	</div>
	
	
	<div class="form-row">
		<label for="email">GENDER</label> 
		<div class="form-group col-md-12">
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="M" checked>
 				 <label class="form-check-label" for="inlineRadio1">남</label>
			</div>
			<div class="form-check form-check-inline">
  				<input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="F">
  				<label class="form-check-label" for="inlineRadio2">녀</label>
			</div>
		</div>
	</div>	



  <button type="submit" class="btn btn-primary btn-block">Join</button>
</form>
</div>
</div>
</body>
</html>