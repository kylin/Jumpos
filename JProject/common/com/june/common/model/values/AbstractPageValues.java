package com.june.common.model.values;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import com.june.implemented.common.application.Process;
import com.june.implemented.common.application.ProcessUtils;

public abstract class AbstractPageValues implements PageValues {

	public AbstractPageValues() {
		
		process = ProcessUtils.getProcess(FacesContext.getCurrentInstance());

		if (process == null) {
			ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			process = (Process) elContext.getELResolver().getValue(elContext,
					null, "process");
			System.err.println("Process Is Not In Context[" + this +"]");
		}
	}

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	String assignee;

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	protected Process process;

}
