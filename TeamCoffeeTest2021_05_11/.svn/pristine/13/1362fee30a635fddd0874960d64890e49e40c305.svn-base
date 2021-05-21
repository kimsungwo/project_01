/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	$(document).on('click', '.stockPlus', function(){
		const menuPrice = parseInt($('#menuPrice').text());
		let buyQuantity = parseInt($('#buyQuantity').val());
		buyQuantity = buyQuantity + 1;
		$('#buyQuantity').val(buyQuantity);
		let option = 0;
		$('input[class=custom-control-input]:checked').each(function(){
			option = parseInt(option) + parseInt($(this).attr('data-optionPrice'));
		})
		let totalPrice = (menuPrice + option) * buyQuantity;
		$('.totalPrice').text(totalPrice);
		$('#hiddenTp').val(totalPrice);
	});
	
	$(document).on('click', '.stockMinus', function(){
		const menuPrice = parseInt($('#menuPrice').text());
		let buyQuantity = parseInt($('#buyQuantity').val());
		if(buyQuantity == 1){
			alert('1개 이상 선택해주세요');
			return;
		}
		buyQuantity = buyQuantity - 1;
		$('#buyQuantity').val(buyQuantity);
		let option = 0;
		$('input[class=custom-control-input]:checked').each(function(){
			option = parseInt(option) + parseInt($(this).attr('data-optionPrice'));
		})
		let totalPrice = (menuPrice + option) * buyQuantity;
		$('.totalPrice').text(totalPrice);
		$('#hiddenTp').val(totalPrice);
		
	});
	
	$('#menuInfoModal').on('hidden.bs.modal', function (event) {
		$('.menuOptionList').empty();
		$('#buyQuantity').val(1);
	});
	
	$(document).on('change', '.custom-control-input', function(){
		const menuPrice = parseInt($('#menuPrice').text());
		let buyQuantity = parseInt($('#buyQuantity').val());
		let option = 0;
		$('input[class=custom-control-input]:checked').each(function(){
			option = parseInt(option) + parseInt($(this).attr('data-optionPrice'));
		})
		let totalPrice = (menuPrice + option) * buyQuantity;
		$('.totalPrice').text(totalPrice);
		$('#hiddenTp').val(totalPrice);
	})
	
	$(document).on('change', '#buyQuantity', function(){
		if($('#buyQuantity').val() >= 2){
			$('.stockMinus').attr('disable', false);
		}
	});
	
	$(document).on('click', '#insertCartBtn', function(){
		const menuCode = $('#menuCode').val();
		const buyQuantity = $('#buyQuantity').val();
		let requiredOptions = [];
		let selectionOptions = [];
		const cartPrice = $('#hiddenTp').val();
		$('input[class=custom-control-input]:checked').each(function(){
			if($(this).attr('type') == 'radio'){
				requiredOptions.push($(this).val());
				$(this).attr('name', 'requiredOptions');
			}
			else if($(this).attr('type') == 'checkbox'){
				selectionOptions.push($(this).val());
				$(this).attr('name', 'selectionOptions');
			}
		})
		const isBuy = false;
		isOverlabCart(menuCode, buyQuantity, requiredOptions, selectionOptions, cartPrice, isBuy);
		
	})
	
	$(document).on('click', '#buyFormBtn', function(){
		const menuCode = $('#menuCode').val();
		const buyQuantity = $('#buyQuantity').val();
		let requiredOptions = [];
		let selectionOptions = [];
		const cartPrice = $('#hiddenTp').val();
		$('input[class=custom-control-input]:checked').each(function(){
			if($(this).attr('type') == 'radio'){
				requiredOptions.push($(this).val());
				$(this).attr('name', 'requiredOptions');
			}
			else if($(this).attr('type') == 'checkbox'){
				selectionOptions.push($(this).val());
				$(this).attr('name', 'selectionOptions');
			}
		})
		const isBuy = true;
		isOverlabCart(menuCode, buyQuantity, requiredOptions, selectionOptions, cartPrice, isBuy);
	})
	
});

