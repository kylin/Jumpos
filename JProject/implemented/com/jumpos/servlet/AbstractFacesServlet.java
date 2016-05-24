package com.jumpos.servlet;

import java.io.IOException;

import javax.faces.FactoryFinder;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractFacesServlet extends HttpServlet {

	/** Creates a new instance of AbstractFacesServlet */
	public AbstractFacesServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

	}

	protected abstract void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		processRequest(request, response);
	}

	protected void log(FacesContext facesContext, String message) {
		facesContext.getExternalContext().log(message);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");		
		processRequest(request, response);
	}

	protected FacesContext getFacesContext(HttpServletRequest request, HttpServletResponse response) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
//		if (facesContext == null) {
			FacesContextFactory contextFactory = (FacesContextFactory) FactoryFinder
					.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
			LifecycleFactory lifecycleFactory = (LifecycleFactory) FactoryFinder
					.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
			Lifecycle lifecycle = lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
			facesContext = contextFactory.getFacesContext(request.getSession().getServletContext(), request, response,
					lifecycle);
			InnerFacesContext.setFacesContextAsCurrentInstance(facesContext);
			UIViewRoot view = facesContext.getApplication().getViewHandler().createView(facesContext, "cms");
			facesContext.setViewRoot(view);
//		}
		return facesContext;
	}

	protected Object getBean(String beanName, FacesContext facesContext) {
		return facesContext.getApplication().getVariableResolver().resolveVariable(facesContext, beanName);
	}

	private abstract static class InnerFacesContext extends FacesContext {
		protected static void setFacesContextAsCurrentInstance(FacesContext facesContext) {
			FacesContext.setCurrentInstance(facesContext);
		}
	}

}