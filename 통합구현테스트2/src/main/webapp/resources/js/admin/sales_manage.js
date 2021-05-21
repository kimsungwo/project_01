/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//총매출액을 화면에 보여주는 기능.
	setSalesMoney();
	
	
	
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
	setSalesMoney= function(){
		let totalMoney = 0;
		$('.salesSpan').each(function(index, element){
			const money = parseInt($(element).text().trim().replace(/,/gi,''));
//			const money = $(element).text().trim().replace(/,/gi,'');
			totalMoney = totalMoney + money;
			console.log(money);
		}); 
		//alert(totalMoney);
		
		$('#totalPriceSpan').text(totalMoney.toLocaleString() +'원');
	}
	
	
	
	
	
	
})(jQuery);
	
	
	
/*	deleteCategory = function(categoryCode){
		const result = confirm('ㄹㅇ삭제하싈?');
		
		if(result){
			location.href='/admin/deleteCategory?categoryCode='+categoryCode
		}
		else{
			location.href='/admin/categoryManage?categoryCode='+categoryCode
		}
		
	}*/
	
	