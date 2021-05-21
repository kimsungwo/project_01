/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//추가 버튼 클릭시
    $(document).on('click', '#addRow', function(){
    	//추가할 학급코드 구하기
    	const classCode = $('.codeTd').last().text();
    	const codeNumber = parseInt(classCode.substr(3,3)) +1 ;
    	
    	var number = codeNumber + '';//숫자 + 문자 = 문자열
    	
    	var a = '';
    	//문자열 길이표현 : 문자열.length
    	for(var i=0; i<3-number.length; i++){
    		a = a+ '0';//0의 갯수지정. 001~002~이런식으로 하기위해
    	}
    	var result = 'CL_' + a + number;
    	
    	
    	//var -> let, const
    	//const -> finally 변하지 않는 변수를 선언할 때 (java ->final) 얘가 속도가 훨빠름
    	//const를 주로쓰고 변화가 필요할때 let으로 써라.
		let str = '';
		str += '<tr>';
		str += '<td class = "codeTd">'+result+'</td>';
		str += '<td>';
		str += '<input type="text" name="className">';
		str += '<input type="hidden" name="classCode" value="'+result+'">';
		str += '</td>';
		str += '<td><input type="submit" value="등록"></td>';
		str += '</tr>';
    	$('#listTable').append(str);
    	//점수수정버튼 클릭시
/*    	var classCode = $('#classSelector').val();
    	location.href='/student/studentList?classCode=' +classCode;*/
    	
});
});
/* 함수선언 영역*/
(function($){
   //aaa = function(){}
	
	
	
})(jQuery);