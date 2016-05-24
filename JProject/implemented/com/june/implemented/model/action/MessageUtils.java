package com.june.implemented.model.action;

/**
 * 此方法为Trigger所调用方法
 */
import java.io.IOException;
import java.util.List;

import com.june.implemented.common.function.*;
import com.june.implemented.common.application.*;
import com.june.common.api.AbstractWorkData;
import com.june.common.api.AbstractWorkFlow;
import com.june.common.exception.SystemException;
import com.june.implemented.common.util.ClassUtil;
import com.june.implemented.control.flowaction.*;
import com.june.implemented.common.application.Process;
import com.june.implemented.common.authentication.User;

public class MessageUtils{
       
    public MessageUtils() {
    }

	public static void doSignal(String classname, String currentState,String mainFlowID,
			BDCSWorkData workdata,User user) {
		if(mainFlowID == null)
			return;
			
		String sql = "select flow from AbstractWorkFlow flow where flow.mainFlowID = '"+mainFlowID+"'  and flow.currentState = '"+currentState+"'";
		List<AbstractWorkFlow> values = null;
		synchronized (WorkObjectImpl.em) {
			values = WorkObjectImpl.em.createQuery(sql).getResultList();
		}

		
		for(AbstractWorkFlow wf:values){
			Process process = new Process("");
			WorkObjectImpl wo = new WorkObjectImpl();
			process.setUser(user);
			process.setActiveWorkObject(wo);
			((AbstractWorkFlow) wf).setOwner(wo);
			wo.setActiveFlowInstance(((AbstractWorkFlow) wf));
			wo.setWorkDataInstance(wf.getWorkData());
			wo.setObjectId(((AbstractWorkFlow) wf).getObjectId());
			wo.setCurrentState(((AbstractWorkFlow) wf).getCurrentState());
			wo.setCurrentStateDisplay(((AbstractWorkFlow) wf)
					.getCurrentStateDisplay());
			wo.setAssignee(((AbstractWorkFlow) wf).getAssignee());
			wo.setFlowState(((AbstractWorkFlow) wf).getFlowState());
			wo.setFlowName(((AbstractWorkFlow) wf).getFlowName());
			wo.setFlowNameCN(((AbstractWorkFlow) wf).getFlowNameCN());
			
						//给workdata赋值
			BDCSWorkData wd1 = (BDCSWorkData)wf.getWorkData();
			
			wd1.setFou1574(workdata.getFou1574());
			
			wd1.getBaoxiaoxixiang55012().clear();
			for(Baoxiaoxixiang55012 baoxiaoxixiang55012:workdata.getBaoxiaoxixiang55012()){
				Baoxiaoxixiang55012 baoxiaoxixiang55012New = new Baoxiaoxixiang55012();
			
				baoxiaoxixiang55012New.setBaoxiaojine59923(baoxiaoxixiang55012.getBaoxiaojine59923());						
			
				baoxiaoxixiang55012New.setRiqi12548(baoxiaoxixiang55012.getRiqi12548());						
			
				baoxiaoxixiang55012New.setFeiyongmingcheng39006(baoxiaoxixiang55012.getFeiyongmingcheng39006());						
			
				
				wd1.getBaoxiaoxixiang55012().add(baoxiaoxixiang55012New);
			}
			
			wd1.setBaoxiaojine59923(workdata.getBaoxiaojine59923());
			
			wd1.setShi6191(workdata.getShi6191());
			
			wd1.setShifoutongguoshenhe51727(workdata.getShifoutongguoshenhe51727());
			
			wd1.setShenqingren26084(workdata.getShenqingren26084());
			
			wd1.setSqbbtgyy78335(workdata.getSqbbtgyy78335());
			
			wd1.setBumen35536(workdata.getBumen35536());
			
			wd1.setXiangmumingcheng42340(workdata.getXiangmumingcheng42340());
			

			
		
		}
	}
	
	
	public static void createNewWorkFromTrigger(String classname,String id,BDCSWorkData workClass,String startUser,String startUserGroup,String userUserHigher,User user,int openFlowIndex,String startFlowName) throws SystemException {

		try {
			String flowname = classname.split("_")[1];
			AbstractWorkData wd = (AbstractWorkData) ClassUtil
					.newInstance("com.june.implemented.common.application." + flowname
							+ "WorkData");
			AbstractWorkFlow wf = (AbstractWorkFlow) ClassUtil
					.newInstance("com.june.implemented.common.application." + flowname);
			Process process = new Process("");
			WorkObjectImpl wo = new WorkObjectImpl();
			process.setUser(user);
			process.setActiveWorkObject(wo);

			wf.setFlowName(flowname);
			wf.setOwner(wo);
			wf.setMainFlowID(id);
			wf.setStartUser(startUser);
			wf.setStartUserGroup(startUserGroup);
			wf.setStartUserHigher(userUserHigher);
			wf.setOpenFlowIndex(openFlowIndex);
			wf.setFlowNameCN(startFlowName);
			
			//给workdata赋值
			BDCSWorkData wd1 = (BDCSWorkData)wd;
			
			wd1.setFou1574(workClass.getFou1574());
			
			for(Baoxiaoxixiang55012 baoxiaoxixiang55012:workClass.getBaoxiaoxixiang55012()){
				Baoxiaoxixiang55012 baoxiaoxixiang55012New = new Baoxiaoxixiang55012();
			
				baoxiaoxixiang55012New.setBaoxiaojine59923(baoxiaoxixiang55012.getBaoxiaojine59923());						
			
				baoxiaoxixiang55012New.setRiqi12548(baoxiaoxixiang55012.getRiqi12548());						
			
				baoxiaoxixiang55012New.setFeiyongmingcheng39006(baoxiaoxixiang55012.getFeiyongmingcheng39006());						
			
				wd1.getBaoxiaoxixiang55012().add(baoxiaoxixiang55012New);
			}
			
			wd1.setBaoxiaojine59923(workClass.getBaoxiaojine59923());
			
			wd1.setShi6191(workClass.getShi6191());
			
			wd1.setShifoutongguoshenhe51727(workClass.getShifoutongguoshenhe51727());
			
			wd1.setShenqingren26084(workClass.getShenqingren26084());
			
			wd1.setSqbbtgyy78335(workClass.getSqbbtgyy78335());
			
			wd1.setBumen35536(workClass.getBumen35536());
			
			wd1.setXiangmumingcheng42340(workClass.getXiangmumingcheng42340());
			
			
			
			wo.setActiveFlowInstance(wf);
			wo.setWorkDataInstance(wd1);
			wo.getActiveFlowInstance().setWorkData(wd1);
			
			wo.getWorkDataInstance().setFlowState(wo.getActiveFlowInstance()
					.getFlowState()); // 设置WD的流程状态

			wo.getWorkDataInstance().setFlowName(wo.getActiveFlowInstance()
					.getFlowName()); // 设置WD的流程名
			wo.setObjectId(wo.getActiveFlowInstance().getObjectId());
			wo.setCurrentState(wo.getActiveFlowInstance().getCurrentState());
			wo.setCurrentStateDisplay(wo.getActiveFlowInstance().getCurrentStateDisplay());
			wo.setAssignee(wo.getActiveFlowInstance().getAssignee());
			
			synchronized (WorkObjectImpl.em) {
				try {
					WorkObjectImpl.em.getTransaction().begin();
					WorkObjectImpl.em.persist(wf);
					WorkObjectImpl.em.getTransaction().commit();
				} catch (Exception e) {
					e.printStackTrace();
					WorkObjectImpl.em.getTransaction().rollback();
				}
			}
			
			
			if(classname.equals("shape_BDCS_ID410jd29K8067I3v7otK107Bc7O78809N9")){
				new Shape_BDCS_ID410jd29K8067I3v7otK107Bc7O78809N9_Submit_Action(wo,user,process).perform();
			}
			
			

			synchronized (WorkObjectImpl.em) {
				try {
					WorkObjectImpl.em.getTransaction().begin();
					WorkObjectImpl.em.merge(wf);
					WorkObjectImpl.em.flush();
					WorkObjectImpl.em.getTransaction().commit();
				} catch (Exception e) {
					e.printStackTrace();
					WorkObjectImpl.em.getTransaction().rollback();
				}
			}


		} catch (Exception e) {
			throw new SystemException(e);
		}

	
	}
	

}

