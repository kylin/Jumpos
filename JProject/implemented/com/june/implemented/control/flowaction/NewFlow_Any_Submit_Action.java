/**
 *	FileName   : NewFlow_Any_Submit_Action
 * 	Package    : com.june.implemented.control.flowaction
 *	Create Time: 2016-5-25 7:25:26
 *	Usage	   : 开启新流程
 *	Purpose	   :
 *	Note	   :
 *
 */
package com.june.implemented.control.flowaction;

import com.june.implemented.common.application.WorkObjectImpl;
import com.june.common.exception.AuthorizationException;
import com.june.common.exception.SystemException;
import com.june.common.exception.ValidationException;
import com.june.common.exception.WorkNotFoundException;
import com.june.common.model.action.AbstractAction;

public class NewFlow_Any_Submit_Action extends AbstractAction{
	
	private final WorkObjectImpl activeWork;
    
    public NewFlow_Any_Submit_Action(WorkObjectImpl simpleFlow) {
    	this.activeWork = simpleFlow;
    }
	
    public void perform(String projectName, String startIndex) throws SystemException, ValidationException, WorkNotFoundException, AuthorizationException {
 		
 		if(projectName.equals("BDCS")) {
 			activeWork.getActiveFlowInstance().setCurrentState("end");	
		// 
		//shape_BDCS_ID410jd29K8067I3v7otK107Bc7O78809N9
		//
			//if(" ".equals(activeWork.getActiveFlowInstance().getAssignee()) || ("申请人".equals(activeWork.getActiveFlowInstance().getUserGroup()) && "填写报销申请".equals(startIndex))) {
	    		new Shape_BDCS_ID410jd29K8067I3v7otK107Bc7O78809N9_Submit_Action(activeWork).perform();		
 			//}
 		}
 	
   
    }
}