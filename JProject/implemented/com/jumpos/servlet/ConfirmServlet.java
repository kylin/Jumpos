package com.jumpos.servlet;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.june.implemented.common.view.Confirm;
import com.june.implemented.model.output.Confirm_PageOutput;
import com.june.util.Json;

@WebServlet("/confirm")
public class ConfirmServlet extends AbstractFacesServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FacesContext context = getFacesContext(request, response);
		Confirm shape = (Confirm)getBean("confirm", context);
		Confirm_PageOutput page = shape.getPageOutput();
		Json json = new Json();
		json.setSuccess(true);
		json.setObj(page);
		json.setUrl("confirm.htm");
		String callback = request.getParameter("callback");
		response.getWriter().print(callback+"("+JSON.toJSONString(json)+")");				
	}

}
