
/**
 * 	FileName   : Shape_BDCS_ID9E4GDYr7RcEW6MhIc4X4j07108978ciu_PageOutput
 * 	Package    : com.june.generated.model.output
 *	Create Time: 2016-5-24 9:41:09
 *	Usage	   : 涉及属性的定义、Get、Set、初始值定义 
 *	Purpose	   : null 
 *	Note	   :
 *  taskName   : 查看拒绝原因
 *
 */
package com.june.generated.model.output;

import com.june.common.model.output.AbstractPageOutput;
import com.june.implemented.common.application.BDCSWorkData;
import com.june.implemented.common.function.*;
import java.util.*;

public class Shape_BDCS_ID9E4GDYr7RcEW6MhIc4X4j07108978ciu_PageOutput extends AbstractPageOutput {

	private String sqbbtgyy78335;
	
	public String getSqbbtgyy78335() {
		return sqbbtgyy78335;
	}
	
	public void setSqbbtgyy78335(String sqbbtgyy78335) {
		this.sqbbtgyy78335 = sqbbtgyy78335;
	}
	public Shape_BDCS_ID9E4GDYr7RcEW6MhIc4X4j07108978ciu_PageOutput() {
		super();
        this.LoadInitData();
	}
	
	private void LoadInitData(){	

	}

	public void getDataFromProcess() {
		BDCSWorkData workData = (BDCSWorkData) process.getActiveWorkObject().getWorkDataInstance();
		setSqbbtgyy78335(workData.getSqbbtgyy78335());
		
	}

}