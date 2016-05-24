/**
 * 	FileName   : Shape_Error02_Submit
 * 	Package    : com.june.generated.model.action
 *	Create Time: 2014-8-26 11:40:38
 *	Usage	   : 涉及页面的输入和perform方法
 *	Purpose	   : null 
 *	Note	   :
 * 	taskName   : 异常处理等待
 *
 */ 
package com.june.generated.model.action;

import com.june.common.model.action.AbstractAction;
import com.june.implemented.control.flowaction.Shape_Error02_Submit_Action;
import com.june.implemented.model.input.Shape_Error02_UserInput;
import com.june.implemented.model.values.Shape_Error02_PageValue;

public class Shape_Error02_Submit extends AbstractAction {
	
	private Shape_Error02_UserInput userInput = new Shape_Error02_UserInput();

	public Shape_Error02_UserInput getUserInput() {
		return userInput;
	}

	public void setUserInput(Shape_Error02_UserInput userInput) {
		this.userInput = userInput;
	}
	
	private Shape_Error02_PageValue pageValue = new Shape_Error02_PageValue();

	public Shape_Error02_PageValue getPageValue() {
		return pageValue;
	}

	public void setPageValue(Shape_Error02_PageValue pageValue) {
		this.pageValue = pageValue;
	}
	
	
	
	
	

	
	public String perform() {
		if (process.getActiveWorkObject().getActiveFlowInstance() == null) {
			return "login.xhtml?faces-redirect=true&IsOutTime=true";
		}
		try {
			pageValue.setDataToInput(userInput);
			userInput.setDataToProcess();
			

			process.getActiveWorkObject().recordHistory(user.getUsername(), "用户操作", null);
			
	new Shape_Error02_Submit_Action(process.getActiveWorkObject()).perform();
			process.getActiveWorkObject().getNextStep();

			String step = process.getActiveWorkObject().getCurrentState();
			
			if ((!process.getUser().getUsergroup().equals(process.getActiveWorkObject().getUserGroup()) || !process.getActiveWorkObject().getAssignee().equals(" ")) && !process.getActiveWorkObject().getAssignee().equals(process.getUser().getUsername())) {
				return "confirm.xhtml?faces-redirect=true";
			}
			return step+".xhtml?faces-redirect=true";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "confirmError.xhtml?faces-redirect=true";
		}
	}
}