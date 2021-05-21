<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/admin/qna_admin.js?ver=18" type="text/javascript"></script>
<style type="text/css">
.table th{
	text-align: center;
}
.qnaTable{
	text-align: center;
}
.qnaTable td{
	vertical-align: middle;
}
.qnaTable tr:last-of-type td{
	border-bottom: 1px solid #dee2e6;
}
.qnaRegDate, .qnaMemberType{
	font-size: 0.95rem;
	color: #585858;
}
.qnaStatus{
	font-size: 0.95rem;
	font-weight: bold;
	color: red;
}
a{
	color: #212529;
}
a:hover{
	color: #212529;
	text-decoration: none;
}
</style>
</head>
<body>
<div class="container">
	<div class="row justify-content-center">
		<div class="col">
			<h1>Q/A</h1>
			<table class="table table-bordered">
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th scope="col">회원 타입</th>
						<td>
							<select class="form-control form-control-sm" id="selectMemberType">
								<option value="all">전체</option>
								<option value="member" >일반회원</option>
								<option value="owner">매장주</option>
							</select>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row justify-content-center">
		<div class="col">
			<table class="table qnaTable">
				<colgroup>
					<col width="20%">
					<col width="*">
					<col width="20%">
					<col width="20%">
				</colgroup>
				<thead>
					<tr>
						<th>상태</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody class="qnaList">
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>