
/**
 * 	FileName   : Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019
 * 	Package    : com.june.generated.view
 *	Create Time: 2016-5-25 7:25:29
 *	Usage	   : 包含实现系统的页面
 *	Purpose	   : null 
 *	Note	   :
 *  TaskName   : 审核报销申请表
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
import com.june.implemented.model.output.Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_PageOutput;
import com.june.implemented.model.input.Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_UserInput;
import com.june.implemented.model.values.Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_PageValue;
import com.june.common.view.AbstractManagedBean;
import org.primefaces.model.UploadedFile;

 
@ManagedBean(name="shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019")
//@RequestScoped
@ViewScoped
public class Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019 extends AbstractManagedBean {


  
	Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_PageOutput pageOutput = new Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_PageOutput();
	
    public Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_PageOutput getPageOutput() {
		return pageOutput;
	}
	
	public void setPageOutput(Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_PageOutput pageOutput) {
		this.pageOutput = pageOutput;
	}
	
	
	Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_UserInput userInput = new Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_UserInput();
	
    public Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_UserInput getUserInput() {
		return userInput;
	}
	
	public void setUserInput(Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_UserInput userInput) {
		this.userInput = userInput;
	}
	
	
	Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_PageValue pageValue = new Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_PageValue();
	
    public Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_PageValue getPageValue() {
		return pageValue;
	}
	
	public void setPageValue(Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_PageValue pageValue) {
		this.pageValue = pageValue;
	}

    private Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_Submit submitAction = new Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_Submit();
    
    public Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_Submit getSubmitAction() {
		return submitAction;
	}

	public void setSubmitAction(Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_Submit submitAction) {
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
