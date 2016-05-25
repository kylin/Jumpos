/**
 * 	FileName   : Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_Submit
 * 	Package    : com.june.generated.model.action
 *	Create Time: 2016-5-25 8:42:34
 *	Usage	   : 涉及页面的输入和perform方法
 *	Purpose	   : null 
 *	Note	   :
 * 	taskName   : 审核报销申请表
 *
 */ 
package com.june.generated.model.action;

import com.june.common.model.action.AbstractAction;
import javax.faces.event.ActionEvent;
import com.june.implemented.control.flowaction.Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_Submit_Action;
import com.june.implemented.model.input.Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_UserInput;
import com.june.implemented.model.values.Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_PageValue;

public class Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_Submit extends AbstractAction {
	
	private Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_UserInput userInput = new Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_UserInput();

	public Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_UserInput getUserInput() {
		return userInput;
	}

	public void setUserInput(Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_UserInput userInput) {
		this.userInput = userInput;
	}
	
	private Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_PageValue pageValue = new Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_PageValue();

	public Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_PageValue getPageValue() {
		return pageValue;
	}

	public void setPageValue(Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_PageValue pageValue) {
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
			
	new Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_Submit_Action(process.getActiveWorkObject()).perform();
			process.getActiveWorkObject().getNextStep();

			String step = process.getActiveWorkObject().getCurrentState();
			
			if ((!process.getUser().getUsergroup().equals(process.getActiveWorkObject().getUserGroup()) || !process.getActiveWorkObject().getAssignee().equals(" ")) && !process.getActiveWorkObject().getAssignee().equals(process.getUser().getUsername())) {
				return "shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_confirm.xhtml?faces-redirect=true";
			}
			return step+".xhtml?faces-redirect=true";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "confirmError.xhtml?faces-redirect=true";
		}
	}
}