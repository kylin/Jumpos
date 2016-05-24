package com.june.implemented.common.authentication;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "user")
@SessionScoped
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

	
	
	public String getHomePage() {
//		if ("窗口领导组".equals(this.getUsergroup())) {
//			return "homePage_chuangkoulingdao.xhtml";
//		} else if ("窗口业务人员组".equals(this.getUsergroup())) {
//			return "homePage_chuangkouyewu.xhtml";
//		} else if ("联动平台业务人员组".equals(this.getUsergroup())) {
//			return "homePage_liandongrenyuan.xhtml";
//		} else if ("省平台领导组".equals(this.getUsergroup())) {
//			return "homePage_shengpingtailingdao.xhtml";
//		} else if("联动平台工作人员（联动窗口）组".equals(this.getUsergroup())){
//			return "homePage_liandongchuangkou.xhtml";
//		} else if("联动平台工作人员（联动窗口领导）组".equals(this.getUsergroup())){
//			return "homePage_liandonglingdao.xhtml";
//		} else if("联动平台工作人员（服务匹配）组".equals(this.getUsergroup())){
//			return "homePage_liandongfuwu.xhtml";
//		} else if("管理人员组".equals(this.getUsergroup())){
//			return "homePage_shengpingtaiguanliyuan.xhtml";
//		} else{
			return "homePage_default.xhtml";
//		}
	}
	
	//区分管理人员组、企业组  页面菜单的不同
	public String getLeftMenu() {
//		if("管理人员组".equals(this.getUsergroup())){
//			return "layout/leftMenu_guanliyuan.xhtml";
//		} else if("企业组".equals(this.getUsergroup())){
//			return "layout/leftMenu_qiye.xhtml";
//		} else {
			return "layout/leftMenu_default.xhtml";
//		}
	}	
	
	public String getPageName(){
		if ("窗口领导组".equals(this.getUsergroup())) {
			return "窗口管理工作界面";
		}
		if ("窗口业务人员组".equals(this.getUsergroup())) {
			return "窗口业务工作界面";
		}
		if ("联动平台业务人员组".equals(this.getUsergroup())) {
			return "联动平台业务工作界面";
		}
		if ("省平台领导组".equals(this.getUsergroup())) {
			return "省平台管理工作界面";
		}
		if("联动平台工作人员（联动窗口）组".equals(this.getUsergroup())){
			return "联动平台工作人员（联动窗口）组";
		}
		if("联动平台工作人员（联动窗口领导）组".equals(this.getUsergroup())){
			return "联动平台工作人员（联动窗口领导）组";
		}
		if("联动平台工作人员（服务匹配）组".equals(this.getUsergroup())){
			return "联动平台工作人员（服务匹配）组";
		}
		if("管理人员组".equals(this.getUsergroup())){
			return "省平台技术监控工作界面";
		}else{
			return "";
		}
	}
	
	public String getTopLog() {
		if ("窗口领导组".equals(this.getUsergroup())||"窗口业务人员组".equals(this.getUsergroup())) {
			return "url(images/topRight_chuangkou.png)";
		} else if ("联动平台业务人员组".equals(this.getUsergroup())) {
			return "url(images/topRight_liandong.png)";
		} else{
			return "url(images/topRight_sheng.png)";
		}
	}

}
