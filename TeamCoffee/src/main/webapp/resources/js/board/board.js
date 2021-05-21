/* 페이지 로딩 후 실행 */
$(document).ready(function(){
   $(document).on('click', '#delete', function() {
		const boardNum = $(this).attr('data-boardNum');
		const boardCode = $(this).attr('data-boardCode');
		let result = confirm('삭제하시겠습니까?');
		if(result){
			alert('삭제되었습니다.')
			location.href='/board/deleteBoard?boardNum=' + boardNum + '&boardCode=' + boardCode;
		}
		else{
		    return;
		}
	});
	$(document).on('click', '#deleteComment', function() {
		const boardNum = $(this).attr('data-boardNum');
		const commentCode = $(this).attr('data-commentCode');
		let result = confirm('삭제하시겠습니까?');
		if(result){
			location.href='/comment/deleteComment?boardNum=' + boardNum + '&commentCode=' + commentCode;
		}
		else{
		    return;
		}
	});
	$(document).on('click', '#upload', function() {
		let result = confirm('작성한 내용으로 등록하시겠습니까?');
		if(result){
			document.getElementById('uploadBoard').submit();
		}
		else{
			return;
		}
	});
});

/* 함수선언 영역*/
(function($){
	
})(jQuery);