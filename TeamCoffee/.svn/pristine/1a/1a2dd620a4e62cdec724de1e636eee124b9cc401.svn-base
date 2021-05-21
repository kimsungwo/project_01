/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	$(document).on('click', '#commentBtn', function(){
		const adminComment = $('#adminComment').val();
		if(adminComment == ''){
			alert('답변을 입력해주세요');
			$('#adminComment').focus();
			return;
		}
		else{
			$('#adminCommentForm').submit();
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