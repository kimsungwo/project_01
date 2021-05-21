/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	let menuOptionGroupCode = $('#meunOptionGroupType').attr('data-menuOptionGroupCode');
	selectGroupSelectedList(menuOptionGroupCode);
	
	$(document).on('click', '.insertOptionBtn', function(){
		const menuOptionName = $('#menuOptionName').val();
		const menuOptionPrice = $('#menuOptionPrice').val();
		const selectedTag = $(this);
		if(menuOptionName == ''){
			alert('옵션명을 입력해주세요');
			$('#menuOptionName').focus();
			return;
		}
		else if(menuOptionPrice == ''){
			alert('가격을 입력해주세요');
			$('#menuOptionPrice').focus();
			return;
		}
		else{
			insertOption(menuOptionName, menuOptionPrice, selectedTag);
		}
	});
	
	$(document).on('change', '#meunOptionGroupType', function(){
		const selectedTag = $(this);
		let menuOptionGroupType = '';
		if($(this).prop('checked') == true){
			menuOptionGroupType = '1';
			updateOptionGroupType(menuOptionGroupType, selectedTag);
		}
		else{
			menuOptionGroupType = '0';
			updateOptionGroupType(menuOptionGroupType, selectedTag);
		}
	});
	
	$(document).on('hidden.bs.modal', '#insertLinkMenu', function(){
		$('#insertMenuList').empty();
	});
	
	$(document).on('hidden.bs.modal', '#deleteLinkMenu', function(){
		$('#deleteMenuList').empty();
	});
	
	$(document).on('click', '.linkMenuBtn', function(){
		const selectedTag = $(this);
		const menuOptionGroupCode = $('#meunOptionGroupType').attr('data-menuOptionGroupCode');
		let result = confirm('옵션에 메뉴를 추가하시겠습니까?')
		if(result){
			insertLinkMenu(selectedTag, menuOptionGroupCode);
		}
		else{
			return;
		}
	});
	
	$(document).on('click', '.deleteLinkedMenuBtn', function(){
		const selectedTag = $(this)
		let result = confirm('옵션에 메뉴를 삭제하시겠습니까?')
		if(result){
			deleteLinkedMenu(selectedTag);
		}
		else{
			return;
		}
	});
	
	$(document).on('click', '.deleteOptionBtn', function(){
		const selectedTag = $(this);
		let result = confirm('옵션을 삭제하시겠습니까?');
		if(result){
			deleteOption(selectedTag);
		}
	});
	
	//메뉴 옵션 가격 
	$(document).on('keyup paste', '#menuOptionPrice', function(){
		let menuOptionPrice = $('#menuOptionPrice').val();
		let regex= /^[0-9]/g;
		if(!regex.test(menuOptionPrice)){
			alert('숫자만 입력하세요');
			$(this).val('');
		}
		else if(menuOptionPrice == '' || menuOptionPrice == null){
			return;
		}
	})
	
	
});

