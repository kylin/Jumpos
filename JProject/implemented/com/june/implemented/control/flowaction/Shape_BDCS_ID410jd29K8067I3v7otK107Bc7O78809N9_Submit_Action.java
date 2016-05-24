/**
 * 	FileName   : Shape_BDCS_ID410jd29K8067I3v7otK107Bc7O78809N9_Submit_Action
 * 	Package    : com.june.implemented.control.flowaction
 *	Create Time: 2016-5-24 9:41:04
 *	Usage	   : 涉及流程中需要人工参与的步骤与逻辑走向定义代码
 *	Purpose	   : 
 *	Note	   : 
 *  taskName   : 开始
 *
 */
package com.june.implemented.control.flowaction;

import com.june.implemented.common.application.WorkObjectImpl;
import com.june.common.control.FlowAction;
import com.june.implemented.common.authentication.User;
import com.june.implemented.common.application.Process;

public final class Shape_BDCS_ID410jd29K8067I3v7otK107Bc7O78809N9_Submit_Action extends com.june.generated.control.flowaction.Shape_BDCS_ID410jd29K8067I3v7otK107Bc7O78809N9_Submit_Action implements FlowAction {

    public Shape_BDCS_ID410jd29K8067I3v7otK107Bc7O78809N9_Submit_Action(WorkObjectImpl simpleFlow) {
    	super(simpleFlow);
    }
    public Shape_BDCS_ID410jd29K8067I3v7otK107Bc7O78809N9_Submit_Action(WorkObjectImpl simpleFlow,User currentUser,Process currentProcess) {
    	super(simpleFlow);
    	process = currentProcess;
    	user = currentUser;
    }
    
}
