package com.june.common.api;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.june.common.model.WorkFlow;


@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name = "flow_data")
public abstract class AbstractWorkFlow implements WorkFlow {
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	private static final long serialVersionUID = 6820027005044063676L;
	public static final String END_STATE = "end";
//	private static final Logger log = LoggerFactory.getLogger(AbstractWorkFlow.class);

//	@Transient
//	protected Map<String, FlowAction> flowActionMap = new HashMap<String, FlowAction>();

	@Transient
	protected WorkObject owner;
	@Column(name = "state")
	protected String currentState;
	protected String currentStateDisplay;
	protected String assignee;
	protected String userGroup;
	protected String userCircle;
	@Column(length = 1000)
	protected String flowState;
	protected String mainFlowID;
	protected String startUser;
	protected String startUserGroup;
	protected String startUserHigher;
	protected String errorFlowUser;
	protected String errorFlowUserGroup;
	protected String errorFlowState;
	protected String errorFlowStateDisplay;
	protected String errorFlowType;
	//开启新流程时的指数
	protected int openFlowIndex = 0;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="flow_dataseq")
    @SequenceGenerator(name="flow_dataseq",sequenceName="flow_data_seq",allocationSize=1)  
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long objectID;
	@Column(length = 1000)
	protected String flowName;
	
	@Column(length = 1000)
	protected String flowNameCN;

	@OneToOne(cascade = CascadeType.ALL)
	private AbstractWorkData workData;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	//@Column(name = "history", nullable = true)
	@Column(name = "history", columnDefinition = "CLOB",nullable = true)
	private String lastHistoryData;

	public String getLastHistoryData() {
		return lastHistoryData;
	}
	
	public void setLastHistoryData(String lastHistoryData) {
		this.lastHistoryData = lastHistoryData;
	}

	public AbstractWorkData getWorkData() {
		return workData;
	}

	public void setWorkData(AbstractWorkData workData) {
		this.workData = workData;
	}
	
	public String getFlowName() {
		return flowName;
	}

	public void setOwner(WorkObject owner) {
		this.owner = owner;
	}
	
	public String toString() {
		return "[Flow - " + getClass().getName() + "(id=" + ")]";
	}
	
	public String getUserGroup() {
		return userGroup;
	}
	
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public String getUserCircle() {
		return userCircle;
	}

	public void setUserCircle(String userCircle) {
		this.userCircle = userCircle;
	}

	public String getCurrentStateDisplay() {
		return currentStateDisplay;
	}

	public void setCurrentStateDisplay(String currentStateDisplay) {
		this.currentStateDisplay = currentStateDisplay;
	}

	public String getCurrentState() {
		// TODO Auto-generated method stub
		return currentState;
	}

	public String getAssignee() {
		// TODO Auto-generated method stub
		return assignee;
	}

	public long getObjectId() {
		// TODO Auto-generated method stub
		return objectID;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
//	public void setFlowData(String state) {
//		this.currentState = state;
//	}
	
	public void LoadDefaultValue(String operatorID) {
		this.assignee = operatorID;
		this.currentState = "newFlow";
	}

	public String getFlowState() {
		return flowState;
	}

	public void setFlowState(String flowState) {
		this.flowState = flowState;
	}

	public String getMainFlowID() {
		return mainFlowID;
	}

	public void setMainFlowID(String mainFlowID) {
		this.mainFlowID = mainFlowID;
	}

	public String getStartUser() {
		return startUser;
	}

	public void setStartUser(String startUser) {
		this.startUser = startUser;
	}

	public String getStartUserGroup() {
		return startUserGroup;
	}

	public void setStartUserGroup(String startUserGroup) {
		this.startUserGroup = startUserGroup;
	}

	public String getStartUserHigher() {
		return startUserHigher;
	}

	public void setStartUserHigher(String startUserHigher) {
		this.startUserHigher = startUserHigher;
	}

	public String getErrorFlowUser() {
		return errorFlowUser;
	}

	public void setErrorFlowUser(String errorFlowUser) {
		this.errorFlowUser = errorFlowUser;
	}

	public String getErrorFlowUserGroup() {
		return errorFlowUserGroup;
	}

	public void setErrorFlowUserGroup(String errorFlowUserGroup) {
		this.errorFlowUserGroup = errorFlowUserGroup;
	}

	public String getErrorFlowState() {
		return errorFlowState;
	}

	public void setErrorFlowState(String errorFlowState) {
		this.errorFlowState = errorFlowState;
	}

	public String getErrorFlowStateDisplay() {
		return errorFlowStateDisplay;
	}

	public void setErrorFlowStateDisplay(String errorFlowStateDisplay) {
		this.errorFlowStateDisplay = errorFlowStateDisplay;
	}

	public String getErrorFlowType() {
		return errorFlowType;
	}

	public void setErrorFlowType(String errorFlowType) {
		this.errorFlowType = errorFlowType;
	}

	public String getFlowNameCN() {
		return flowNameCN;
	}

	public void setFlowNameCN(String flowNameCN) {
		this.flowNameCN = flowNameCN;
	}

	public int getOpenFlowIndex() {
		return openFlowIndex;
	}

	public void setOpenFlowIndex(int openFlowIndex) {
		this.openFlowIndex = openFlowIndex;
	}

}
