package com.june.implemented.model.data;

public class LoginRecoderEntity {
	//用户登录id
	private String userId;
	//用户登录时间
	private String onlineTime;
	//用户离线时间
	private String offlineTime;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOnlineTime() {
		return onlineTime;
	}
	public void setOnlineTime(String onlineTime) {
		this.onlineTime = onlineTime;
	}
	public String getOfflineTime() {
		return offlineTime;
	}
	public void setOfflineTime(String offlineTime) {
		this.offlineTime = offlineTime;
	}

}
