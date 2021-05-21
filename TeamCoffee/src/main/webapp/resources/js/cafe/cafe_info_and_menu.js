/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	$(document).on('click', '.stockPlus', function(){
		const menuPrice = parseInt($('#menuPrice').text().replace(/,/g, ""));
		let buyQuantity = parseInt($('#buyQuantity').val());
		buyQuantity = buyQuantity + 1;
		$('#buyQuantity').val(buyQuantity);
		let option = 0;
		$('input[class=custom-control-input]:checked').each(function(){
			option = parseInt(option) + parseInt($(this).attr('data-optionPrice'));
		})
		let totalPrice = (menuPrice + option) * buyQuantity;
		$('.totalPrice').text(totalPrice.toLocaleString());
		$('#hiddenTp').val(totalPrice);
	});
	
	$(document).on('click', '.stockMinus', function(){
		const menuPrice = parseInt($('#menuPrice').text().replace(/,/g, ""));
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
		$('.totalPrice').text(totalPrice.toLocaleString());
		$('#hiddenTp').val(totalPrice);
		
	});
	
	$('#menuInfoModal').on('hidden.bs.modal', function (event) {
		$('.menuOptionList').empty();
		$('#buyQuantity').val(1);
	});
	
	$(document).on('change', '.custom-control-input', function(){
		const menuPrice = parseInt($('#menuPrice').text().replace(/,/g, ""));
		let buyQuantity = parseInt($('#buyQuantity').val());
		let option = 0;
		$('input[class=custom-control-input]:checked').each(function(){
			option = parseInt(option) + parseInt($(this).attr('data-optionPrice'));
		})
		let totalPrice = (menuPrice + option) * buyQuantity;
		$('.totalPrice').text(totalPrice.toLocaleString());
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
		const cartPrice = $('#hiddenTp').val().replace(/,/g, "");
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
		const cartPrice = $('#hiddenTp').val().replace(/,/g, "");
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
            $('#menuImgName').attr('src', '/resources/img/menu/' + result.menuImgName);
            $('#menuName').text(result.menuName);
            $('#cafeCode').val(result.cafeCode);
            $('#menuCode').val(result.menuCode);
            if(result.menuInfo != null){
            	$('#menuInfo').text(result.menuInfo);
            }
            $('#menuPrice').text(result.menuPrice.toLocaleString());
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
            		if(result.length == 0){
            			setTotalPrice();
            			return;
            		}
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
            				   str += '<div class="optionPrice">+' + result[i].menuOptionPrice.toLocaleString() + '원</div>';
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
            				   str += '<div class="optionPrice">+' + result[i].menuOptionPrice.toLocaleString() + '원</div>';
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
            	   setTotalPrice();
            	   
              }
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

    }
    
    setTotalPrice = function(){
    	const menuPrice = parseInt($('#menuPrice').text().replace(/,/g, ""));
		let option = 0;
		$('input[class=custom-control-input]:checked').each(function(){
			option = parseInt(option) + parseInt($(this).attr('data-optionPrice'));
		})
		let totalPrice = (menuPrice + option);
		$('.totalPrice').text(totalPrice.toLocaleString());
		$('#hiddenTp').val(totalPrice.toLocaleString());
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
    
    //로그아웃시 장바구니 진입
    needLogin = function() {
		alert('로그인이 필요한 항목입니다.');
	}
    
    selectMenuTab = function(menuCategoryCode) {
    	const cafeCode = $('#cafeCodeInfo').val();
    	const menuName = $('#menuNameInfo').val();
    	if(menuCategoryCode != null){
    		$.ajax({
                url: '/cafe/selectCafeMenuCategory', //요청경로
                type: 'post',
                data:{'menuCategoryCode' : menuCategoryCode, 'cafeCode' : cafeCode}, //필요한 데이터
                success: function(result) {
                   //ajax 실행 성공 후 실행할 코드 작성
                	$('.menuList').empty();
                	
                	let str = '';
                	if(result.length == 0){
                		str += '<tr>';
                    	str += '<td colspan="3" class="text-center">등록된 메뉴가 없습니다.</td>';
                    	str += '</tr>';
                	}
                	else{
                    	$.each(result, function(index, result){
                    		str += '<tr class="tableClick" data-toggle="modal" data-target="#menuInfoModal" onclick="menuInfoModal(\'' + result.menuCode + '\')">';
                        	str += '<th scope="row"><img src="/resources/img/menu/'+result.menuImgName+'" width="70px"></th>';
                        	str += '<td>';
                        	str += '<h5>'+result.menuName+'</h5>';
                        	if(result.menuInfo != null){
                        		str += '<h6 class="menuInfo">'+result.menuInfo+'</h6>';
                        	}
                        	str += result.menuPrice.toLocaleString()+'원';
                        	str += '</td>';
                        	str += '<td>'+result.status +'</td>';
                        	str += '</tr>';
                        	str += '<input type="hidden" value="'+result.menuCategoryCode+'" class="menuCategoryCodeInfo">';
                    	}); 
                	}
                	$('.menuList').append(str);
                	$('#menuNameInfo').val('');
                },
                error: function(){
                 //ajax 실행 실패 시 실행되는 구간
                   alert('실패');
                }
          });
    	}
    	else {
    		$.ajax({
                url: '/cafe/selectCafeMenuCategory', //요청경로
                type: 'post',
                data:{'cafeCode' : cafeCode}, //필요한 데이터
                success: function(result) {
                   //ajax 실행 성공 후 실행할 코드 작성
                	$('.menuList').empty();
                	let str = '';
                	if(result.length == 0){
                		str += '<tr>';
                    	str += '<td colspan="3" class="text-center">등록된 메뉴가 없습니다.</td>';
                    	str += '</tr>';
                	}
                	else{
                    	$.each(result, function(index, result){
                    		str += '<tr class="tableClick" data-toggle="modal" data-target="#menuInfoModal" onclick="menuInfoModal(\'' + result.menuCode + '\')">';
                        	str += '<th scope="row"><img src="/resources/img/menu/'+result.menuImgName+'" width="70px"></th>';
                        	str += '<td>';
                        	str += '<h5>'+result.menuName+'</h5>';
                        	if(result.menuInfo != null){
                        		str += '<h6 class="menuInfo">'+result.menuInfo+'</h6>';
                        	}
                        	str += result.menuPrice.toLocaleString()+'원';
                        	str += '</td>';
                        	str += '<td>'+result.status +'</td>';
                        	str += '</tr>';
                    	}); 
                	}
                	$('.menuList').append(str);
                	$('#menuNameInfo').val('');
                },
                error: function(){
                 //ajax 실행 실패 시 실행되는 구간
                   alert('실패');
                }
          });
    	}
    	
    }
    
    searchMenu = function() {
    	const cafeCode = $('#cafeCodeInfo').val();
    	const menuName = $('#menuNameInfo').val();
    	const menuCategoryCode = $('.menuCategoryCodeInfo').val();
    	if(menuCategoryCode == null) {
    		$.ajax({
                url: '/cafe/searchMenu', //요청경로
                type: 'post',
                data:{'cafeCode' : cafeCode, 'menuName' : menuName}, //필요한 데이터
                success: function(result) {
                   //ajax 실행 성공 후 실행할 코드 작성
                	$('.menuList').empty();
                	
                	let str = '';
                	if(result.length == 0){
                		str += '<tr>';
                    	str += '<td colspan="3" class="text-center">등록된 메뉴가 없습니다.</td>';
                    	str += '</tr>';
                	}
                	else{
                    	$.each(result, function(index, result){
                    		str += '<tr class="tableClick" data-toggle="modal" data-target="#menuInfoModal" onclick="menuInfoModal(\'' + result.menuCode + '\')">';
                        	str += '<th scope="row"><img src="/resources/img/menu/'+result.menuImgName+'" width="70px"></th>';
                        	str += '<td>';
                        	str += '<h5>'+result.menuName+'</h5>';
                        	if(result.menuInfo != null){
                        		str += '<h6 class="menuInfo">'+result.menuInfo+'</h6>';
                        	}
                        	str += result.menuPrice.toLocaleString()+'원';
                        	str += '</td>';
                        	str += '<td>'+result.status +'</td>';
                        	str += '</tr>';
                    	}); 
                	}
                	
                	$('.menuList').append(str);
                	$('#menuNameInfo').val('');
                },
                error: function(){
                 //ajax 실행 실패 시 실행되는 구간
                   alert('실패');
                }
          });
    		
    	}
    	else {
    		$.ajax({
                url: '/cafe/searchMenu', //요청경로
                type: 'post',
                data:{'cafeCode' : cafeCode, 'menuName' : menuName, 'menuCategoryCode' : menuCategoryCode}, //필요한 데이터
                success: function(result) {
                   //ajax 실행 성공 후 실행할 코드 작성
                	$('.menuList').empty();
                	let str = '';
                	if(result.length == 0){
                		str += '<tr>';
                    	str += '<td colspan="3" class="text-center">등록된 메뉴가 없습니다.</td>';
                    	str += '</tr>';
                	}
                	else{
                    	$.each(result, function(index, result){
                    		str += '<tr class="tableClick" data-toggle="modal" data-target="#menuInfoModal" onclick="menuInfoModal(\'' + result.menuCode + '\')">';
                        	str += '<th scope="row"><img src="/resources/img/menu/'+result.menuImgName+'" width="70px"></th>';
                        	str += '<td>';
                        	str += '<h5>'+result.menuName+'</h5>';
                        	if(result.menuInfo != null){
                        		str += '<h6 class="menuInfo">'+result.menuInfo+'</h6>';
                        	}
                        	str += result.menuPrice.toLocaleString()+'원';
                        	str += '</td>';
                        	str += '<td>'+result.status +'</td>';
                        	str += '</tr>';
                        	str += '<input type="hidden" value="'+result.menuCategoryCode+'" class="menuCategoryCodeInfo">';
                    	}); 
                	}
                	$('.menuList').append(str);
                	$('#menuNameInfo').val('');
                },
                error: function(){
                 //ajax 실행 실패 시 실행되는 구간
                   alert('실패');
                }
          });
    	}
    	
    }
    
    like_func = function(cafeCode, selectedTag){
		$.ajax({
            url: '/like/tolike', //요청경로
            type: 'post',
            data:{'cafeCode' : cafeCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	if(result == 1) {
            		$(selectedTag).children(':first').removeClass('bi-heart');
            		$(selectedTag).children(':first').addClass('bi-heart-fill');
            		updateLikeCount(cafeCode);
            	}
            	else if(result == 0) {
            		$(selectedTag).children(':first').removeClass('bi-heart-fill');
            		$(selectedTag).children(':first').addClass('bi-heart');
            		updateLikeCount(cafeCode);
            	}
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
	}
    
    updateLikeCount = function(cafeCode){
    	$.ajax({
            url: '/like/selectLikeCountToCafeCode', //요청경로
            type: 'post',
            data:{'cafeCode' : cafeCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	$('#cafeLikeCnt').text(result);
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

    }
    
    needLogin = function() {
		alert('로그인이 필요한 항목입니다.');
	}
    
})(jQuery);