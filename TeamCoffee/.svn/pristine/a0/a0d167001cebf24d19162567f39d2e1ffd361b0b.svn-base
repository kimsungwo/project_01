/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	let totalPrice = 0;
	$('.cartPrice').each(function(){
		totalPrice = parseInt(totalPrice) + parseInt($(this).text().replace(/,/g, ""));
		$('.totalPrice').text(totalPrice.toLocaleString());
	})
	
	
	$(document).on('change', '.buyQuantity', function(){
		const selectedTag = $(this);
		let buyQuantity = $(this).val();
		if(buyQuantity < 1){
			alert('수량은 1개 이상 선택가능합니다');
			$(this).val(1);
		}
		else{
			updateBuyQuantity(buyQuantity, selectedTag);
		}
	});
	
	$(document).on('click', '.deleteCartBtn', function(){
		let cartCode = $(this).attr('data-cartCode');
		if(cartCode == null){
			cartCode = '';
		}
		deleteCart(cartCode);
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
	
    updateBuyQuantity = function(buyQuantity, selectedTag){
    	const cartCode = selectedTag.attr('data-cartCode');
    	$.ajax({
            url: '/cart/updateBuyQuantity', //요청경로
            type: 'post',
            data:{'buyQuantity' : buyQuantity, 'cartCode' : cartCode}, //필요한 데이터
            success: function(result) {
               if(result == 1){
            	   location.reload();
               }
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
    }
    
    deleteCart = function(cartCode){
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
    
    
    
})(jQuery);