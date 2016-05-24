package com.june.implemented.common.application;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.june.common.api.AbstractWorkData;
import com.june.common.api.AbstractWorkFlow;
import com.june.common.api.WorkObject;
import com.june.common.exception.SystemException;
import com.june.common.exception.ValidationException;
import com.june.common.exception.WorkNotFoundException;
import com.june.implemented.common.function.*;
import com.june.implemented.common.util.ClassUtil;
import com.june.implemented.control.flowaction.NewFlow_Any_Submit_Action;

@ManagedBean(name = "activeWorkObject")
@SessionScoped
public class WorkObjectImpl extends WorkObject {

	public static Map<String,Long> map4weixin = new HashMap<String, Long>(); //key:AgentID,value:flowid
	
	public long selectWorkData4weixin(String assignee,String agentID,String taskid) throws Exception{
		List<AbstractWorkFlow> values = null;
		String sql = "";
		long flowid = 0;
		if(map4weixin.get(agentID) != null){
			flowid = map4weixin.get(agentID);
		}
		sql = "select flow from AbstractWorkFlow flow";
		if(assignee != null && !assignee.isEmpty()){
			sql = "select flow from AbstractWorkFlow flow where flow.assignee = '"+assignee+"' and (flow.objectID = "+flowid+" or flow.mainFlowID = '"+flowid+"')";
		}else{
			sql = "select flow from AbstractWorkFlow flow where flow.objectID = "+flowid+" or flow.mainFlowID = '"+flowid+"'";
		}
		synchronized (em) {
			values = em.createQuery(sql).getResultList();
		}
		long retid = 0;
		for(AbstractWorkFlow wf:values){
			if(wf.getCurrentState() != null && wf.getCurrentState().equalsIgnoreCase(taskid)){
				if(wf.getObjectId() > retid){
					retid = wf.getObjectId();
				}
			}
		}
		if(retid != 0){
			loadWorkData("", "", retid);
		}
		return retid;
	}
	
	public void createNewWork4weixin(String workClass, String workFlow,
			String operatorID, String usergroup, String userUserHigher, String loc,
			String projectName, String flowType, String startIndex)
			throws SystemException {
		try {
			System.out.println("workClass:" + workClass);
			System.out.println("workFlow:" + workFlow);
			System.out.println("operatorID:" + operatorID);
			AbstractWorkData wd = (AbstractWorkData) ClassUtil
					.newInstance("com.june.implemented.common.application." + workClass
							+ "WorkData");
			AbstractWorkFlow wf = (AbstractWorkFlow) ClassUtil
					.newInstance("com.june.implemented.common.application." + workFlow);
			// wd.LoadDefaultValue();
			wf.LoadDefaultValue(operatorID);
			wf.setUserGroup(usergroup); // 设置用户所在组
			wf.setStartUser(operatorID);
			wf.setStartUserGroup(usergroup);
			wf.setStartUserHigher(userUserHigher);
			wf.setFlowNameCN(startIndex);
			wd.setFlowType(flowType);

			wd.setUserGroup(usergroup);
			wd.setPlatformLoc(loc); // 设置wd位置

			wf.setOwner(this);
			this.setActiveFlowInstance(wf);
			this.setWorkDataInstance(wd);
			this.setAssignee(operatorID);
			//？？？
			this.getActiveFlowInstance().setWorkData(wd);
			
			synchronized (em) {
				try {
					em.getTransaction().begin();
					em.persist(wf);
					em.getTransaction().commit();
				} catch (Exception e) {
					em.getTransaction().rollback();
					e.printStackTrace();
				}
			}
			wf.setMainFlowID(""+wf.getObjectId());
			this.getWorkDataInstance().setFlowState(this.getActiveFlowInstance()
					.getFlowState()); // 设置WD的流程状态

			this.getWorkDataInstance().setFlowName(this.getActiveFlowInstance()
					.getFlowName()); // 设置WD的流程名
			synchronized (em) {
				try {
					em.getTransaction().begin();
					em.merge(wf);
					em.flush();
					em.getTransaction().commit();
				} catch (Exception e) {
					em.getTransaction().rollback();
					e.printStackTrace();
				}
			}

			this.objectId = this.getActiveFlowInstance().getObjectId();
			this.setCurrentState(this.getActiveFlowInstance().getCurrentState());
			this.setCurrentStateDisplay(this.getActiveFlowInstance().getCurrentStateDisplay());
			this.setAssignee(this.getActiveFlowInstance().getAssignee());
			this.setUserGroup(this.getActiveFlowInstance().getUserGroup());
			this.setFlowState(this.getActiveFlowInstance().getFlowState());
			this.setFlowName(this.getActiveFlowInstance().getFlowName());
			this.setFlowNameCN(this.getActiveFlowInstance().getFlowNameCN());
			this.getWorkDataInstance().setAssignee(this.getAssignee());
			this.getWorkDataInstance().setCurrentState(this.getCurrentState());
			// this.CopyDataFromWorkInstance();

		} catch (Exception e) {
			throw new SystemException(e);
		}

	}
	
