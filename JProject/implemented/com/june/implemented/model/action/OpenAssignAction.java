package com.june.implemented.model.action;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import com.june.common.exception.AuthorizationException;
import com.june.common.exception.SystemException;
import com.june.common.exception.ValidationException;
import com.june.common.exception.WorkNotFoundException;
import com.june.common.model.action.AbstractAction;
import com.june.implemented.common.application.Process;
import com.june.implemented.common.application.ProcessUtils;
import com.june.implemented.model.input.OpenAssign_UserInput;

// @ManagedBean(name="openAssignAction")
public class OpenAssignAction extends AbstractAction {
	private OpenAssign_UserInput userInput = new OpenAssign_UserInput();

	public OpenAssign_UserInput getUserInput() {
		return userInput;
	}

	public void setUserInput(OpenAssign_UserInput userInput) {
		this.userInput = userInput;
	}

	// @ManagedProperty(value = "#{process}")
	Process processImpl;

	public OpenAssignAction() {
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		processImpl = (Process) elContext.getELResolver().getValue(elContext,
				null, "process");
		processImpl = ProcessUtils.getProcess(FacesContext.getCurrentInstance());
	}

	public Process getProcess() {
		return processImpl;
	}

	public void setProcess(Process process) {
		this.processImpl = process;
	}

	public String perform() throws SystemException, ValidationException,
			WorkNotFoundException, AuthorizationException {
		if (userInput.getInstanceHandle() != 0) { // 未选情况

			processImpl.getActiveWorkObject().loadWorkData(
					processImpl.getUser().getWorkclass(),
					userInput.getFlowName(), userInput.getInstanceHandle());
//			if (!processImpl.getUser().getUsergroup()
//					.equals(processImpl.getActiveWorkObject().getUserGroup())) {
//				System.out.println("用户组不匹配");
//				return "review";
//			}
			System.out.println("待办任务选中:"
					+ processImpl.getActiveWorkObject().getCurrentState());
			return processImpl.getActiveWorkObject().getCurrentState()
					+ ".xhtml?faces-redirect=true";
		}
		return null;
	}


}