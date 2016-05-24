
/**
 * 	FileName   : Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S
 * 	Package    : com.june.generated.view
 *	Create Time: 2016-5-24 9:41:12
 *	Usage	   : 包含实现系统的页面
 *	Purpose	   : null 
 *	Note	   :
 *  TaskName   : 填写报销申请表
 *
 */
package com.june.generated.view;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.june.implemented.common.authentication.User;
import com.june.implemented.model.action.*;
import com.june.implemented.model.output.Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageOutput;
import com.june.implemented.model.input.Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_UserInput;
import com.june.implemented.model.values.Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageValue;
import com.june.common.view.AbstractManagedBean;
import org.primefaces.model.UploadedFile;

 
@ManagedBean(name="shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S")
//@RequestScoped
@ViewScoped
public class Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S extends AbstractManagedBean {


  
	Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageOutput pageOutput = new Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageOutput();
	
    public Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageOutput getPageOutput() {
		return pageOutput;
	}
	
	public void setPageOutput(Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageOutput pageOutput) {
		this.pageOutput = pageOutput;
	}
	
	
	Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_UserInput userInput = new Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_UserInput();
	
    public Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_UserInput getUserInput() {
		return userInput;
	}
	
	public void setUserInput(Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_UserInput userInput) {
		this.userInput = userInput;
	}
	
	
	Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageValue pageValue = new Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageValue();
	
    public Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageValue getPageValue() {
		return pageValue;
	}
	
	public void setPageValue(Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageValue pageValue) {
		this.pageValue = pageValue;
	}

    private Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_Submit submitAction = new Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_Submit();
    
    public Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_Submit getSubmitAction() {
		return submitAction;
	}

	public void setSubmitAction(Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_Submit submitAction) {
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
