
/**
 * 	FileName   : Shape_Error02_PageValue
 * 	Package    : com.june.generated.model.values
 *	Create Time: 2014-8-26 11:40:57
 *	Usage	   : 涉及属性的定义、Get、Set、初始值定义 
 *	Purpose	   : null 
 *	Note	   :
 *  taskName   : 异常处理等待
 *
 */
package com.june.generated.model.values;

import com.june.common.model.values.AbstractPageValues;
import com.june.implemented.model.input.Shape_Error02_UserInput;
import com.june.implemented.model.output.Shape_Error02_PageOutput;

public class Shape_Error02_PageValue extends AbstractPageValues{

	private String liuchengid19276;
	
	public String getLiuchengid19276() {
		return liuchengid19276;
	}
	
	public void setLiuchengid19276(String liuchengid19276) {
		this.liuchengid19276 = liuchengid19276;
	}
	public Shape_Error02_PageValue() {
		super();
        this.LoadInitData();
	}
	
	private void LoadInitData(){

	}

	public void getDataFromOutput(Shape_Error02_PageOutput pageOutput) {
		setLiuchengid19276(pageOutput.getLiuchengid19276());
		
	}
	
	public void setDataToInput(Shape_Error02_UserInput userInput) {
		
	}
	
	

}