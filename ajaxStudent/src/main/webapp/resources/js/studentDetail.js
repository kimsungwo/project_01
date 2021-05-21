/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//셀렉트 박스의 값 변경시
    $(document).on('click', '#updateBtn', function(){
    	$('input[type="text"]').prop('readonly',false);
    	$('#updateBtn').after('<input type="submit" value="수정하기">');
    	//점수수정버튼 클릭시
/*    	var classCode = $('#classSelector').val();
    	location.href='/student/studentList?classCode=' +classCode;*/
    	
});
});
/* 함수선언 영역*/
(function($){
   //aaa = function(){}
	
	
	
})(jQuery);