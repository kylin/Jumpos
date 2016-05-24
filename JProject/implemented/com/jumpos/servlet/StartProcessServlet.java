package com.jumpos.servlet;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.june.implemented.common.ext.StartProcessManageBean;
import com.june.util.Json;

@WebServlet("/StartProcess")
public class StartProcessServlet extends AbstractFacesServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FacesContext context = getFacesContext(request, response);
		StartProcessManageBean start = (StartProcessManageBean)getBean("startProcess", context);
//		start.process();
		Json json = (Json)request.getAttribute("JSON");
		String callback = request.getParameter("callback");
		response.getWriter().print(callback+"("+JSON.toJSONString(json)+")");		
	}

}
