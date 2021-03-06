/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	$('.insertMenuBtnDiv').hide();
	
	//매장 선택
	$(document).on('change', '#selectCafeList', function(){
		const cafeCode = $('#selectCafeList option:selected').val();
		if(cafeCode == ''){
			$('#selectCategoryForm').fadeOut(500, function(){
				$('#selectCategoryForm').empty();
			});
			$('#insertMenuForm').fadeOut(500, function(){
				$('#insertMenuForm').empty();
			});
			$('.insertMenuBtnDiv').fadeOut(500, function(){
				
			});
			return;
		}
		$('#selectCategoryForm').empty();
		$('#insertMenuForm').empty();
		selectCafeCategoryList(cafeCode);
	});
	
	//카테고리 선택
	$(document).on('change', '#selectCategoryList', function(){
		const categoryCode = $('#selectCategoryList option:selected').val();
		if(categoryCode == ''){
			$('#insertMenuForm').fadeOut(500, function(){
				$('#insertMenuForm').empty();
			});
			$('.insertMenuBtnDiv').fadeOut(500, function(){
			});
			return;
		}
		$('#insertMenuForm').empty();
		insertMenuForm();
	});
	
	//메뉴 이미지 미리보기
	$(document).on('change', '#menuImgName', function(){
		const ext = $(this).val().split('.').pop().toLowerCase();
		if($.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1 ){
			resetFormElement($(this));
			alert('이미지 파일이 아닙니다');
		}
		else{
			const file = $('#menuImgName').prop('files')[0];
			const blobURL = window.URL.createObjectURL(file);
			let str = '<div id="image_preview"><img src="" style="width:200px; height:200px;"></div>';
			$('#menuImgName').after(str);
            $('#image_preview img').attr('src', blobURL);
            $('#image_preview').slideDown(); //업로드한 이미지 미리보기 
            $(this).slideUp(); //파일 양식 감춤
		}
	});
	
	//메뉴 추가
	$(document).on('click', '#insertMenuBtn', function(){
		const menuName = $('#menuName').val();
		const menuPrice = $('#menuPrice').val();
		if(menuName == ''){
			alert('메뉴명을 입력해주세요');
			$('#menuName').focus();
			return;
		}
		else if(menuPrice == ''){
			alert('가격을 입력해주세요');
			$('#menuPrice').focus();
			return;
		}
		else{
			alert('메뉴 등록이 성공적으로 완료되었습니다.');
			$('#insertMenuSubmit').submit();
		}
	})
	
	//카테고리 추가
	$(document).on('click', '#insertCategoryBtn', function(){
		const categoryName = $('#categoryName').val();
		const cafeCode = $('#selectCafeList option:selected').val();
		if(categoryName == ''){
			alert('카테고리를 입력해주세요');
			$('#categoryName').focus();
			return;
		}
		else{
			insertCategory(cafeCode, categoryName);
		}

	});
	
	//모달 헤터 이름
	$(document).on('change', '#selectCafeList', function(){
		const cafeName = $('#selectCafeList option:selected').text();
		$('#insertCategoryLabel').text(cafeName);
	})
	
	//메뉴 가격 
	$(document).on('keyup paste', '#menuPrice', function(){
		let menuPrice = $('#menuPrice').val();
		let regex= /^[0-9]/g;
		if(!regex.test(menuPrice)){
			alert('숫자만 입력하세요');
			$(this).val('');
		}
		else if(menuPrice == '' || menuPrice == null){
			return;
		}
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
               str += '<option value="">클릭하면 선택이 가능합니다</option>';
               for(let i = 0; i < result.length; i++){
            	   str += '<option value="' + result[i].menuCategoryCode + '">' + result[i].categoryName + '</option>';
               }
               str += '</select></td>';
               str += '<td><input type="button" class="btn btn-primary btn-sm" value="추가" data-toggle="modal" data-target="#insertCategory"></td>'
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
	
	insertMenuForm = function(){
		let str = '';
		str += '<tr>';
		str += '<th scope="row">메뉴명</th>';
		str += '<td><input type="text" class="form-control" name="menuName" id="menuName"></td>';
		str += '</tr>';
		str += '<tr>';
		str += '<th scope="row">가격</th>';
		str += '<td><input type="text" class="form-control" name="menuPrice" id="menuPrice"></td>';
		str += '</tr>';
		str += '<tr>';
		str += '<th scope="row">메뉴 이미지</th>';
		str += '<td>';
		str += '<input type="file" class="custom-file-input" name="menuImgName" id="menuImgName">';
		str += '</td>';
		str += '</tr>';
		str += '<tr>';
		str += '<th scope="row">설명</th>';
		str += '<td><input type="text" class="form-control" name="menuInfo" id="menuInfo"></td>';
		str += '</tr>';
		$('#insertMenuForm').append(str).hide();
        $('#insertMenuForm').fadeIn(500);
        $('.insertMenuBtnDiv').fadeIn(500);
	}
	
	insertCategory = function(cafeCode, categoryName){
		$.ajax({
            url: '/menu/insertCategory', //요청경로
            type: 'post',
            data:{'cafeCode' : cafeCode, 'categoryName' : categoryName}, //필요한 데이터
            success: function(result) {
               //ajax 실행 성공 후 실행할 코드 작성
            	if(result == 1){
            		alert('카테고리가 추가되었습니다');
            		$('#selectCategoryForm').empty();
            		$('#insertMenuForm').empty();
            		$('#insertCategory').modal('hide');
            		selectCafeCategoryList(cafeCode);
            	}
            },
            error: function(){
             //ajax 실행 실패 시 실행되는 구간
               alert('실패');
            }
      });

	}
	
	
})(jQuery);