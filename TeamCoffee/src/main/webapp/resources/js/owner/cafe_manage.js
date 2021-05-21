/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	$(document).on('click', '#goDeleteCafe', function(){
		const cafeCode = $(this).next().val();
		const result = confirm('매장 폐업시 매장 정보를 다시 복구 시킬 수 없습니다\n매장을 폐업하시겠습니까?');
		if(result) {
			checkBuyStatusToCafe(cafeCode);
		}
	});
	
	$(document).on('change', '.cafeState', function(){
		const selectedTag = $(this);
		updateCafeState(selectedTag);
	})
	
});

/* 함수선언 영역*/
(function($){
	
	checkBuyStatusToCafe = function(cafeCode){
		$.ajax({
            url: '/owner/checkBuyStatusToCafe', //요청경로
            type: 'post',
            data:{'cafeCode' : cafeCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
               if(!result){
            	   alert('아직 처리되지않은 주문이 있습니다\n모든 주문을 확인 또는 취소해주세요');
            	   return;
               }
               else{
            	   deleteCafe(cafeCode);
               }
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

		
	}
	
    deleteCafe = function(cafeCode){
    	$.ajax({
            url: '/owner/deleteCafe', //요청경로
            type: 'post',
            data:{'cafeCode' : cafeCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	if(result > 0){
            		alert('매장이 폐업 처리 되었습니다');
            		location.href = '/owner/cafeManage';
            	}
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
    }
	
    updateCafeState = function(selectedTag){
    	const cafeCode = selectedTag.attr('data-cafeCode');
    	const cafeState = selectedTag.val();
    	$.ajax({
            url: '/owner/updateCafeState', //요청경로
            type: 'post',
            data:{'cafeCode' : cafeCode, 'cafeState' : cafeState}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

    }
    
})(jQuery);