/* 페이지 로딩 후 실행 */
$(document).ready(function(){


	
	
});
/* 함수선언 영역*/
(function($){
	id3=function(){    
		const title = $('#ti').val();	
		const id = $('#id').val();
		if(title != '' ){
			if(id != ''){
				$('#writer').submit();
			}
		}
		else{
			alert('제목이나 작성자 공간을 채워주시기 바랍니다.');
			return;
			//location.href='/admin/deleteCategory?categoryCode='+categoryCode
			
		}
	}

})(jQuery);