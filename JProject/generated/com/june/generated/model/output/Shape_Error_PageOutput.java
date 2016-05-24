
/**
 * 	FileName   : Shape_Error_PageOutput
 * 	Package    : com.june.generated.model.output
 *	Create Time: 2014-8-26 11:40:53
 *	Usage	   : Decision的output部分 
 *	Purpose	   : null 
 *	Note	   :
 *  taskName   : 决策任务
 *
 */
package com.june.generated.model.output;

import com.june.common.api.AbstractWorkData;
import com.june.common.model.output.AbstractPageOutput;

public class Shape_Error_PageOutput extends AbstractPageOutput {

	private String shifoukeyishoudongchuli28454;
	
	public String getShifoukeyishoudongchuli28454() {
		return shifoukeyishoudongchuli28454;
	}
	
	public void setShifoukeyishoudongchuli28454(String shifoukeyishoudongchuli28454) {
		this.shifoukeyishoudongchuli28454 = shifoukeyishoudongchuli28454;
	}
	private String shi6191;
	
	public String getShi6191() {
		return shi6191;
	}
	
	public void setShi6191(String shi6191) {
		this.shi6191 = shi6191;
	}
	public Shape_Error_PageOutput() {
		super();
        this.LoadInitData();
	}
	
	private void LoadInitData(){	
	

	}

	public void getDataFromProcess() {
		AbstractWorkData workData = process.getActiveWorkObject().getWorkDataInstance();
		setShifoukeyishoudongchuli28454(workData.getIsDealError());
	}

}