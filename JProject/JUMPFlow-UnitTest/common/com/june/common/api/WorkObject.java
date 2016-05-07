package com.june.common.api;

public abstract class WorkObject {


	private AbstractWorkData workDataInstance;

	public void setWorkDataInstance(AbstractWorkData workDataInstance) {
		this.workDataInstance = workDataInstance;
	}

	public AbstractWorkData getWorkDataInstance() {
		return this.workDataInstance;
	}


	public WorkObject() {

	}


}
