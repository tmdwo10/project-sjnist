$(document).ready(function(){
	
	$("#submit").on('click', function(){
		let id = $("#id").val();
		let password = $("#password").val();
		
		if(id == "" || id == null){
			alert("아이디를 입력해주세요.");
			return false;
		}
		if(password == "" || password == null){
			alert("비밀번호를 입력해주세요.");
			return false;
		}
		
		let params = {
			"id" : id,
			"password" : password
		}
		
		fn_login(params);
	});
	
});

function fn_login(params){
	
	$.ajax({
		type: 'POST',
		url: '/common/login',
		data: JSON.stringify(params),
		contentType: 'application/json; charset=UTF-8',
		success: function(resp) {
			if (resp.success) {
				window.location.href = "/main";
			} else {
				alert("로그인 실패: " + resp.message);
			}
		},
		error: function(xhr, status, error) {
			console.error('오류:', error);
		}
	});
	
}