
/**
 * 	FileName   : Shape_BDCS_IDSetFlowState93978fD10Khf7X2s9e30_PageOutput
 * 	Package    : com.june.generated.model.output
 *	Create Time: 2016-5-24 9:41:10
 *	Usage	   : Activity的output部分 
 *	Purpose	   : null 
 *	Note	   :
 *  taskName   : 系统任务
 *
 */
package com.june.generated.model.output;

import com.june.common.model.output.AbstractPageOutput;
import com.june.implemented.common.application.BDCSWorkData;
import com.june.implemented.common.function.*;
import java.util.*;

public class Shape_BDCS_IDSetFlowState93978fD10Khf7X2s9e30_PageOutput extends AbstractPageOutput {

	private String bumen35536;
	
	public String getBumen35536() {
		return bumen35536;
	}
	
	public void setBumen35536(String bumen35536) {
		this.bumen35536 = bumen35536;
	}
	private List<Baoxiaoxixiang55012> baoxiaoxixiang55012;
	
	public List<Baoxiaoxixiang55012> getBaoxiaoxixiang55012() {
		if(baoxiaoxixiang55012 == null)
			baoxiaoxixiang55012 = new ArrayList<Baoxiaoxixiang55012>();
		return baoxiaoxixiang55012;
	}
	
	public void setBaoxiaoxixiang55012(List<Baoxiaoxixiang55012> baoxiaoxixiang55012) {
		this.baoxiaoxixiang55012 = baoxiaoxixiang55012;
	}
	public Shape_BDCS_IDSetFlowState93978fD10Khf7X2s9e30_PageOutput() {
		super();
        this.LoadInitData();
	}
	
	private void LoadInitData(){	
	

	}

	public void getDataFromProcess() {
		BDCSWorkData workData = (BDCSWorkData) process.getActiveWorkObject().getWorkDataInstance();
		setBumen35536(workData.getBumen35536());
		setBaoxiaoxixiang55012(workData.getBaoxiaoxixiang55012());
		
	}

}