/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	$(document).on('click', '#deleteBtn', function(){
		const selectedTag = $(this);
		deleteMember(selectedTag);
	});
});

/* 함수선언 영역*/
(function($){
	deleteMember=function(selectedTag){
	const password0 = $(selectedTag).attr('data-password');
	const password = $('#login_password').val();

	if(password0 != password){
		alert('정확히 입력하세요.');

		return;
	}
	$('#deleteForm').submit();
  };
	
})(jQuery);















/*	//우편번호 검색 함수
	openPostCode = function(){
        new daum.Postcode({
            oncomplete: function(data) {
                var roadAddr = data.roadAddress;
                $('#inputAddr').val(roadAddr);
            }
        }).open();
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
    }*/





/*
//비밀번호 미입력시 경고창
function checkValue(){
	if(!document.deleteform.password.value){
    	alert("비밀번호를 입력하지 않았습니다.");
        return false;
    }
}*/