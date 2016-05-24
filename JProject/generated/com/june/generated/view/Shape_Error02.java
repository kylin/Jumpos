
/**
 * 	FileName   : Shape_Error02
 * 	Package    : com.june.generated.view
 *	Create Time: 2014-8-26 11:40:58
 *	Usage	   : 包含实现系统的页面
 *	Purpose	   : null 
 *	Note	   :
 *  TaskName   : 异常处理等待
 *
 */
package com.june.generated.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.june.common.view.AbstractManagedBean;
import com.june.implemented.model.action.Shape_Error02_Submit;
import com.june.implemented.model.input.Shape_Error02_UserInput;
import com.june.implemented.model.output.Shape_Error02_PageOutput;
import com.june.implemented.model.values.Shape_Error02_PageValue;

 
@ManagedBean(name="shape_Error02")
//@RequestScoped
@ViewScoped
public class Shape_Error02 extends AbstractManagedBean {
	  
	Shape_Error02_PageOutput pageOutput = new Shape_Error02_PageOutput();
	
    public Shape_Error02_PageOutput getPageOutput() {
		return pageOutput;
	}
	
	public void setPageOutput(Shape_Error02_PageOutput pageOutput) {
		this.pageOutput = pageOutput;
	}
	
	
	Shape_Error02_UserInput userInput = new Shape_Error02_UserInput();
	
    public Shape_Error02_UserInput getUserInput() {
		return userInput;
	}
	
	public void setUserInput(Shape_Error02_UserInput userInput) {
		this.userInput = userInput;
	}
	
	
	Shape_Error02_PageValue pageValue = new Shape_Error02_PageValue();
	
    public Shape_Error02_PageValue getPageValue() {
		return pageValue;
	}
	
	public void setPageValue(Shape_Error02_PageValue pageValue) {
		this.pageValue = pageValue;
	}

    private Shape_Error02_Submit submitAction = new Shape_Error02_Submit();
    
    public Shape_Error02_Submit getSubmitAction() {
		return submitAction;
	}

	public void setSubmitAction(Shape_Error02_Submit submitAction) {
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