	public void createNewWork(String workClass, String workFlow,
			String operatorID, String usergroup, String userUserHigher, String loc,
			String projectName, String flowType, String startIndex)
			throws SystemException {
		try {
			System.out.println("workClass:" + workClass);
			System.out.println("workFlow:" + workFlow);
			System.out.println("operatorID:" + operatorID);
			AbstractWorkData wd = (AbstractWorkData) ClassUtil
					.newInstance("com.june.implemented.common.application." + workClass
							+ "WorkData");
			AbstractWorkFlow wf = (AbstractWorkFlow) ClassUtil
					.newInstance("com.june.implemented.common.application." + workFlow);
			// wd.LoadDefaultValue();
			wf.LoadDefaultValue(operatorID);
			wf.setUserGroup(usergroup); // 设置用户所在组
			wf.setStartUser(operatorID);
			wf.setStartUserGroup(usergroup);
			wf.setStartUserHigher(userUserHigher);
			wf.setFlowNameCN(startIndex);
			wd.setFlowType(flowType);

			wd.setUserGroup(usergroup);
			wd.setPlatformLoc(loc); // 设置wd位置

			wf.setOwner(this);
			this.setActiveFlowInstance(wf);
			this.setWorkDataInstance(wd);
			this.setAssignee(operatorID);
			//？？？
			this.getActiveFlowInstance().setWorkData(wd);
			
			synchronized (em) {
				try {
					em.getTransaction().begin();
					em.persist(wf);
					em.getTransaction().commit();
				} catch (Exception e) {
					em.getTransaction().rollback();
					e.printStackTrace();
				}
			}
			wf.setMainFlowID(""+wf.getObjectId());
			new NewFlow_Any_Submit_Action((WorkObjectImpl) this).perform(
					projectName, startIndex);
			this.getWorkDataInstance().setFlowState(this.getActiveFlowInstance()
					.getFlowState()); // 设置WD的流程状态

			this.getWorkDataInstance().setFlowName(this.getActiveFlowInstance()
					.getFlowName()); // 设置WD的流程名
			synchronized (em) {
				try {
					em.getTransaction().begin();
					em.merge(wf);
					em.flush();
					em.getTransaction().commit();
				} catch (Exception e) {
					em.getTransaction().rollback();
					e.printStackTrace();
				}
			}

			this.objectId = this.getActiveFlowInstance().getObjectId();
			this.setCurrentState(this.getActiveFlowInstance().getCurrentState());
			this.setCurrentStateDisplay(this.getActiveFlowInstance().getCurrentStateDisplay());
			this.setAssignee(this.getActiveFlowInstance().getAssignee());
			this.setUserGroup(this.getActiveFlowInstance().getUserGroup());
			this.setFlowState(this.getActiveFlowInstance().getFlowState());
			this.setFlowName(this.getActiveFlowInstance().getFlowName());
			this.setFlowNameCN(this.getActiveFlowInstance().getFlowNameCN());
			this.getWorkDataInstance().setAssignee(this.getAssignee());
			this.getWorkDataInstance().setCurrentState(this.getCurrentState());
			// this.CopyDataFromWorkInstance();

		} catch (Exception e) {
			throw new SystemException(e);
		}

	}
	
