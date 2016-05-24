/**
 * 
 * 		NewWork_BDCS_UserInput
 *
 */
package com.june.generated.model.input;

import com.june.implemented.common.application.BDCSWorkData;
import com.june.common.model.input.AbstractInput;

public class NewWork_BDCS_UserInput extends AbstractInput {
      
	private String flowName;
      
	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	
	public NewWork_BDCS_UserInput() {
		super();
		this.LoadInitData();
	}
	
	private void LoadInitData() {
		this.flowName = "BDCS";
	}
	
	public void setDataToProcess() {
		((BDCSWorkData) process.getActiveWorkObject().getWorkDataInstance()).setFlowName(flowName);
	}
}