/* 페이지 로딩 후 실행 */
$(document).ready(function(){

});
/* 함수선언 영역*/
(function($){
	goPage=function(loginId){    
		//로그인유무체크후 페이지이동 or alert후 로그인창띄움
		if(loginId!= ''){ //null과 빈값은 다르다.
			$('#buyPage').submit(); //자바스크립트에서 폼태그 태우기
			//Form태그는 input 태그의 name값을 가져간다.
			
			
			
			
			
		}
		else{
			
			alert('로그인이 필요합니다. 고객님');
		}
		
		
		
		
	}
		
		
		
		
		
		
		
		
/*		new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
        	  // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            $('#addr').val(roadAddr);
            
            
        }
		}).open();*/
	
	
	
})(jQuery);