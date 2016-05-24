
/**
 * 	FileName   : Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_PageOutput
 * 	Package    : com.june.generated.model.output
 *	Create Time: 2016-5-24 9:41:09
 *	Usage	   : 涉及属性的定义、Get、Set、初始值定义 
 *	Purpose	   : null 
 *	Note	   :
 *  taskName   : 审核报销申请表
 *
 */
package com.june.generated.model.output;

import com.june.common.model.output.AbstractPageOutput;
import com.june.implemented.common.application.BDCSWorkData;
import com.june.implemented.common.function.*;
import java.util.*;

public class Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_PageOutput extends AbstractPageOutput {

	private String shenqingren26084;
	
	public String getShenqingren26084() {
		return shenqingren26084;
	}
	
	public void setShenqingren26084(String shenqingren26084) {
		this.shenqingren26084 = shenqingren26084;
	}
	private String bumen35536;
	
	public String getBumen35536() {
		return bumen35536;
	}
	
	public void setBumen35536(String bumen35536) {
		this.bumen35536 = bumen35536;
	}
	private String xiangmumingcheng42340;
	
	public String getXiangmumingcheng42340() {
		return xiangmumingcheng42340;
	}
	
	public void setXiangmumingcheng42340(String xiangmumingcheng42340) {
		this.xiangmumingcheng42340 = xiangmumingcheng42340;
	}
	private String baoxiaojine59923;
	
	public String getBaoxiaojine59923() {
		return baoxiaojine59923;
	}
	
	public void setBaoxiaojine59923(String baoxiaojine59923) {
		this.baoxiaojine59923 = baoxiaojine59923;
	}
	private List<Baoxiaoxixiang55012> baoxiaoxixiang55012;
	
	public List<Baoxiaoxixiang55012> getBaoxiaoxixiang55012() {
		if(baoxiaoxixiang55012 == null)
			baoxiaoxixiang55012 = new ArrayList<Baoxiaoxixiang55012>();
		return baoxiaoxixiang55012;
	}
	
	public void setBaoxiaoxixiang55012(List<Baoxiaoxixiang55012> baoxiaoxixiang55012) {
		this.baoxiaoxixiang55012 = baoxiaoxixiang55012;
	}
	private List<javax.faces.model.SelectItem> shifoutongguoshenhe51727List;
	
	public List<javax.faces.model.SelectItem> getShifoutongguoshenhe51727List() {
		return shifoutongguoshenhe51727List;
	}
	
	public void setShifoutongguoshenhe51727List(List<javax.faces.model.SelectItem> shifoutongguoshenhe51727List) {
		this.shifoutongguoshenhe51727List = shifoutongguoshenhe51727List;
	}
	private String shifoutongguoshenhe51727;
	
	public String getShifoutongguoshenhe51727() {
		return shifoutongguoshenhe51727;
	}
	
	public void setShifoutongguoshenhe51727(String shifoutongguoshenhe51727) {
		this.shifoutongguoshenhe51727 = shifoutongguoshenhe51727;
	}
	private String sqbbtgyy78335;
	
	public String getSqbbtgyy78335() {
		return sqbbtgyy78335;
	}
	
	public void setSqbbtgyy78335(String sqbbtgyy78335) {
		this.sqbbtgyy78335 = sqbbtgyy78335;
	}
	public Shape_BDCS_ID1S3NTN684221eRL9O5Q7cfY1k6s10019_PageOutput() {
		super();
        this.LoadInitData();
	}
	
	private void LoadInitData(){	
	
	
	
	

	//this.shifoutongguoshenhe51727List = new ArrayList<javax.faces.model.SelectItem>();
	//javax.faces.model.SelectItem items0 = new javax.faces.model.SelectItem("否", "否");
	//this.shifoutongguoshenhe51727List.add(items0);
	//javax.faces.model.SelectItem items1 = new javax.faces.model.SelectItem("是", "是");
	//this.shifoutongguoshenhe51727List.add(items1);	
	

	}

	public void getDataFromProcess() {
		BDCSWorkData workData = (BDCSWorkData) process.getActiveWorkObject().getWorkDataInstance();
		setShenqingren26084(workData.getShenqingren26084());
		setBumen35536(workData.getBumen35536());
		setXiangmumingcheng42340(workData.getXiangmumingcheng42340());
		setBaoxiaojine59923(workData.getBaoxiaojine59923());
		setBaoxiaoxixiang55012(workData.getBaoxiaoxixiang55012());
		setShifoutongguoshenhe51727(workData.getShifoutongguoshenhe51727());
		setSqbbtgyy78335(workData.getSqbbtgyy78335());
		
	}

}