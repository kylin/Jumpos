/**
 * 	FileName   : Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_Submit
 * 	Package    : com.june.generated.model.action
 *	Create Time: 2016-5-25 7:25:20
 *	Usage	   : 涉及页面的输入和perform方法
 *	Purpose	   : null 
 *	Note	   :
 * 	taskName   : 填写报销申请表
 *
 */ 
package com.june.generated.model.action;

import com.june.common.model.action.AbstractAction;
import javax.faces.event.ActionEvent;
import com.june.implemented.control.flowaction.Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_Submit_Action;
import com.june.implemented.model.input.Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_UserInput;
import com.june.implemented.model.values.Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageValue;

public class Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_Submit extends AbstractAction {
	
	private Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_UserInput userInput = new Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_UserInput();

	public Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_UserInput getUserInput() {
		return userInput;
	}

	public void setUserInput(Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_UserInput userInput) {
		this.userInput = userInput;
	}
	
	private Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageValue pageValue = new Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageValue();

	public Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageValue getPageValue() {
		return pageValue;
	}

	public void setPageValue(Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageValue pageValue) {
		this.pageValue = pageValue;
	}
	
	
	
	public void addbaoxiaoxixiang55012(ActionEvent event){
		getPageValue().addbaoxiaoxixiang55012();
	}
	public void modifybaoxiaoxixiang55012(ActionEvent event){
		getPageValue().modifybaoxiaoxixiang55012();
	}
	public void deletebaoxiaoxixiang55012(ActionEvent event){
		getPageValue().deletebaoxiaoxixiang55012();
	}
	public void confirmmodifybaoxiaoxixiang55012(ActionEvent event){
		getPageValue().confirmmodifybaoxiaoxixiang55012();
	}
	public void confirmaddbaoxiaoxixiang55012(ActionEvent event){
		getPageValue().confirmaddbaoxiaoxixiang55012();
	}
	
	

	
	public String perform() {
		if (process.getActiveWorkObject().getActiveFlowInstance() == null) {
			return "login.xhtml?faces-redirect=true&IsOutTime=true";
		}
		try {
			pageValue.setDataToInput(userInput);
			userInput.setDataToProcess();
			

			process.getActiveWorkObject().recordHistory(user.getUsername(), "用户操作", null);
			
	new Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_Submit_Action(process.getActiveWorkObject()).perform();
			process.getActiveWorkObject().getNextStep();

			String step = process.getActiveWorkObject().getCurrentState();
			
			if ((!process.getUser().getUsergroup().equals(process.getActiveWorkObject().getUserGroup()) || !process.getActiveWorkObject().getAssignee().equals(" ")) && !process.getActiveWorkObject().getAssignee().equals(process.getUser().getUsername())) {
				return "shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_confirm.xhtml?faces-redirect=true";
			}
			return step+".xhtml?faces-redirect=true";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "confirmError.xhtml?faces-redirect=true";
		}
	}
}