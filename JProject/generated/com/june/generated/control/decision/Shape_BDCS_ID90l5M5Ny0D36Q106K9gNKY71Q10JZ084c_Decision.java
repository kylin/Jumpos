/**
 * 	FileName   : Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_Decision
 * 	Package    : com.june.generated.control.decision
 *	Create Time: 2016-5-25 7:25:22
 *	Usage	   : 涉及整体流程的决策定义的代码块
 *	Purpose	   : 
 *	Note	   :
 * 	taskName   : 是否通过审核 
 *
 */
package com.june.generated.control.decision;

import com.june.common.api.*;
import com.june.common.control.Decision;
import com.june.implemented.common.application.Process;
import com.june.implemented.common.application.WorkObjectImpl;
import com.june.implemented.common.authentication.User;
import com.june.common.model.action.AbstractAction;
import com.june.implemented.model.input.*;
import com.june.implemented.model.output.*;

public class Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_Decision extends AbstractAction implements Decision {
	
	public Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_Decision(WorkObjectImpl simpleFlow) {
		this.owner = simpleFlow;
		userInput = new Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_UserInput(process);
    	pageOutput = new Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_PageOutput(process);
		pageOutput.getDataFromProcess();
	}
	
	public Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_Decision(WorkObjectImpl simpleFlow,User currentUser,Process currentProcess) {
		this.owner = simpleFlow;
		process = currentProcess;
    	user = currentUser;
    	userInput = new Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_UserInput(process);
    	pageOutput = new Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_PageOutput(process);
		pageOutput.getDataFromProcess();
	}
	
    public WorkObject owner;

    public void setOwner(WorkObject wo) {
        this.owner = wo;
    }
    
    Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_UserInput userInput;
    
    public Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_UserInput getUserInput() {
		return userInput;
	}
	
	public void setUserInput(Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_UserInput userInput) {
		this.userInput = userInput;
	}
	
	Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_PageOutput pageOutput;
	
	public Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_PageOutput getPageOutput() {
		return pageOutput;
	}

	public void setPageOutput(Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_PageOutput pageOutput) {
		this.pageOutput = pageOutput;
	}

	
	
	
    public boolean perform() {
        //BDCSWorkData wd = (BDCSWorkData) owner.getWorkDataInstance();
        
        	
		//String shifoutongguoshenhe51727 = wd.getShifoutongguoshenhe51727().toString();
		//String fou1574 = wd.getFou1574().toString();
		//String shi6191 = wd.getShi6191().toString();    
	//	wd.setFou1574("");
	//	wd.setShi6191("");
        
			if(getPageOutput().getShifoutongguoshenhe51727() != null && getPageOutput().getShifoutongguoshenhe51727().equals("是")) {
				return true;
								
			} else {
				return false;
			}
							
		//null
				 
    }

    public String getName() {
        return getClass().getCanonicalName();
    }
    
}
