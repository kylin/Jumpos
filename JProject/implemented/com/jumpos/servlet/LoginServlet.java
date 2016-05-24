package com.jumpos.servlet;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.june.implemented.common.authentication.User;
import com.june.implemented.common.view.Login;
import com.june.implemented.model.action.LoginAction;
import com.june.implemented.model.input.Login_UserInput;
import com.june.util.Json;

@WebServlet("/Login")
public class LoginServlet extends AbstractFacesServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FacesContext context = getFacesContext(request, response);
		Login login = (Login)getBean("login", context);
		Login_UserInput userInput = new Login_UserInput();
		userInput.setOperatorId(request.getParameter("username"));
		userInput.setOperatorPassword(request.getParameter("userpwd"));
		LoginAction action = login.getLoginAction();
		action.setUserInput(userInput);
		Json json = action.perform();
		request.getSession().setAttribute("user", (User)json.getObj());
		String callback = request.getParameter("callback");
		response.getWriter().print(callback+"("+JSON.toJSONString(json)+")");
	}

}
