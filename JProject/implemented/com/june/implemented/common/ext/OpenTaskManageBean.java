package com.june.implemented.common.ext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.june.implemented.common.application.Process;
import com.june.implemented.common.application.WorkObjectImpl;

@ManagedBean(name = "openTask")
@ViewScoped
public class OpenTaskManageBean extends AbstractProcessManageBean {

	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	protected void doProcess(Process process, HttpServletRequest request,
			HttpServletResponse response) throws Exception {


		String taskId = request.getParameter("taskId");

		WorkObjectImpl wo = (WorkObjectImpl) WorkObjectImpl
				.getPendingWorkWS(Long.parseLong(taskId));

		process.setActiveWorkObject(wo);

		process.getActiveWorkObject().loadWorkData(
				process.getUser().getWorkclass(), wo.getFlowName(),
				Long.parseLong(taskId));

		setUrl(process.getActiveWorkObject().getCurrentState());
	}

}
