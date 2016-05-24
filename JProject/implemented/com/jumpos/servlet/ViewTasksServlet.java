package com.jumpos.servlet;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import  com.june.implemented.common.application.Process;
import com.june.implemented.common.ext.ViewTasksManageBean;
import com.june.util.Json;


@WebServlet("/ViewTasks")
public class ViewTasksServlet extends AbstractFacesServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FacesContext context = getFacesContext(request, response);
		ViewTasksManageBean bean = (ViewTasksManageBean)getBean("viewTasks", context);
		Process proc = (Process)getBean("process", context);
//		bean.process();
//		bean.doProcess(proc,request,response);
		Json json = new Json();
		List list = bean.getPendingWorkList();
		json.setList(list);
		json.setSuccess(true);
		json.setUrl("viewTaskList.htm");
		String callback = request.getParameter("callback");
		response.getWriter().print(callback+"("+JSON.toJSONString(json)+")");
	}

}
