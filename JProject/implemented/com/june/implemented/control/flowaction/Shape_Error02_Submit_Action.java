/**
 * 	FileName   : Shape_Error02_Submit_Action
 * 	Package    : com.june.implemented.control.flowaction
 *	Create Time: 2014-8-26 11:40:44
 *	Usage	   : 涉及流程中需要人工参与的步骤与逻辑走向定义代码
 *	Purpose	   : null
 *	Note	   : 
 *  taskName   : 异常处理等待
 *
 */
package com.june.implemented.control.flowaction;

import com.june.implemented.common.application.WorkObjectImpl;
import com.june.common.control.FlowAction;
import com.june.implemented.common.authentication.User;
import com.june.implemented.common.application.Process;

public final class Shape_Error02_Submit_Action extends com.june.generated.control.flowaction.Shape_Error02_Submit_Action implements FlowAction {

    public Shape_Error02_Submit_Action(WorkObjectImpl simpleFlow) {
    	super(simpleFlow);
    }
    public Shape_Error02_Submit_Action(WorkObjectImpl simpleFlow,User currentUser,Process currentProcess) {
    	super(simpleFlow);
    	process = currentProcess;
    	user = currentUser;
    }
    
}
