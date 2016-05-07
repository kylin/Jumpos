/**
 * 	FileName   : Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_Decision
 * 	Package    : com.june.generated.control.decision
 *	Create Time: 2016-4-5 13:12:27
 *	Usage	   : 涉及整体流程的决策定义的代码块
 *	Purpose	   : 
 *	Note	   :
 * 	taskName   : 决策任务 
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

public class Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_Decision extends AbstractAction implements Decision {
	
	public Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_Decision(WorkObjectImpl simpleFlow) {
		this.owner = simpleFlow;
		userInput = new Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_UserInput(process);
    	pageOutput = new Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_PageOutput(process);
//		pageOutput.getDataFromProcess();
	}
	
	public Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_Decision(WorkObjectImpl simpleFlow,User currentUser,Process currentProcess) {
		this.owner = simpleFlow;
		process = currentProcess;
    	user = currentUser;
    	userInput = new Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_UserInput(process);
    	pageOutput = new Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_PageOutput(process);
//		pageOutput.getDataFromProcess();
	}
	
    public WorkObject owner;

    public void setOwner(WorkObject wo) {
        this.owner = wo;
    }
    
    Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_UserInput userInput;
    
    public Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_UserInput getUserInput() {
		return userInput;
	}
	
	public void setUserInput(Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_UserInput userInput) {
		this.userInput = userInput;
	}
	
	Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_PageOutput pageOutput;
	
	public Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_PageOutput getPageOutput() {
		return pageOutput;
	}

	public void setPageOutput(Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_PageOutput pageOutput) {
		this.pageOutput = pageOutput;
	}

	
	
	
    public boolean perform() {
        //Admin1WorkData wd = (Admin1WorkData) owner.getWorkDataInstance();
        
        	
		//String yonghuming16748 = wd.getYonghuming16748().toString();
		//String fou1574 = wd.getFou1574().toString();
		//String shi6191 = wd.getShi6191().toString();    
	//	wd.setFou1574("");
	//	wd.setShi6191("");
        
			if(getPageOutput().getYonghuming16748() != null && getPageOutput().getYonghuming16748().equals("a")) {
				return true;
								
			} else {
				return false;
			}
							
		//
				 
    }

    public String getName() {
        return getClass().getCanonicalName();
    }
    
}
