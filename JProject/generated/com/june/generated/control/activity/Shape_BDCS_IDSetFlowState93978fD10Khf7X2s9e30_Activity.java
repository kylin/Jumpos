/**
 * 	FileName   : Shape_BDCS_IDSetFlowState93978fD10Khf7X2s9e30_Activity
 * 	Package    : com.june.generated.control.activity
 *	Create Time: 2016-5-24 9:41:03
 *	Usage	   : 涉及系统中定义的自动完成的部分
 *	Purpose	   : 
 *	Note	   :
 * 	taskName   : 系统任务 
 *
 */ 
package com.june.generated.control.activity;

import com.june.common.api.WorkObject;
import com.june.common.control.Activity;
import com.june.implemented.common.application.BDCSWorkData;
import com.june.implemented.common.application.Process;
import com.june.implemented.common.application.WorkObjectImpl;
import com.june.implemented.common.authentication.User;
import com.june.common.model.action.AbstractAction;
import com.june.implemented.model.input.*;
import com.june.implemented.model.output.*;
import com.june.implemented.common.function.*;
import java.util.*;

public class Shape_BDCS_IDSetFlowState93978fD10Khf7X2s9e30_Activity extends AbstractAction implements Activity {

	public Shape_BDCS_IDSetFlowState93978fD10Khf7X2s9e30_Activity(WorkObjectImpl simpleFlow) {
		this.owner = simpleFlow;
		userInput = new Shape_BDCS_IDSetFlowState93978fD10Khf7X2s9e30_UserInput(process);
    	pageOutput = new Shape_BDCS_IDSetFlowState93978fD10Khf7X2s9e30_PageOutput(process);
		pageOutput.getDataFromProcess();
	}
	
	public Shape_BDCS_IDSetFlowState93978fD10Khf7X2s9e30_Activity(WorkObjectImpl simpleFlow,User currentUser,Process currentProcess) {
		this.owner = simpleFlow;
		process = currentProcess;
    	user = currentUser;
    	userInput = new Shape_BDCS_IDSetFlowState93978fD10Khf7X2s9e30_UserInput(process);
    	pageOutput = new Shape_BDCS_IDSetFlowState93978fD10Khf7X2s9e30_PageOutput(process);
		pageOutput.getDataFromProcess();
	}
	
    public WorkObject owner;

    public void setOwner(WorkObject wo) {
        this.owner = wo;
    }
    
    Shape_BDCS_IDSetFlowState93978fD10Khf7X2s9e30_UserInput userInput;
    
    public Shape_BDCS_IDSetFlowState93978fD10Khf7X2s9e30_UserInput getUserInput() {
		return userInput;
	}
	
	public void setUserInput(Shape_BDCS_IDSetFlowState93978fD10Khf7X2s9e30_UserInput userInput) {
		this.userInput = userInput;
	}
	
	Shape_BDCS_IDSetFlowState93978fD10Khf7X2s9e30_PageOutput pageOutput;
	
	public Shape_BDCS_IDSetFlowState93978fD10Khf7X2s9e30_PageOutput getPageOutput() {
		return pageOutput;
	}

	public void setPageOutput(Shape_BDCS_IDSetFlowState93978fD10Khf7X2s9e30_PageOutput pageOutput) {
		this.pageOutput = pageOutput;
	}
	
	public String flowName = "BDCS";
	
	

	
    public String perform(){
    	String commitStr = "";
        BDCSWorkData workClass = (BDCSWorkData) owner.getWorkDataInstance(); 
		//String bumen35536 = workClass.getBumen35536().toString();
		//String baoxiaoxixiang55012 = workClass.getBaoxiaoxixiang55012().toString();    
	//	workClass.setBaoxiaoxixiang55012("");   
		if(true){
for (Baoxiaoxixiang55012 e:getPageOutput().getBaoxiaoxixiang55012()){
e.setFeiyongmingcheng39006("补助");
}
getUserInput().setBaoxiaoxixiang55012(getPageOutput().getBaoxiaoxixiang55012());
}

		
		//null
					
		//      
		return commitStr;
    }

    public String getName() {
        return getClass().getCanonicalName();
    }

}
