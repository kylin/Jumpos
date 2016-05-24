package com.june.implemented.common.authentication;

import java.util.List;

import javax.persistence.Persistence;

import com.june.common.api.WorkObject;
import com.june.implemented.common.function.UserEntity;

public class InitializeUser {
	
	
	
	public InitializeUser() {

		// TODO Auto-generated constructor stub
	}

	public static List<UserEntity> getAllUser() {
		if (WorkObject.em == null) {
			WorkObject.em = Persistence.createEntityManagerFactory("JUNE")
					.createEntityManager();
		}
		List<UserEntity> values = null;
		String strSql = "select userEntity from UserEntity userEntity";
		synchronized (WorkObject.em) {
			values = WorkObject.em.createQuery(strSql).getResultList();
		}
		if (values.isEmpty()) {
			synchronized (WorkObject.em) {
				try {
					WorkObject.em.getTransaction().begin();

				UserEntity user0 = new UserEntity();
				// user0.setUserId("admin");
				user0.setUserName("admin");
				user0.setUserGroup("管理人员组");
				user0.setUserPassword("12345");
				// user0.setLocation("");
				WorkObject.em.persist(user0);
				user0 = new UserEntity();
				user0.setUserName("申请人");
				user0.setUserGroup("申请人");
				user0.setUserHigher("申请人");
				user0.setUserPassword("12345");
				// user0.setLocation("");
				WorkObject.em.persist(user0);
				user0 = new UserEntity();
				user0.setUserName("后台系统");
				user0.setUserGroup("后台系统");
				user0.setUserHigher("后台系统");
				user0.setUserPassword("12345");
				// user0.setLocation("");
				WorkObject.em.persist(user0);
				user0 = new UserEntity();
				user0.setUserName("部门经理");
				user0.setUserGroup("部门经理");
				user0.setUserHigher("部门经理");
				user0.setUserPassword("12345");
				// user0.setLocation("");
				WorkObject.em.persist(user0);
				user0 = new UserEntity();
				user0.setUserName("财务");
				user0.setUserGroup("财务");
				user0.setUserHigher("财务");
				user0.setUserPassword("12345");
				// user0.setLocation("");
				WorkObject.em.persist(user0);
				WorkObject.em.getTransaction().commit();
				} catch (Exception e) {
					e.printStackTrace();
					WorkObject.em.getTransaction().rollback();
				}
				
			}
			synchronized (WorkObject.em) {
				values = WorkObject.em.createQuery(strSql).getResultList();
			}
		}
		return values;
	}

}
