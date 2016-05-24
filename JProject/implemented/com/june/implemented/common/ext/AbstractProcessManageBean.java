package com.june.implemented.common.ext;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.june.common.api.WorkObject;
import com.june.implemented.common.application.Process;
import com.june.implemented.common.application.WorkObjectImpl;
import com.june.implemented.common.authentication.InitializeUser;
import com.june.implemented.common.authentication.User;
import com.june.implemented.common.function.UserEntity;
//import com.june.implemented.common.wechat.SendMsg;

@ViewScoped
abstract public class AbstractProcessManageBean {

	private String userName;
	private String userId;

	private String result;

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	public AbstractProcessManageBean() {
		super();
		request = (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();

		response = (HttpServletResponse) FacesContext.getCurrentInstance()
				.getExternalContext().getResponse();
		
		userId = request.getParameter("userId");
    	System.out.println("userid:"+userId);

//		String code = request.getParameter("code");
//		if(StringUtils.isNotBlank(code)){
//			userName = SendMsg.getUserID(code, SendMsg.agentid);
//	    	System.out.println("userName:"+userName);
//		}

	}

	@PostConstruct
	public void process() {

		try {

			Process process = new Process();
			
			InitializeUser.getAllUser();


			if (StringUtils.isNotBlank(userName)) {
				UserEntity userEntity = getUserByName(userName);

				User user = new User();

				user.setUserId(userEntity.getUserId());
				user.setUsername(userEntity.getUserName());
				user.setUsergroup(userEntity.getUserGroup());

				process.setUser(user);
			} else if (StringUtils.isNotBlank(userId)) {
				UserEntity userEntity = getUserById(Long.parseLong(userId));

				User user = new User();

				user.setUserId(userEntity.getUserId());
				user.setUsername(userEntity.getUserName());
				user.setUsergroup(userEntity.getUserGroup());

				process.setUser(user);
			}

			process.setActiveWorkObject(new WorkObjectImpl());
			
			doProcess(process, this.request, this.response);

			result = "SUCCESS";

		} catch (Exception ex) {
			ex.printStackTrace();
			result = "ERROR : " + ex.getMessage();
			// throw new RuntimeException(ex);
		}

	}

	public String getUserName() {
		return userName;
	}

	public String getUserId() {
		return userId;
	}

	public String getResult() {
		return result;
	}

	abstract protected void doProcess(Process process,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	protected UserEntity getUserById(long id) throws Exception {

		if (WorkObject.em == null) {
			WorkObject.em = Persistence.createEntityManagerFactory("JUNE")
					.createEntityManager();
		}

		UserEntity user = WorkObject.em.find(UserEntity.class, id);

		if (user == null) {
			throw new Exception("Can Not Found User By Id [" + id + "}");
		}

		return user;
	}

	protected UserEntity getUserByName(String userName) throws Exception {

		if (WorkObject.em == null) {
			WorkObject.em = Persistence.createEntityManagerFactory("JUNE")
					.createEntityManager();
		}

		List<UserEntity> users = WorkObject.em
				.createQuery(
						"select user from UserEntity user where user.userName = '" + userName + "'")					
				.getResultList();

		if (users == null || users.isEmpty()) {
			throw new Exception("Can Not Found User By Name [" + userName + "}");
		}

		return users.get(0);
	}

}
