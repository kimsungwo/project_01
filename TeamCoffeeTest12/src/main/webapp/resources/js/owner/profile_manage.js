/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	$(document).on('click', '#sample', function(){
	});
	
	initValidation();
	//벨리데이션처리 비밀번호영역
	  $('.pw').focusout(function () {
		  
	        const pwd1 = $("#password_1").val();
	       const pwd2 = $("#password_2").val();
	       
	  
	        if ( pwd1 != '' && pwd2 == '' ) {
	                $("#alert-success").css('display', 'none');
	                $("#alert-danger").css('display', 'inline-block');
	        }
	        else if ( pwd1 == '' && pwd2 != '' ) {
	                $("#alert-success").css('display', 'none');
	                $("#alert-danger").css('display', 'inline-block');
	        }
	        
	        else if (pwd1 != "" || pwd2 != "") {
	        	if (pwd1 == pwd2) {
	                $("#alert-success").css('display', 'inline-block');
	                $("#alert-danger").css('display', 'none');
	            } else {
	                alert("비밀번호가 일치하지 않습니다. 비밀번호를 재확인해주세요.");
	                $("#alert-success").css('display', 'none');
	                $("#alert-danger").css('display', 'inline-block');
	            }
	        }
	    });
	
	
	
});

/* 함수선언 영역*/
(function($){	
	//우편번호 검색 함수
	openPostCode = function(){
        new daum.Postcode({
            oncomplete: function(data) {
                var roadAddr = data.roadAddress;
                $('#inputAddr').val(roadAddr);
            }
        }).open();
   }
	


	initValidation = function() {
	$("#updateForm").validate({
		debug : false,
		onfocusout : function(element) {
			$(element).valid();
		},
		rules : {
			memTel : {
				maxlength : 11,
				minlength : 10,
				digits : true
			}
		},
		//검사를 충족하지 못할 경우,
		//위의 rules의 조건을 만족하지 못했을경우 표시될 메시지의 나열                                                         
		messages : {
			memTel : {
				maxlength : '최대{0}글자',
				minlength : '최소{0}글자',
				digits : '숫자만 써주세요.'
			}
		}
	});
}
	
	
})(jQuery);