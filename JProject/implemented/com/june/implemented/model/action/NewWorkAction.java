package com.june.implemented.model.action;

import com.june.common.exception.AuthorizationException;
import com.june.common.exception.SystemException;
import com.june.common.exception.ValidationException;
import com.june.common.exception.WorkNotFoundException;
import com.june.common.model.action.AbstractAction;
import com.june.implemented.model.input.NewWork_UserInput;

import javax.faces.bean.ManagedBean;

 @ManagedBean(name="newWorkAction")
public class NewWorkAction extends AbstractAction {
	private NewWork_UserInput userInput = new NewWork_UserInput();

	// @ManagedProperty(value = "#{process}")
	public NewWork_UserInput getUserInput() {
		return userInput;
	}

	public void setUserInput(NewWork_UserInput userInput) {
		this.userInput = userInput;
	}

	public String perform() throws SystemException, ValidationException, WorkNotFoundException, AuthorizationException {
		userInput.setFlowName("JUMPOS"); 

		process.getActiveWorkObject().createNewWork("JUMPOS", userInput.getFlowName(), process.getUser().getUsername(), process.getUser().getUsergroup(), process.getUser().getUserHigher(), user.getLocation(),
				"JUMPOS", "JUMPOS", "流程1");
		process.getActiveWorkObject().recordHistory(user.getUsername(), "开启新流程", null);
		String currentState = process.getActiveWorkObject().getCurrentState();
		System.out.println("process.getActiveWorkObject().getCurrentState():" + process.getActiveWorkObject().getCurrentState());
		if(currentState == null || !currentState.contains("shape")){
			return "verifyUser.xhtml";
		}
		if ((!process.getUser().getUsergroup().equals(process.getActiveWorkObject().getUserGroup()) || !process.getActiveWorkObject().getAssignee().equals(" ")) && !process.getActiveWorkObject().getAssignee().equals(process.getUser().getUsername())) {
				return "confirm.xhtml?faces-redirect=true";
		}
		return process.getActiveWorkObject().getCurrentState() + ".xhtml";

	}

}
