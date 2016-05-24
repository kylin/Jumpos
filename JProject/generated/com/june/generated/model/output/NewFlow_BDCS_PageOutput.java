/**
 * 
 * 		NewFlow_BDCS_PageOutput
 *
 */
package com.june.generated.model.output;

import java.util.ArrayList;
import java.util.List;

import com.june.common.api.WorkObject;
import com.june.common.model.output.AbstractPageOutput;

public class NewFlow_BDCS_PageOutput extends AbstractPageOutput {

	private List<WorkObject> pendingWorkBDCS;

	public List<WorkObject> getPendingWorkBDCS() {
		return pendingWorkBDCS;
	}

	public void setPendingWorkBDCS(List<WorkObject> pendingWorkBDCS) {
		this.pendingWorkBDCS = pendingWorkBDCS;
	}
	
	public NewFlow_BDCS_PageOutput() {
        pendingWorkBDCS = new ArrayList<WorkObject>();
    }
}