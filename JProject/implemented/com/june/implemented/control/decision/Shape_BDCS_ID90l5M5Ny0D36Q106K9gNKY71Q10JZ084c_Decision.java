/**
 * 	FileName   : Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_Decision
 * 	Package    : com.june.implemented.control.decision
 *	Create Time: 2016-5-24 9:41:04
 *	Usage	   : 涉及整体流程的决策定义的代码块
 *	Purpose	   : 
 *	Note	   :
 * 	taskName   : 是否通过审核 
 *
 */
package com.june.implemented.control.decision;

import com.june.implemented.common.application.Process;
import com.june.implemented.common.application.WorkObjectImpl;
import com.june.implemented.common.authentication.User;
import com.june.common.control.Decision;

public class Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_Decision extends com.june.generated.control.decision.Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_Decision implements Decision {
	
	public Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_Decision(WorkObjectImpl simpleFlow) {
		super(simpleFlow);
	}
	public Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_Decision(WorkObjectImpl simpleFlow,User currentUser,Process currentProcess) {
		super(simpleFlow,currentUser,currentProcess);
	}
    
     public boolean perform() {
     	return super.perform();
     }
}
