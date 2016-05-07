/**
 * 	FileName   : Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_UserInput
 * 	Package    : com.june.generated.model.input
 *	Create Time: 2016-4-5 13:12:31
 *	Usage	   : Decision的input部分
 *	Purpose	   : null 
 *	Note	   :
 * 	taskName   : 决策任务
 *
 */
package com.june.generated.model.input;

import com.june.implemented.common.application.Admin1WorkData;
import com.june.common.model.input.AbstractInput;

public class Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_UserInput extends AbstractInput {

	private String yonghuming16748;
		
	public String getYonghuming16748() {
			return yonghuming16748;
		}
	
	public void setYonghuming16748(String yonghuming16748) {
			this.yonghuming16748 = yonghuming16748;
			((Admin1WorkData) process.getActiveWorkObject().getWorkDataInstance()).setYonghuming16748(yonghuming16748);
		}

	public Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_UserInput() {
		super();
        this.LoadInitData();
	}
	
	private void LoadInitData(){	
  	}
  	
	public void setDataToProcess() {
		//if(yonghuming16748 != null)
		//((Admin1WorkData) process.getActiveWorkObject().getWorkDataInstance()).setYonghuming16748(yonghuming16748);		
	}
}