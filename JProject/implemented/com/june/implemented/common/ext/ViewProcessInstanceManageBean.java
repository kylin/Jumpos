package com.june.implemented.common.ext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.june.implemented.common.application.Process;
import com.june.implemented.common.application.WorkObjectImpl;

@ManagedBean(name = "viewProcessInstance")
@ViewScoped
public class ViewProcessInstanceManageBean extends AbstractProcessManageBean {

	private WorkObjectImpl processInstance;
	
	@Override
	protected void doProcess(Process process, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String processId = request.getParameter("id");


		WorkObjectImpl wo = (WorkObjectImpl) WorkObjectImpl
				.getPendingWorkWS(Long.parseLong(processId));

		process.setActiveWorkObject(wo);
		
		processInstance = process.getActiveWorkObject();
		
		if (process.getActiveWorkObject().getCurrentState().equals("end")) {
//			response.sendRedirect("../mobile/"+ process.getActiveWorkObject()
//					.getCurrentState() + ".xhtml");
		} else {
//			response.sendRedirect("../mobile/"+ process.getActiveWorkObject()
//					.getCurrentState() + "_confirm.xhtml");
		}

	}

	public WorkObjectImpl getProcessInstance() {
		return processInstance;
	}
	

}
