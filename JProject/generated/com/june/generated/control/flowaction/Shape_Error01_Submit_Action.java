/**
 * 	FileName   : Shape_Error01_Submit_Action
 * 	Package    : com.june.generated.control.flowaction
 *	Create Time: 2014-8-26 11:40:43
 *	Usage	   : 涉及流程中需要人工参与的步骤与逻辑走向定义代码
 *	Purpose	   : null
 *	Note	   : 
 *  taskName   : 异常任务
 *
 */
package com.june.generated.control.flowaction;

import com.june.common.control.FlowAction;
import com.june.common.exception.SystemException;
import com.june.common.model.action.AbstractAction;
import com.june.implemented.common.application.WorkObjectImpl;
import com.june.implemented.control.decision.Shape_Error_Decision;

public class Shape_Error01_Submit_Action extends AbstractAction implements
		FlowAction {

	private final WorkObjectImpl activeWork;

	public Shape_Error01_Submit_Action(WorkObjectImpl simpleFlow) {
		this.activeWork = simpleFlow;
	}

	public void perform() throws SystemException {
		if (String.valueOf(
				new Shape_Error_Decision(activeWork, user, process).perform())
				.equals("false")) {
			activeWork.getActiveFlowInstance().setCurrentState("end");
		} else if (String.valueOf(
				new Shape_Error_Decision(activeWork, user, process).perform())
				.equals("true")) {
			activeWork.getActiveFlowInstance().setAssignee(" ");
			activeWork.getActiveFlowInstance().setUserGroup("后台系统");
			activeWork.getActiveFlowInstance().setCurrentState("shape_Error02");
			activeWork.getActiveFlowInstance().setCurrentStateDisplay("异常处理等待");
		}

	}
}
