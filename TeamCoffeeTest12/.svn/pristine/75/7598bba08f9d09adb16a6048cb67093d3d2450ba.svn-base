/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//벨리데이션 초기화
	initValidation();
	
	$(document).on('click', '#sample', function(){
	
	});
	
});

/* 함수선언 영역*/
(function($){
	
	initValidation = function(){
		
		jQuery.validator.addMethod("alphanumeric", function(value, element) {
	           return this.optional(element) || !/[\{\}\[\]\/?,;:|\)*~`!^\-_+<>\#$%&\\\=\(\'\"]/.test(value);
		    });
			
			jQuery.validator.addMethod("regType1", function(value, element) {
			   return this.optional(element) ||  /^[A-Za-z0-9+]*$/.test(value);
			});
	   
	   $("#joinForm").validate({
	        // 테스트를 위하여 유효성 검사가 완료되어도 submit을 처리하지 않음.
	        debug : false,
	        //유효성 검사를 제외할 엘레먼트를 넣는다.
	        //ignore: ".ignore",
	        //포커스가 떠날 때 유효성 검사를 한다.
	        onfocusout: function(element){
	        	$(element).valid();
	        },
	        	//각각의 input태그에 필요한 검증 조건 나열
	           rules : {
	        	/*
	        	 input태그의 name속성 값 : {
	        	 	required : true -> 필수 입력값 지정
	        	 	, number : true -> 숫자만 입력, 음수,양수,실수 
	        	 	, digits : true -> 숫자만 입력, 양의 정수
	        	 	, email : true -> 이메일 형식
	        	 	, maxlength : 10 -> 글자수 10개로 제한
	        	 	, minlength : 5 -> 최소 글자수
	        	 	, equalTo : 대상 요소의 id -> 입력값 일치 여부
	        	 }
	        	 */
	        	 memId : {
	        		 required : true
	        		 , minlength : 3
	        		 , maxlength : 10
	        		 , regType1 : true
	        	 },
	        	 memNickname : {
	        		 required : true
	        	 },
	        	 memPw : {
	        		 required : true
	        	 },
	        	 memAddr : {
	        		 required : true
	        	 },
	        	 memTel : {
	        		 required : true
	        	 },
	        	 memEmail : {
	        		 required : true
	        		 , alphanumeric : true
	        	 }
	         
	        },
	        //검사를 충족하지 못할 경우 표시될 메시지의 나열                                                         
	        messages : {
	        	 memId : {
	        		 required : '필수 입력 사항입니다'
	        		, minlength : '3 ~ 10 사이의 글자수만 가능합니다'
	     	        , maxlength : '3 ~ 10 사이의 글자수만 가능합니다'
	     	        , regType1 : '영 대,소문자 / 숫자만 가능합니다'	 
	        	 },
	        	 memNickname : {
	        		 required : '필수 입력 사항입니다'
	        	 },
	        	 memPw : {
	        		 required : '필수 입력 사항입니다'
	        	 },
	        	 memAddr : {
	        		 required : '필수 입력 사항입니다'
	        	 },
	        	 memTel : {
	        		 required : '필수 입력 사항입니다'
	        	 },
	        	 memEmail : {
	        		 required : '필수 입력 사항입니다'
	        		, alphanumeric : '특수문자는 사용불가합니다'
	        	 }
	        }
	        //조건 검사 후 유효성검증 실패 시 실행되는 코드. 만약 작성하지 않으면 기본적으로 input태그의 우측에 에러메세지를 나타낸다
//		        errorPlacement: function(error, element){
//		          
//		        },
	        //validation 처리가 성공하면 기본적으로 폼태그를 submit한다. 만약 검증 후 submit이 아닌 다른 기능을 수행하고자 할때
	        //아래 영역에 필요한 소스를 구현
//		        submitHandler: function(form) {
//		           $('#joinForm').submit();
//
//		        }


	   });
   }
	
	//우편번호 검색 함수
	openPostCode = function(){
        new daum.Postcode({
            oncomplete: function(data) {
                var roadAddr = data.roadAddress;
                $('#inputAddr').val(roadAddr);
            }
        }).open();
    }
	
	//아이디 중복체크
	memIdCheck = function() {
		const memId = $('#inputId').val();
		if(memId == '') {
			alert('아이디를 입력 해 주세요');
			return;
		}
		$.ajax({
            url: '/member/memIdCheck', //요청경로
            type: 'post',
            data:{'memId' : memId}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
               if(result != ''){
            	   alert('이미 등록된 아이디입니다');
            	   $('#inputId').val('');
            	   $('#inputId').removeClass('is-valid');
               }
               else {
            	   alert('사용 가능한 아이디입니다');
               }
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
	}
	
	//이메일 중복체크
	memEmailCheck = function() {
		const memEmail = $('#inputEmail').val();
		if(memEmail == '') {
			alert('이메일을 입력 해 주세요');
			return;
		}
		$.ajax({
            url: '/member/memEmailCheck', //요청경로
            type: 'post',
            data:{'memEmail' : memEmail}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
               if(result != ''){
            	   alert('이미 등록된 이메일입니다');
            	   $('#inputEmail').val('');
            	   $('#inputEmail').removeClass('is-valid');
               }
               else {
            	   alert('사용 가능한 이메일입니다');
               }
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