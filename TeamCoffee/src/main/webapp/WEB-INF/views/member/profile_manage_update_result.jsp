<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
					<h3>프로필 변경 완료</h3>
				</div>
				<div>
					<p>
						<label>회원정보 수정이 성공적으로 이루어졌습니다.</label>
					</p>
					<p class="w3-center">
							<button type="button" onclick="location.href='/cafe/main';" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round">메인페이지</button>
						</p>
				</div>
			</form>
		</div>
	</div>
</body>
</html>