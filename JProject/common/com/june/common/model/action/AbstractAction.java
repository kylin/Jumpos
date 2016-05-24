package com.june.common.model.action;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import com.june.implemented.common.application.Process;
import com.june.implemented.common.application.ProcessUtils;
import com.june.implemented.common.authentication.User;

public abstract class AbstractAction {
	public AbstractAction() {
		process = ProcessUtils.getProcess(FacesContext.getCurrentInstance());
		
		if(process != null){
			user = process.getUser();
		}
		else{
			ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			process = (Process) elContext.getELResolver().getValue(elContext,
					null, "process");
			System.err.println("Process Is Not In Context[" + this +"]");
		}
	}
	
	protected Process process;
	protected User user;

}
