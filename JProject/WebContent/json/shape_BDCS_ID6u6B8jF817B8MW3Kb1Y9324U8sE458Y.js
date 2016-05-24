

var testData = {
	id : 1,
	success : true,
	url : "shape_BDCS_ID6u6B8jF817B8MW3Kb1Y9324U8sE458Y.htm",
	list : [],
	obj : {},
	msg : "",
	map : {},
	note : ""
};

function initData(data){
	loadFormData("form",$.extend({id:data.id},data.obj));		

}



function submitForm(){

	var submitData = serializeForm("form");
	
	submitAndGotoNext("shape_BDCS_ID6u6B8jF817B8MW3Kb1Y9324U8sE458Y",submitData);
}


