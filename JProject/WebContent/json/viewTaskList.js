function initData(data){
	var str="";
	  if(data.list){
		  for (var i = 0; i < data.list.length; i++) {
        	  var id = data.list[i].objectId;
            var flowName = data.list[i].flowName;
            var currentStateDisplay = data.list[i].currentStateDisplay;
            var currentState = data.list[i].currentState;
            var url = "openUrl(\""+id+"\")";
            str += "<tr><td>"+id+"</td><td><a onclick='"+url+"'>"+flowName+"</a></td><td><a onclick='"+url+"'>"+currentStateDisplay+"</a></td></tr>";
        }
	  }
    
    $("#tbdy").html(str);
}

function openUrl(id){
	
	submitAndGotoNext("openTask",{taskId:id});
	
}
