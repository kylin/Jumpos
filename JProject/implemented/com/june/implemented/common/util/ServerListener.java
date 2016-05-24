package com.june.implemented.common.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * 此类用于前端服务器启动时保存ServletContext

 在web.xml进行如下定义
 <listener>
 <listener-class>
 com.june.implemented.common.util.ServerListener
 </listener-class>
 </listener>
 */
public class ServerListener implements ServletContextListener {

	static ServletContext servletContext;

	// static ServerDaemon serverDaemon;

	public static ServletContext getServletContext() {
		return servletContext;
	}

	public static void setServletContext(ServletContext servletContext) {
		ServerListener.servletContext = servletContext;
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// serverDaemon.setToStop(true);
		// System.out.println("线程XXXXXXXXXXXXXXXXXX摧毁");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		servletContext = event.getServletContext();
		// serverDaemon = new ServerDaemon();
		// serverDaemon.setDaemon(true);
		// serverDaemon.start();

	}
}