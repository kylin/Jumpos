
/**
 * 	FileName   : Shape_Error02_PageOutput
 * 	Package    : com.june.generated.model.output
 *	Create Time: 2014-8-26 11:40:52
 *	Usage	   : 涉及属性的定义、Get、Set、初始值定义 
 *	Purpose	   : null 
 *	Note	   :
 *  taskName   : 异常处理等待
 *
 */
package com.june.generated.model.output;

import com.june.common.api.AbstractWorkData;
import com.june.common.model.output.AbstractPageOutput;

public class Shape_Error02_PageOutput extends AbstractPageOutput {

	private String liuchengid19276;
	
	public String getLiuchengid19276() {
		return liuchengid19276;
	}
	
	public void setLiuchengid19276(String liuchengid19276) {
		this.liuchengid19276 = liuchengid19276;
	}
	public Shape_Error02_PageOutput() {
		super();
        this.LoadInitData();
	}
	
	private void LoadInitData(){	

	}

	public void getDataFromProcess() {
		AbstractWorkData workData = process.getActiveWorkObject().getWorkDataInstance();
		setLiuchengid19276(""+workData.getId());
		
	}

}