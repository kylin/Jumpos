/**
 *
 *        NewWork_BDCS_Action
 *
 */
package com.june.implemented.model.action;

import com.june.generated.model.input.NewWork_BDCS_UserInput;
import com.june.common.exception.AuthorizationException;
import com.june.common.exception.SystemException;
import com.june.common.exception.ValidationException;
import com.june.common.exception.WorkNotFoundException;
import com.june.common.model.action.AbstractAction;

public class NewWork_BDCS_Action extends AbstractAction{

    private NewWork_BDCS_UserInput userInput = new NewWork_BDCS_UserInput();
    
    public NewWork_BDCS_UserInput getUserInput() {
		return userInput;
	}

	public void setUserInput(NewWork_BDCS_UserInput userInput) {
		this.userInput = userInput;
	}
	
    public String perform() throws SystemException, ValidationException, WorkNotFoundException, AuthorizationException {

        userInput.setDataToProcess();
//		process.getActiveWorkObject().createNewWork(process.getUser().getWorkclass(), userInput.getFlowName(),
//				process.getUser().getUsername());
		return process.getActiveWorkObject().getCurrentState() +".xhtml";
    }
}