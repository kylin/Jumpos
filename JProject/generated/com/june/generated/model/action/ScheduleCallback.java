/**
 * 	FileName   : ScheduleCallback
 * 	Package    : com.june.generated.model.action
 *	Create Time: 2016-5-25 7:25:21
 *	Note	   :
 *
 */ 
package com.june.generated.model.action;

import java.util.List;

import com.june.common.api.AbstractWorkData;
import com.june.common.api.AbstractWorkFlow;
import com.june.implemented.common.application.Process;
import com.june.implemented.common.application.WorkObjectImpl;
import com.june.implemented.common.authentication.User;
import com.june.implemented.common.function.UserEntity;
import com.june.implemented.common.util.ClassUtil;
import com.june.implemented.control.flowaction.*;
import com.june.implemented.model.action.*;

/*
 * 供任务调度方调用的WebService端
 */
public class ScheduleCallback {

	/**
	 * 
	 * @param jobId 调度方任务id
	 * @param data  封装好的信息  Format:id_command_user
	 */
	public String callback(String jobId,String data) {
//		data:Timeout_test_qiye
//		type_data_user
		
		try {
			
			System.err.println("jobId:" + jobId +";data:" + data);
			String timerType  = data.split(";_;")[0];
			String userName  = data.split(";_;")[1];
			long id = Long.parseLong(data.split(";_;")[2]);
			String timerMessage  = data.split(";_;")[3];
			
			boolean isValid = false;
			List<UserEntity> values = null;
			String strSql = "select userEntity from UserEntity userEntity where userEntity.userName='"+userName+"'";
			synchronized (WorkObjectImpl.em) {
				values = WorkObjectImpl.em.createQuery(strSql).getResultList();
			}
			User user = new User();
			
			if(!values.isEmpty()){
				UserEntity ue = values.get(0);
				user.setUsername(ue.getUserName());
				user.setUsergroup(ue.getUserGroup());
				user.setUserHigher(ue.getUserHigher());
			}
			
			AbstractWorkFlow wf = null;

			synchronized (WorkObjectImpl.em) {
				wf = WorkObjectImpl.em.find(AbstractWorkFlow.class, id);
			}
			String currentState = wf.getCurrentState();
			Process process = new Process();
			WorkObjectImpl wo = new WorkObjectImpl();
			process.setActiveWorkObject(wo);
			process.setUser(user);
			
			if("unbounded".equals(timerType)){
				
				String flowname = currentState.split("_")[1];
				AbstractWorkData wd = (AbstractWorkData) ClassUtil
						.newInstance("com.june.implemented.common.application." + flowname
								+ "WorkData");
				AbstractWorkFlow wf1 = (AbstractWorkFlow) ClassUtil
						.newInstance("com.june.implemented.common.application." + flowname);

				wf1.setFlowName(flowname);
				wf1.setOwner(wo);
				wf1.setStartUser(user.getUsername());
				wf1.setStartUserGroup(user.getUsergroup());
				wf1.setStartUserHigher(user.getUserHigher());
				
				
				wo.setActiveFlowInstance(wf1);
				wo.setWorkDataInstance(wd);
				wo.getActiveFlowInstance().setWorkData(wd);
				
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
						WorkObjectImpl.em.persist(wf1);
						WorkObjectImpl.em.getTransaction().commit();
					} catch (Exception e) {
						WorkObjectImpl.em.getTransaction().rollback();
						e.printStackTrace();
					}
				}

			
			}else{
				wo.setActiveFlowInstance(wf);
				wo.setWorkDataInstance(wf.getWorkData());
			
				System.err.println(currentState);
				if(!isValid){
					return "true";
				}
				process.getActiveWorkObject().getNextStep();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return "true";
	}
}