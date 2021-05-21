/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	initValidation();
	
	$(document).on('change', '#selectChain', function(){
		let chainCode = $("#selectChain option:selected").val();
		selectChain(chainCode);
	});
	
	$(document).on('change', '#imgFile', function(){
		const ext = $(this).val().split('.').pop().toLowerCase();
		if($.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1 ){
			resetFormElement($(this));
			alert('이미지 파일이 아닙니다');
		}
		else{
			const file = $('#imgFile').prop('files')[0];
			const blobURL = window.URL.createObjectURL(file);
			let str = '<div id="image_preview"><img src="" style="width:200px; height:200px;"></div>';
			$('#imgFile').after(str);
            $('#image_preview img').attr('src', blobURL);
            $('#image_preview').slideDown(); //업로드한 이미지 미리보기 
            $(this).slideUp(); //파일 양식 감춤
		}
	});
	
});

/* 함수선언 영역*/
(function($){
	
	//매장 등록 함수
	regCafe = function() {
		let chain = $("#selectChain option:selected").val();
		if(chain == ''){
			alert('체인점 목록을 선택 해 주세요');
			return;
		}
//		else {
//			var result = confirm('등록을 진행하시겠습니까?');
//			
//			if(result){
//				alert('매장 등록이 성공적으로 완료되었습니다.');
//				$('#regForm').submit();
//			}
//		}	
	}
	
	//체인점 선택시 해당 로고가 뜰 수 있게 ajax
	selectChain = function(chainCode) {
	    	$.ajax({
	            url: '/owner/selectChainLogo', //요청경로
	            type: 'post',
	            data:{'chainCode' : chainCode}, //필요한 데이터
	            success: function(result) {
	               //ajax 실행 성공 후 실행할 코드 작성
	            	if(result == 'noimage.jpg') {
	            		$('#logoDiv').empty();
	            		let str = '';
	            		str += '<div class="form-group">';
	            		str += '<label for="imgFile"></label>';
	            		str += '<input type="file" class="form-control-file" id="imgFile" name="file1">';
	            		str += '</div>';
	            		$('#logoDiv').after(str);
	            	}
	            	else if(result == '') {
	            		$('#logoDiv').empty();
	            	}
	            	else {
	            		$('.form-group').remove();
	            		$('#logoDiv').empty();
	            		let str = '';
	 	               str += '<img src="/resources/img/logo/' + result + '" width="200px">'
	 	               str += '<input type="hidden" value="'+ result + '" name="cafeLogo">'
	 	               $('#logoDiv').prepend(str);
	            	}
	            },
	            error: function(){
	             //ajax 실행 실패 시 실행되는 구간
	               alert('실패');
	            }
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
	
	initValidation = function(){
//		   jQuery.validator.addMethod("alphanumeric", function(value, element) {
//	           return this.optional(element) || !/[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/.test(value);
//		   });
		   
		   $("#regForm").validate({
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
		        	 cafeName : {
		        		 required : true
		        	 },
		        	 cafeTel : {
		        		 required : true
		        	 },
		        	 cafeAddr : {
		        		 required : true
		        	 },
		        	 cafeHoursArray : {
		        		 required : true
		        	 }
		         
		        },
		        //검사를 충족하지 못할 경우 표시될 메시지의 나열                                                         
		        messages : {
		        	cafeName : {
		        		 required : '필수 입력 사항입니다'
		        	 },
		        	 cafeTel : {
		        		 required : '필수 입력 사항입니다'
		        	 },
		        	 cafeAddr : {
		        		 required : '필수 입력 사항입니다'
		        	 },
		        	 cafeHoursArray : {
		        		 required : '필수 입력 사항입니다'
		        	 }
		        }
		        //조건 검사 후 유효성검증 실패 시 실행되는 코드. 만약 작성하지 않으면 기본적으로 input태그의 우측에 에러메세지를 나타낸다
//			        errorPlacement: function(error, element){
//			          
//			        },
		        //validation 처리가 성공하면 기본적으로 폼태그를 submit한다. 만약 검증 후 submit이 아닌 다른 기능을 수행하고자 할때
		        //아래 영역에 필요한 소스를 구현
//			        submitHandler: function(form) {
//			           $('#joinForm').submit();
	//
//			        }


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