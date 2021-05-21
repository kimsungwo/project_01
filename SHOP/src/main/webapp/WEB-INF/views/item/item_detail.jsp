<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.sumary{
   border-top: 1px solid #dddddd;
   border-bottom: 1px solid #dddddd;
   padding-top: 10px;
   padding-bottom: 10px;
}
</style>
<script src="/resources/js/item/item_detail.js?ver=04" type="text/javascript"></script>
</head>
<body>
<form action="/item/buyInfo" method="post" id="itemDetailForm">
<input type="hidden" value="${detailList[0].itemName}" name="itemName">
<input  type="hidden" value="${detailList[0].categoryName}" name="categoryName">
<input  type="hidden" value="${detailList[0].itemPrice}" name="itemPrice">
<input  type="hidden" value="${detailList[0].itemCode}" name="itemCode">
<div class="row justify-content-center">
   <div class="col-10">
      <div class="row sumary">
         <div class="col-5 text-center">
            <img alt="" class="img-thumbnail" width="100%" src="/resources/image/${detailList[0].imgName}">
         </div>
         <div class="col-7">
            <div class="row" style="margin-bottom: 20px; margin-top: 10px;">
               <div class="col" style="font-size: 24px; font-weight: bold;">	
                  상품명 : ${detailList[0].itemName} <br>
                   상품상태 :  ${detailList[0].itemStatus}
               </div>
            </div>
            <div class="row" style="margin-bottom: 15px;">
               <div class="col-5">
                  도서 카테고리
               </div>
               <div class="col-7">
                  ${detailList[0].categoryName}
               </div>
            </div>
            <div class="row" style="margin-bottom: 15px;">
               <div class="col-5">
                  판매가
               </div>
               <div class="col-7">
                  <fmt:formatNumber value="${detailList[0].itemPrice}" pattern="#,###"/>원
               </div>
            </div>
            <div class="row" style="margin-bottom: 15px;">
               <div class="col-5">
                  상품소개
               </div>
               <div class="col-7">
                  ${detailList[0].itemInfo}
               </div>
            </div>
            <div class="row" style="margin-bottom: 15px;">
               <div class="col-5">
                  남은수량
               </div>
               <div class="col-7" id ="itemStockDiv">
                  ${detailList[0].itemStock}
               </div>
            </div>
            <div class="row form-group align-items-center" style="margin-bottom: 30px;">
               <div class="col-5">
                  구매수량
               </div>
               <div class="col-7">
                  <input type="number" class="form-control" id="buyQuantity" name="buyQuantity" value="1" min="1" max="${detailList[0].itemStock}">
               </div>
            </div>
            <div class="row" style="margin-bottom: 15px;">
               <div class="col">
                  <button type="button" class="btn btn-success btn-block" onclick="goBuyInfo('${sessionScope.loginInfo.id}');">
                     <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bag" viewBox="0 0 16 16">
                       <path d="M8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5h12v9a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V5z"/>
                     </svg>
                     바로구매
                  </button>
               </div>
               <div class="col">
                  <button type="button" class="btn btn-warning btn-block">
                     <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-basket3" viewBox="0 0 16 16">
                       <path d="M5.757 1.071a.5.5 0 0 1 .172.686L3.383 6h9.234L10.07 1.757a.5.5 0 1 1 .858-.514L13.783 6H15.5a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5H.5a.5.5 0 0 1-.5-.5v-1A.5.5 0 0 1 .5 6h1.717L5.07 1.243a.5.5 0 0 1 .686-.172zM3.394 15l-1.48-6h-.97l1.525 6.426a.75.75 0 0 0 .729.574h9.606a.75.75 0 0 0 .73-.574L15.056 9h-.972l-1.479 6h-9.21z"/>
                     </svg>
                     장바구니에 담기
                  </button>
               </div>
            </div>
         </div>
      </div>
      <div class="row">
         <div class="col"  style="margin-top: 10px;">
            <img alt="" class="img-thumbnail" width="100%" src="/resources/image/${detailList[1].imgName}">
         </div>
      </div>
   </div>
</div>
</form>
</body>
</html>