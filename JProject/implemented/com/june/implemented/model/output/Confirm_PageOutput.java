package com.june.implemented.model.output;

import com.june.common.api.WorkObject;
import com.june.common.model.output.AbstractPageOutput;
import com.june.implemented.common.application.WorkObjectImpl;

public class Confirm_PageOutput extends AbstractPageOutput {
	protected long objectId;
	private String assignee;
	private String currentState;
	private String flowName;

	public long getObjectId() {
		return objectId;
	}

	public void setObjectId(long objectId) {
		this.objectId = objectId;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public void getDataFromProcess() {
		WorkObject da = (WorkObjectImpl) process.getActiveWorkObject();
		setObjectId(da.getObjectId());
		setAssignee(da.getActiveFlowInstance().getUserGroup());
		setCurrentState(da.getCurrentStateDisplay());
		setFlowName(da.getFlowName());

	}

}