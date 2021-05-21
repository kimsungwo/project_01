/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	
	/*
	$(document).on('click', '.codeBtn', function(){
		const ownerCode = $(this).attr('data-ownerCode');
		selectDetailOwnerInfo(ownerCode);
	})
	*/
	
	const preDate = $('#preDate').val();
	const nowDate = $('#nowDate').val();
	const searchText = '';
	selectMemberList(preDate, nowDate, searchText);
	
});

/* 함수선언 영역*/
(function($){
	
	/*codeBtn = function(){
		$('#reserveList').empty();
		cafeCode = $('#selectCafeList option:selected').val();
		selectDetailOwnerInfo(ownerCode);
	}*/
	
	searchMembers = function(){
		preDate = $('#preDate').val();
		nowDate = $('#nowDate').val();
		searchText = $('#searchText').val();
		memberType = $('#selectManageList option:selected').val();
		if(memberType == 'member'){
			selectMemberList(preDate, nowDate, searchText);
		}
		else if(memberType == 'owner'){
			selectOwnerList(preDate, nowDate, searchText);
		}
	}
	
	selectMemberList = function(preDate, nowDate, searchText){
		$.ajax({
            url: '/admin/selectMemberList', //요청경로
            type: 'post',
            data:{'preDate' : preDate, 'nowDate' : nowDate, 'memId' : searchText}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
               $('#memberManageTable').empty();
               if(result != ''){
            	   let str = '';
            	   $(result).each(function(i){
            		   str += '<tr>';
            		   str += '<td>' + result[i].memRegDate + '</td>';
            		   str += '<td><a href="#" data-toggle="modal" data-target="#memberDetail"';
            		   str += ' onclick="selectDetailMemberInfo(\'' + result[i].memCode + '\')\;" >' + result[i].memId + '</a>';
            		   str += '</td>';
            		   str += '</tr>';
            	   })
            	   $('#memberManageTable').append(str);
               }
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	selectOwnerList = function(preDate, nowDate, searchText){
		$.ajax({
            url: '/admin/selectOwnerList', //요청경로
            type: 'post',
            data:{'preDate' : preDate, 'nowDate' : nowDate, 'ownerId' : searchText}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
               $('#memberManageTable').empty();
               if(result != ''){
            	   let str = '';
            	   $(result).each(function(i){
            		   str += '<tr>';
            		   str += '<td>' + result[i].ownerRegDate + '</td>';
            		   str += '<td><a href="#" data-toggle="modal" data-target="#ownerDetail"';
            		   str += 'onclick="selectDetailOwnerInfo(\'' + result[i].ownerCode + '\')\;" >' + result[i].ownerId + '</a>';
            		   str += '</td>';
            		   str += '</tr>';
            	   })
            	   $('#memberManageTable').append(str);
               }
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	
	selectDetailOwnerInfo = function(ownerCode){//매개변수값으로 넘기면 그냥 가지고넘어감
		$.ajax({
            url: '/admin/selectOwnerDetail', //요청경로
            type: 'post',
            data:{'ownerCode' : ownerCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	$('.ownerId').text(result.ownerId);
            	$('.ownerTel').text(result.ownerTel);
            	$('.ownerEmail').text(result.ownerEmail);
            	$('.ownerAddr').text(result.ownerAddr);
            	if(result.ownerAddrDetail == ''){
            		$('.ownerAddrDetail').text('상세주소 미기재');
            	}
            	else{
            		$('.ownerAddrDetail').text(result.ownerAddrDetail);
            	}
            	if(result.ownerName == ''){
            		$('.ownerName').text('미입력');
            	}
            	else{
            		$('.ownerName').text(result.ownerName);
            	}
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
    	});
	}
	
	
	selectDetailMemberInfo = function(memCode){
    	$.ajax({
            url: '/admin/selectMemberDetail', //요청경로
            type: 'post',
            data:{'memCode' : memCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	$('.memId').text(result.memId);
            	$('.memTel').text(result.memTel);
            	$('.memEmail').text(result.memEmail);
            	$('.memAddr').text(result.memAddr);
            	if(result.memNickname == ''){
            		$('.memNickname').text('미입력');
            	}
            	else{
            		$('.memNickname').text(result.memNickname);
            	}
            	if(result.memAddrDetail == ''){
            		$('.memAddrDetail').text('상세주소 미기재');
            	}
            	else{
            		$('.memAddrDetail').text(result.memAddrDetail);
            	}
            	if(result.gradeName == ''){
            		$('.gradeName').text('(없음)');
            	}
            	else{
            		$('.gradeName').text(result.gradeName);
            	}
            	if(result.memPoint == ''){
            		$('.memPoint').text('0')+"포인트";
            	}
            	else{
            		$('.memPoint').text(result.memPoint)+"포인트";
            	}
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
    	});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	

	selectOrderList = function(cafeCode, preDate, nowDate){
    	$.ajax({
            url: '/owner/selectOrderList', //요청경로
            type: 'post',
            data:{'cafeCode' : cafeCode, 'preDate' : preDate, 'nowDate' : nowDate}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성\
            	let str = '';
            	if(result != ''){
            		$(result).each(function(i){
            			str += '<tr>';
            			str += '<td>' + result[i].buyDate + '</td>';
            			str += '<td><a href="#" onclick="selectDetailOrderInfo(\'' + result[i].buyCode + '\')" class="buyCode" data-toggle="modal" data-target="#orderDetail">' + result[i].buyCode +'</a></td>';
            			str += '<td>' + result[i].totalPrice.toLocaleString() + '원</td>';
            			str += '<td><input type="button" value="주문승인" class="btn btn-primary btn-sm orderAprBtn codeBtn" data-buyCode="' + result[i].buyCode + '" data-buyStatus="' + result[i].buyStatus + '" data-toggle="modal" data-target="#orderApr"></td>';
            			str += '<td><input type="button" value="주문취소" class="btn btn-danger btn-sm orderCancelBtn codeBtn" data-buyCode="' + result[i].buyCode + '" data-buyStatus="' + result[i].buyStatus + '" data-toggle="modal" data-target="#orderCancel"></td>';
            			str += '<td>' + result[i].buyStatusName + '</td>';
            			str += '</tr>';
            		})
            	}
            	else if(result == ''){
            		str += '<tr><td colspan="6">주문 내역이 없습니다</td></tr>';
            	}
            	$('#reserveList').append(str);
            	
            	$('.buyCode').each(function(){
            		const selectedTag = $(this);
            		renameOrderNames(selectedTag);
            	})
            	$('.orderAprBtn').each(function(){
					const buyStatus = $(this).attr('data-buyStatus');
					if(buyStatus == '2'){
						$(this).val('주문확정');
						$(this).removeClass('orderAprBtn');
						$(this).removeClass('btn-primary');
						$(this).removeAttr('data-toggle');
						$(this).removeAttr('data-target');
						$(this).addClass('orderPreparingBtn');
						$(this).addClass('btn-success');
					}
					else if(buyStatus == '3' || buyStatus == '0'){
						$(this).remove();
					}
				})
				$('.orderCancelBtn').each(function(){
					const buyStatus = $(this).attr('data-buyStatus');
					if(buyStatus == '3' || buyStatus == '0'){
						$(this).remove();
					}
				})
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
    }
	
	renameOrderNames = function(selectedTag){
		const buyCode = selectedTag.text();
		$.ajax({
            url: '/owner/renameOrderNames', //요청경로
            type: 'post',
            data:{'buyCode' : buyCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	let menuName = '';
            	if(result != null){
            		if(result.length > 1){
            			menuName += result[0].menuName + ' 외 ' + (result.length - 1) + '건';
            		}
            		else if(result.length == 1){
            			menuName += result[0].menuName;
            		}
            		selectedTag.text(menuName);
            	}
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	selectBuyDetailMenu = function(buyCode){
		$.ajax({
            url: '/buy/selectBuyDetailMenu', //요청경로
            type: 'post',
            data:{'buyCode' : buyCode}, //필요한 데이터
            success: function(result) {
               if(result != null){
            	   let str = '';
            	   $(result).each(function(i){
            		   str += '<div class="col-8 buyMenuName">' + result[i].menuName + ' x ' + result[i].buyQuantity + '</div>';
            		   str += '<div class="col-4 text-right"><span class="menuPriceModal">' + (result[i].menuPrice * result[i].buyQuantity).toLocaleString() +'</span>원</div>';
            		   str += '<div class="col-12"><div class="row menuOption" id="' + result[i].buyDetailCode + '"></div></div></div>'
            		   
            	   })
            	   $('.buyMenuDetail').append(str);
            	   $(result).each(function(i){
            		   selectBuyDetailMenuOption(buyCode, result[i].buyDetailCode);
            	   })
               }
               
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	selectBuyDetailMenuOption = function(buyCode, buyDetailCode){
		$.ajax({
            url: '/buy/selectBuyDetailMenuOption', //요청경로
            type: 'post',
            data:{'buyCode' : buyCode, 'buyDetailCode' : buyDetailCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	if(result != null){
            		let str = '';
            		$(result).each(function(i){
            			if(result[i].menuOptionCode != null){
            				str += '<div class="col-8">- ' + result[i].menuOptionGroupName;
            				if(result[i].menuOptionGroupType == 1){
            					str += ' 선택 : ';
            				}
            				else{
            					str += ' (추가) : ';
            				}
            				str += result[i].menuOptionName + '</div><div class="col-4 text-right"><span class="menuOptionPriceModal">' + (result[i].menuOptionPrice * result[i].buyQuantity).toLocaleString() +'</span>원</div>';
            			}
            		})
            		$('#' + buyDetailCode +'').append(str);
            	}
            	updateTotalPrice();
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	updateTotalPrice = function(){
		let menuPrice = 0;
		let menuOptionPrice = 0;
		$('.menuPriceModal').each(function(){
			menuPrice = parseInt(menuPrice) + parseInt($(this).text().replace(/,/g, ""));
		})
		$('.menuOptionPriceModal').each(function(){
			menuOptionPrice = parseInt(menuOptionPrice) + parseInt($(this).text().replace(/,/g, ""));
		})
		let totalPrice = parseInt(menuPrice) + parseInt(menuOptionPrice)
		$('.allPrice').text(totalPrice.toLocaleString() + '원');
	}
	
	selectBuyPoint = function(selectBuyPoint){
    	$.ajax({
            url: '/buy/selectBuyPoint', //요청경로
            type: 'post',
            data:{'buyCode' : buyCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	if(result != null){
            		$('.usedPoint').text(result.toLocaleString() + '원');
            	}
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

    }
	
	updateBuyStatus = function(buyCode, buyStatus, orderMessage){
		$.ajax({
            url: '/buy/updateBuyStatus', //요청경로
            type: 'post',
            data:{'buyCode' : buyCode, 'buyStatus' : buyStatus, 'orderMessage' : orderMessage}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
               if(result == '1'){
            	   if(buyStatus == '0'){
            		   alert('주문을 취소했습니다');
            		   pointRefund(buyCode);
            	   }
            	   else if(buyStatus == '2'){
            		   alert('주문을 승인했습니다');
            	   }
            	   else if(buyStatus == '3'){
            		   alert('주문을 완료했습니다');
            		   pointSave(buyCode);
            	   }
            	   searchDateBtn();
            	   $('#orderApr').modal('hide');
            	   $('#orderCancel').modal('hide');
               }
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
	
	}
	
	//취소시 포인트 환불
	pointRefund = function(buyCode){
		$.ajax({
            url: '/buy/pointRefund', //요청경로
            type: 'post',
            data:{'buyCode' : buyCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}

	//주문완료시 포인트 적립
	pointSave = function(buyCode){
		$.ajax({
            url: '/buy/pointSave', //요청경로
            type: 'post',
            data:{'buyCode' : buyCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
	}
	*/
		
})(jQuery);