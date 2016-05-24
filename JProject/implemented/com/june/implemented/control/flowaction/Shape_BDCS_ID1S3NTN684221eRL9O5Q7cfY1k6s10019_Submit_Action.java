/**
 * 	FileName   : Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_Submit_Action
 * 	Package    : com.june.implemented.control.flowaction
 *	Create Time: 2016-5-25 7:25:22
 *	Usage	   : 涉及流程中需要人工参与的步骤与逻辑走向定义代码
 *	Purpose	   : null
 *	Note	   : 
 *  taskName   : 审核报销申请表
 *
 */
package com.june.implemented.control.flowaction;

import com.june.implemented.common.application.WorkObjectImpl;
import com.june.common.control.FlowAction;
import com.june.implemented.common.authentication.User;
import com.june.implemented.common.application.Process;

public final class Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_Submit_Action extends com.june.generated.control.flowaction.Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_Submit_Action implements FlowAction {

    public Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_Submit_Action(WorkObjectImpl simpleFlow) {
    	super(simpleFlow);
    }
    public Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_Submit_Action(WorkObjectImpl simpleFlow,User currentUser,Process currentProcess) {
    	super(simpleFlow);
    	process = currentProcess;
    	user = currentUser;
    }
    
}
