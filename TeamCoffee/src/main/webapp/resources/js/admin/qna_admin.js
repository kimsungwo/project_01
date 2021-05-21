/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	let qnaMemberType = 'all';
	selectQnAList(qnaMemberType);
	
	$(document).on('change', '#selectMemberType', function(){
		qnaMemberType = $('#selectMemberType option:selected').val();
		selectQnAList(qnaMemberType);
	});
	
});

/* 함수선언 영역*/
(function($){
    selectQnAList = function(qnaMemberType){
    	$('.qnaList').empty();
    	$.ajax({
            url: '/admin/selectQnAList', //요청경로
            type: 'post',
            data:{'qnaMemberType' : qnaMemberType}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	let str = '';
            	if(result != ''){
            		$(result).each(function(i){
            			str += '<tr>';
            			str += '<td class="qnaStatus">' + result[i].qnaIsAnswerName + '</td>';
            			str += '<td><a href="/admin/qnaAdminDetail?boardNum=' + result[i].boardNum + '">' + result[i].boardName + '</a></td>';
            			str += '<td>' + result[i].boardWriter + '<span class="qnaMemberType">(' + result[i].memberType + ')</span></td>';
            			str += '<td class="qnaRegDate">' + result[i].boardRegDate + '</td>';
            			str += '</tr>';
            		})
            	}
            	else if(result == ''){
            		str += '<tr><td colspan="4" class="text-center">질문이 없습니다</td></tr>';
            	}
            	$('.qnaList').append(str);
            	$('.qnaList').hide();
            	$('.qnaList').fadeIn(500);
            	
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
    }
	
})(jQuery);