	private List<AbstractWorkFlow> getUserCirclePendingWork(String assignee){
		List<AbstractWorkFlow> values = new ArrayList<AbstractWorkFlow>();
		String sql;
		
		//查询用户所属的所有用户圈
		List<UserCircle> userCircleList = null;
		String userCircleSql = "select uc from UserCircle uc where instr(uc.value,'["+assignee+",')>0 or instr(uc.value,',"+assignee+",')>0 or instr(uc.value,',"+assignee+"]')>0";
		synchronized (em) {
			userCircleList = em.createQuery(userCircleSql).getResultList();
		}
		
		for(UserCircle uc:userCircleList){
			sql = "select flow from AbstractWorkFlow flow where flow.userCircle ='"+uc.getName()+"' and flow.assignee =' ' and flow.userGroup = ' ' and flow.currentState <> 'end'";
			List<AbstractWorkFlow> valuesTemp = null;
			synchronized (em) {
				valuesTemp = em.createQuery(sql).getResultList();
			}
			values.addAll(valuesTemp);
		}
		
		
		return values;
	}
	
	@SuppressWarnings("unchecked")
	public List<WorkObject> getPendingWork(String workClassName,
			String assignee, String userGroup, String loc, String platformLDName)
			throws SystemException {

		List<AbstractWorkFlow> values = null;
		String sql = "";
		//instr(flow.flowState,'RESOLVED')=0
//		sql = "select flow from AbstractWorkFlow flow where (flow.assignee = '"
//				+ assignee
//				+ "' or (flow.userGroup ='"
//				+ userGroup
//				+ "' and flow.assignee = ' ')) and CHARINDEX('RESOLVED',flow.flowState)=0 and flow.currentState <> 'end' and flow.flowState <> 'end'";
		
//		sql = "select flow from AbstractWorkFlow flow where (flow.assignee = '"
//				+ assignee
//				+ "' or (flow.userGroup ='"
//				+ userGroup
//				+ "' and flow.assignee = ' ')) and instr(flow.flowState,'RESOLVED')=0 and flow.currentState <> 'end' and flow.flowState <> 'end'";
		
		sql = "select flow from AbstractWorkFlow flow where (flow.assignee = '"
			+ assignee
			+ "' or (flow.userGroup ='"
			+ userGroup
			+ "' and flow.assignee = ' ')) and flow.currentState <> 'end'";
//		sql = "select flow from AbstractWorkFlow flow where flow.currentState <> 'end'";
		
		
		synchronized (em) {
			values = em.createQuery(sql).getResultList();
		}
		
		List<AbstractWorkFlow> values2 = getUserCirclePendingWork(assignee);
		values.addAll(values2);
		

		if (values != null & values.size() > 0) {
			List<WorkObject> ret = new ArrayList<WorkObject>(values.size());
			for (Object val : values) {
				WorkObject wo = new WorkObjectImpl();
				((AbstractWorkFlow) val).setOwner(wo);
				wo.setActiveFlowInstance(((AbstractWorkFlow) val));
				wo.setObjectId(((AbstractWorkFlow) val).getObjectId());
				wo.setCurrentState(((AbstractWorkFlow) val).getCurrentState());
				wo.setCurrentStateDisplay(((AbstractWorkFlow) val).getCurrentStateDisplay());
				wo.setAssignee(((AbstractWorkFlow) val).getAssignee());
				wo.setFlowState(((AbstractWorkFlow) val).getFlowState());
				wo.setFlowName(((AbstractWorkFlow) val).getFlowName());
				wo.setFlowNameCN(((AbstractWorkFlow) val).getFlowNameCN());

				ret.add((WorkObject) wo);
			}
			return ret;
		}
		return null;
	}
	
