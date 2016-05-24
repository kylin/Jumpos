package com.jumpos.servlet;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.june.implemented.common.application.WorkObjectImpl;
import com.june.implemented.common.ext.ViewProcessInstanceManageBean;
import com.june.util.Json;

@WebServlet("/end")
public class ViewProcessInstanceServlet extends AbstractFacesServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("Object Id:"+id);
		FacesContext context = getFacesContext(request, response);
		ViewProcessInstanceManageBean bean = (ViewProcessInstanceManageBean)getBean("viewProcessInstance", context);
		bean.process();
		Json json = new Json();
		
		WorkObjectImpl data = bean.getProcessInstance();
		//Admin1WorkData data = ((Admin1WorkData)flow.);
		json.setObj(data);
		json.setId(id);
		
		json.setUrl(data.getCurrentState() + ".htm");
		
		String callback = request.getParameter("callback");
		if(callback != null){
			response.getWriter().print(callback+"("+JSON.toJSONString(json)+")");	
		}
		else{
			response.getWriter().print(JSON.toJSONString(json));	
		}
	}

}
