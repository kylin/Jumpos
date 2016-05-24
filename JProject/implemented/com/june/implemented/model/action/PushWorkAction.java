package com.june.implemented.model.action;

import com.june.common.exception.AuthorizationException;
import com.june.common.exception.SystemException;
import com.june.common.exception.ValidationException;
import com.june.common.exception.WorkNotFoundException;
import com.june.common.model.action.AbstractAction;
import com.june.implemented.common.application.WorkObjectImpl;
import com.june.implemented.control.flowaction.NewFlow_Any_Submit_Action;
import com.june.implemented.model.input.NewWork_UserInput;

// @ManagedBean(name="newWorkAction2")
public class PushWorkAction extends AbstractAction {
	private NewWork_UserInput userInput = new NewWork_UserInput();

	// @ManagedProperty(value = "#{process}")
	public String objectID;
	
	public String getObjectID() {
		return objectID;
	}

	public void setObjectID(String objectID) {
		this.objectID = objectID;
	}
	public NewWork_UserInput getUserInput() {
		return userInput;
	}

	public void setUserInput(NewWork_UserInput userInput) {
		this.userInput = userInput;
	}

	public String perform() throws SystemException, ValidationException, WorkNotFoundException, AuthorizationException {
		System.out.println("XXXXXXXXObjectID:" + objectID);
		int objectIDint = Integer.parseInt(objectID);
		System.err.println("PushObjectID:" + objectIDint);
		userInput.setFlowName("LDFW");	//不同流程改名
//		return perform("newFlow", userInput);
		process.getUser().setWorkclass("LDFW");
//		long objectID = process.getActiveWorkObject().getObjectId();
//		process.getActiveWorkObject().loadWorkData(process.getUser().getWorkclass(), userInput.getFlowName(), objectIDint);
//		process.getActiveWorkObject().createNewWork(process.getUser().getWorkclass(), userInput.getFlowName(),
//				process.getUser().getUsername(), "LDFW", "pushStart");
//		new NewFlow_Any_Submit_Action((WorkObjectImpl) process.getActiveWorkObject()).perform("LDFW", "pushStart");	
		System.out.println("process.getActiveWorkObject().getCurrentState():" + process.getActiveWorkObject().getCurrentState());
		process.getActiveWorkObject().getNextStep();
		return process.getActiveWorkObject().getCurrentState() +".xhtml";
	
		// Shape_Cs_IDASDIOG_UserInput userInput1 = new
		// Shape_Cs_IDASDIOG_UserInput();
		// userInput1.setXuanzefuwu("纯文本沟通");
		// return process.perform("submit", userInput1);

	}

}
