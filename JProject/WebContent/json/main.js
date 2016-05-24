$(function(){
	
	loadMainContent("ViewTasks",{});
    	
});

function loadFormData(formId, data) {

	for ( var key in data) {
		$("[name='" + key + "']", "#" + formId).val(data[key]);
	}
}

function serializeForm(formId) {
	var formData = $("#" + formId).serializeArray();
	var v = {};
	var value;
	for ( var i in formData) {
		if ($("#" + formData[i].name).hasClass("encrypt")) {
			value = $.md5(formData[i].value);
		} else {
			value = formData[i].value;
		}
		if (typeof (v[formData[i].name]) == 'undefined') {
			v[formData[i].name] = value;
		} else {
			v[formData[i].name] += "," + value;
		}
	}
	return v;
}

function loadMainContent(url,parameter,callBack){
	$.showPreloader('加载中...');
	$.ajax({
	    url:url,
	    async:true,
	    data:parameter,  
	    type:'post',  
		dataType: "jsonp",
		jsonp:"callback", 
	    success:function(data) {
	    	//alert(data.url);
	    	$.get(data.url + "?ts=" + Date.parse(new Date()), {show:1}, function(content, status) {
	    		$.hidePreloader();
	    		if (status == 'success') {
	    			//$("#mainContent").load("demo_test.txt #p1");
	    			var html = $(content).find(".content").html();
	    			var toolBar = $(content).find("nav").html();
	    			//alert(html);
	    			//alert(toolBar);
	    			if(!html){
	    				html = content;
	    			}
	    			var doms = $.parseHTML( html, false );
	    			//alert($(doms , ".content").index());
	    			$("#mainContent").empty();
	    	    	$("#mainContent").append(doms);
					
					$("#toolBar").empty();
	    	    	if(toolBar){
	    	    		$("#toolBar").append($.parseHTML( toolBar, false ));
	    	    	}
					
	    	    	$.getScript("json/" + data.url.replace(".htm",".js"),function(){
						$.init();
	    	    		if(typeof (callBack) == 'function'){
		    	    		callBack(data);
		    	    	}
		    	    	if(typeof (initData) == 'function'){
		    	    		initData(data);
		    	    	}
	    	    	});
	    	    	
	    		}
	    	});
	    },
	    error : function(ex) {
	    	 $.hidePreloader();
	    	 var str = JSON.stringify(ex);
	    	 if(str.indexOf("json/login.js") > 0){
	    		 location.href = "login.htm?ts=" + Date.parse(new Date());
	    	 }
	    	 else{
	    		 alert("Error"+str);
	    	 }
	     }
	});
}

function submitAndGotoNext(serviceUrl,parameterData){
	$.showPreloader('加载中...');
	$.ajax({
	    url:serviceUrl,
	    async:true,
	    data:parameterData,  
	    type:'post',  
		dataType: "jsonp",
		jsonp:"callback", 
	    success:function(data) {
	    	$.hidePreloader();
	    	loadMainContent(data.url,$.extend(data,{show:1}));
	    },
	    error : function(ex) {
	    	$.hidePreloader();
	        alert("Error"+JSON.stringify(ex));  
	     }
	});
}

function newFLow(){
	submitAndGotoNext("StartProcess",{state:'BDCS'});
}
