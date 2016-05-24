/**
 * 	FileName   : Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_UserInput
 * 	Package    : com.june.generated.model.input
 *	Create Time: 2016-5-25 7:25:24
 *	Usage	   : 涉及属性的定义和Get 、Set、初始值的定义
 *	Purpose	   : null 
 *	Note	   :
 * 	taskName   : 填写报销申请表
 *
 */
package com.june.generated.model.input;

import com.june.implemented.common.application.BDCSWorkData;
import com.june.common.model.input.AbstractInput;
import com.june.implemented.common.function.*;
import java.util.*;

public class Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_UserInput extends AbstractInput {

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

	public Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_UserInput() {
		super();
        this.LoadInitData();
	}
	
	private void LoadInitData(){					
  	}
  	
	public void setDataToProcess() {
		((BDCSWorkData) process.getActiveWorkObject().getWorkDataInstance()).setShenqingren26084(shenqingren26084);
		((BDCSWorkData) process.getActiveWorkObject().getWorkDataInstance()).setBumen35536(bumen35536);
		((BDCSWorkData) process.getActiveWorkObject().getWorkDataInstance()).setXiangmumingcheng42340(xiangmumingcheng42340);
		((BDCSWorkData) process.getActiveWorkObject().getWorkDataInstance()).setBaoxiaojine59923(baoxiaojine59923);
		((BDCSWorkData) process.getActiveWorkObject().getWorkDataInstance()).setBaoxiaoxixiang55012(baoxiaoxixiang55012);		
	}
}