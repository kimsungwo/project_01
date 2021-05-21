/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	$(document).on('change', '#imgFile', function(){
		const ext = $(this).val().split('.').pop().toLowerCase();
		if($.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1 ){
			resetFormElement($(this));
			alert('이미지 파일이 아닙니다');
		}
		else{
			$('#logoDiv').empty();
			const file = $('#imgFile').prop('files')[0];
			const blobURL = window.URL.createObjectURL(file);
			let str = '<div id="image_preview"><img src="" style="width:200px; height:200px;"></div>';
			$('#imgFile').after(str);
            $('#image_preview img').attr('src', blobURL);
            $('#image_preview').slideDown(); //업로드한 이미지 미리보기 
            $(this).slideUp(); //파일 양식 감춤
		}
	});
	
	$(document).on('click', '#logoUpdate', function() {
		let str = '';
		str += '<div class="form-group">';
		str += '<label for="imgFile"></label>';
		str += '<input type="file" class="form-control-file" id="imgFile" name="file1">';
		str += '</div>';
		$(this).after(str);
		$(this).remove();
	});
	
});

/* 함수선언 영역*/
(function($){
	
	//우편번호 검색 함수
	openPostCode = function(){
        new daum.Postcode({
            oncomplete: function(data) {
                var roadAddr = data.roadAddress;
                $('#inputAddr').val(roadAddr);
            }
        }).open();
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