/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	$(document).on('change', '.form-check-input', function(){
            
	});
	
	$(document).on('keydown', '#loginId, #loginPw', function(key){
		const loginId = $('#loginId').val();
		const loginPw = $('#loginPw').val();
    	if(loginId != '' && loginPw != ''){
    		if (key.keyCode == 13) {
    			loginProcess();
    		}
		}
	})
	
});

/* 함수선언 영역*/
(function($){
	
	//멤버타입에 따른 로그인처리
	loginProcess = function(){
		const memberType = $("input:radio[name ='inlineRadioOptions']:checked").val();
		const loginId = $('#loginId').val();
		const loginPw = $('#loginPw').val();
		if(loginId == ''){
			alert('아이디를 입력해주세요');
			$('#loginId').focus();
			return;
		}
		else if(loginPw == ''){
			alert('비밀번호를 입력해주세요');
			$('#loginPw').focus();
			return;
		}
		
		//매장주 선택시
		if(memberType == '매장주'){
			$.ajax({
	            url: '/owner/ownerLoginProcess', //요청경로
	            type: 'post',
	            data:{'ownerId' : loginId, 'ownerPw' : loginPw}, //필요한 데이터
	            success: function(result) {
	               //ajax 실행 성공 후 실행할 코드 작성
	               if(result) {
	            	   alert('로그인 되었습니다');
	            	   $('#loginModal').modal('hide');
	            	   location.reload();
	            	   
	               }
	               else {
	            	   alert('아이디와 비밀번호를 다시 확인해주세요');
	            	   $('#loginId').val('');
	            	   $('#loginPw').val('');
	            	   $('#loginId').focus();
	               }
	            },
	            error: function(){
	             //ajax 실행 실패 시 실행되는 구간
	               alert('실패');
	            }
	      });
		}
		
		//일반회원 선택시
		else if(memberType == '일반회원'){
			$.ajax({
	            url: '/member/memberLoginProcess', //요청경로
	            type: 'post',
	            data:{'memId' : loginId, 'memPw' : loginPw}, //필요한 데이터
	            success: function(result) {
	               //ajax 실행 성공 후 실행할 코드 작성
	               if(result) {
	            	   alert('로그인 되었습니다');
	            	   $('#loginModal').modal('hide');
	            	   location.reload();
	               }
	               else {
	            	   alert('아이디와 비밀번호를 다시 확인해주세요');
	            	   $('#loginId').val('');
	            	   $('#loginPw').val('');
	               }
	            },
	            error: function(){
	             //ajax 실행 실패 시 실행되는 구간
	               alert('실패');
	            }
	      });
		}
	}
	
	//로그아웃(멤버, 매장주 컨트롤러 통일)
	logout = function() {
		$.ajax({
            url: '/member/logout', //요청경로
            type: 'post',
            data:{}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
               alert('로그아웃 되었습니다');
               location.reload();
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	
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