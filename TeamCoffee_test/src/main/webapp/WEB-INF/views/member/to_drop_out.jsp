<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="/resources/js/member/to_drop_out.js?ver=05" type="text/javascript"></script>
<style type="text/css">
.container{
	width: 35rem;
}
</style>
</head>
<body>
	<div class="w3-content w3-container w3-margin-top container">
		<div class="w3-container w3-card-4">
			<form action="/member/toDropOut"  name="deleteform" id="deleteForm" method="post">
				<div class="w3-center w3-large w3-margin-top">
					<h3>회원 탈퇴</h3>
				</div>
				<div>
					<p>
						<label>비밀번호</label>
						<input class="w3-input password" type="password"  id="login_password" name="password" required>
						<input type="hidden" name="memCode" value="${memberInfo.memCode}"> 
					</p>
					<p class="w3-center">
						<button type="submit" id="deleteBtn" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round"  data-password="${memberInfo.memPw}">탈퇴하기</button>
						<button type="button" onclick="history.go(-1);" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round">Cancel</button>
					</p>
				</div>
			</form>
		</div>
	</div>
</body>
</html>

<%-- 
table{
	margin-left:auto; 
	margin-right:auto;
	border:3px solid gray;
	margin-bottom: 5rem;
}
td{
	border:1px solid skyblue
}

}
a{
	margin: 3rem;
	color: black;

}
</style>

</head>
<body>
<h1>회원탈퇴</h1>
    <form action="/member/toDropOut" name="deleteform" id="deleteForm" method="post">
        <table>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="password" class="password" id="login_password"></td>
            </tr>
        </table>
        
        
        <a type="button" class="btn btn-light" href="/cafe/main">취소</a>
        <a type="button" class="btn btn-light" id="deleteBtn"  data-password="${memberInfo.memPw}">탈퇴하기</a>
    </form>
</body> --%>