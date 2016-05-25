package com.june.implemented.common.authentication;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1881413500711441951L;
	
	private String username; //用户名（登录）
	private String usergroup; //用户组（管理人员组、企业组）
	private String userHigher; //用户上级
	private String workclass;
	private String linkage;
	
	private String userId;

	// channel用到
//	private String qiyeName;

	private String pushMsg;
	
	private String lastAccessTime;
	
	private String location;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsergroup() {
		return usergroup;
	}

	public void setUsergroup(String usergroup) {
		this.usergroup = usergroup;
	}

	public String getUserHigher() {
		return userHigher;
	}

	public void setUserHigher(String userHigher) {
		this.userHigher = userHigher;
	}

	public String getWorkclass() {
		return workclass;
	}

	public void setWorkclass(String workclass) {
		this.workclass = workclass;
	}

	public String getLinkage() {
		return linkage;
	}

	public void setLinkage(String linkage) {
		this.linkage = linkage;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPushMsg() {
		return pushMsg;
	}

	public void setPushMsg(String pushMsg) {
		this.pushMsg = pushMsg;
	}

	public String getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(String lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	

}
