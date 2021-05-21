/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	alert(111);
	//셀렉트 박스의 값 변경시
    $(document).on('change', '#classSelector', function(){
    	//셀렉트 박스의 값이 바뀔때
    	//바뀐 학급의 classCode를 alert로 띄워보세요.
    	//var classCode = $('#classSelector').val();
    	//location.href='/student/studentList?classCode=' +classCode;
    	selectStudentList();
    });
});
/* 함수선언 영역*/
(function($){
   //aaa = function(){}
		
/*	
	login = function()
     {
         inputForm = eval("document.loginInfo");
         if(!inputForm.id.value)
         {
             alert("아이디를 입력하세요");    
             inputForm.id.focus();
             return false;
         }
         if(!inputForm.password.value)
         {
             alert("비밀번호를 입력하세요");    
             inputForm.password.focus();
             return false;
         }
     }*/

	
})(jQuery);