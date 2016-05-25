


$(function(){

loadMainContent(testData.url,testData);

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
	
	if(typeof (callBack) == 'function'){
	    callBack(testData);
	}
	if(typeof (initData) == 'function'){
	    initData(testData);
	}
	
}

function submitAndGotoNext(serviceUrl,parameterData){
	var str = "提交至 : " + serviceUrl + "\r\n"; 
	str += "数据如下：\r\n";
	var i = 0;
	for ( var key in parameterData) {
		str += "	" + key + " = " + parameterData[key] 
		str += "\r\n";
		i++;
	}
	alert(str);
}
