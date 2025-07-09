$(document).ready(function(){
	$("#submit").on('click', function(){
		const params = {};
		
		$('#signCont').find('input, select, textarea').each(function () {
			const name = $(this).attr('name');
			const value = $(this).val();
			
			if(name){
				params[name] = value;
			}
		});
		
		fn_submit(params);
	});
});


function fn_submit(params){
	
	$.ajax({
		type: 'POST',
		url: '/common/signUp',
		data: JSON.stringify(params),
		contentType: 'application/json; charset=UTF-8',
		success: function(resp) {
			console.log(resp);
		},
		error: function(xhr, status, error) {
			console.error('오류:', error);
		}
	});
}