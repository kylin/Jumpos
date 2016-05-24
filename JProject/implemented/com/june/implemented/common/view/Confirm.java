package com.june.implemented.common.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.june.common.view.AbstractManagedBean;
import com.june.implemented.model.output.Confirm_PageOutput;



@ManagedBean(name="confirm")
@RequestScoped
public class Confirm extends AbstractManagedBean {
    private Confirm_PageOutput pageOutput = new Confirm_PageOutput();
    
    public Confirm() {
    }
    
	public Confirm_PageOutput getPageOutput() {
		return pageOutput;
	}

	public void setPageOutput(Confirm_PageOutput pageOutput) {
		this.pageOutput = pageOutput;
	}

	@PostConstruct
	public void getPageOutputData(){
		try {
			pageOutput.getDataFromProcess();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
