package com.june.common.api;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.primefaces.push.PushContextFactory;

import com.june.common.exception.SystemException;
import com.june.common.exception.ValidationException;
import com.june.common.exception.WorkNotFoundException;
import com.thoughtworks.xstream.XStream;

public abstract class WorkObject {

	protected long objectId;
	private String assignee;
	private String userGroup; // 用户组

	private String currentState;
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public void setCurrentStateDisplay(String currentStateDisplay) {
		this.currentStateDisplay = currentStateDisplay;
	}

	public void setFlowState(String flowState) {
		this.flowState = flowState;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	private String currentStateDisplay; // 当前流程状态显示名 eg:输入企业名称
	private String flowState;
	private AbstractWorkData workDataInstance;
	public void setObjectId(long objectId) {
		this.objectId = objectId;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public void setWorkDataInstance(AbstractWorkData workDataInstance) {
		this.workDataInstance = workDataInstance;
	}

	public void setActiveFlowInstance(AbstractWorkFlow activeFlowInstance) {
		this.activeFlowInstance = activeFlowInstance;
	}

	private AbstractWorkFlow activeFlowInstance;

	private String flowName;
	
	private String flowNameCN;

	public String getFlowNameCN() {
		return flowNameCN;
	}

	public void setFlowNameCN(String flowNameCN) {
		this.flowNameCN = flowNameCN;
	}

	public static EntityManager em;

	public AbstractWorkFlow getActiveFlowInstance() {
		return activeFlowInstance;
	}

	public AbstractWorkData getWorkDataInstance() {
		if(activeFlowInstance == null)
			return null;
		return activeFlowInstance.getWorkData();
	}

	public long getObjectId() {
		return objectId;
	}

	public String getFlowState() {
		return flowState;
	}

	public String getAssignee() {
		return assignee;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public String getCurrentState() {
		return currentState;
	}

	public String getCurrentStateDisplay() {
		return currentStateDisplay;
	}

	public String getFlowName() {
		return flowName;
	}

	public WorkObject() {
		if (em == null) {
			em = Persistence.createEntityManagerFactory("JUNE")
					.createEntityManager();
		}
	}

	public String toString() {
		return String.format("%d - %s - %s", this.objectId, assignee,
				this.currentState);
	}



	/**
	 * updata操作，作用为对Mail方式跳转后角色切换
	 */
	public static void updataFlowState(String userGroup, long id)
			throws WorkNotFoundException, SystemException, ValidationException {
		try {
			AbstractWorkFlow wf = null;

			synchronized (em) {
				wf = em.find(AbstractWorkFlow.class, id);

				// wf.setAssignee("联动平台业务人员");
				wf.setAssignee(" ");
				wf.setUserGroup(userGroup);
				// wf.setCurrentState("shape_LDFW_IDNbi0UJ52zAp43FF4724f89CX3N986ke");
				// wf.setCurrentStateDisplay("上传服务成果显示");

				try {
					em.getTransaction().begin();
					em.merge(wf);
					em.flush();
					em.getTransaction().commit();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					em.getTransaction().rollback();
				}
			}
			PushContextFactory.getDefault().getPushContext()
					.push("/toprefresh", ""); // push任务数更新

		} catch (Exception e) {
			throw new SystemException(e);
		}

	}







	public void loadWorkData(String workClass, String workFlow, long id)
			throws WorkNotFoundException, SystemException, ValidationException {
		try {
			AbstractWorkFlow wf = null;

			synchronized (em) {
				wf = em.find(AbstractWorkFlow.class, id);
			}

			if (wf != null) {
				wf.setOwner(this);
				this.workDataInstance = wf.getWorkData();
				this.activeFlowInstance = wf;
				this.objectId = this.activeFlowInstance.getObjectId();
				this.currentState = this.activeFlowInstance.getCurrentState();
				this.currentStateDisplay = this.activeFlowInstance
						.getCurrentStateDisplay();
				this.assignee = this.activeFlowInstance.getAssignee();
				this.userGroup = this.activeFlowInstance.getUserGroup();
				this.flowState = this.activeFlowInstance.getFlowState();
				this.flowName = this.activeFlowInstance.getFlowName();
				this.flowNameCN = this.activeFlowInstance.getFlowNameCN();
				this.workDataInstance.setAssignee(this.assignee);
				this.workDataInstance.setCurrentState(this.currentState);
				this.workDataInstance.setFlowName(this.flowName);
				this.workDataInstance.setFlowState(this.flowState);
			} else {
				throw new WorkNotFoundException();
			}
		} catch (Exception e) {
			throw new SystemException(e);
		}

	}

	public String getNextStep() throws SystemException, ValidationException {
		if(workDataInstance==null){
			return "";
		}
		String xml = new XStream().toXML(this.workDataInstance);
		System.out.println("xml:" + xml);
		activeFlowInstance.setLastHistoryData(xml);

		synchronized (em) {
			try {
				em.getTransaction().begin();
				em.merge(this.activeFlowInstance);
				em.flush();
				em.getTransaction().commit();
			} catch (Exception e) {
				// TODO: handle exception
				em.getTransaction().rollback();
				e.printStackTrace();
			}
		}

		if (this.assignee != null
				&& !this.assignee.equals(this.activeFlowInstance.getAssignee())) {
			PushContextFactory.getDefault().getPushContext()
					.push("/toprefresh", ""); // push任务数更新

		}
		this.objectId = this.activeFlowInstance.getObjectId();
		this.currentState = this.activeFlowInstance.getCurrentState();
		this.currentStateDisplay = this.activeFlowInstance
				.getCurrentStateDisplay();
		this.assignee = this.activeFlowInstance.getAssignee();
		this.userGroup = this.activeFlowInstance.getUserGroup();
		this.flowName = this.activeFlowInstance.getFlowName();
		this.flowNameCN = this.activeFlowInstance.getFlowNameCN();
		this.flowState = this.activeFlowInstance.getFlowState();
		this.workDataInstance.setAssignee(this.assignee);
		this.workDataInstance.setCurrentState(this.currentState);
		this.workDataInstance.setFlowState(this.flowState);
		this.workDataInstance.setFlowName(this.flowName);

		// this.CopyDataFromWorkInstance();
		return this.currentState;
	}

	// public String getNextStep(String userGroup) throws SystemException,
	// ValidationException {
	//
	// String xml = new XStream().toXML(this.workDataInstance);
	// System.out.println("xml:" + xml);
	// activeFlowInstance.setLastHistoryData(xml);
	//
	// if (activeFlowInstance.userGroup != userGroup) {
	// activeFlowInstance.userGroup = userGroup;
	// }
	// // activeFlowInstance.assignee = operatorID
	//
	// synchronized (em) {
	// em.getTransaction().begin();
	// em.merge(this.activeFlowInstance);
	// em.flush();
	// em.getTransaction().commit();
	// }
	//
	// this.objectId = this.activeFlowInstance.getObjectId();
	// this.currentState = this.activeFlowInstance.getCurrentState();
	// this.currentStateDisplay =
	// this.activeFlowInstance.getCurrentStateDisplay();
	// this.assignee = this.activeFlowInstance.getAssignee();
	// this.flowName = this.activeFlowInstance.getFlowName();
	// this.flowState = this.activeFlowInstance.getFlowState();
	// this.workDataInstance.setAssignee(this.assignee);
	// this.workDataInstance.setCurrentState(this.currentState);
	// this.workDataInstance.setFlowState(this.flowState);
	// this.workDataInstance.setFlowName(this.flowName);
	//
	// // this.CopyDataFromWorkInstance();
	// return this.currentState;
	// }

//	public static void main(String[] args) {
//		String assignee = "gwang";
//		String liandongpingtai1 = "窗口业务人员";
//		String hql = "select users from UserEntity users where users.linkage = '"
//				+ liandongpingtai1 + "'";
//		System.out.println("HQL:" + hql);
//	}
}
