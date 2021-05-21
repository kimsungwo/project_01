/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	$('#optionManageDiv').hide();
	
	//매장 선택
	$(document).on('change', '#selectCafeList', function(){
		const cafeCode = $('#selectCafeList option:selected').val();
		if(cafeCode == ''){
			$('#selectCategoryForm').fadeOut(500, function(){
				$('#selectCategoryForm').empty();
			});
			$('#selectMenuForm').fadeOut(500, function(){
				$('#selectMenuForm').empty();
			});
			$('#optionManageDiv').fadeOut(500);
			return;
		}
		$('#selectCategoryForm').empty();
		$('#selectMenuForm').empty();
		selectCafeCategoryList(cafeCode);
		selectMenuForm(cafeCode);
		$('#optionManageDiv').fadeIn(500);
		insertMenuCategoryToDetailModal(cafeCode);
	});
	
	//카테고리 선택
	$(document).on('change', '#selectCategoryList', function(){
		const cafeCode = $('#selectCafeList option:selected').val();
		const categoryCode = $('#selectCategoryList option:selected').val();
		if(categoryCode == null){
			$('#selectMenuForm').fadeOut(500, function(){
				$('#selectMenuForm').empty();
			});
			return;
		}
		$('#selectMenuForm').empty();
		selectMenuForm(cafeCode ,categoryCode);
		insertMenuCategoryToDetailModal(cafeCode);
	});
	
	//메뉴 내용 변경
	$(document).on('click', '#updateMenuBtn', function(){
		const cafeCode = $('#selectCafeList option:selected').val();
		const menuCode = $('#menuCode').val();
		const menuName = $('#menuName').val();
		const menuPrice = $('#menuPrice').val();
		const menuCategoryCode = $('#menuCategoryCode option:selected').val();
		const menuInfo = $('#menuInfo').val();
		const menuStatus = $('#menuStatus option:selected').val();
		
		updateMenuDetail(menuCode, menuName, menuPrice, menuCategoryCode, menuInfo, menuStatus, cafeCode);
	});
	
	//메뉴 삭제
	$(document).on('click', '#deleteMenuBtn', function(){
		const cafeCode = $('#selectCafeList option:selected').val();
		const menuCode = $('#menuCode').val();
		const menuCategoryCode = $('#selectCategoryList option:selected').val();
		let result = confirm('메뉴를 삭제하시겠습니까?');
		if(result){
			deleteMenu(cafeCode, menuCategoryCode, menuCode);
		}
	});
	
	//옵션그룹관리 페이지 이동
	$(document).on('click', '#optionManageBtn', function(){
		const cafeCode = $('#selectCafeList option:selected').val();
		location.href='/owner/optionGroupManage?cafeCode=' + cafeCode;
	})
	
});

