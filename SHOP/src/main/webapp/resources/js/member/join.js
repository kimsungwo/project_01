/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//jsp로딩후 바로 validation을 세팅해줘야됨.
	initValidation();

});
/* 함수선언 영역*/
(function($){
   //aaa = function(){}
	openPostCode=function(){    
		new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
        	  // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            $('#addr').val(roadAddr);
        }
		}).open();
	}
	join=function(){
		//입력된 데이터의 유효성을 검증(Validation)	
		//검증다되면 submit
		//ID는 반드시 입력받아야 하고, 10자를 초과하면 안됨
		//연락처는 반드시 숫자만 4자리 글자가 들어와야된다.
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
	
	
	
	initValidation=function(){
		//특수문자를 제외하는 정규식을 validation에 추가
		jQuery.validator.addMethod("alphanumeric", function(value, element) {
			return this.optional(element) || !/[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/.test(value);
		});
		$("#joinForm").validate({ //여기서 들어올값은 유효성 검사할 대상 
	        // 테스트를 위하여 유효성 검사가 완료되어도 submit을 처리하지 않음.
	        debug : true,
	        //유효성 검사를 제외할 엘레먼트를 넣는다.
	        // ignore: ".ignore",
	        //포커스가 떠날 때 유효성 검사를 한다.
	        onfocusout: function(element) { 
	              $(element).valid(); 
	           },
	            //각각의 input태그에 필요한 검증조건을 나열
	        	rules : {
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
	        		id : {//input태그의 name속성이 id인것의 규칙을 지정하겠음.
	        			required : true
	        			, minlength : 4
	        		}
					, name : { 
						required : true
						, minlength : 3
					}
					, password : {
						equalTo : confirm_pw
					}
					,  tels : {
						required : true
						, maxlength : 4
						, minlength : 4
						, digits : true
					}
					, addrDetail : {
						required : true
						, alphanumeric : true
					}
					
	        	},
	        	//검사를 충족하지 못할 경우,
	        	//위의 rules의 조건을 만족하지 못했을경우 표시될 메시지의 나열                                                         
	        	messages : {
	        		id:{
	        			required : '필수 입력'
	        			, minlength : '최소{0}글자'
	        		}
	        		, name : { 
						required : '필수 입력, 이름도' 
						, minlength : '최소{0}글자'
							
					}
	        		, password : {
	        			equalTo : '패스워드가 일치하지 않습니다.'
	        		}
	        		, tels : {
	        			required : '필쑤입니다.'
						, maxlength : '최대{0}글자'
						, minlength : '최소{0}글자'
						, digits : '숫자만 쓰십쇼'
					}
	        		, addrDetail : {
						required : '주소가 없으십니가...'
						, alphanumeric : '특수문자ㄴㄴ'
					}
	        	}
	        	//조건검사후 검증 실패시 실행되는 코드
	        	//만약 작성하지 않으면 기본적으로 input태그의 우측에 
	        	//error메세지를 나타낸다.
	        	
	        	/*
	        	,
	        	errorPlacement: function(error, element){
	        		alert(123);
	        	}*/
	        	,//validation처리가 성공하면 기본적으로 폼태그를 submit한다.
	        	//만약, 검증 후 submit이 아닌 다른 기능을 수행하고자 할때 
	        	//아래의 영역에 필요한 소스를 구현 예를들어 ajax로 간다거나,
	        	//form태그말고 다른거할때
	        	submitHandler: function(form) {
	        	
	        	}
	        	


	   });
		
		
		
		
	}
	
})(jQuery);





/*join=function(){
	//입력된 데이터의 유효성을 검증(Validation)	
	//검증다되면 submit
	$('#joinForm').submit();
}*/

/*
$("").validate({
    // 테스트를 위하여 유효성 검사가 완료되어도 submit을 처리하지 않음.
   // debug : true,
    //유효성 검사를 제외할 엘레먼트를 넣는다.
    ignore: ".ignore",
    //포커스가 떠날 때 유효성 검사를 한다.
    onfocusout: false,
       rules : {
      
     
    },
    //검사를 충족하지 못할 경우 표시될 메시지의 나열                                                         
    messages : {
      
    },
    errorPlacement: function(error, element){
      
    },
    submitHandler: function(form) {
       

    }


});*/

























