package com.june.common.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.june.common.model.WorkData;

@Entity
@Table(name = "work_data")
public class AbstractWorkData implements WorkData {
	private static final long serialVersionUID = -8676917275086480541L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="work_dataseq")
    @SequenceGenerator(name="work_dataseq",sequenceName="work_data_seq",allocationSize=1) 
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	private String assignee;
	private String currentState;
	private String flowName;
	private String flowType;
	
	private String userGroup;
	private String platformLoc;
	
	private String flowState;
	
	private String isDealError;

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	
	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public String getPlatformLoc() {
		return platformLoc;
	}

	public void setPlatformLoc(String platformLoc) {
		this.platformLoc = platformLoc;
	}

	public String getAssignee() {
		return assignee;
	}
	public String getFlowState() {
		return flowState;
	}

	public void setFlowState(String flowState) {
		this.flowState = flowState;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getFlowType() {
		return flowType;
	}

	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}


	public String getIsDealError() {
		return isDealError;
	}

	public void setIsDealError(String isDealError) {
		this.isDealError = isDealError;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		return "[WorkClass - " + getClass().getName() + "(id=" + id + ")]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
