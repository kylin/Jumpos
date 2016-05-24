package com.june.implemented.common.ext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.june.implemented.common.application.Process;
import com.june.util.Json;

@ManagedBean(name = "startProcess")
@ViewScoped
public class StartProcessManageBean extends AbstractProcessManageBean {

	@Override
	protected void doProcess(Process process, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String processName = request.getParameter("state");
		System.out.println("Process Name:"+processName);
    	

		process.getActiveWorkObject().createNewWork(processName, processName,
				process.getUser().getUsername(),
				process.getUser().getUsergroup(),
				process.getUser().getUserHigher(),
				process.getUser().getLocation(), processName, processName, "流程开启");

		process.getActiveWorkObject().recordHistory(
				process.getUser().getUsername(), "开启新流程", null);

		String currentState = process.getActiveWorkObject().getCurrentState();
		System.out.println("process.getActiveWorkObject().getCurrentState():"
				+ process.getActiveWorkObject().getCurrentState());

		String viewPath = currentState;
		Json json = new Json();
		json.setId(process.getActiveWorkObject().getObjectId()+"");
		json.setUrl(viewPath);
		json.setObj(process);
		json.setSuccess(true);
		request.setAttribute("JSON", json);
	}

}
