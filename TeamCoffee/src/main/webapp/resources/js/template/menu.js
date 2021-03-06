/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	$(document).on('keydown', '#loginId, #loginPw', function(key){
		const loginId = $('#loginId').val();
		const loginPw = $('#loginPw').val();
    	if(loginId != '' && loginPw != ''){
    		if (key.keyCode == 13) {
    			loginProcess();
    		}
		}
	})
	
	/*$(document).on('change', 'input[name="loginRadio"]', function(){
		const memberType = $("input:radio[name ='loginRadio']:checked").val();
		if(memberType == '매장주'){
			$('#forgotId').attr('onclick', 'location.href="/owner/find_idFormOwner";');
			$('#forgotPw').attr('onclick', 'location.href="/owner/find_pwFormOwner";');
		}
		else if(memberType == '일반회원'){
			$('#forgotId').attr('onclick', 'location.href="/member/find_idForm";');
			$('#forgotPw').attr('onclick', 'location.href="/member/find_pwForm";');
		}
	})*/
	
	$(document).on('change', '#ownerSwitch', function(){
		if($(this).prop('checked') == true){
			$('#forgotId').attr('onclick', 'location.href="/owner/find_idFormOwner";');
			$('#forgotPw').attr('onclick', 'location.href="/owner/find_pwFormOwner";');
		}
		else{
			$('#forgotId').attr('onclick', 'location.href="/member/find_idForm";');
			$('#forgotPw').attr('onclick', 'location.href="/member/find_pwForm";');
		}
	})
	
	$(document).on('change', 'input[id="useCookie"]', function(){
		const loginChecked = $('input[id="useCookie"]:checked').val();
		if(loginChecked == 'useCookie'){
			$('#loginLabel').css('color', '#343a40');
		}
		else if(loginChecked == undefined){
			$('#loginLabel').css('color', 'rgba(0, 0, 0, 0.4)');
		}
	})
	
});

/* 함수선언 영역*/
(function($){
	
	//멤버타입에 따른 로그인처리
	loginProcess = function(){
		const memberType = $('#ownerSwitch').prop('checked');
		const loginId = $('#loginId').val();
		const loginPw = $('#loginPw').val();
		const useCookie = $("input:checkbox[name ='useCookie']:checked").val();
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
		if(memberType == true){
			$.ajax({
	            url: '/owner/ownerLoginProcess', //요청경로
	            type: 'post',
	            data:{'ownerId' : loginId, 'ownerPw' : loginPw, 'useCookie' : useCookie}, //필요한 데이터
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
	            error: function(request, status, error){
	             //ajax 실행 실패 시 실행되는 구간
	            	alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
	            }
	      });
		}
		
		//일반회원 선택시
		else{
			/*$('#loginForm').attr('action', '/member/memberLoginProcess');
			$('#loginForm').submit();*/
			
			$.ajax({
	            url: '/member/memberLoginProcess', //요청경로
	            type: 'post',
	            data:{'memId' : loginId, 'memPw' : loginPw, 'useCookie' : useCookie}, //필요한 데이터
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
	            error: function(request, status, error){
	             //ajax 실행 실패 시 실행되는 구간
	            	alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
	            }
			});		
		}
	}
	
	//로그아웃(멤버)
	memberLogout = function() {
		$.ajax({
            url: '/member/memberLogout', //요청경로
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
	//로그아웃(매장주)
	ownerLogout = function() {
		$.ajax({
            url: '/owner/ownerLogout', //요청경로
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