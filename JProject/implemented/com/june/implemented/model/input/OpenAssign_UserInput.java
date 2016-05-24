package com.june.implemented.model.input;

import com.june.implemented.common.application.WorkObjectImpl;

public class OpenAssign_UserInput {
	private long instanceHandle;
	private String flowName;
	String searchid;

	private WorkObjectImpl workSelectedforAssignee = new WorkObjectImpl();

	public String getSearchid() {
		return searchid;
	}

	public void setSearchid(String searchid) {
		this.searchid = searchid;
	}

	public long getInstanceHandle() {
		return instanceHandle;
	}

	public WorkObjectImpl getWorkSelectedforAssignee() {
		return workSelectedforAssignee;
	}

	public void setWorkSelectedforAssignee(
			WorkObjectImpl workSelectedforAssignee) {
		this.workSelectedforAssignee = workSelectedforAssignee;
		if (workSelectedforAssignee != null
				&& workSelectedforAssignee.getObjectId() != 0)
			this.instanceHandle = (int) workSelectedforAssignee.getObjectId();
	}

	public void setInstanceHandle(long instanceHandle) {
		this.instanceHandle = instanceHandle;
	}

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

}