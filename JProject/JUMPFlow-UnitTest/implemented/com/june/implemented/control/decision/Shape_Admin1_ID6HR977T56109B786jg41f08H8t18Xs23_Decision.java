/**
 * 	FileName   : Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_Decision
 * 	Package    : com.june.implemented.control.decision
 *	Create Time: 2016-4-5 13:12:28
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

public class Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_Decision extends com.june.generated.control.decision.Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_Decision implements Decision {
	
	public Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_Decision(WorkObjectImpl simpleFlow) {
		super(simpleFlow);
	}
	public Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_Decision(WorkObjectImpl simpleFlow,User currentUser,Process currentProcess) {
		super(simpleFlow,currentUser,currentProcess);
	}
    
     public boolean perform() {
    	 
    	 //Get data like this.getPageOutput().getYonghuming16748()
    	 String name = this.getPageOutput().getYonghuming16748();
    	 
    	 //Do Decision
    	 Boolean result = false;
    	 
    	 if (name.equalsIgnoreCase("aaa")){
    		 result = true;
    	 }
    	 
    	 //Set data like  this.getUserInput().setYonghuming16748("XXXX");
    	 this.getUserInput().setYonghuming16748("bbbbccc");
    	 
    	 return result;
    	
     	//return super.perform();
     	
     }
     

}
