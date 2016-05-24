package com.june.implemented.common.ext;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.june.common.api.AbstractWorkFlow;
import com.june.common.api.WorkObject;
import com.june.implemented.common.application.Process;
import com.june.implemented.common.application.WorkObjectImpl;

@ManagedBean(name = "viewProcessInstances")
@ViewScoped
public class ViewProcessInstancesManageBean extends AbstractProcessManageBean {

	private List<AbstractWorkFlow> processInstanceList = new ArrayList<AbstractWorkFlow>();
	private List<AbstractWorkFlow> processInstanceList2 = new ArrayList<AbstractWorkFlow>();
	
	@Override
	protected void doProcess(Process process, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String processName = request.getParameter("state");
		
		if (WorkObject.em == null) {
			WorkObject.em = Persistence.createEntityManagerFactory("JUNE")
					.createEntityManager();
		}

		processInstanceList2 = WorkObjectImpl.em.createQuery(
				"select flow from AbstractWorkFlow flow where flow.flowName = '" + processName
						+ "'", AbstractWorkFlow.class).getResultList();
		
		for (AbstractWorkFlow workFlow : processInstanceList2) {
			if(!String.valueOf(workFlow.getObjectId()).equalsIgnoreCase(workFlow.getMainFlowID())){
				processInstanceList.add(workFlow);
			}
		}
		
	}

	public List<AbstractWorkFlow> getProcessInstanceList() {
		return processInstanceList;
	}

	public String viewProcessInstance() {

		String processId = request.getParameter("processId");

		return "viewProcessInstance.xhtml?processId=" + processId;
	}

}
