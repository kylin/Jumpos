package com.june.common.model.output;

import com.june.implemented.common.application.Process;

public abstract class AbstractPageOutput implements PageOutput {

	public AbstractPageOutput() {

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
