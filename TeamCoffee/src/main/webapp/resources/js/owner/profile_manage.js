/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	$(document).on('click', '#sample', function(){
	});
	
	initValidation();
	
	$(document).on('click', '#updateBtn', function(){
		let result = confirm('프로필을 수정하시겠습니까?');
		if(result){
			$('#updateForm').submit();
		}
	})
	
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
			ownerTel : {
				required : true,
				maxlength : 11,
				minlength : 10,
				digits : true
			},
			ownerPw : {
				required : true
			},
			ownerPw1 : {
				required : true,
				equalTo : "#ownerPw"
			}
		},
		//검사를 충족하지 못할 경우,
		//위의 rules의 조건을 만족하지 못했을경우 표시될 메시지의 나열                                                         
		messages : {
			ownerTel : {
				required : '연락처는 필수 입력입니다',
				maxlength : '최대 {0} 글자까지 가능합니다',
				minlength : '최소 {0} 글자 이상 입력해주세요',
				digits : '숫자만 입력해주세요'
			},
			ownerPw : {
				required : '비밀번호는 필수 입력입니다'
			},
			ownerPw1 : {
				required : '비밀번호 확인은 필수 입력입니다',
				equalTo : '비밀번호가 일치하지 않습니다'
			}
		}
	});
}
	
	
})(jQuery);