/* 함수선언 영역*/
(function($){
	selectCafeCategoryList = function(cafeCode){
    	$.ajax({
            url: '/menu/selectCafeCategoryList', //요청경로
            type: 'post',
            data:{'cafeCode' : cafeCode}, //필요한 데이터
            success: function(result) {
               let str = '';
               str += '<tr>';
               str += '<th scope="row">카테고리</th>';
               str += '<td><select id="selectCategoryList" class="form-control form-control-sm" name="menuCategoryCode">';
               str += '<option value="">전체보기</option>';
               for(let i = 0; i < result.length; i++){
            	   str += '<option value="' + result[i].menuCategoryCode + '">' + result[i].categoryName + '</option>';
               }
               str += '</select></td>';
               str += '</tr>';
               $('#selectCategoryForm').append(str).hide();
               $('#selectCategoryForm').fadeIn(500);
               
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
    }
	
	selectMenuForm = function(cafeCode, menuCategoryCode){
		$.ajax({
            url: '/menu/selectMenuList', //요청경로
            type: 'post',
            data:{'cafeCode' : cafeCode, 'menuCategoryCode' : menuCategoryCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	
               let str = '';
               if(result == null || result == ''){
            	   str += '<tr><td>등록된 메뉴가 없습니다</td></tr>'
               }
               else{
            	   $(result).each(function(i){
            		   str += '<tr>';
            		   if(result[i].menuImgName == 'no_image'){
            			   str += '<td></td>';
            		   }
            		   else{
            			   str += '<td><img src="/resources/img/' + result[i].menuImgName + '" class="menuImg"></td>';
            		   }
            		   str += '<td><a href="#" onclick="menuInfoDetail(\'' + result[i].menuCode + '\')" class="menuInfoDetail"';
            		   str += 'data-toggle="modal" data-target="#menuInfoDetail">' + result[i].menuName + '</a></td>';
            		   str += '<td>' + result[i].menuPrice.toLocaleString() + '원</td>';
            		   str += '<td>' + result[i].categoryName + '</td>';
            		   str += '<td>' + result[i].status + '</td>';
            		   str += '</tr>';
            	   })
               }
               
               $('#selectMenuForm').append(str).hide();
               $('#selectMenuForm').fadeIn(500);
               $('#selectCategoryList').val(menuCategoryCode).prop('selected', true);
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });
	}
	
	menuInfoDetail = function(menuCode){
		$.ajax({
            url: '/menu/selectMenuDetail', //요청경로
            type: 'post',
            data:{'menuCode' : menuCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	$('#menuCode').val(result.menuCode);
            	$('#menuImg').attr('src', '/resources/img/' + result.menuImgName);
            	$('#menuName').val(result.menuName);
            	$('#menuPrice').val(result.menuPrice.toLocaleString() + '원');
            	$('#menuCategoryCode').val(result.menuCategoryCode).prop('selected', true);
            	$('#menuInfo').val(result.menuInfo);
            	$('#menuStatus').val(result.menuStatus).prop('selected', true);
            	if(result.menuImgName == 'no_image'){
            		$('#menuImg').hide();
            	}
            	else{
            		$('#menuImg').show();
            	}
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	insertMenuCategoryToDetailModal = function(cafeCode){
		$.ajax({
            url: '/menu/selectCafeCategoryList', //요청경로
            type: 'post',
            data:{'cafeCode' : cafeCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	let str = '';
            	$(result).each(function(i){
            		str += '<option value="' + result[i].menuCategoryCode +'">';
            		str += result[i].categoryName+'</option>';
            	})
            	
            	$('#menuCategoryCode').empty();
            	$('#menuCategoryCode').append(str);
            	
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	updateMenuDetail = function(menuCode, menuName, menuPrice, menuCategoryCode, menuInfo, menuStatus, cafeCode){
		$.ajax({
            url: '/menu/updateMenuDetail', //요청경로
            type: 'post',
            data:{'menuCode': menuCode, 'menuName' : menuName, 'menuPrice' : menuPrice, 'menuCategoryCode' : menuCategoryCode, 'menuInfo' : menuInfo, 'menuStatus' : menuStatus}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	if(result == 1){
            		alert('메뉴 정보가 변경되었습니다');
            		$('#menuInfoDetail').modal('hide');
            		$('#selectCategoryForm').empty();
            		$('#selectMenuForm').empty();
            		selectCafeCategoryList(cafeCode);
            		selectMenuForm(cafeCode, menuCategoryCode);
            	}
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	deleteMenu = function(cafeCode, menuCategoryCode, menuCode){
		$.ajax({
            url: '/menu/deleteMenu', //요청경로
            type: 'post',
            data:{'menuCode' : menuCode}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	alert('메뉴가 삭제되었습니다');
            	$('#menuInfoDetail').modal('hide');
            	$('#selectCategoryForm').empty();
            	$('#selectMenuForm').empty();
            	selectCafeCategoryList(cafeCode);
            	selectMenuForm(cafeCode, menuCategoryCode);
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	/*hideNoImg = function(){
		$('.menuImg').each(function(){
			const imgName = $(this).attr('src');
			alert(imgName);
			if(imgName == '/resources/img/no_image'){
				$(this).closest('img').remove();
			}
		})
			
	}*/
	
	
})(jQuery);