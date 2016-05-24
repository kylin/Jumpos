
/**
 * 	FileName   : Shape_Error01_PageValue
 * 	Package    : com.june.generated.model.values
 *	Create Time: 2014-8-26 11:40:56
 *	Usage	   : 涉及属性的定义、Get、Set、初始值定义 
 *	Purpose	   : null 
 *	Note	   :
 *  taskName   : 异常任务
 *
 */
package com.june.generated.model.values;

import java.util.ArrayList;
import java.util.List;

import com.june.common.model.values.AbstractPageValues;
import com.june.implemented.model.input.Shape_Error01_UserInput;
import com.june.implemented.model.output.Shape_Error01_PageOutput;

public class Shape_Error01_PageValue extends AbstractPageValues{

	private String liuchengid19276;
	
	public String getLiuchengid19276() {
		return liuchengid19276;
	}
	
	public void setLiuchengid19276(String liuchengid19276) {
		this.liuchengid19276 = liuchengid19276;
	}
	private List<javax.faces.model.SelectItem> shifoukeyishoudongchuli28454List;
	
	public List<javax.faces.model.SelectItem> getShifoukeyishoudongchuli28454List() {
		return shifoukeyishoudongchuli28454List;
	}
	
	public void setShifoukeyishoudongchuli28454List(List<javax.faces.model.SelectItem> shifoukeyishoudongchuli28454List) {
		this.shifoukeyishoudongchuli28454List = shifoukeyishoudongchuli28454List;
	}
	private String shifoukeyishoudongchuli28454;
	
	public String getShifoukeyishoudongchuli28454() {
		return shifoukeyishoudongchuli28454;
	}
	
	public void setShifoukeyishoudongchuli28454(String shifoukeyishoudongchuli28454) {
		this.shifoukeyishoudongchuli28454 = shifoukeyishoudongchuli28454;
	}
	public Shape_Error01_PageValue() {
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

	public void getDataFromOutput(Shape_Error01_PageOutput pageOutput) {
		setLiuchengid19276(pageOutput.getLiuchengid19276());
		setShifoukeyishoudongchuli28454(pageOutput.getShifoukeyishoudongchuli28454());
		
	}
	
	public void setDataToInput(Shape_Error01_UserInput userInput) {
		userInput.setShifoukeyishoudongchuli28454(getShifoukeyishoudongchuli28454());
		
	}
	
	

}