	public static WorkObject getPendingWorkWS(Long id) throws SystemException {

		// "select flow from AbstractWorkFlow flow where (flow.assignee = '" +
		// assignee + "' or flow.userGroup ='" + userGroup
		// +
		// "') and instr(flow.flowState,'RESOLVED')=0 and flow.currentState <> 'end' and flow.flowState <> 'end'"
		String sql = "";
		AbstractWorkFlow wf = WorkObject.em.find(AbstractWorkFlow.class, id);

		WorkObject wo = new WorkObjectImpl();
		((AbstractWorkFlow) wf).setOwner(wo);
		wo.setActiveFlowInstance((AbstractWorkFlow) wf);
		wo.setWorkDataInstance(((AbstractWorkFlow) wf).getWorkData());
		wo.setObjectId(((AbstractWorkFlow) wf).getObjectId());
		wo.setCurrentState(((AbstractWorkFlow) wf).getCurrentState());
		wo.setCurrentStateDisplay(((AbstractWorkFlow) wf)
				.getCurrentStateDisplay());
		wo.setAssignee(((AbstractWorkFlow) wf).getAssignee());
		wo.setFlowState(((AbstractWorkFlow) wf).getFlowState());
		wo.setFlowName(((AbstractWorkFlow) wf).getFlowName());
		wo.setFlowNameCN(((AbstractWorkFlow) wf).getFlowNameCN());

		return wo;
	}
	
	public void recordHistory(String assignee,String action,String note){
		FlowHistory fh = new FlowHistory();
		fh.setFlowId(this.getObjectId());
		fh.setAssignee(assignee);
		fh.setOperatingTime(new Date());
		fh.setStep(this.getCurrentStateDisplay());
		fh.setAction(action);
		fh.setFlowType(this.getWorkDataInstance().getFlowType());
		fh.setNote(note);
		synchronized (em) {
			try {
				em.getTransaction().begin();
				em.persist(fh);
				em.getTransaction().commit();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				em.getTransaction().rollback();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<WorkObject> getPendingWorkByTask(String processName,String taskName,
			String assignee, String userGroup, String loc, String platformLDName)
			throws SystemException {

		List<AbstractWorkFlow> values = null;
		String sql = "";
		//instr(flow.flowState,'RESOLVED')=0
//		sql = "select flow from AbstractWorkFlow flow where (flow.assignee = '"
//				+ assignee
//				+ "' or (flow.userGroup ='"
//				+ userGroup
//				+ "' and flow.assignee = ' ')) and CHARINDEX('RESOLVED',flow.flowState)=0 and flow.currentState <> 'end' and flow.flowState <> 'end'";
		
//		sql = "select flow from AbstractWorkFlow flow where (flow.assignee = '"
//				+ assignee
//				+ "' or (flow.userGroup ='"
//				+ userGroup
//				+ "' and flow.assignee = ' ')) and instr(flow.flowState,'RESOLVED')=0 and flow.currentState <> 'end' and flow.flowState <> 'end'";
		
		sql = "select flow from AbstractWorkFlow flow where (flow.assignee = '"
			+ assignee
			+ "' or (flow.userGroup ='"
			+ userGroup
			+ "' and flow.assignee = ' ')) and flow.currentState <> 'end' and flow.currentState ='"
			+ taskName
			+"' and flow.flowName = '"
			+ processName
			+ "'";
		
		
		synchronized (em) {
			values = em.createQuery(sql).getResultList();
		}
		
		if (values != null & values.size() > 0) {
			List<WorkObject> ret = new ArrayList<WorkObject>(values.size());
			for (Object val : values) {
				WorkObject wo = new WorkObjectImpl();
				((AbstractWorkFlow) val).setOwner(wo);
				wo.setActiveFlowInstance(((AbstractWorkFlow) val));
				wo.setObjectId(((AbstractWorkFlow) val).getObjectId());
				wo.setCurrentState(((AbstractWorkFlow) val).getCurrentState());
				wo.setCurrentStateDisplay(((AbstractWorkFlow) val).getCurrentStateDisplay());
				wo.setAssignee(((AbstractWorkFlow) val).getAssignee());
				wo.setFlowState(((AbstractWorkFlow) val).getFlowState());
				wo.setFlowName(((AbstractWorkFlow) val).getFlowName());
				wo.setFlowNameCN(((AbstractWorkFlow) val).getFlowNameCN());

				ret.add((WorkObject) wo);
			}
			return ret;
		}
		return null;
	}

}
