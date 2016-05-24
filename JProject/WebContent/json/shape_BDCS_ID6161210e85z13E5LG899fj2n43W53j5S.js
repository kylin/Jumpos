

var testData = {
	id : 1,
	success : true,
	url : "shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S.htm",
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
	
	submitAndGotoNext("shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S",submitData);
}	

$("#addDetail")
		.click(
				function() {
					
					var index = $(".card").length + 1;
					
					$(".card-content").hide();
					
					var detailId = Date.parse(new Date());
					var trHTML = "";
					trHTML += "<li class=\"card\">";
					trHTML += " <div class=\"card-header\">";
					trHTML += " <a href=\"#\" class=\"link\" onclick=\"$('#"+detailId+"').toggle()\">报销细项"+index+"</a>";
					trHTML += "	<a href=\"#\" class=\"button button-danger\" onclick=\"$(this).parent().parent().remove()\">删除</a>";
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
					trHTML += "						<input type=\"text\" name=\"baoxiaoxixiang55012.baoxiaojine59923\" placeholder=\"请输入报销金额\">";					
					trHTML += "					</div>";
					trHTML += "				</div>";
					trHTML += "			</div>";
					trHTML += "		</li>";
	
					trHTML += "		<li>";
					trHTML += "			<div class=\"item-content\">";
					trHTML += "				<div class=\"item-inner\">";
					trHTML += "					<div class=\"item-title label\">日期</div>";
					trHTML += "					<div class=\"item-input\">";
					trHTML += "						<input type=\"date\" data-toggle='date' class=\"datePicker\" name=\"baoxiaoxixiang55012.riqi12548\" placeholder=\"请输入日期\">";					
					trHTML += "					</div>";
					trHTML += "				</div>";
					trHTML += "			</div>";
					trHTML += "		</li>";
	
					trHTML += "		<li>";
					trHTML += "			<div class=\"item-content\">";
					trHTML += "				<div class=\"item-inner\">";
					trHTML += "					<div class=\"item-title label\">费用名称</div>";
					trHTML += "					<div class=\"item-input\">";
					trHTML += "						<input type=\"text\" name=\"baoxiaoxixiang55012.feiyongmingcheng39006\" placeholder=\"请输入费用名称\">";					
					trHTML += "					</div>";
					trHTML += "				</div>";
					trHTML += "			</div>";
					trHTML += "		</li>";
							
					trHTML += "		</ul>";
					trHTML += "		</div>";
					trHTML += "   </div>";
					trHTML += "  </div>";
					trHTML += " </li>";

					$("#detailList").append(trHTML);
});
$(function() {
	$(".datePacker").calendar();
});		