/* 함수선언 영역*/
(function($){
	menuInfoModal = function(menuCode) {
		$.ajax({
            url: '/cafe/selectMenuDetail', //요청경로
            type: 'post',
            data:{'menuCode' : menuCode }, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            $('#menuImgName').attr('src', '/resources/img/' + result.menuImgName);
            $('#menuName').text(result.menuName);
            $('#cafeCode').val(result.cafeCode);
            $('#menuCode').val(result.menuCode);
            $('#menuInfo').text(result.menuInfo);
            $('#menuPrice').text(result.menuPrice);
            $('.totalPrice').text(result.menuPrice);
            $('#hiddenTp').val(result.menuPrice);
            menuOptionGroupInfoModal(menuCode);
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
	}
	
	menuOptionGroupInfoModal = function(menuCode){
    	$.ajax({
            url: '/cafe/selectMenuOptionDetail', //요청경로
            type: 'post',
            data:{'menuCode' : menuCode }, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	let str = '';
            	if(result != null){
            		$(result).each(function(i){
            			str += '<hr>';
            			str += '<h6>' + result[i].menuOptionGroupName;
            			if(result[i].menuOptionGroupType == 1){
            				str += '<span class="requiredOption">(필수 선택)</span></h6>';
            				str += '<div id="requiredOptionGroup' + i + '"></div>';
            			}
            			else{
            				str += '<span>(추가선택 가능)</span></h6>';
            				str += '<div id="selectedOptionGroup' + i + '"></div>';
            			}
            			
            		})
            		$('.menuOptionList').append(str);
            		let num = 0;
            		$(result).each(function(i){
            			menuOptionListInfoModal(result[i].menuOptionGroupCode, num);
            			num++;
            		})
            	}
            	
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
    }
	
    menuOptionListInfoModal = function(menuOptionGroupCode, num){
    	$.ajax({
            url: '/cafe/selectMenuOptions', //요청경로
            type: 'post',
            data:{'menuOptionGroupCode' : menuOptionGroupCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	
              if(result != null){
            	  let str = '';
            	  //옵션 리스트 태그 생성
            	   $(result).each(function(i){
            		   //필수 옵션그룹의 옵션들
            		   if(result[i].menuOptionGroupType == 1){
            			   str += '<div class="custom-control custom-radio">';
            			   str += '<input type="radio" id="requiredOption' + num + i +'" name="requiredOptionGroup' + num + '" class="custom-control-input" ';
            			   if(i == 0){
            				   str += 'checked';
            			   }
            			   str += ' value="' + result[i].menuOptionCode + '" data-optionPrice="' + result[i].menuOptionPrice +'">';
            			   str += '<label class="custom-control-label" for="requiredOption' + num + i + '">' + result[i].menuOptionName + '</label>';
            			   if(result[i].menuOptionPrice == 0){
            				   str += '<div class="optionPrice">추가비용없음</div>';
            			   }
            			   else{
            				   str += '<div class="optionPrice">+' + result[i].menuOptionPrice + '원</div>';
            			   }
            			   str += '</div>';
            		   }
            		   //선택 옵션그룹의 옵션들
            		   else{
            			   str += '<div class="custom-control custom-checkbox">';
            			   str += '<input type="checkbox" id="selectionOption' + num + i +'" name="selectionOptionGroup' + num + '" class="custom-control-input" value="' + result[i].menuOptionCode + '" ';
            			   str += 'data-optionPrice="' + result[i].menuOptionPrice + '">';
            			   str += '<label class="custom-control-label" for="selectionOption' + num + i +'">' + result[i].menuOptionName + '</label>';
            			   if(result[i].menuOptionPrice == 0){
            				   str += '<div class="optionPrice">추가비용없음</div>';
            			   }
            			   else{
            				   str += '<div class="optionPrice">+' + result[i].menuOptionPrice + '원</div>';
            			   }
            			   str += '</div>';
            		   }
            	   })
            	   if(result[0].menuOptionGroupType == 1){
            		   let ro = '#requiredOptionGroup' + num;
            		   $(ro).append(str);
            	   }
            	   else{
            		   let so = '#selectedOptionGroup' + num;
            		   $(so).append(str);
            	   }
              }
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

    }
    
    insertCart = function(menuCode, buyQuantity, requiredOptions, selectionOptions, cartPrice, isBuy){
    	$.ajax({
			url: '/cart/insertCart', //요청경로
			type: 'post',
			traditional: true,
			data:{'menuCode' : menuCode, 'buyQuantity' : buyQuantity, 'requiredOptions' : requiredOptions, 'selectionOptions' : selectionOptions, 'cartPrice' : cartPrice}, //필요한 데이터
			success: function(result) {
				//ajax 실행 성공 후 실행할 코드 작성
				if(result >= 1){
					if(isBuy){
						location.href='/buy/buyConfirm';
					}
					else{
						let res = confirm('메뉴가 장바구니에 추가되었습니다\n장바구니로 가시겠습니까?');
						if(res){
							location.href='/cart/cartList';
						}
						else{
							$('#menuInfoModal').modal('hide')
							$('.menuOptionList').empty();
							$('#buyQuantity').val(1);
						}
					}
				}
			},
			error: function(){
				//ajax 실행 실패 시 실행되는 구간
				alert('실패');
			}
		});
    }
    
    isOverlabCart = function(menuCode, buyQuantity, requiredOptions, selectionOptions, cartPrice, isBuy){
    	$.ajax({
            url: '/cart/isOverlabCart', //요청경로
            type: 'post',
            data:{'menuCode' : menuCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	if(!result){
            		let res = confirm('장바구니에 다른 매장의 메뉴가 있습니다\n삭제하고 진행하시겠습니까?');
            		if(res){
            			deleteCart();
            			insertCart(menuCode, buyQuantity, requiredOptions, selectionOptions, cartPrice, isBuy);
            		}
            		else{
            			return;
            		}
            	}
            	else{
            		insertCart(menuCode, buyQuantity, requiredOptions, selectionOptions, cartPrice, isBuy);
            	}
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('삭제실패');
            }
      });

    }
    
    deleteCart = function(){
    	const cartCode = '';
    	$.ajax({
            url: '/cart/deleteCart', //요청경로
            type: 'post',
            data:{'cartCode' : cartCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	location.reload();
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
    }
    
	/*buyForm = function(totalPrice, menuCode, cafeCode, buyQuantity, menuOptions){
		
		$.ajax({
			url: '/buy/buyConfirm', //요청경로
			type: 'post',
			data:{'totalPrice' : totalPrice, 'menuCode' : menuCode, 'cafeCode' : cafeCode, 'buyQuantity' : buyQuantity, 'menuOptions' : menuOptions}, //필요한 데이터
			success: function(result) {
				//ajax 실행 성공 후 실행할 코드 작성
				alert('성공');
			},
			error: function(){
				//ajax 실행 실패 시 실행되는 구간
				alert('실패');
			}
		});

	}
	
	buyOptionArray = function(){
		$.ajax({
			url: '', //요청경로
			type: 'post',
			data:{}, //필요한 데이터
			success: function(result) {
				//ajax 실행 성공 후 실행할 코드 작성
				alert('성공');
			},
			error: function(){
				//ajax 실행 실패 시 실행되는 구간
				alert('실패');
			}
		});
	}*/
    
    
})(jQuery);