

var testData = {
	id : 1,
	success : true,
	url : "shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019.htm",
	list : [],
	obj : {},
	msg : "",
	map : {},
	note : ""
};

function initData(data){
	loadFormData("form",$.extend({id:data.id},data.obj));	

	var trHTML = "";
	for(i = 0;i< data.obj.baoxiaoxixiang55012.length;i++){
			var index = i + 1;
		
		var detailId = Date.parse(new Date()) + index;
	
		trHTML += "<li class=\"card\">";
		trHTML += " <div class=\"card-header\">";
		trHTML += " <a href=\"#\" class=\"link\" onclick=\"$('#"+detailId+"').toggle()\">报销细项"+index+"</a>";
		trHTML += "  </div>";
		trHTML += "  <div id=\""+ detailId + "\" class=\"card-content\">";
		trHTML += "    <div class=\"card-content-inner\">";
		trHTML += "     	<div class=\"list-block\">";
		trHTML += "    	<ul style=\"padding-left : 0px;\">";
	
		trHTML += "		<li>";
		trHTML += "			<div class=\"item-content\">";
		trHTML += "				<div class=\"item-inner\">";
		trHTML += "					<div class=\"item-title label\">报销金额</div>";
		trHTML += "					<div class=\"item-input\">";
		trHTML += data.obj.baoxiaoxixiang55012[i].baoxiaojine59923;
		trHTML += "					</div>";
		trHTML += "				</div>";
		trHTML += "			</div>";
		trHTML += "		</li>";	
		trHTML += "		<li>";
		trHTML += "			<div class=\"item-content\">";
		trHTML += "				<div class=\"item-inner\">";
		trHTML += "					<div class=\"item-title label\">日期</div>";
		trHTML += "					<div class=\"item-input\">";
		trHTML += data.obj.baoxiaoxixiang55012[i].riqi12548;
		trHTML += "					</div>";
		trHTML += "				</div>";
		trHTML += "			</div>";
		trHTML += "		</li>";	
		trHTML += "		<li>";
		trHTML += "			<div class=\"item-content\">";
		trHTML += "				<div class=\"item-inner\">";
		trHTML += "					<div class=\"item-title label\">费用名称</div>";
		trHTML += "					<div class=\"item-input\">";
		trHTML += data.obj.baoxiaoxixiang55012[i].feiyongmingcheng39006;
		trHTML += "					</div>";
		trHTML += "				</div>";
		trHTML += "			</div>";
		trHTML += "		</li>";							
		trHTML += "		</ul>";
		trHTML += "		</div>";
		trHTML += "   </div>";
		trHTML += "  </div>";
		trHTML += " </li>";

	}
	$("#detailList").append(trHTML);		

}



function submitForm(){

	var submitData = serializeForm("form");
	
	submitAndGotoNext("shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019",submitData);
}		


