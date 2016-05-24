package com.jumpos.servlet;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.june.implemented.common.ext.OpenTaskManageBean;
import com.june.util.Json;

@WebServlet("/openTask")
public class OpenTaskServlet extends AbstractFacesServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String taskId = request.getParameter("taskId");
		FacesContext context = getFacesContext(request, response);
		OpenTaskManageBean bean = (OpenTaskManageBean)getBean("openTask", context);
		bean.process();
		String url = bean.getUrl();
		Json json = new Json();
		json.setSuccess(true);
		json.setId(taskId);
		json.setUrl(url);
		String callback = request.getParameter("callback");
		response.getWriter().print(callback+"("+JSON.toJSONString(json)+")");	
	}

}
