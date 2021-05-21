/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	checkUnfinishedBuy();
	
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
	
	checkUnfinishedBuy = function(){
		$.ajax({
			url: '/member/checkUnfinishedBuy', //요청경로
			type: 'post',
			data:{}, //필요한 데이터
			success: function(result) {
				//ajax 실행 성공 후 실행할 코드 작성
				if(!result){
					alert('아직 진행중인 주문이 있습니다\n주문내역 페이지로 이동합니다');
					location.href = '/member/buyList';
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