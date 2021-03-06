/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	$('.menuName').each(function(){
		const selectedTag = $(this);
		selectBuyListMenu(selectedTag);
	})
	
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
    
    goDeleteReview = function(reviewCode, buyCode, cafeCode) {
    	const result = confirm('리뷰를 삭제하시겠습니까?');
    	if(result) {
    		alert('리뷰가 삭제되었습니다');
    		location.href='/review/deleteReview?reviewCode=' + reviewCode + '&buyCode=' + buyCode + '&cafeCode=' + cafeCode;
    	}
    }
    
    goUpdateReviewModal = function(reviewCode){
    	$.ajax({
            url: '/review/selectReviewDetail', //요청경로
            type: 'post',
            data:{'reviewCode' : reviewCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	$('#reviewTitleDiv').empty();
            	$('.starRev').empty();
            	$('#reviewImg1').remove();
            	let str = '';
            	let star = '';
            	str += '<input type="hidden" name="cafeCode" value="' + result[0].cafeCode + '">';
            	str += '<input type="hidden" name="reviewCode" value="' + result[0].reviewCode + '">';
            	str += '<img src="/resources/img/logo/'+ result[0].cafeLogo + '" style="width:80px">';
            	str += '<h5>카페 이용은 어떠셨나요?</h5>';
            	str += '<div>' + result[0].cafeName + '</div>';
            	str += '</div>'
            	str += '<div class="detailTitle">';
            	str += result[0].menuName;
            	if(result.length > 1){
            		str += ' 외 ' + (result.length - 1) + '건';
            	}
            	str += '</div>';
            	
            	if(result[0].reviewStar == 0) {
            		star += '<span class="starR">★</span>';
                	star += '<span class="starR">★</span>';
                	star += '<span class="starR">★</span>';
                	star += '<span class="starR">★</span>';
                	star += '<span class="starR">★</span>';
                	$('.starCnt').prepend('<input type="hidden" value="0.0" name="reviewStar">');
            	}
            	else if(result[0].reviewStar == 1) {
            		star += '<span class="starR on">★</span>';
                	star += '<span class="starR">★</span>';
                	star += '<span class="starR">★</span>';
                	star += '<span class="starR">★</span>';
                	star += '<span class="starR">★</span>';
                	$('.starCnt').prepend('<input type="hidden" value="1.0" name="reviewStar">');
            	}
            	else if(result[0].reviewStar == 2) {
            		star += '<span class="starR on">★</span>';
                	star += '<span class="starR on">★</span>';
                	star += '<span class="starR">★</span>';
                	star += '<span class="starR">★</span>';
                	star += '<span class="starR">★</span>';
                	$('.starCnt').prepend('<input type="hidden" value="2.0" name="reviewStar">');
            	}
            	else if(result[0].reviewStar == 3) {
            		star += '<span class="starR on">★</span>';
                	star += '<span class="starR on">★</span>';
                	star += '<span class="starR on">★</span>';
                	star += '<span class="starR">★</span>';
                	star += '<span class="starR">★</span>';
                	$('.starCnt').prepend('<input type="hidden" value="3.0" name="reviewStar">');
            	}
            	else if(result[0].reviewStar == 4) {
            		star += '<span class="starR on">★</span>';
                	star += '<span class="starR on">★</span>';
                	star += '<span class="starR on">★</span>';
                	star += '<span class="starR on">★</span>';
                	star += '<span class="starR">★</span>';
                	$('.starCnt').prepend('<input type="hidden" value="4.0" name="reviewStar">');
            	}
            	else if(result[0].reviewStar == 5) {
            		star += '<span class="starR on">★</span>';
                	star += '<span class="starR on">★</span>';
                	star += '<span class="starR on">★</span>';
                	star += '<span class="starR on">★</span>';
                	star += '<span class="starR on">★</span>';
                	$('.starCnt').prepend('<input type="hidden" value="5.0" name="reviewStar">');
            	}
            	
            	$('.starRev').prepend(star);
            	
            	$('#reviewTitleDiv').prepend(str);
            	if(result[0].reviewImg != null) {
            		$('.regReviewImg').prepend('<img src="/resources/img/review/' + result[0].reviewImg + '" style="width:200px;" id="reviewImg1">');
            	}
            	$('#validationTextarea').val(result[0].reviewContent);
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
    }
    
    
})(jQuery);