/**
 * 	FileName   : Shape_Error_Submit_Action
 * 	Package    : com.june.generated.control.flowaction
 *	Create Time: 2014-8-26 11:40:42
 *	Usage	   : 涉及流程中需要人工参与的步骤与逻辑走向定义代码
 *	Purpose	   : 
 *	Note	   : 
 *  taskName   : Error
 *
 */
package com.june.generated.control.flowaction;

import com.june.common.control.FlowAction;
import com.june.common.model.action.AbstractAction;
import com.june.implemented.common.application.WorkObjectImpl;

public class Shape_Error_Submit_Action extends AbstractAction implements FlowAction {

	private final WorkObjectImpl activeWork;
    
    public Shape_Error_Submit_Action(WorkObjectImpl simpleFlow) {
    	this.activeWork = simpleFlow;
    }
    
	public void perform(){
			activeWork.getActiveFlowInstance().setAssignee(" ");
			activeWork.getActiveFlowInstance().setUserGroup("后台系统");
			activeWork.getActiveFlowInstance().setCurrentState("shape_Error01");
			activeWork.getActiveFlowInstance().setCurrentStateDisplay("异常任务");
	
    }
}
