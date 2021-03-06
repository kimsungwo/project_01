/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	initValidation();
  
  $(document).on('click', '#regProfile', function(){
		$('#profileBtn').empty();
		
		let str = '';
		str += '<div class="form-group">';
		str += '<input type="file" class="form-control-file" id="profileImg" name="file1">';
		str += '</div>';
		$('#profileBtn').prepend(str);
	});
	
	$(document).on('change', '#profileImg', function(){
		const ext = $(this).val().split('.').pop().toLowerCase();
		if($.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1 ){
			resetFormElement($(this));
			alert('이미지 파일이 아닙니다');
		}
		else{
			const file = $('#profileImg').prop('files')[0];
			const blobURL = window.URL.createObjectURL(file);
			$('.img-thumbnail').remove();
			let str = '<div id="image_preview"><img src="" style="width:200px; height:200px;"></div>';
			$('#profileTd').prepend(str);
            $('#image_preview img').attr('src', blobURL);
            $('#image_preview').slideDown(); //업로드한 이미지 미리보기 
            $(this).slideUp(); //파일 양식 감춤
		}
	});
	
	$(document).on('click', '#updateBtn', function(){
		let result = confirm('프로필을 수정하시겠습니까?');
		if(result){
			$('#updateForm').submit();
		}
	})
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
	

		initValidation = function() {
		$("#updateForm").validate({
			debug : false,
			onfocusout : function(element) {
				$(element).valid();
			},
			rules : {
				memNickname : {//input태그의 name속성의 규칙을 지정.
					required : true,
					maxlength : 20,
					minlength : 2
				},
				memTel : {
					required : true,
					maxlength : 11,
					minlength : 10,
					digits : true
				},
				memPw : {
					required : true
				},
				memPw1 : {
					required : true,
					equalTo : "#memPw"
				}
				
			},
			//검사를 충족하지 못할 경우,
			//위의 rules의 조건을 만족하지 못했을경우 표시될 메시지의 나열                                                         
			messages : {
				memNickname : {
					required : '닉네임은 필수 입력입니다',
					maxlength : '최대 {0} 글자까지 가능합니다',
					minlength : '최소 {0} 글자 이상 입력해주세요',
				},
				memTel : {
					required : '연락처는 필수 입력입니다',
					maxlength : '최대 {0} 글자까지 가능합니다',
					minlength : '최소 {0} 글자 이상 입력해주세요',
					digits : '숫자만 써주세요.'
				},
				memPw : {
					required : '비밀번호는 필수 입력입니다'
				},
				memPw1 : {
					required : '비밀번호 확인은 필수 입력입니다',
					equalTo : '비밀번호가 일치하지 않습니다'
				}
			}
		});
	}
})(jQuery);