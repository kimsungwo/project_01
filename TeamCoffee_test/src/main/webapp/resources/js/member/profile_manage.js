/* 페이지 로딩 후 실행 */
$(document).ready(function(){
//	$(document).on('click', '#sample', function(){
//		
//	});
	initValidation();
	
	
	//수정 완료 버튼 클릭 시...
	$(document).on('click', '#updateBtn', function(){
		const selectedTag = $(this);
		updateInfo(selectedTag);
	});
	
	

	
	
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
	  
	 // const nickname = $('.nickname').val();
	  
	
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
	
	
	initValidation=function(){
		//특수문자를 제외하는 정규식을 validation에 추가
		//jQuery.validator.addMethod("alphanumeric", function(value, element) {
		//	return this.optional(element) || !/[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/.test(value);
		//});
		$("#updateForm").validate({ //여기서 들어올값은 유효성 검사할 대상 
	        // 테스트를 위하여 유효성 검사가 완료되어도 submit을 처리하지 않음.
	        debug : false,
	        //유효성 검사를 제외할 엘레먼트를 넣는다.
	        // ignore: ".ignore",
	        //포커스가 떠날 때 유효성 검사를 한다.
	        onfocusout: function(element) { 
	              $(element).valid(); 
	           },
	            //각각의 input태그에 필요한 검증조건을 나열
	        		/*
	        		 input태그의 name속성값 : {
	        		 	required : true 필수 입력값 지정
	        		 	, digits : true 숫자만 받겠음. 양의 정수
	        		 	, number : true 숫자만(+음수,실수포함)
	        		 	, email : true 이메일 형식
	        		 	, maxlength : 10 글자수를 10개로 제한
	        		 	, minlength : 5 최소글자수를 5개로 설정
	        		 	, equalTo : 해당요소의 id 또는"#해당id값" input값의 일치여부
	        		 }
	        		 */
	           rules : {
	        		memNickname : {//input태그의 name속성의 규칙을 지정하겠음.
	        			maxlength : 20
	        		}
					, memTel : { 
						maxlength : 11
						, minlength : 10
						, digits : true
					}
					/*, memPw : {
						equalTo : confirm_pw
					}*/
				//	, memAddrDetail : {
					//	 alphanumeric : true
				//	}
					
	        	},
	        	//검사를 충족하지 못할 경우,
	        	//위의 rules의 조건을 만족하지 못했을경우 표시될 메시지의 나열                                                         
	        	messages : {
	        		memNickname:{
	        			maxlength : '최대{0}글자'
	        		}
	        		, memTel : { 
	        			maxlength : '최대{0}글자'
						, minlength : '최소{0}글자'
						, digits : '숫자만 써주세요.'
							
					}
	        		/*, memPw : {
	        			equalTo : '패스워드가 일치하지 않습니다.'
	        		}*/
	        		//, memAddrDetail : {
					//	alphanumeric : '특수문자는 안됩니다.'
					//}
	        	}
	        	//조건검사후 검증 실패시 실행되는 코드
	        	//만약 작성하지 않으면 기본적으로 input태그의 우측에 
	        	//error메세지를 나타낸다.
	        	
	        	/*
	        	,
	        	errorPlacement: function(error, element){
	        		alert(123);
	        	}*/
	        	//validation처리가 성공하면 기본적으로 폼태그를 submit한다.
	        	//만약, 검증 후 submit이 아닌 다른 기능을 수행하고자 할때 
	        	//아래의 영역에 필요한 소스를 구현 예를들어 ajax로 간다거나,
	        	//form태그말고 다른거할때
	        	//submitHandler: function(form) {
	        	//}
	   });
	}
	
	
	
	
	
	
	
	//프로필 업데이트
	updateInfo=function(selectedTag){
		//1. 데이터가 잘 들어왔는지 체크
		//1) 데이터 수정있으면 입력형태를 맞는지 체크후 틀리면 못쓰게막기
		
		//2. 프로필 수정
		//1) 세션의 비번과 기존 비밀번호의 입력 데이터 비교
		//2) 입력받은 형태값중 널값이 있으면 기존값으로 입력
		//3) 입력형태가 맞지않으면 초기화
		
		
		//1-1)
		const password0 = $(selectedTag).attr('data-password0');
		const password = $('#login_password').val();
		//let nickname = $('#memNickname').val();
		//let nickname1 = $('#memNickname1').val();
		
		
		if(password0 != password){
			alert('기존 비밀번호를 정확히 입력해주세요.');
			//alert(password0);
			//alert(password);
			return;
		}
		//if(nickname == null && nickname == ''){
		//	nickname = nickname1;
		//}
		alert('수정되었습니다.');
		$('#updateForm').submit();
      };
	
	
	
	
	
	/*
	updateInfo=function(){
		//입력된 데이터의 유효성을 검증(Validation)	
		//검증다되면 submit
		//정규식 -> 숫자만,문자만,특수기호x,이메일,주민번호
		const id = $('#id').val();
		const tel2 = $('#tel2').val();
		//숫자만 들어오게 하는 정규식
		const regexp = /^[0-9]*$/;
		
		if(id==''){//id가 빈값인경우
			alert('id가 비었음.');
			return;
		}
		else if(id.length > 10){
			alert('id는 10자이하로 작성하십쇼.');
			return;
		}
		else if(!regexp.test(tel2)){
			alert('연락처는 숫자만 입력 가능합니다.');
			return;
		}
		$('#joinForm').submit();
	}
	
	*/
	
})(jQuery);