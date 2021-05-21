<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
   width: 600px;
   text-align: center;
   border: 1px solid black;
   border-collapse: collapse;
   margin: 0 auto;
}
tr, td{
   border: 1px solid black;
   padding: 5px;
}
.title{
   font-weight: bold;
   background-color: #eeeeee;
}
#btnDiv{
   text-align: center;
   margin-top: 20px;
}
input[type="button"]{
   width: 80px;
}
</style>
</head>
<body>
<div>
   <div style="height: 30px;"></div>
   <table>
      <colgroup>
         <col width="20%">
         <col width="30%">
         <col width="20%">
         <col width="30%">
      </colgroup>
      <tr>
         <td class="title">글 번호</td>
         <td>${board.boardNum}</td>
         <td class="title">조회수</td>
         <td>${board.readCnt}</td>
      </tr>
      <tr>
         <td class="title">작성자</td>
         <td>${board.memberId}</td>
         <td class="title">작성일</td>
         <td>${board.createDate}</td>
      </tr>
      <tr>
         <td class="title">제 목</td>
         <td colspan="3">${board.title}</td>
      </tr>
      <tr height="200px;">
         <td class="title">내 용</td>
         <td colspan="3">${board.content}</td>
      </tr>
      <tr>
         <td class="title">첨부파일</td>
         <td colspan="3">${board.fileName}</td>
      </tr>
   </table>
   <div id="btnDiv">
      <input type="button" value="목록가기" onclick="location.href='boardlist.bo'">
      <input type="button" value="수 정" onclick="location.href='updateForm.bo?boardNum=${board.boardNum}'" >
      <input type="button" value="削猘" onclick="location.href='delete.bo?boardNum=${board.boardNum}'">
   </div>
</div>
</body>
</html>


