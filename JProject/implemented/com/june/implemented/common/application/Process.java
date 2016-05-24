package com.june.implemented.common.application;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.june.implemented.common.authentication.User;

@ManagedBean(name = "process")
@SessionScoped
public class Process {

	@ManagedProperty(value = "#{activeWorkObject}")
	WorkObjectImpl activeWorkObject;

	@ManagedProperty(value = "#{user}")
	User user;

	public WorkObjectImpl getActiveWorkObject() {
		return activeWorkObject;
	}

	public void setActiveWorkObject(WorkObjectImpl activeWorkObject) {
		this.activeWorkObject = activeWorkObject;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Process(String str) {}

	public Process() {
		if (FacesContext.getCurrentInstance() != null) {
			Process process = ProcessUtils.getProcess(FacesContext.getCurrentInstance());
			
			if(process != null){
				this.user = process.getUser();
				this.activeWorkObject = process.getActiveWorkObject();
			}
			
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put(ProcessUtils.PROCESS_ID, this);
		}
		// System.out.println(this);
		ProcessUtils.setProcess(this);
	}

	public Process(HttpSession session) {
		if (session != null) {
			session.setAttribute(ProcessUtils.PROCESS_ID, this);
		}
		// System.out.println(this);
		ProcessUtils.setProcess(this);
	}
	
}
