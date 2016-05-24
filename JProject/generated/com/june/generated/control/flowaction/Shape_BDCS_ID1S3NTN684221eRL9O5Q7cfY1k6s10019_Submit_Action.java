/**
 * 	FileName   : Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_Submit_Action
 * 	Package    : com.june.generated.control.flowaction
 *	Create Time: 2016-5-25 7:25:22
 *	Usage	   : 涉及流程中需要人工参与的步骤与逻辑走向定义代码
 *	Purpose	   : null
 *	Note	   : 
 *  taskName   : 审核报销申请表
 *
 */
package com.june.generated.control.flowaction;

import java.util.Date;
import java.util.List;

import com.june.implemented.control.decision.*;
import com.june.implemented.control.activity.*;
import com.june.implemented.model.data.*;
import com.june.common.exception.SystemException;
import com.june.implemented.common.application.WorkObjectImpl;
import com.june.common.control.FlowAction;
import com.june.common.model.action.AbstractAction;
import com.june.common.api.*;
import com.june.implemented.common.application.*;
import com.june.implemented.common.function.*;

public class Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_Submit_Action extends AbstractAction implements FlowAction {

	private final WorkObjectImpl activeWork;
    
    public Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_Submit_Action(WorkObjectImpl simpleFlow) {
    	this.activeWork = simpleFlow;
    }
    
	public void perform(){
	AbstractWorkData awd = activeWork.getWorkDataInstance();
	BDCSWorkData wd = (BDCSWorkData)awd;
	activeWork.getActiveFlowInstance().setErrorFlowUser(user.getUsername());
	activeWork.getActiveFlowInstance().setErrorFlowUserGroup(user.getUsergroup());
	activeWork.getActiveFlowInstance().setErrorFlowState(activeWork.getActiveFlowInstance().getCurrentState());
	activeWork.getActiveFlowInstance().setErrorFlowStateDisplay(activeWork.getActiveFlowInstance().getCurrentStateDisplay());
	activeWork.getActiveFlowInstance().setErrorFlowType("UserPage");
	try {
				if (String.valueOf(new Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_Decision(activeWork,user,process).perform()).equals("true")) {
			//
			activeWork.getActiveFlowInstance().setAssignee(" ");
			activeWork.getActiveFlowInstance().setUserGroup("财务");
			activeWork.getActiveFlowInstance().setCurrentState("shape_BDCS_ID6u6B8jF817B8MW3Kb1Y9324U8sE458Y");
			activeWork.getActiveFlowInstance().setCurrentStateDisplay("支付金额");
	}
		else if (String.valueOf(new Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_Decision(activeWork,user,process).perform()).equals("false")) {
			//
			activeWork.getActiveFlowInstance().setAssignee(" ");
			activeWork.getActiveFlowInstance().setUserGroup("申请人");
			activeWork.getActiveFlowInstance().setCurrentState("shape_BDCS_ID9E4GDYr7RcEW6MhIc4X4j07108978ciu");
			activeWork.getActiveFlowInstance().setCurrentStateDisplay("查看拒绝原因");
	}

	}catch(Exception e){
		new com.june.implemented.control.flowaction.Shape_Error_Submit_Action(activeWork).perform();
	}
    }
}
