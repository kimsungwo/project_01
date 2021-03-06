/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	$(document).on('click', '#sample', function(){
		
	});
	
	//매장주의 매장들에 새로운 주문이 들어오는지 20초마다 확인
	const isOwner = $('#isOwner').val();
	if(isOwner != undefined){
		let orderTimerId = setInterval(function(){
			checkCafeCodeList();
		}, 20000)
	}
	

	//주문자의 주문 상태를 20초마다 확인
	const isMem = $('#isMem').val();
	if(isMem != undefined){
		let memberTimerId = setInterval(function(){
			memberConfirm();
		}, 20000)
	}
	
});

/* 함수선언 영역*/
(function($){
	checkCafeCodeList = function(){
		$.ajax({
            url: '/owner/selectCafeCodeToOwner', //요청경로
            type: 'post',
            data:{}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
               if(result[0].cafeCode != ''){
            	   orderConfirm();
               }
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	
	
    orderConfirm = function(){
    	$.ajax({
            url: '/owner/checkOrderConfirm', //요청경로
            type: 'post',
            data:{}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
	           let str = '';
	           if(result[0]){
	        	   str += result[0].cafeName + '에 새로운 주문이 접수되었습니다\n확인하러 가시겠습니까?';
	        	   let res = confirm(str);
	        	   if(res){
	        		   updateIsRead(result[0].buyCode);
	        		   location.href = '/owner/orderConfirm?cafeCode=' +result[0].cafeCode;
	        	   }
	           }
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
    }
    
    memberConfirm = function(){
    	$.ajax({
            url: '/member/checkMemberConfirm', //요청경로
            type: 'post',
            data:{}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	let str = '';
            	if(result[0]){
            		if(result[0].buyStatus == '0'){
            			str += result[0].buyDate + '\n' + result[0].cafeName + '의 주문이 취소되었습니다\n';
            			if(result[0].orderMessage != '' && result[0].orderMessage != null){
            				str += '취소 사유 : ' + result[0].orderMessage;
            			}
            		}
            		else if(result[0].buyStatus == '2'){
            			str += result[0].buyDate + '\n' + result[0].cafeName + '의 주문이 접수되었습니다\n';
            			if(result[0].orderMessage != '' && result[0].orderMessage != null){
            				str += '매장 메시지 : ' + result[0].orderMessage;
            			}
            		}
            		alert(str);
            		updateIsRead(result[0].buyCode);
            		location.href = '/member/buyList';
            	}
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

    }
    
    updateIsRead = function(buyCode){
    	$.ajax({
            url: '/buy/readMessage', //요청경로
            type: 'post',
            data:{'buyCode' : buyCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

    }
    
    
})(jQuery);