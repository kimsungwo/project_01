<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/member/qna_member_form.js?ver=1" type="text/javascript"></script>
<style type="text/css">
.qnaTable td:first-of-type{
	text-align: center;
	vertical-align: middle;
}
.btnDiv{
	margin-top: 20px;
	text-align: right;
	margin-right: 20px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<form action="/member/qnaWrite" method="post" id="qnaForm">
				<table class="table qnaTable">
					<tbody>
						<tr>
							<td><input type="text" class="form-control" placeholder="제목을 입력해주세요" id="boardName" name="boardName"></td>
						</tr>
						<tr>
							<td>
								<textarea class="form-control" placeholder="내용을 입력해주세요" rows="15" id="boardContent" name="boardContent"></textarea>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="btnDiv">
					<button type="button" class="btn btn-primary" id="insertQnABtn">작성</button>
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>