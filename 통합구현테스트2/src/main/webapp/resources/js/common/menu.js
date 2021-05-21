/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//선택한 모달이 닫힐때 실행
	$('#loginModal').on('hidden.bs.modal', function (event) {
		$('#loginForm')[0].reset();
	})

	
	
});
/* 함수선언 영역*/
(function($){
   //aaa = function(){}
	login=function(){
		const id = $('#login_id').val();
		const password = $('#login_password').val();
		
		$.ajax({
            url: '/member/login', //요청경로
            type: 'post',
            data:{'id':id, 'password':password}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	if(result){
            		alert('login success');
            		$('#loginModal').modal('hide');
            		location.reload();
            		
            	}
            	else{
            		alert('아이디나 비밀번호 확인후 다시ㄱ');
            		$('#login_id').val('');
            		$('#login_password').val('');
            	}
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
	}
	logout=function(){
		$.ajax({
            url: '/member/logout', //요청경로
            type: 'post',
            data:{}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
               alert('로그아웃 했음');
               location.reload();
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
		
	}
	
	
})(jQuery);