
/**
 * 	FileName   : Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageValue
 * 	Package    : com.june.generated.model.values
 *	Create Time: 2016-5-25 8:42:42
 *	Usage	   : 涉及属性的定义、Get、Set、初始值定义 
 *	Purpose	   : null 
 *	Note	   :
 *  taskName   : 填写报销申请表
 *
 */
package com.june.generated.model.values;

import java.text.SimpleDateFormat;
import java.util.*;
import org.omg.CORBA.PRIVATE_MEMBER;
import com.june.common.model.output.AbstractPageOutput;
import com.june.common.model.values.AbstractPageValues;
import com.june.implemented.model.data.*;
import com.june.implemented.model.input.Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_UserInput;
import com.june.implemented.model.output.Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageOutput;
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

public class Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageValue extends AbstractPageValues{

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
	
	private Baoxiaoxixiang55012 selectionbaoxiaoxixiang55012;
	
	public Baoxiaoxixiang55012 getSelectionbaoxiaoxixiang55012() {
		return selectionbaoxiaoxixiang55012;
	}
	
	public void setSelectionbaoxiaoxixiang55012(Baoxiaoxixiang55012 selectionbaoxiaoxixiang55012) {
		this.selectionbaoxiaoxixiang55012 = selectionbaoxiaoxixiang55012;
	}
	
	public void addbaoxiaoxixiang55012(){
		this.setBaoxiaoxixiang55012baoxiaojine599230(null);
		this.setBaoxiaoxixiang55012riqi125480(null);
		this.setBaoxiaoxixiang55012feiyongmingcheng390060(null);
	}
	
	
	public void modifybaoxiaoxixiang55012(){
		if(this.getSelectionbaoxiaoxixiang55012() == null)
			return;
		this.setBaoxiaoxixiang55012baoxiaojine599231(this.getSelectionbaoxiaoxixiang55012().getBaoxiaojine59923());
		this.setBaoxiaoxixiang55012riqi125481(this.getSelectionbaoxiaoxixiang55012().getRiqi12548());
		this.setBaoxiaoxixiang55012feiyongmingcheng390061(this.getSelectionbaoxiaoxixiang55012().getFeiyongmingcheng39006());
	}
	
		public void deletebaoxiaoxixiang55012(){
			this.getBaoxiaoxixiang55012().remove(this.getSelectionbaoxiaoxixiang55012());
		}
	
	
	public void confirmmodifybaoxiaoxixiang55012(){
		boolean handle = true;// 记录操作是否成功
		if(false){
			RequestContext.getCurrentInstance().addCallbackParam("handle", true);
			RequestContext.getCurrentInstance().addCallbackParam("state", "不能为空。");
		}else{
			RequestContext.getCurrentInstance().addCallbackParam("handle", false);
			RequestContext.getCurrentInstance().addCallbackParam("state", "不能为空。");
			handle = false;
		}
		if(this.getSelectionbaoxiaoxixiang55012() == null || handle)
			return;
		
		this.getSelectionbaoxiaoxixiang55012().setBaoxiaojine59923(this.getBaoxiaoxixiang55012baoxiaojine599231());
		this.getSelectionbaoxiaoxixiang55012().setRiqi12548(this.getBaoxiaoxixiang55012riqi125481());
		this.getSelectionbaoxiaoxixiang55012().setFeiyongmingcheng39006(this.getBaoxiaoxixiang55012feiyongmingcheng390061());
	}
	
	
	public void confirmaddbaoxiaoxixiang55012(){
		boolean handle = true;// 记录操作是否成功
		Baoxiaoxixiang55012 instance = new Baoxiaoxixiang55012();
		if(false){
			RequestContext.getCurrentInstance().addCallbackParam("handle", true);
			RequestContext.getCurrentInstance().addCallbackParam("state", "不能为空。");
		}else{
			RequestContext.getCurrentInstance().addCallbackParam("handle", false);
			RequestContext.getCurrentInstance().addCallbackParam("state", "不能为空。");
			handle = false;
		}
		if(handle)
			return;
		
		instance.setBaoxiaojine59923(this.getBaoxiaoxixiang55012baoxiaojine599230());
		instance.setRiqi12548(this.getBaoxiaoxixiang55012riqi125480());
		instance.setFeiyongmingcheng39006(this.getBaoxiaoxixiang55012feiyongmingcheng390060());
		this.getBaoxiaoxixiang55012().add(instance);
		synchronized (WorkObjectImpl.em) {
			try {
				WorkObjectImpl.em.getTransaction().begin();
				WorkObjectImpl.em.persist(instance);
				WorkObjectImpl.em.getTransaction().commit();
			} catch (Exception e) {
				WorkObjectImpl.em.getTransaction().rollback();
				e.printStackTrace();
			}
		}
	}
	
	
	
