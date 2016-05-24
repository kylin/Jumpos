package com.june.implemented.model.output;

import com.june.common.model.output.AbstractPageOutput;

public class OpenAssign_PageOutput extends AbstractPageOutput {
    
    public String getWorkId() {
		return searchid;
	}

	public void setWorkId(String workId) {
		searchid = workId;
	}

	private String searchid;
   
	public OpenAssign_PageOutput() {
		super();
        
	}	
	
}
