
/**
 * 	FileName   : Shape_Error01_PageOutput
 * 	Package    : com.june.generated.model.output
 *	Create Time: 2014-8-26 11:40:52
 *	Usage	   : 涉及属性的定义、Get、Set、初始值定义 
 *	Purpose	   : null 
 *	Note	   :
 *  taskName   : 异常任务
 *
 */
package com.june.generated.model.output;

import java.util.List;

import com.june.common.api.AbstractWorkData;
import com.june.common.model.output.AbstractPageOutput;

public class Shape_Error01_PageOutput extends AbstractPageOutput {

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
	public Shape_Error01_PageOutput() {
		super();
        this.LoadInitData();
	}
	
	private void LoadInitData(){	

	}

	public void getDataFromProcess() {
		AbstractWorkData workData = process.getActiveWorkObject().getWorkDataInstance();
		setLiuchengid19276(""+workData.getId());
		setShifoukeyishoudongchuli28454(workData.getIsDealError());
		
	}

}