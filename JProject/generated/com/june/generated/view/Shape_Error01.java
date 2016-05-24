
/**
 * 	FileName   : Shape_Error01
 * 	Package    : com.june.generated.view
 *	Create Time: 2014-8-26 11:40:58
 *	Usage	   : 包含实现系统的页面
 *	Purpose	   : null 
 *	Note	   :
 *  TaskName   : 异常任务
 *
 */
package com.june.generated.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.june.common.view.AbstractManagedBean;
import com.june.implemented.model.action.Shape_Error01_Submit;
import com.june.implemented.model.input.Shape_Error01_UserInput;
import com.june.implemented.model.output.Shape_Error01_PageOutput;
import com.june.implemented.model.values.Shape_Error01_PageValue;

 
@ManagedBean(name="shape_Error01")
//@RequestScoped
@ViewScoped
public class Shape_Error01 extends AbstractManagedBean {
	  
	Shape_Error01_PageOutput pageOutput = new Shape_Error01_PageOutput();
	
    public Shape_Error01_PageOutput getPageOutput() {
		return pageOutput;
	}
	
	public void setPageOutput(Shape_Error01_PageOutput pageOutput) {
		this.pageOutput = pageOutput;
	}
	
	
	Shape_Error01_UserInput userInput = new Shape_Error01_UserInput();
	
    public Shape_Error01_UserInput getUserInput() {
		return userInput;
	}
	
	public void setUserInput(Shape_Error01_UserInput userInput) {
		this.userInput = userInput;
	}
	
	
	Shape_Error01_PageValue pageValue = new Shape_Error01_PageValue();
	
    public Shape_Error01_PageValue getPageValue() {
		return pageValue;
	}
	
	public void setPageValue(Shape_Error01_PageValue pageValue) {
		this.pageValue = pageValue;
	}

    private Shape_Error01_Submit submitAction = new Shape_Error01_Submit();
    
    public Shape_Error01_Submit getSubmitAction() {
		return submitAction;
	}

	public void setSubmitAction(Shape_Error01_Submit submitAction) {
		this.submitAction = submitAction;
	}
	
	
	@PostConstruct
	public void getPageOutputData(){
		try {
			pageOutput.getDataFromProcess();
			pageValue.getDataFromOutput(pageOutput);
			submitAction.setPageValue(pageValue);
			submitAction.setUserInput(userInput);
			
			
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
