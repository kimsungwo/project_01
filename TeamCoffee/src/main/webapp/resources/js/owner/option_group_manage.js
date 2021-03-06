/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	$('.menuList').each(function(){
		const selectedTag = $(this);
		selectGroupSelectedList(selectedTag);
	})
	$('.optionList').each(function(){
		const selectedTag = $(this);
		selectGroupOptionList(selectedTag);
	})
	
	$(document).on('click', '#insertOptionGroupBtn', function(){
		const cafeCode = $(this).attr('data-cafeCode');
		const menuOptionGroupName = $('#menuOptionGroupName').val();
		if(menuOptionGroupName == ''){
			alert('그룹명을 입력해주세요');
			return;
		}
		else{
			insertOptionGroup(cafeCode, menuOptionGroupName);
		}
	});
	
	$(document).on('click','.deleteOptionGroupBtn', function(){
		const selectedTag = $(this);
		const menuOptionGroupCode = $(this).attr('data-menuOptionGroupCode');
		let result = confirm('그룹을 삭제하시겠습니까?');
		if(result){
			deleteOptionGroup(selectedTag);
		}
	})
	
	
	
});

/* 함수선언 영역*/
(function($){
	insertOptionGroup = function(cafeCode, menuOptionGroupName){
		$.ajax({
            url: '/menu/insertOptionGroup', //요청경로
            type: 'post',
            data:{'cafeCode' : cafeCode, 'menuOptionGroupName' : menuOptionGroupName}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	if(result == 1){
            		alert('그룹이 추가되었습니다');
            		$('#insertOptionGroup').modal('hide');
            		selectOptionGroupList(cafeCode);
            	}
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	selectOptionGroupList = function(cafeCode){
		$.ajax({
            url: '/menu/selectOptionGroupList', //요청경로
            type: 'post',
            data:{'cafeCode' : cafeCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
               let str = '';
               $('#selectOptionList').empty();
               if(result == null || result == ''){
            	   str += '<tr class="text-center"><td colspan="2">등록된 메뉴가 없습니다</td></tr>';
               }
               else {
            	   $(result).each(function(i){
            		   str += '<tr>';
            		   str += '<td><h3><a href="/owner/optionManage?menuOptionGroupCode=' + result[i].menuOptionGroupCode +'">' + result[i].menuOptionGroupName +'</a></h3>';
            		   str += '<h6 class="optionList"data-menuOptionGroupCode="' + result[i].menuOptionGroupCode + '"></h6></td>';
            		   str += '<h5 class="menuList"data-menuOptionGroupCode="' + result[i].menuOptionGroupCode + '"></h5></td>';
            		   str += '<td class="text-center">';
            		   str += '<input type="button" value="삭제" class="btn btn-danger btn-sm deleteOptionGroupBtn"';
            		   str += 'data-menuOptionGroupCode=' + result[i].menuOptionGroupCode + '></td>';
            		   str += '</tr>';
            	   })
            	   $('#selectOptionList').append(str).hide();
            	   rename();
                   $('#selectOptionList').fadeIn(500);
              } 
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	deleteOptionGroup = function(selectedTag){
		const menuOptionGroupCode = selectedTag.attr('data-menuOptionGroupCode');
		$.ajax({
            url: '/menu/deleteOptionGroup', //요청경로
            type: 'post',
            data:{'menuOptionGroupCode' : menuOptionGroupCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
               if(result == 1){
            	   alert('그룹이 삭제되었습니다');
            	   selectedTag.closest('tr').remove();
               }
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	selectGroupSelectedList = function(selectedTag){
		const menuOptionGroupCode = selectedTag.attr('data-menuOptionGroupCode');
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
            	selectedTag.text(str);
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	selectGroupOptionList = function(selectedTag){
		const menuOptionGroupCode = selectedTag.attr('data-menuOptionGroupCode');
		$.ajax({
            url: '/menu/selectOptionList', //요청경로
            type: 'post',
            data:{'menuOptionGroupCode' : menuOptionGroupCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	let str = '';
            	if(result == null || result == ''){
             	   str += '등록된 옵션이 없습니다';
                }
                else {
             	   $(result).each(function(i){
             		  str += result[i].menuOptionName;
             		  if(result[i+1] != null){
             			  str += ', ';
             		  }
             	   })
               } 
            	selectedTag.text(str);
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	rename = function(){
		$('.menuList').each(function(){
			const selectedTag = $(this);
			selectGroupSelectedList(selectedTag);
		})
		$('.optionList').each(function(){
			const selectedTag = $(this);
			selectGroupOptionList(selectedTag);
		})
	}
	
	
})(jQuery);