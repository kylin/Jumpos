
/**
 * 	FileName   : Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_PageOutput
 * 	Package    : com.june.generated.model.output
 *	Create Time: 2016-4-5 13:12:33
 *	Usage	   : Decision的output部分 
 *	Purpose	   : null 
 *	Note	   :
 *  taskName   : 决策任务
 *
 */
package com.june.generated.model.output;

import com.june.common.model.output.AbstractPageOutput;
import com.june.implemented.common.application.Admin1WorkData;

public class Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_PageOutput extends AbstractPageOutput {

	private String yonghuming16748;
	
	public String getYonghuming16748() {
		return yonghuming16748;
	}
	
	public void setYonghuming16748(String yonghuming16748) {
		this.yonghuming16748 = yonghuming16748;
	}
	public Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_PageOutput() {
		super();
        this.LoadInitData();
	}
	
	private void LoadInitData(){	

	}

	public void getDataFromProcess() {
		Admin1WorkData workData = (Admin1WorkData) process.getActiveWorkObject().getWorkDataInstance();
		setYonghuming16748(workData.getYonghuming16748());
		
	}

}