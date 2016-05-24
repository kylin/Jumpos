package com.june.implemented.model.output;

import com.june.common.model.output.AbstractPageOutput;

public class End_PageOutput extends AbstractPageOutput {
	    String id;
	    private String resolutionStatus;
	    int counter;
	    
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getResolutionStatus() {
			return resolutionStatus;
		}
		public void setResolutionStatus(String resolutionStatus) {
			this.resolutionStatus = resolutionStatus;
		}
		public int getCounter() {
			return counter;
		}
		public void setCounter(int counter) {
			this.counter = counter;
		}

}
