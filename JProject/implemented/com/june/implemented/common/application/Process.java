package com.june.implemented.common.application;

import com.june.implemented.common.authentication.User;


public class Process {

	WorkObjectImpl activeWorkObject;

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

	}

}
