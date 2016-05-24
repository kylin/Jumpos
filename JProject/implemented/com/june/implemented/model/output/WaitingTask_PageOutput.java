package com.june.implemented.model.output;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.june.common.api.WorkObject;
import com.june.common.model.output.AbstractPageOutput;

public class WaitingTask_PageOutput extends AbstractPageOutput implements
		Serializable {
	private static final long serialVersionUID = 6568466988588632229L;

	private List<WorkObject> pendingWork;

	// 代办任务 数目
	private int pendingCounter;

	public WaitingTask_PageOutput() {
		pendingWork = new ArrayList<WorkObject>();

	}

	public int getPendingCounter() {
		return pendingCounter;
	}

	public void setPendingCounter(int pendingCounter) {
		this.pendingCounter = pendingCounter;
	}

	public List<WorkObject> getPendingWork() {
		return pendingWork;
	}

	public void setPendingWork(List<WorkObject> pendingWork) {
		this.pendingWork = pendingWork;
		if (pendingWork != null) {
			this.pendingCounter = pendingWork.size();
			if (pendingWork.size() > 0) {
				for (WorkObject wk : pendingWork) {
					if ("QYDJZC".equals(wk.getFlowName())) {
				}
			}
		} else
			this.pendingCounter = 0;
	}

	}
}