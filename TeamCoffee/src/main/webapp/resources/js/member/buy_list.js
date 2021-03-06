/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	$('.menuName').each(function(){
		const selectedTag = $(this);
		selectBuyListMenu(selectedTag);
	})
	
	$('.buyStatusBar').each(function(){
		const buyStatus = $(this).attr('data-buyStatus');
		if(buyStatus == 0){
			$(this).attr('style', 'width: 100%');
			$(this).addClass('bg-danger');
		}
		else if(buyStatus == 1){
			$(this).attr('style', 'width: 33%');
			$(this).addClass('progress-bar-animated');
		}
		else if(buyStatus == 2){
			$(this).attr('style', 'width: 66%');
			$(this).addClass('progress-bar-animated bg-info');
		}
		else if(buyStatus == 3){
			$(this).attr('style', 'width: 100%');
			$(this).addClass('bg-success');
		}
	})
	
	$('#buyDetail').on('hidden.bs.modal', function (event) {
		$('.buyMenuDetail').empty();
		$('.menuOption').empty();
	})	
	
	$('#buyDetail').on('show.bs.modal', function (event) {
		
	})
	
	$(document).on('click', '.starRev span', function(){
		$(this).parent().children('span').removeClass('on');
		  $(this).addClass('on').prevAll('span').addClass('on');
		  let onCnt = $('.on').length;
		  if(onCnt == 0) {
			  $('.starCnt').empty();
			  $('.starCnt').prepend('<input type="hidden" value="0.0" name="reviewStar">');
		  }
		  else if(onCnt == 1) {
			  $('.starCnt').empty();
			  $('.starCnt').prepend('<input type="hidden" value="1.0" name="reviewStar">');
		  }
		  else if(onCnt == 2) {
			  $('.starCnt').empty();
			  $('.starCnt').prepend('<input type="hidden" value="2.0" name="reviewStar">');
		  }
		  else if(onCnt == 3) {
			  $('.starCnt').empty();
			  $('.starCnt').prepend('<input type="hidden" value="3.0" name="reviewStar">');
		  }
		  else if(onCnt == 4) {
			  $('.starCnt').empty();
			  $('.starCnt').prepend('<input type="hidden" value="4.0" name="reviewStar">');
		  }
		  else if(onCnt == 5) {
			  $('.starCnt').empty();
			  $('.starCnt').prepend('<input type="hidden" value="5.0" name="reviewStar">');
		  }
		  return false;
	});

	
	$(document).on('click', '#regImg', function(){
		$('.regReviewImg').empty();
		
		let str = '';
		str += '<div class="form-group">';
		str += '<input type="file" class="form-control-file" id="reviewImg" name="file1">';
		str += '</div>';
		$('.regReviewImg').prepend(str);
	});
	
	$(document).on('change', '#reviewImg', function(){
		const ext = $(this).val().split('.').pop().toLowerCase();
		if($.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1 ){
			resetFormElement($(this));
			alert('이미지 파일이 아닙니다');
		}
		else{
			const file = $('#reviewImg').prop('files')[0];
			const blobURL = window.URL.createObjectURL(file);
			let str = '<div id="image_preview"><img src="" style="width:200px;"></div>';
			$('.regReviewImg').prepend(str);
            $('#image_preview img').attr('src', blobURL);
            $('#image_preview').slideDown(); //업로드한 이미지 미리보기 
            $(this).slideUp(); //파일 양식 감춤
		}
	});
	
	$(document).on('click', '.completeReview', function(){
		alert('이미 리뷰를 등록하셨습니다');
	});

	
});

/* 함수선언 영역*/
(function($){
    selectBuyListMenu = function(selectedTag){
    	const buyCode = selectedTag.attr('data-buyCode');
    	$.ajax({
            url: '/buy/selectBuyListMenu', //요청경로
            type: 'post',
            data:{'buyCode' : buyCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	let str = '';
               $(result).each(function(i){
            	   str += result[i].menuName + ' x ' + result[i].buyQuantity;
            	   if(result[i+1] != null){
            		   str += ', ';
            	   }
               })
               selectedTag.text(str);
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
    }
    
    selectBuyDetail = function(buyCode){
    	selectBuyPoint(buyCode);
    	$.ajax({
            url: '/buy/selectBuyDetail', //요청경로
            type: 'post',
            data:{'buyCode' : buyCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	$('#buyDetailLabel').text(result[0].buyStatusName);
            	$('.cafeNameModal').text(result[0].cafeName);
            	$('.buyDateModal').text(result[0].buyDate);
            	$('.memTelModal').text(result[0].buyMemTel);
            	if(result[0].orderMessage == null){
            		$('.orderMessage').text('(없음)');
            	}
            	else{
            		$('.orderMessage').text(result[0].orderMessage);
            	}
            	if(result[0].buyRequests == null){
            		$('.buyRequestsModal').text('(없음)');
            	}
            	else{
            		$('.buyRequestsModal').text(result[0].buyRequests);
            	}
            	$('.totalPriceModal').text(result[0].totalPrice.toLocaleString() + '원');
            	selectBuyDetailMenu(buyCode);
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
	
	selectBuyPoint = function(buyCode){
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
	regReviewForm = function(buyCode) {
		$.ajax({
            url: '/review/reviewForm', //요청경로
            type: 'post',
            data:{'buyCode' : buyCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	$('#reviewTitleDiv').empty();
            	let str = '';
            	str += '<input type="hidden" name="cafeCode" value="' + result[0].cafeCode + '">';
            	str += '<input type="hidden" name="buyCode" value="' + result[0].buyCode + '">';
            	str += '<img src="/resources/img/logo/'+ result[0].cafeLogo + '" style="width:80px">';
            	str += '<h5>카페 이용은 어떠셨나요?</h5>';
            	str += '<div>' + result[0].cafeName + '</div>';
            	str += '</div>';
            	str += '<div class="detailTitle">';
            	str += result[0].menuName;
            	if(result.length > 1){
            		str += ' 외 ' + (result.length - 1) + '건';
            	}
            	str += '</div>';
            	
            	$('#reviewTitleDiv').prepend(str);
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
	}
	
	insertReview = function() {
		if(reviewContent == '') {
			alert('리뷰내용을 입력해주세요');
		}
		else {
			const result = confirm('리뷰를 등록하시겠습니까?');
			if(result) {
				alert('성공적으로 등록되었습니다');
				$('#insertReviewForm').submit;
			}
		}
	}
	
})(jQuery);