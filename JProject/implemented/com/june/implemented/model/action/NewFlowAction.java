package com.june.implemented.model.action;

import com.june.common.exception.AuthorizationException;
import com.june.common.exception.SystemException;
import com.june.common.exception.ValidationException;
import com.june.common.exception.WorkNotFoundException;
import com.june.common.model.action.AbstractAction;
import com.june.implemented.model.input.NewFlow_UserInput;
import com.june.implemented.model.input.NewWork_UserInput;

// @ManagedBean(name="newFlowAction")
public class NewFlowAction extends AbstractAction {
	private NewFlow_UserInput userInput = new NewFlow_UserInput();

	// @ManagedProperty(value = "#{process}")

	public NewFlow_UserInput getUserInput() {
		return userInput;
	}

	public void setUserInput(NewFlow_UserInput userInput) {
		this.userInput = userInput;
	}

	public String perform() throws SystemException, ValidationException, WorkNotFoundException, AuthorizationException {
		NewWork_UserInput userInput1 = new NewWork_UserInput();
		userInput1.setFlowName("Cs");
		// perform("newFlow", userInput1);

		// process.getActiveWorkObject().createNewWork(process.getUser().getWorkclass(),
		// userInput1.getFlowName(),
		// process.getUser().getUsername());

		String step = process.getActiveWorkObject().getNextStep();
		if (!process.getActiveWorkObject().getAssignee().equals(process.getUser().getUsername())) {
			return "confirm.xhtml?faces-redirect=true";
		}
		return step + ".xhtml?faces-redirect=true";
	}

}
