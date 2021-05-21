/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	$(document).on('click', '#insertQnABtn', function(){
		const title = $('#boardName').val();
		const content = $('#boardContent').val();
		if(title == ''){
			alert('제목을 입력해주세요');
			$('#boardName').focus();
			return;
		}
		else if(content == ''){
			alert('내용을 입력해주세요');
			$('#boardContent').focus();
			return;
		}
		else{
			$('#qnaForm').submit();
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