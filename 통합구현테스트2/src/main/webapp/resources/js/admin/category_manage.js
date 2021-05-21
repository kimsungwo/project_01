/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	/* $(document).on('click','.delete',function() {
		var a = $(this).parent().prev().prev().text();
		a=confirm("진짜 삭제할?");
		if(a){
			location.href='/admin/deleteCategory?categoryCode='+categoryCode
			
		}
		else{
			location.href='/admin/categoryManage?categoryCode='+categoryCode
		}
	})*/

});
/* 함수선언 영역*/
(function($){
	deleteCategory = function(categoryCode){
		const result = confirm('ㄹㅇ삭제하싈?');
		
		if(result){
			location.href='/admin/deleteCategory?categoryCode='+categoryCode
		}
		else{
			location.href='/admin/categoryManage?categoryCode='+categoryCode
		}
		
	}
	
	
})(jQuery);