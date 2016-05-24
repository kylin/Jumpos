/**
 * 	FileName   : Shape_BDCS_ID410jd29K8067I3v7otK107Bc7O78809N9_Submit_Action
 * 	Package    : com.june.generated.control.flowaction
 *	Create Time: 2016-5-25 7:25:22
 *	Usage	   : 涉及流程中需要人工参与的步骤与逻辑走向定义代码
 *	Purpose	   : 
 *	Note	   : 
 *  taskName   : 开始
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

public class Shape_BDCS_ID410jd29K8067I3v7otK107Bc7O78809N9_Submit_Action extends AbstractAction implements FlowAction {

	private final WorkObjectImpl activeWork;
    
    public Shape_BDCS_ID410jd29K8067I3v7otK107Bc7O78809N9_Submit_Action(WorkObjectImpl simpleFlow) {
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
    activeWork.getActiveFlowInstance().setAssignee(activeWork.getActiveFlowInstance().getStartUser());
	activeWork.getActiveFlowInstance().setUserGroup(activeWork.getActiveFlowInstance().getUserGroup());
	wd.LoadInitData();
	
	try {
				//
			activeWork.getActiveFlowInstance().setAssignee(" ");
			activeWork.getActiveFlowInstance().setUserGroup("申请人");
			activeWork.getActiveFlowInstance().setCurrentState("shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S");
			activeWork.getActiveFlowInstance().setCurrentStateDisplay("填写报销申请表");
	
	}catch(Exception e){
		new com.june.implemented.control.flowaction.Shape_Error_Submit_Action(activeWork).perform();
	}
    }
}
