package com.june.implemented.common.authentication;

import java.util.List;

import javax.persistence.Persistence;

import com.june.common.api.WorkObject;
import com.june.implemented.common.function.UserCircle;

public class InitializeUserCircle {
	
	
	
	public InitializeUserCircle() {
		if (WorkObject.em == null) {
			WorkObject.em = Persistence.createEntityManagerFactory("JUNE")
					.createEntityManager();
		}
		List<UserCircle> values = null;
		String strSql = "select userCircle from UserCircle userCircle";
		synchronized (WorkObject.em) {
			values = WorkObject.em.createQuery(strSql).getResultList();
		}
		if (values.isEmpty()) {
			synchronized (WorkObject.em) {
			try {
				WorkObject.em.getTransaction().begin();
				UserCircle uc;
				WorkObject.em.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				WorkObject.em.getTransaction().rollback();
			}
			
			}
		}
	}

}
