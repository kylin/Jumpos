var jsonUrl = $.parseJSON('{"success": true,"url": "main.htm"}');
function submitForm(){
	$.showPreloader('登录中...');
	$("#form").ajaxSubmit({
		url:"Login",
		async:false,
		dataType: "jsonp",
		jsonp:"callback",
		success:function(data){
			$.hidePreloader();
			if(data && data.success){
				
				window.location.href=data.url;
			}else{
				alert(data.msg);
			}
		},
	    error : function(ex) {
	    	$.hidePreloader();
		    alert("Error："+JSON.stringify(ex));  
		}
	});
}