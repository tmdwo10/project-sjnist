$(document).ready(function(){
	
	$("#test").on('click', function(){
		fn_test();
	});
	
	function fn_test(){
		$.ajax({
			type: 'POST',
			url: '/test/selectTest',
			data: JSON.stringify({}),
			contentType: 'application/json; charset=UTF-8',
			success: function(resp) {
				alert('성공');
				console.log(resp);
			},
			error: function(xhr, status, error) {
				console.error('오류:', error);
			}
		});
	}
});