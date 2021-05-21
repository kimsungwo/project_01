/* 페이지 로딩 후 실행 */
$(document).ready(function(){
//	$(document).on('click', '#sample', function(){
//		
//	});
	//수정 완료 버튼 클릭 시...
	$(document).on('click', '#findBtn', function(){
		findBtn();
	});	
});

/* 함수선언 영역*/
(function($){	
	findBtn=function(){
		const email = $('#email').val();
		if(email == ''){
			alert('email을 정확히 입력해주세요.');
			return;
		}
		$('#find_id').submit();
      };
})(jQuery);