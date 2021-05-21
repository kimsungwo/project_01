/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	checkCafeClosed();
	
	$(document).on('click', '#deleteBtn', function(){
		const pw = $('#login_password').val();
		if(pw == ''){
			alert('비밀번호를 입력해주세요');
			$('#login_password').focus();
		}
		else{
			$('#deleteForm').submit();
		}
	});
});

/* 함수선언 영역*/
(function($){
	
	checkCafeClosed = function(){
		$.ajax({
            url: '/owner/checkCafeClosed', //요청경로
            type: 'post',
            data:{}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	if(!result){
            		alert('아직 운영중인 매장이 있습니다\n매장 관리 페이지로 이동합니다');
            		location.href = '/owner/cafeManage';
            	}
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	/*deleteMember=function(selectedTag){
	const password0 = $(selectedTag).attr('data-password');
	const password = $('#login_password').val();

	if(password0 != password){
		alert('정확히 입력하세요.');

		return;
	}
	alert('탈퇴처리 완료하였습니다. 메인페이지로 이동합니다.'); 
	$('#deleteForm').submit();
  };*/
	
})(jQuery);