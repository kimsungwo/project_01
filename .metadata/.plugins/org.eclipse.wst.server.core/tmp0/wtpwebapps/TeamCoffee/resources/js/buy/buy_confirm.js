/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	$(document).on('click', '#sample', function(){
		
	});
	
	let totalPrice = 0;
	$('.cartPrice').each(function(){
		totalPrice = parseInt(totalPrice) + parseInt($(this).text().replace(/,/g, ""));
		$('.totalPrice').text(totalPrice.toLocaleString());
		$('.buyPrice').text(totalPrice.toLocaleString());
		$('.hiddenBP').val(totalPrice);
	})
	
	$(document).on('click', '#pointBtn', function(){
		
		let usePoint = parseInt($('#memPoint').val());
		const memPoint = parseInt($('#point').text());
		const totalPrice = $('.totalPrice').text().replace(/,/g, "");
		if(usePoint > memPoint){
			alert('적립금은 ' + memPoint + '원 까지 사용 가능합니다');
			$('#memPoint').val(0);
			$('.buyPrice').text(totalPrice.toLocaleString());
			$('.hiddenBP').val(totalPrice);
			return;
		}
		else if(usePoint > totalPrice){
			alert('적립금은 합계 금액을 초과할 수 없습니다');
			$('#memPoint').val(0);
			$('.buyPrice').text(totalPrice.toLocaleString());
			$('.hiddenBP').val(totalPrice);
			return;
		}
		else if(isNaN(usePoint)){
			usePoint = 0;
		}
		
		let buyPrice = totalPrice - usePoint;
		$('.buyPrice').text(buyPrice.toLocaleString());
		$('.hiddenBP').val(buyPrice);
		$('#usePoint').val(usePoint);
		$('#usePointSpan').text(usePoint);
	})
	
	$("#check_module").click(function () {
		var IMP = window.IMP; // 생략가능
		let buyTitle = $('#buyMenu').val();
		if($('#buyListSize') != 0){
			buyTitle += ' 외 ' + $('#buyListSize').val() + '건';
		}
		const email = $('#memEmail').val();
		const name = $('#memNickname').val();
		const tel = $('#memTel').val();
		const addr = $('#memAddr').val();
		const addrDetail = $('#memAddrDetail').val();
		const price = $('.hiddenBP').val();
		if(tel == '' || tel == null){
			alert('연락처를 입력해주세요');
			$('#memTel').focus();
			return;
		}
		
		
		IMP.init('imp25564259');
		// 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
		// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
		IMP.request_pay({
			pg : 'html5_inicis', // version 1.1.0부터 지원.
			/*
			 * 'kakao':카카오페이, html5_inicis':이니시스(웹표준결제) 'nice':나이스페이
			 * 'jtnet':제이티넷 'uplus':LG유플러스 'danal':다날 'payco':페이코 'syrup':시럽페이
			 * 'paypal':페이팔
			 */

			pay_method : 'card',
			/*
			 * 'samsung':삼성페이, 'card':신용카드, 'trans':실시간계좌이체, 'vbank':가상계좌,
			 * 'phone':휴대폰소액결제
			 */
			merchant_uid : 'merchant_' + new Date().getTime(),
			/*
			 * merchant_uid에 경우 https://docs.iamport.kr/implementation/payment
			 * 위에 url에 따라가시면 넣을 수 있는 방법이 있습니다. 참고하세요. 나중에 포스팅 해볼게요.
			 */
			
			name : buyTitle,
			// 결제창에서 보여질 이름
			amount : 100,
			// 가격
			buyer_email : email,
			buyer_name : name,
			buyer_tel : tel,
			buyer_addr : addr + addrDetail,
			buyer_postcode : '00000',
			m_redirect_url : '/buy/buy_complete'
		/*
		 * 모바일 결제시, 결제가 끝나고 랜딩되는 URL을 지정 (카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로
		 * callback함수로 결과가 떨어짐)
		 */
		}, function(rsp) {
			console.log(rsp);
			if (rsp.success) {
				var msg = '결제가 완료되었습니다.';
				msg += '고유ID : ' + rsp.imp_uid;
				msg += '상점 거래ID : ' + rsp.merchant_uid;
				msg += '결제 금액 : ' + rsp.paid_amount;
				msg += '카드 승인번호 : ' + rsp.apply_num;
				
			} else {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
			}
			alert(msg);
			if(rsp.success){
				insertBuyList();
			}
		});
	});


});

/* 함수선언 영역*/
(function($){

	insertBuyList = function(){
		const cafeCode = $('#ccc').attr('data-cafeCode');
		const totalPrice = $('.hiddenBP').val();
		const buyRequests = $('#buyRequests').val();
		const buyMemTel = $('#memTel').val();
		if(buyMemTel == '' || buyMemTel == null){
			alert('연락처를 입력해주세요');
			$('#memTel').focus();
			return;
		}
    	$.ajax({
            url: '/buy/insertBuyList', //요청경로
            type: 'post',
            data:{'cafeCode' : cafeCode, 'totalPrice' : totalPrice, 'buyRequests' : buyRequests, 'buyMemTel' : buyMemTel}, //필요한 데이터
            success: function(result) {
            	insertPointHistory();
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
    }
	
	insertPointHistory = function(){
		const pointChange = parseInt(-$('#usePoint').val());
		const pointChangeName = '결제 시 사용';
		if(pointChange != 0){
			$.ajax({
				url: '/member/insertPointHistory', //요청경로
				type: 'post',
				data:{'pointChangeName' : pointChangeName, 'pointChange' : pointChange}, //필요한 데이터
				success: function(result) {
					//ajax 실행 성공 후 실행할 코드 작성
					updateMemPoint();
				},
				error: function(){
					//ajax 실행 실패 시 실행되는 구간
					alert('실패');
				}
			});
		}
		else{
			deleteCart();
		}
	}
	
	updateMemPoint = function(){
		const memPoint = parseInt(-$('#usePoint').val());
		$.ajax({
            url: '/member/updateMemPoint', //요청경로
            type: 'post',
            data:{'memPoint' : memPoint}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	deleteCart();
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	deleteCart = function(){
    	$.ajax({
            url: '/cart/deleteCart', //요청경로
            type: 'post',
            data:{}, //필요한 데이터
            success: function(result) {
            	location.href = '/member/buyList';
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
    }
	
})(jQuery);