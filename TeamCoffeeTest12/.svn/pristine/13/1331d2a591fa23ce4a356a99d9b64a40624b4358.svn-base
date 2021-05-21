/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	$(document).on('click', '#deleteBtn', function(){
		const selectedTag = $(this);
		deleteMember(selectedTag);
	});
});

/* 함수선언 영역*/
(function($){
	deleteMember=function(selectedTag){
	const password0 = $(selectedTag).attr('data-password');
	const password = $('#login_password').val();

	if(password0 != password){
		alert('정확히 입력하세요.');

		return;
	}
	alert('탈퇴처리 완료하였습니다. 메인페이지로 이동합니다.'); 
	$('#deleteForm').submit();
  };
	
})(jQuery);