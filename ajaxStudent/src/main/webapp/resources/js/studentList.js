/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//셀렉트 박스의 값 변경시
    $(document).on('change', '#classSelector', function(){
    	//셀렉트 박스의 값이 바뀔때
    	//바뀐 학급의 classCode를 alert로 띄워보세요.
    	//var classCode = $('#classSelector').val();
    	//location.href='/student/studentList?classCode=' +classCode;
    	selectStudentList();
    	$('#scoreTd').empty();//반바뀔때마다 내용 비워주기
    });
    
    $(document).on('click', '.deletS', function() { 
    	const selectedTag = $(this);
    	/*const stuNum = $(this).attr('data-stuNum');*/
    	
    	deleteStudent(selectedTag);
    });
    	 

    
    
});



(function($){
	selectScore = function(stuNum){
		$.ajax({
            url: '/student/selectScore', //요청경로
            type: 'post',
            data:{'stuNum':stuNum}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	let str = '';
            	str += '<table class="inner">';
            	str += '<tr>';
            	str += '<th>국어점수</th>';
            	str += '<th>영어점수</th>';
            	str += '<th>수학점수</th>';
            	str += '</tr>';
            	str += '<tr>';
            	str += '<td>'+result.korScore+'</td>';
            	str += '<td>'+result.engScore+'</td>';
            	str += '<td>'+result.mathScore+'</td>';
            	str += '</tr>';
            	str += '</table>';
            	str += '';
            	str += '';
            	
            	$('#scoreTd').empty();//해당값을 비운다.
            	
            	
            	$('#scoreTd').append(str);//작성한 html코드를 다시 테이블에[ 붙인다.
 
            	
            },
            error: function(){
                //ajax 실행 실패 시 실행되는 구간
                  alert('실패');
               }
          });
	}
	
   //aaa = function(){}
	selectStudentList=function(){
		//학급코드 데이터
		const classCode = $('#classSelector').val();
		
		$.ajax({
            url: '/student/selectStudentListAjax', //요청경로
            type: 'post',
            data:{'classCode':classCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	
            	//선택한 태그의 안쪽내용을 지운다.
            	$('.inner').empty();
            	
            	//새로 화면에 뿌려질 html코드를 작성.
            	let str = '';
            	str += '<tr class="menu">';
            	str += '<td>이름</td>';
            	str += '<td>나이</td>';
            	str += '<td>주소</td>';
            	str += '<td>삭제</td>';
            	str += '</tr>';
        
            	$(result).each(function(index, element){      //.each각각 안에있는 내용을 실행
            		str += '<tr class="menu">';						//  \이거넣으면 다음에 넣을걸 문자열로 인식
                	str += '<td><a  href="#"  onclick="selectScore(\''+element.stuNum+'\');">'+element.stuName +'</a></td>';
                	str += '<td>'+element.stuAge +'</td>';
                	str += '<td>'+element.stuAddr +'</td>';
                	str += '<td><div class="deletS" data-stuNum="'+element.stuNum+'">삭제</div></td>';
                	str += '</tr>';
            	});
            	//작성한 html코드를 다시 테이블에[ 붙인다.
            	$('.inner').append(str);

            	//result의 모든 내용을 콘솔로 출력
        //    	$(result).each(function(index, element){//result의 데이터갯수만큼 반복하는거임
            	//	console.log(index + ' / ' +element.stuName +' / '+result[index].stuName);
              	$(this).closest('tr').remove();
            	//});
            	
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
	}
	deleteStudent=function(selectedTag){
		const stuNum = $(selectedTag).attr('data-stuNum');
		$.ajax({
            url: '/student/deleteAjax', 
            type: 'post',
            data:{'stuNum':stuNum},
            success: function(result) {
            	if(result==1){
            		alert('삭제성공');
            	}
            	
            	//$(this).parent().parent().remove();
            	//closest 부모태그중 가장 가까이 있는 태그를 선택
            	//selectStudentList();
            	$(selectedTag).closest('tr').remove();
            	
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
		
	}
	

	
	
})(jQuery);