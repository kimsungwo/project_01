/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	   
	

    $(document).on('click', '.updatePriceBtn', function(){
    	const itemPrice =  parseInt($(this).prev().val().trim().replace(/,/gi,''));
    	const itemCode = $(this).attr('data-itemCode');
    	updateItemPrice(itemCode,itemPrice);
    });

    //가격이 변경될때마다 천단위 구분기호 세팅...
    $(document).on('keyup', '.priceRefresh', function(){
    	//const price = parseInt($(this).val().replace(/,/gi,'')).toLocaleString();
    	let price = $(this).val();
    	
    	if(price==''){
    		price=0;
    	}
    	else{
    		price = parseInt(price.replace(/,/gi,'')).toLocaleString();
    	}
    	$(this).val(price);
    });
    
    
    //상품상태 셀렉트박스값 변경시
    
    $(document).on('change', '.updateItemStatus', function(){
    	const originItemStock = parseInt($(this).attr('data-itemStock'));
    	if(originItemStock==0){
    		alert('재고부족으로 상태변경불가');
    		$(this).val(2);
    		return;
    	}
    	
    	const itemCode =$(this).attr('data-itemCode');
    	const itemStatus =$(this).val();
    	updateItemStatus(itemCode,itemStatus);
    });
    //셀렉트 박스의 값이 바뀔때
/*
    	selectStudentList();
    	$('#scoreTd').empty();//반바뀔때마다 내용 비워주기
    });
    
    $(document).on('click', '.deletS', function() { 
    	const selectedTag = $(this);

    	
    	deleteStudent(selectedTag);*/
    	 

	
	


});
/* 함수선언 영역*/
(function($){
	updateItemStock = function(selectedTag,itemCode){
		const result =  confirm('재고변경하실?'); //confirm는 확인,취소 두가지리턴이 있음.
		const itemStock = $(selectedTag).prev().val(); // prev()그앞에있는것
		if(result){ 
			$.ajax({
	            url: '/admin/updateItemStock', //이쪽으로 넘겨줌.대충 컨트롤러 간다보면됨.
	            type: 'post',
	            data:{'itemCode':itemCode,'itemStock':itemStock}, //필요한 데이터 내가 보낼변수명 :
	            								//값 커맨드객체로 보낼거라 변수명 일치시켜줌
	            success: function(result) {
	               //ajax 실행 성공 후 실행할 코드 작성
	               if(result==1){
	            	   alert('재고변경완료');
	            	   
	            	   //선택한 노드를 기준으로 부모요소들중 가장 가까이에있는
	            	   //노드를 찾아간다.
	            	   $(selectedTag).closest('td').next().children().eq(0).attr('data-itemStock', itemStock);
	            	   //eq(0)대신 .first(),또는 children의 매개변수로 ':first'넣어줘도됨
	            	   //attr('data-itemStock')여기서 attr('data-itemStock',)하면 뒤의값으로 바꾸는거임
	               }
	            },
	            error: function(){
	             //ajax 실행 실패 시 실행되는 구간
	               alert('이게 왜 실패?');
	            }
	      });		
		}
	}
	
	
	updateItemPrice = function(itemCode,itemPrice){
		const result =  confirm('가격변경하실?'); //confirm는 확인,취소 두가지리턴이 있음.
		if(result){ 	
		$.ajax({
				url: '/admin/updateItemPrice', //이쪽으로 넘겨줌.대충 컨트롤러 간다보면됨.
				type: 'post',
				data:{'itemCode':itemCode,'itemPrice':itemPrice}, //필요한 데이터 내가 보낼변수명 :
				//값 커맨드객체로 보낼거라 변수명 일치시켜줌
				success: function(result) {
					//ajax 실행 성공 후 실행할 코드 작성
					if(result!=null){
						alert('가격변경완료');
					}
				},
				error: function(){
					//ajax 실행 실패 시 실행되는 구간
					alert('아니 왜 실패?');
				}
			});	
		}
	}
	
	
	
	updateItemStatus = function(itemCode,itemStatus){
			$.ajax({
	            url: '/admin/updateItemStatus', //이쪽으로 넘겨줌.대충 컨트롤러 간다보면됨.
	            type: 'post',
	            data:{'itemCode':itemCode,'itemStatus':itemStatus}, //필요한 데이터 내가 보낼변수명 :
	            								//값 커맨드객체로 보낼거라 변수명 일치시켜줌
	            success: function(result) {
	                //ajax 실행 성공 후 실행할 코드 작성
	                alert('상품의 상태가 변경되었습니다.');
	             },
	             error: function(){
	              //ajax 실행 실패 시 실행되는 구간
	                alert('실패');
	             }
	      });		
	}
	
	
	
	
	
	
	
	
	
	
	
		
		/*$.ajax({
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
	}*/
	
   //aaa = function(){}
/*	selectStudentList=function(){
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
		
	}*/
	
	
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
	
	