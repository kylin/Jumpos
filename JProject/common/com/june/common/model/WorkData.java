package com.june.common.model;

import java.io.Serializable;

public interface WorkData extends Serializable, Cloneable {
//    public long getId();
	public void setAssignee(String assignee) ;
	public void setCurrentState(String currentState);
	
//    public void LoadDefaultValue() throws SystemException;
//    public void loadWorkData(long id) throws WorkNotFoundException;
//    public List<WorkObject> getPendingWork(String operatorID);
	

}
