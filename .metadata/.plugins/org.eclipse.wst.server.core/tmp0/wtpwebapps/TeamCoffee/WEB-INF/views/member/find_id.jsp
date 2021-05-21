<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/member/find_id.js?ver=08" type="text/javascript"></script>
<style type="text/css">
.container{
	width: 35rem;
}
</style>
</head>
	<div class="container">
		<h1>아이디 찾기[일반회원]</h1>
		<p class="subMenuInfo">회원가입시 입력한 이메일을 입력해주세요.</p>
			<form action="/member/find_id" method="post" id="find_id">
			<table class="table profileTable findTable">
				<colgroup>
					<col width="18%">
				</colgroup>
				<tr>
					<td>
						EMAIL
					</td>
					<td>
						<input class="form-control" type="text" id="email" name="memEmail" required>
					</td>
				</tr>
			</table>
			<div class="findBtnDiv">
				<button type="button" id="findBtn" class="btn btn-primary">F I N D</button>
			</div>
		</form>
	</div>
</body>



</html>