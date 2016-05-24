/**
 * 	FileName   : Shape_Error02_Submit_Action
 * 	Package    : com.june.generated.control.flowaction
 *	Create Time: 2014-8-26 11:40:44
 *	Usage	   : 涉及流程中需要人工参与的步骤与逻辑走向定义代码
 *	Purpose	   : null
 *	Note	   : 
 *  taskName   : 异常处理等待
 *
 */
package com.june.generated.control.flowaction;

import com.june.common.control.FlowAction;
import com.june.common.exception.SystemException;
import com.june.common.model.action.AbstractAction;
import com.june.implemented.common.application.WorkObjectImpl;

public class Shape_Error02_Submit_Action extends AbstractAction implements FlowAction {

	private final WorkObjectImpl activeWork;
    
    public Shape_Error02_Submit_Action(WorkObjectImpl simpleFlow) {
    	this.activeWork = simpleFlow;
    }
    
	public void perform() throws SystemException {
		if("Activity".equals(activeWork.getActiveFlowInstance().getErrorFlowType())){
			new com.june.implemented.control.flowaction.FlowActionUtils().perform(activeWork.getActiveFlowInstance().getErrorFlowState());
		}else{
			activeWork.getActiveFlowInstance().setAssignee(activeWork.getActiveFlowInstance().getErrorFlowUser());
			activeWork.getActiveFlowInstance().setUserGroup(activeWork.getActiveFlowInstance().getErrorFlowUserGroup());
			activeWork.getActiveFlowInstance().setCurrentState(activeWork.getActiveFlowInstance().getErrorFlowState());
			activeWork.getActiveFlowInstance().setCurrentStateDisplay(activeWork.getActiveFlowInstance().getErrorFlowStateDisplay());
		}
	
    }
}
