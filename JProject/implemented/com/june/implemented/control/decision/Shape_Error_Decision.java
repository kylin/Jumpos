/**
 * 	FileName   : Shape_Error_Decision
 * 	Package    : com.june.implemented.control.decision
 *	Create Time: 2014-8-26 11:40:41
 *	Usage	   : 涉及整体流程的决策定义的代码块
 *	Purpose	   : 
 *	Note	   :
 * 	taskName   : 决策任务 
 *
 */
package com.june.implemented.control.decision;

import com.june.implemented.common.application.Process;
import com.june.implemented.common.application.WorkObjectImpl;
import com.june.implemented.common.authentication.User;
import com.june.common.control.Decision;

public class Shape_Error_Decision extends com.june.generated.control.decision.Shape_Error_Decision implements Decision {
	
	public Shape_Error_Decision(WorkObjectImpl simpleFlow) {
		super(simpleFlow);
	}
	public Shape_Error_Decision(WorkObjectImpl simpleFlow,User currentUser,Process currentProcess) {
		super(simpleFlow,currentUser,currentProcess);
	}
    
     public boolean perform() {
     	return super.perform();
     }
}
