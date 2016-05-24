package com.june.common.model;

import java.io.Serializable;

import com.june.common.api.WorkObject;



public interface WorkFlow extends Serializable, Cloneable {

	public void setOwner(WorkObject wo);
	
//	public void perform(String action) throws SystemException;

//	public String getCurrentState();
//
//	public String getAssignee();
//
//	public long getObjectId();
//	
//	public String getFlowName();
	
//	public void loadFlowData(long id) throws WorkNotFoundException;


	
}
