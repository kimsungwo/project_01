/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	$(document).on('click', '#sample', function(){
		
	});
	
	let totalPrice = 0;
	$('.cartPrice').each(function(){
		totalPrice = parseInt(totalPrice) + parseInt($(this).text());
		$('.totalPrice').text(totalPrice);
		$('.buyPrice').text(totalPrice);
		$('.hiddenBP').val(totalPrice);
	})
	
	$(document).on('click', '#pointBtn', function(){
		const usePoint = parseInt($('#memPoint').val());
		const memPoint = parseInt($('#point').text());
		const totalPrice = $('.totalPrice').text();
		if(usePoint > memPoint){
			alert('적립금은 ' + memPoint + '원 까지 사용 가능합니다');
			$('#memPoint').val(0);
			$('.buyPrice').text(totalPrice);
			$('.hiddenBP').val(totalPrice);
			return;
		}
		
		let buyPrice = totalPrice - usePoint;
		$('.buyPrice').text(buyPrice);
		$('.hiddenBP').val(buyPrice);
	})
	
	
});

/* 함수선언 영역*/
(function($){
    aaa = function(){
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
    }
	
})(jQuery);