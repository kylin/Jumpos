/**
 * 	FileName   : Shape_Error_Decision
 * 	Package    : com.june.generated.control.decision
 *	Create Time: 2014-8-26 11:40:41
 *	Usage	   : 涉及整体流程的决策定义的代码块
 *	Purpose	   : 
 *	Note	   :
 * 	taskName   : 决策任务 
 *
 */
package com.june.generated.control.decision;

import com.june.common.api.WorkObject;
import com.june.common.control.Decision;
import com.june.common.model.action.AbstractAction;
import com.june.implemented.common.application.Process;
import com.june.implemented.common.application.WorkObjectImpl;
import com.june.implemented.common.authentication.User;
import com.june.implemented.model.input.Shape_Error_UserInput;
import com.june.implemented.model.output.Shape_Error_PageOutput;

public class Shape_Error_Decision extends AbstractAction implements Decision {
	
	public Shape_Error_Decision(WorkObjectImpl simpleFlow) {
		this.owner = simpleFlow;
		userInput = new Shape_Error_UserInput(process);
    	pageOutput = new Shape_Error_PageOutput(process);
		pageOutput.getDataFromProcess();
	}
	
	public Shape_Error_Decision(WorkObjectImpl simpleFlow,User currentUser,Process currentProcess) {
		this.owner = simpleFlow;
		process = currentProcess;
    	user = currentUser;
    	userInput = new Shape_Error_UserInput(process);
    	pageOutput = new Shape_Error_PageOutput(process);
		pageOutput.getDataFromProcess();
	}
	
    public WorkObject owner;

    public void setOwner(WorkObject wo) {
        this.owner = wo;
    }
    
    Shape_Error_UserInput userInput;
    
    public Shape_Error_UserInput getUserInput() {
		return userInput;
	}
	
	public void setUserInput(Shape_Error_UserInput userInput) {
		this.userInput = userInput;
	}
	
	Shape_Error_PageOutput pageOutput;
	
	public Shape_Error_PageOutput getPageOutput() {
		return pageOutput;
	}

	public void setPageOutput(Shape_Error_PageOutput pageOutput) {
		this.pageOutput = pageOutput;
	}

	
	
	
    public boolean perform() {
			if(getPageOutput().getShifoukeyishoudongchuli28454() != null && getPageOutput().getShifoukeyishoudongchuli28454().equals("true")) {
				return true;
								
			} else {
				return false;
			}
    }

    public String getName() {
        return getClass().getCanonicalName();
    }
    
}
