

var testData = {
	id : 1,
	success : true,
	url : "shape_BDCS_ID9E4GDYr7RcEW6MhIc4X4j07108978ciu.htm",
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
	
	submitAndGotoNext("shape_BDCS_ID9E4GDYr7RcEW6MhIc4X4j07108978ciu",submitData);
}


