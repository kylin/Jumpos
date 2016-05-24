package com.june.common.model.input;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import com.june.implemented.common.application.Process;
import com.june.implemented.common.application.ProcessUtils;

public abstract class AbstractInput implements Input {

	public AbstractInput() {

		process = ProcessUtils.getProcess(FacesContext.getCurrentInstance());

		if (process == null) {
			ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			process = (Process) elContext.getELResolver().getValue(elContext,
					null, "process");
			System.err.println("Process Is Not In Context[" + this +"]");
		}
	}

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	protected Process process;

}
