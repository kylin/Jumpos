package com.june.implemented.common.application;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class ProcessUtils {

	public static final String PROCESS_ID = "com.june.implemented.common.application.ProcessID";

	private static final ThreadLocal<Process> processThreadLocal = new ThreadLocal<Process>();

	public static void setProcess(Process process) {
		processThreadLocal.set(process);
	}

	public static Process getProcess(FacesContext facesContext) {

		if (facesContext != null) {
			return getProcess((HttpSession) facesContext.getExternalContext()
					.getSession(false));
		} else {
			System.out.println("Get Process From ThreadLocal");
			return processThreadLocal.get();
		}
	}

	public static Process getProcess(HttpSession session) {
		if (session == null) {
			System.out.println("Get Process From ThreadLocal");
			return processThreadLocal.get();
		} else {
			System.out.println("Get Process From Session [" + session.getId()
					+ "]");
			Process process = (Process) session.getAttribute(PROCESS_ID);
			processThreadLocal.set(process);
			return process;
		}

	}

}
