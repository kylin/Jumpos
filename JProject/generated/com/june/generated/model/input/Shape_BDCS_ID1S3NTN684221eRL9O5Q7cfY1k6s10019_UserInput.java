/**
 * 	FileName   : Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_UserInput
 * 	Package    : com.june.generated.model.input
 *	Create Time: 2016-5-24 9:41:06
 *	Usage	   : 涉及属性的定义和Get 、Set、初始值的定义
 *	Purpose	   : null 
 *	Note	   :
 * 	taskName   : 审核报销申请表
 *
 */
package com.june.generated.model.input;

import com.june.implemented.common.application.BDCSWorkData;
import com.june.common.model.input.AbstractInput;
import com.june.implemented.common.function.*;
import java.util.*;

public class Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_UserInput extends AbstractInput {

	private String shifoutongguoshenhe51727;
	
	public String getShifoutongguoshenhe51727() {
		return shifoutongguoshenhe51727;
	}

	public void setShifoutongguoshenhe51727(String shifoutongguoshenhe51727) {
		this.shifoutongguoshenhe51727 = shifoutongguoshenhe51727;
	}
	
	private List<javax.faces.model.SelectItem> shifoutongguoshenhe51727List;
	
	public List<javax.faces.model.SelectItem> getShifoutongguoshenhe51727List() {
		return shifoutongguoshenhe51727List;
	}

	public void setShifoutongguoshenhe51727List(List<javax.faces.model.SelectItem> shifoutongguoshenhe51727List) {
		this.shifoutongguoshenhe51727List = shifoutongguoshenhe51727List;
	}
	private String sqbbtgyy78335;
		
	public String getSqbbtgyy78335() {
			return sqbbtgyy78335;
		}
	
	public void setSqbbtgyy78335(String sqbbtgyy78335) {
			this.sqbbtgyy78335 = sqbbtgyy78335;
		}

	public Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_UserInput() {
		super();
        this.LoadInitData();
	}
	
	private void LoadInitData(){
		this.shifoutongguoshenhe51727List = new ArrayList<javax.faces.model.SelectItem>();
		javax.faces.model.SelectItem shifoutongguoshenhe51727items0 = new javax.faces.model.SelectItem("否", "否");
		this.shifoutongguoshenhe51727List.add(shifoutongguoshenhe51727items0);
		javax.faces.model.SelectItem shifoutongguoshenhe51727items1 = new javax.faces.model.SelectItem("是", "是");
		this.shifoutongguoshenhe51727List.add(shifoutongguoshenhe51727items1);		
  	}
  	
	public void setDataToProcess() {
		((BDCSWorkData) process.getActiveWorkObject().getWorkDataInstance()).setShifoutongguoshenhe51727(shifoutongguoshenhe51727);
		((BDCSWorkData) process.getActiveWorkObject().getWorkDataInstance()).setSqbbtgyy78335(sqbbtgyy78335);		
	}
}