/* 함수선언 영역*/
(function($){
	insertOption = function(menuOptionName, menuOptionPrice, selectedTag){
		const menuOptionGroupCode = selectedTag.attr('data-menuOptionGroupCode');
    	$.ajax({
            url: '/menu/insertOption', //요청경로
            type: 'post',
            data:{'menuOptionName' : menuOptionName, 'menuOptionPrice' : menuOptionPrice, 'menuOptionGroupCode' : menuOptionGroupCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	if(result == 1){
            		alert('옵션이 추가되었습니다');
            		selectOptionList(menuOptionGroupCode);
            		return;
            	}
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
    }
	
	deleteOption = function(selectedTag){
		const menuOptionCode = selectedTag.attr('data-menuOptionCode');
		$.ajax({
            url: '/menu/deleteOption', //요청경로
            type: 'post',
            data:{'menuOptionCode' : menuOptionCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	if(result == 1){
            		alert('옵션이 삭제되었습니다');
            		selectedTag.closest('tr').remove();
            	}
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	updateOptionGroupType = function(menuOptionGroupType, selectedTag){
		const menuOptionGroupCode = selectedTag.attr('data-menuOptionGroupCode');
		$.ajax({
            url: '/menu/updateOptionGroupType', //요청경로
            type: 'post',
            data:{'menuOptionGroupType' : menuOptionGroupType, 'menuOptionGroupCode' : menuOptionGroupCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	if(result == 1){
            		if(selectedTag.prop('checked') == true){
            			alert('필수 옵션으로 변경되었습니다');
            			return;
            		}
            		else{
            			alert('선택 옵션으로 변경되었습니다');
            			return;
            		}
            	}
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	selectOptionList = function(menuOptionGroupCode){
		$.ajax({
            url: '/menu/selectOptionList', //요청경로
            type: 'post',
            data:{'menuOptionGroupCode' : menuOptionGroupCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	let str = '';
            	$('#selectOptionList').empty();
            	if(result == null || result == ''){
             	   str += '<tr class="text-center"><td colspan="2">등록된 옵션이 없습니다</td></tr>';
                }
                else {
             	   $(result).each(function(i){
             		   str += '<tr>';
             		   str += '<td><h5>' + result[i].menuOptionName + '</h5>';
             		   str += '<h6>' + result[i].menuOptionPrice.toLocaleString() +'원</h6></td>';
             		   str += '<td class="text-center"><input type="button" value="삭제" class="btn btn-danger btn-sm deleteOptionBtn" data-menuOptionCode="' + result[i].menuOptionCode +'">';
             		   str += '</td>';
             		   str += '</tr>';
             	   })
             	   $('#selectOptionList').append(str).hide();
                   $('#selectOptionList').fadeIn(500);
               } 
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	selectGroupMenuList = function(menuOptionGroupCode){
		$.ajax({
            url: '/menu/selectGroupMenuList', //요청경로
            type: 'post',
            data:{'menuOptionGroupCode' : menuOptionGroupCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	let str = '';
            	if(result == null || result == ''){
            		str += '<tr class="text-center"><td colspan="2">추가할 메뉴가 없습니다</td></tr>';
            		$('#insertMenuList').append(str);
            	}
            	else{
            		$(result).each(function(i){
            			str += '<tr>';
            			str += '<td>' + result[i].menuName + '</td>';
            			str += '<td><input type="button" value="추가" class="btn btn-primary btn-sm linkMenuBtn" data-menuCode="' + result[i].menuCode +'"></td>';
            			str += '</tr>';
            		})
            		$('#insertMenuList').append(str);
            	}
            
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	insertLinkMenu = function(selectedTag, menuOptionGroupCode){
		const menuCode = selectedTag.attr('data-menuCode');
		$.ajax({
            url: '/menu/insertLinkMenu', //요청경로
            type: 'post',
            data:{'menuCode' : menuCode, 'menuOptionGroupCode' : menuOptionGroupCode}, //필요한 데이터
            success: function(result) {
               if(result == 1){
            	   alert('메뉴가 추가되었습니다');
            	   /*selectedTag.closest('tr').remove();*/
            	   $('#insertMenuList').empty();
            	   selectGroupMenuList(menuOptionGroupCode);
            	   selectGroupSelectedList(menuOptionGroupCode);
               }
            	
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	selectLinkedMenuList = function(menuOptionGroupCode){
		$.ajax({
            url: '/menu/selectLinkedMenuList', //요청경로
            type: 'post',
            data:{'menuOptionGroupCode' : menuOptionGroupCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	let str = '';
            	if(result == null || result == ''){
            		str += '<tr class="text-center"><td colspan="2">삭제할 메뉴가 없습니다</td></tr>';
            		$('#deleteMenuList').append(str);
            	}
            	else{
            		$(result).each(function(i){
            			str += '<tr>';
            			str += '<td>' + result[i].menuName + '</td>';
            			str += '<td><input type="button" value="삭제" class="btn btn-danger btn-sm deleteLinkedMenuBtn" data-groupSelectedCode="' + result[i].groupSelectedCode +'" data-menuOptionGroupCode="' + menuOptionGroupCode +'"></td>';
            			str += '</tr>';
            		})
            		$('#deleteMenuList').append(str);
            	}
            
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	deleteLinkedMenu = function(selectedTag){
		const groupSelectedCode = selectedTag.attr('data-groupSelectedCode');
		const menuOptionGroupCode = selectedTag.attr('data-menuOptionGroupCode');
		$.ajax({
            url: '/menu/deleteLinkedMenu', //요청경로
            type: 'post',
            data:{'groupSelectedCode' : groupSelectedCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	alert('메뉴가 삭제되었습니다');
            	const menuOptionGroupCode = $('#meunOptionGroupType').attr('data-menuOptionGroupCode');
            	/*selectedTag.closest('tr').remove();*/
            	$('#deleteMenuList').empty();
            	selectLinkedMenuList(menuOptionGroupCode);
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	selectGroupSelectedList = function(menuOptionGroupCode){
		$.ajax({
            url: '/menu/selectLinkedMenuList', //요청경로
            type: 'post',
            data:{'menuOptionGroupCode' : menuOptionGroupCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	let str = '';
            	if(result == null || result == ''){
             	   str += '연결된 메뉴가 없습니다';
                }
                else {
             	   $(result).each(function(i){
             		  str += result[i].menuName;
             		  if(result[i+1] != null){
             			  str += ', ';
             		  }
             	   })
               } 
            	$('#linkedMenuList').text(str);
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
	}
	
})(jQuery);