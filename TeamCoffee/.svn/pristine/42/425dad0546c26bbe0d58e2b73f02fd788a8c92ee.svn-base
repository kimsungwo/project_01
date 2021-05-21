/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	$(document).on('click', '#goDeleteCafe', function(){
		const cafeCode = $(this).next().val();
		const result = confirm('정말 진행 하시겠습니까?');
		if(result) {
			alert('신청이 완료되었습니다');
			location.href="/owner/deleteCafe?cafeCode=" + cafeCode;
		}
	});
	
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