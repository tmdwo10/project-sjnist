$(document).ready(function(){
	$("#submit").on('click', function(){
		const cont = {};
		
		$('#signCont').find('input, select, textarea').each(function () {
			const name = $(this).attr('name');
			const value = $(this).val();
			
			if(name){
				cont[name] = value;
			}
		});
		
		fn_submit(cont);
	});
	
	$("#validateId").on('click', function(){
		const cont = {};
		let id = $("#id").val();
		
		if(id == "" || id == null){
			alert("아이디를 입력해주세요");
			return false;
		}
		
		cont['id'] = id;
		
		fn_validateId(cont);
	});
});


function fn_submit(params){
	
	let validateYn = $("#validateYn").val();
	
	if(validateYn == 'N'){
		alert("아이디 중복확인을 해주세요.");
		return false;
	}
	
	$.ajax({
		type: 'POST',
		url: '/common/signUp',
		data: JSON.stringify(params),
		contentType: 'application/json; charset=UTF-8',
		success: function(resp) {
			if (resp.success) {
				alert("회원가입 성공!");
				window.location.href = "/login";
			} else {
				alert("회원가입 실패: " + resp.message);
			}
		},
		error: function(xhr, status, error) {
			console.error('오류:', error);
		}
	});
}

function fn_validateId(params){
	$.ajax({
		type: 'POST',
		url: 'common/validateId',
		data: JSON.stringify(params),
		contentType: 'application/json; charset=UTF-8',
		success: function(resp){
			
			if (resp.success) {
				if(resp.result == 'N'){
					if(confirm("사용할 수 있는 아이디입니다.\n\n 아이디를 사용하시겠습니까?")){
						$("#id").attr("disabled", true);
						$("#validateId").attr("disabled", true);
						$("#validateYn").val("Y");
					}else{
						return false;
					}
					
				}else{
					alert("사용중인 아이디입니다.");
				}
			} else {
				alert("회원가입 실패: " + resp.message);
			}
			
		},
		error: function(resp){
			console.error('오류:', error);
		}
	});
}