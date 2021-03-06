/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	$(document).on('change', '#selectOrder', function(){
		let order = $(this).val();
		const chainCode = $('#chainCode').val();
		location.href='/cafe/selectChain?order='+order + '&chainCode='+chainCode;
	});
});

/* 함수선언 영역*/
(function($){
	
	selectMapInfo = function(cafeCode){
		$.ajax({
            url: '/cafe/selectCafeMap', //요청경로
            type: 'post',
            data:{'cafeCode' : cafeCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	let str = '';
               $('.mapInfo').empty();
               str += '<div id="map" style="width:600px;height:500px;"></div>';
               str += '<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3e4301ac7e87ca3c730fd7d8a7002d1b&libraries=services"></script>';
               str += '<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3e4301ac7e87ca3c730fd7d8a7002d1b"></script>';
               str += '<script type="text/javascript">';
               str += 'var container = document.getElementById(\'map\');';
               str += 'var options = {';
               str += 'center: new kakao.maps.LatLng(33.450701, 126.570667),';
               str += 'level: 3';
               str += '};';
               str += 'var map = new kakao.maps.Map(container, options);';
               str += 'var geocoder = new kakao.maps.services.Geocoder();';
               str += 'geocoder.addressSearch(' + result + ', function (result, status) {';
               str += 'if (status === kakao.maps.services.Status.OK) {';
               str += 'var coords = new kakao.maps.LatLng(result[0].y, result[0].x);';
               str += 'var marker = new kakao.maps.Marker({';
               str += 'map: map,';
               str += 'position: coords });';
               str += 'map.setCenter(coords);';
               str += '}';
               str += '});';
               str += '</script>';
               $('.mapInfo').prepend(str);
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
	}
	
	/*cafeClick = function(cafeCode) {
		const menuCategoryCode = '';
		const result = confirm('메뉴정보를 보시겠습니까?')
		if(result) {
			location.href='/cafe/cafeInfoAndMenu?menuCategoryCode=' + menuCategoryCode +'&cafeCode=' + cafeCode;
		}
	}*/
	
	//좋아요(로그아웃상태)
	needLogin = function() {
		alert('로그인이 필요한 항목입니다.');
	}
	
	//좋아요(로그인상태)
	like_func = function(cafeCode, selectedTag){
		$.ajax({
            url: '/like/tolike', //요청경로
            type: 'post',
            data:{'cafeCode' : cafeCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	if(result == 1) {
            		$(selectedTag).children(':first').removeClass('bi-heart');
            		$(selectedTag).children(':first').addClass('bi-heart-fill');
            	}
            	else if(result == 0) {
            		$(selectedTag).children(':first').removeClass('bi-heart-fill');
            		$(selectedTag).children(':first').addClass('bi-heart');
            	}
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
	}
	
	selectReview = function(cafeCode) {
		$.ajax({
            url: '/review/reviewListbyCafeCode', //요청경로
            type: 'post',
            data:{'cafeCode' : cafeCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
               if(result.length == 0) {
            	   $('#reviewModalBody').empty();
            	   $('#reviewModalBody').prepend('<div class="text-center"><h5>등록된 리뷰가 없습니다</h5><div>');
               }
               else{
            	   let str = '';
            	   $('#reviewModalBody').empty();
            	   $(result).each(function(i){
            		   str += '<div class="reviewDiv">';
            		   str += '<div>';
            		   if(result[i].memProfileImg != null){
            			   str += '<img src="/resources/img/profile/' + result[i].memProfileImg + '" style="width:30px; border-radius:50px">';
            		   }
            		   str += result[i].memNickname;
            		   str += '<span class="subDetailTitle">' + result[i].reviewRegDate + '</span>';
            		   str += '</div>';
            		   if(result[i].reviewStar == 1) {
            			   str += '<div><span class="yellow-star">★</span><span class="gray-star">★★★★</span></div>';
            		   }
            		   else if(result[i].reviewStar == 2) {
            			   str += '<div><span class="yellow-star">★★</span><span class="gray-star">★★★</span></div>';
            		   }
            		   else if(result[i].reviewStar == 3) {
            			   str += '<div><span class="yellow-star">★★★</span><span class="gray-star">★★</span></div>';
            		   }
            		   else if(result[i].reviewStar == 4) {
            			   str += '<div><span class="yellow-star">★★★★</span><span class="gray-star">★</span></div>';
            		   }
            		   else if(result[i].reviewStar == 5) {
            			   str += '<div><span class="yellow-star">★★★★★</span></div>';
            		   }
            		   str += '<div>' + result[i].reviewContent + '</div>';
            		   if(result[i].reviewImg != null) {
            			   str += '<div><img src="/resources/img/review/' + result[i].reviewImg + '" style="width:100px"></div>';
            		   }
            		   str += '</div>';
            		   
            	   })
            	   $('#reviewModalBody').prepend(str);
               }
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
	}
	
	
    aaa = function(){
    	$.ajax({
            url: '', //요청경로
            type: 'post',
            data:{}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
               alert('성공');
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
    }
	
})(jQuery);