	private String baoxiaoxixiang55012baoxiaojine599230;
	
	public String getBaoxiaoxixiang55012baoxiaojine599230() {
		return baoxiaoxixiang55012baoxiaojine599230;
	}
	
	public void setBaoxiaoxixiang55012baoxiaojine599230(String baoxiaoxixiang55012baoxiaojine599230) {
		this.baoxiaoxixiang55012baoxiaojine599230 = baoxiaoxixiang55012baoxiaojine599230;
	}
	
	private String baoxiaoxixiang55012baoxiaojine599231;
	
	public String getBaoxiaoxixiang55012baoxiaojine599231() {
		return baoxiaoxixiang55012baoxiaojine599231;
	}
	
	public void setBaoxiaoxixiang55012baoxiaojine599231(String baoxiaoxixiang55012baoxiaojine599231) {
		this.baoxiaoxixiang55012baoxiaojine599231 = baoxiaoxixiang55012baoxiaojine599231;
	}
	private String baoxiaoxixiang55012riqi125480;
	
	public String getBaoxiaoxixiang55012riqi125480() {
		return baoxiaoxixiang55012riqi125480;
	}
	
	public void setBaoxiaoxixiang55012riqi125480(String baoxiaoxixiang55012riqi125480) {
		this.baoxiaoxixiang55012riqi125480 = baoxiaoxixiang55012riqi125480;
	}
	
	private String baoxiaoxixiang55012riqi125481;
	
	public String getBaoxiaoxixiang55012riqi125481() {
		return baoxiaoxixiang55012riqi125481;
	}
	
	public void setBaoxiaoxixiang55012riqi125481(String baoxiaoxixiang55012riqi125481) {
		this.baoxiaoxixiang55012riqi125481 = baoxiaoxixiang55012riqi125481;
	}
	private String baoxiaoxixiang55012feiyongmingcheng390060;
	
	public String getBaoxiaoxixiang55012feiyongmingcheng390060() {
		return baoxiaoxixiang55012feiyongmingcheng390060;
	}
	
	public void setBaoxiaoxixiang55012feiyongmingcheng390060(String baoxiaoxixiang55012feiyongmingcheng390060) {
		this.baoxiaoxixiang55012feiyongmingcheng390060 = baoxiaoxixiang55012feiyongmingcheng390060;
	}
	
	private String baoxiaoxixiang55012feiyongmingcheng390061;
	
	public String getBaoxiaoxixiang55012feiyongmingcheng390061() {
		return baoxiaoxixiang55012feiyongmingcheng390061;
	}
	
	public void setBaoxiaoxixiang55012feiyongmingcheng390061(String baoxiaoxixiang55012feiyongmingcheng390061) {
		this.baoxiaoxixiang55012feiyongmingcheng390061 = baoxiaoxixiang55012feiyongmingcheng390061;
	}
	public Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageValue() {
		super();
        this.LoadInitData();
	}
	
	private void LoadInitData(){
	BDCSWorkData workData = (BDCSWorkData) process.getActiveWorkObject().getWorkDataInstance();	
	
	
	
	

	}

	public void getDataFromOutput(Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_PageOutput pageOutput) {
		setShenqingren26084(pageOutput.getShenqingren26084());
		setBumen35536(pageOutput.getBumen35536());
		setXiangmumingcheng42340(pageOutput.getXiangmumingcheng42340());
		setBaoxiaojine59923(pageOutput.getBaoxiaojine59923());
		setBaoxiaoxixiang55012(pageOutput.getBaoxiaoxixiang55012());
		
	}
	
	public void setDataToInput(Shape_BDCS_ID6161210e85z13E5LG899fj2n43W53j5S_UserInput userInput) {
		userInput.setShenqingren26084(getShenqingren26084());
		userInput.setBumen35536(getBumen35536());
		userInput.setXiangmumingcheng42340(getXiangmumingcheng42340());
		if(getBaoxiaojine59923() != null && !getBaoxiaojine59923().contains(".") && !getBaoxiaojine59923().isEmpty()){
			userInput.setBaoxiaojine59923(getBaoxiaojine59923()+".00");
		}else{
			userInput.setBaoxiaojine59923(getBaoxiaojine59923());
		}		
		userInput.setBaoxiaoxixiang55012(getBaoxiaoxixiang55012());
		
	}
	
	

}