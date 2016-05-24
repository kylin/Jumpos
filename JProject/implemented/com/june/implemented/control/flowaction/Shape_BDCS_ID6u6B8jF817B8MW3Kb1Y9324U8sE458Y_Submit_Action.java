/**
 * 	FileName   : Shape_BDCS_ID6u6B8jF817B8MW3Kb1Y9324U8sE458Y_Submit_Action
 * 	Package    : com.june.implemented.control.flowaction
 *	Create Time: 2016-5-24 9:41:05
 *	Usage	   : 涉及流程中需要人工参与的步骤与逻辑走向定义代码
 *	Purpose	   : null
 *	Note	   : 
 *  taskName   : 支付金额
 *
 */
package com.june.implemented.control.flowaction;

import com.june.implemented.common.application.WorkObjectImpl;
import com.june.common.control.FlowAction;
import com.june.implemented.common.authentication.User;
import com.june.implemented.common.application.Process;

public final class Shape_BDCS_ID6u6B8jF817B8MW3Kb1Y9324U8sE458Y_Submit_Action extends com.june.generated.control.flowaction.Shape_BDCS_ID6u6B8jF817B8MW3Kb1Y9324U8sE458Y_Submit_Action implements FlowAction {

    public Shape_BDCS_ID6u6B8jF817B8MW3Kb1Y9324U8sE458Y_Submit_Action(WorkObjectImpl simpleFlow) {
    	super(simpleFlow);
    }
    public Shape_BDCS_ID6u6B8jF817B8MW3Kb1Y9324U8sE458Y_Submit_Action(WorkObjectImpl simpleFlow,User currentUser,Process currentProcess) {
    	super(simpleFlow);
    	process = currentProcess;
    	user = currentUser;
    }
    
}
