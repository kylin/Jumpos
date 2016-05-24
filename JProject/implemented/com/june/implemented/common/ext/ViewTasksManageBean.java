package com.june.implemented.common.ext;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.june.common.api.WorkObject;
import com.june.implemented.common.application.Process;
import com.june.implemented.common.application.WorkObjectImpl;
import com.june.implemented.common.authentication.User;

@ManagedBean(name = "viewTasks")
@ViewScoped
public class ViewTasksManageBean extends AbstractProcessManageBean {

	private List<WorkObject> pendingWorkList = new ArrayList<WorkObject>();

	private WorkObjectImpl workSelectedforAssignee;

	private long selectedtaskId;

	@Override
	protected void doProcess(Process process, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
				
		User user = (User)request.getSession().getAttribute("user");

		String processName = request.getParameter("state");
		System.out.println("Process Name:" + processName);
		String taskName = request.getParameter("taskName");
		System.out.println("Task Name:" + taskName);
		String groupName = user != null ? user.getUsergroup() : request.getParameter("userGroup");
		System.out.println("user group:" + groupName);

		if (process == null || process.getUser() == null) {
			response.sendRedirect("login.htm");
		} else {

			WorkObjectImpl wo = new WorkObjectImpl();

			process.setActiveWorkObject(wo);

			if (taskName == null || "".equals(taskName)) {
				pendingWorkList = process.getActiveWorkObject().getPendingWork(
						processName, process.getUser().getUsername(),
						groupName, process.getUser().getLocation(),
						process.getUser().getLinkage());
			} else {

				pendingWorkList = process.getActiveWorkObject()
						.getPendingWorkByTask(processName, taskName,
								process.getUser().getUsername(), groupName,
								process.getUser().getLocation(),
								process.getUser().getLinkage());
			}

			if (pendingWorkList == null) {
				// response.getWriter().print("NO_PENDING_TASK");
				return;
			}
		}
		// response.sendRedirect("viewTasks.xhtml");

	}

	public List<WorkObject> getPendingWorkList() {
		return pendingWorkList;
	}

	public WorkObjectImpl getWorkSelectedforAssignee() {
		return workSelectedforAssignee;
	}

	public void setWorkSelectedforAssignee(
			WorkObjectImpl workSelectedforAssignee) {
		this.workSelectedforAssignee = workSelectedforAssignee;
		if (workSelectedforAssignee != null
				&& workSelectedforAssignee.getObjectId() != 0) {
			this.selectedtaskId = workSelectedforAssignee.getObjectId();
			System.out.println(this.selectedtaskId);
		}

	}

	public String openTask() {

		String taskId = request.getParameter("taskId");

		return "openTask.xhtml?taskId=" + taskId + "&userId" + this.getUserId();
	}

}
