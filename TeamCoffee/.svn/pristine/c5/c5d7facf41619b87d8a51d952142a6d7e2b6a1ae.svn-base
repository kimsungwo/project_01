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
		const id = $('#ownerId').val();
		if(id == ''){
			alert('ID를 입력해주세요.');
			$('#ownerId').focus();
			return;
		}
		else if(email == ''){
			alert('email을 입력해주세요.');
			$('#email').focus();
			return;
		}
		$('#find_pw').submit();
      };
})(jQuery);