
/**
 * 	FileName   : Shape_BDCS_ID6u6B8jF817B8MW3Kb1Y9324U8sE458Y_PageValue
 * 	Package    : com.june.generated.model.values
 *	Create Time: 2016-5-25 8:42:43
 *	Usage	   : 涉及属性的定义、Get、Set、初始值定义 
 *	Purpose	   : null 
 *	Note	   :
 *  taskName   : 支付金额
 *
 */
package com.june.generated.model.values;

import java.text.SimpleDateFormat;
import java.util.*;
import org.omg.CORBA.PRIVATE_MEMBER;
import com.june.common.model.output.AbstractPageOutput;
import com.june.common.model.values.AbstractPageValues;
import com.june.implemented.model.data.*;
import com.june.implemented.model.input.Shape_BDCS_ID6u6B8jF817B8MW3Kb1Y9324U8sE458Y_UserInput;
import com.june.implemented.model.output.Shape_BDCS_ID6u6B8jF817B8MW3Kb1Y9324U8sE458Y_PageOutput;
import com.june.implemented.model.*;
import javax.servlet.ServletContext;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;
import com.june.implemented.common.function.*;
import com.june.implemented.common.application.*;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

public class Shape_BDCS_ID6u6B8jF817B8MW3Kb1Y9324U8sE458Y_PageValue extends AbstractPageValues{

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
	public Shape_BDCS_ID6u6B8jF817B8MW3Kb1Y9324U8sE458Y_PageValue() {
		super();
        this.LoadInitData();
	}
	
	private void LoadInitData(){
	BDCSWorkData workData = (BDCSWorkData) process.getActiveWorkObject().getWorkDataInstance();	
	
	
	

	}

	public void getDataFromOutput(Shape_BDCS_ID6u6B8jF817B8MW3Kb1Y9324U8sE458Y_PageOutput pageOutput) {
		setShenqingren26084(pageOutput.getShenqingren26084());
		setBumen35536(pageOutput.getBumen35536());
		setXiangmumingcheng42340(pageOutput.getXiangmumingcheng42340());
		setBaoxiaojine59923(pageOutput.getBaoxiaojine59923());
		
	}
	
	public void setDataToInput(Shape_BDCS_ID6u6B8jF817B8MW3Kb1Y9324U8sE458Y_UserInput userInput) {
		
	}
	
	

}