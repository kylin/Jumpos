package com.june.implemented.model.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.alibaba.fastjson.JSON;
import com.june.implemented.common.authentication.InitializeUser;
import com.june.implemented.common.authentication.InitializeUserCircle;
import com.june.implemented.common.authentication.User;
import com.june.implemented.common.function.UserEntity;
import com.june.implemented.model.data.LoginRecoderEntity;
import com.june.implemented.model.data.XmlOperate;
import com.june.implemented.model.input.Login_UserInput;
import com.june.util.Json;

 //@ManagedBean(name="loginAction")
public class LoginAction {

	// @ManagedProperty(value = "#{user}")
	// User user;

	public LoginAction() {
		// ELContext elContext =
		// FacesContext.getCurrentInstance().getELContext();
		// user = (User) elContext.getELResolver().getValue(elContext, null,
		// "user");

	}

	// public User getUser() {
	// return user;
	// }
	//
	// public void setUser(User user) {
	// this.user = user;
	// }

	private Login_UserInput userInput = new Login_UserInput();

	public Login_UserInput getUserInput() {
		return userInput;
	}

	public void setUserInput(Login_UserInput userInput) {
		this.userInput = userInput;
	}

	public Json perform() {
		new InitializeUserCircle();
		List<UserEntity> values = InitializeUser.getAllUser();
		RequestContext context = RequestContext.getCurrentInstance();
		boolean handle = false;// 记录操作是否成功(是否登录成功)
		String state = null; // 显示添加状态，是失败或者成功 ,失败原因
		Json json = new Json();
		if ("".equals(userInput.getOperatorId())
				|| "".equals(userInput.getOperatorPassword())) {
			state = "用户名和密码不能为空！";
		} else {
			ELContext elContext = FacesContext.getCurrentInstance()
					.getELContext();
			User loginUser = (User) elContext.getELResolver().getValue(
					elContext, null, "user");
			for (UserEntity user : values) {
				if (user.getUserName().equals(userInput.getOperatorId())
						&& user.getUserPassword().equals(
								userInput.getOperatorPassword())) {
					handle = true;
					loginUser.setUserId(""+user.getId());
					loginUser.setUsername(user.getUserName());
					loginUser.setUsergroup(user.getUserGroup());
					loginUser.setUserHigher(user.getUserHigher());
					// loginUser.setLocation(user.getLocation());
					// if (!"".equals(user.getLinkage()) && user.getLinkage() !=
					// null) {
					// loginUser.setLinkage(user.getLinkage());
					// }else{
					// loginUser.setLinkage(null);
					// }
					json.setObj(loginUser);
					break;
				}
			}
			if (!handle) {
				state = "用户名或密码不正确！";
			} else {
				try {
					LoginRecoderEntity recoderInfo = new LoginRecoderEntity();
					// 设置日期格式
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					// new Date()为获取当前系统时间

					recoderInfo.setOnlineTime(df.format(new Date()).toString());
					recoderInfo.setUserId(userInput.getOperatorId());
					// 获取用户上次访问信息
					loginUser.setLastAccessTime(XmlOperate
							.getLastAccessTime(userInput.getOperatorId()));
					// 保存此次访问信息
					XmlOperate.saveLoginRecoder(recoderInfo);
				} catch (Exception e) {
					e.printStackTrace();
				}
				json.setUrl("main.htm");
//				return "main.xhtml?faces-redirect=true&amp;id=1";
			}
		}
		json.setSuccess(handle);
		json.setMsg(state);
//		context.addCallbackParam("handle", handle);
//		context.addCallbackParam("state", state);
		return json;
	}
}