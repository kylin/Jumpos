/**
 * 	FileName   : Shape_Error01_UserInput
 * 	Package    : com.june.generated.model.input
 *	Create Time: 2014-8-26 11:40:48
 *	Usage	   : 涉及属性的定义和Get 、Set、初始值的定义
 *	Purpose	   : null 
 *	Note	   :
 * 	taskName   : 异常任务
 *
 */
package com.june.generated.model.input;

import java.util.ArrayList;
import java.util.List;

import com.june.common.model.input.AbstractInput;

public class Shape_Error01_UserInput extends AbstractInput {

	private String shifoukeyishoudongchuli28454;
	
	public String getShifoukeyishoudongchuli28454() {
		return shifoukeyishoudongchuli28454;
	}

	public void setShifoukeyishoudongchuli28454(String shifoukeyishoudongchuli28454) {
		this.shifoukeyishoudongchuli28454 = shifoukeyishoudongchuli28454;
	}
	
	private List<javax.faces.model.SelectItem> shifoukeyishoudongchuli28454List;
	
	public List<javax.faces.model.SelectItem> getShifoukeyishoudongchuli28454List() {
		return shifoukeyishoudongchuli28454List;
	}

	public void setShifoukeyishoudongchuli28454List(List<javax.faces.model.SelectItem> shifoukeyishoudongchuli28454List) {
		this.shifoukeyishoudongchuli28454List = shifoukeyishoudongchuli28454List;
	}

	public Shape_Error01_UserInput() {
		super();
        this.LoadInitData();
	}
	
	private void LoadInitData(){
		this.shifoukeyishoudongchuli28454List = new ArrayList<javax.faces.model.SelectItem>();
		javax.faces.model.SelectItem shifoukeyishoudongchuli28454items0 = new javax.faces.model.SelectItem("true", "是");
		this.shifoukeyishoudongchuli28454List.add(shifoukeyishoudongchuli28454items0);
		javax.faces.model.SelectItem shifoukeyishoudongchuli28454items1 = new javax.faces.model.SelectItem("false", "否");
		this.shifoukeyishoudongchuli28454List.add(shifoukeyishoudongchuli28454items1);	
  	}
  	
	public void setDataToProcess() {
		process.getActiveWorkObject().getWorkDataInstance().setIsDealError(shifoukeyishoudongchuli28454);
	}
}