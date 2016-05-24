package com.june.implemented.common.util;

import java.util.List;

import com.june.implemented.common.application.WorkObjectImpl;
import com.june.implemented.common.function.ActivityCount;

public class RunActivityCount {
	public static void invoke(long flowId,String nodeid){
		List<ActivityCount> values = null;
		String Sql = "select ac from ActivityCount ac where ac.flowId = "+flowId+" and ac.nodeid = '"+nodeid+"'";
		synchronized (WorkObjectImpl.em) {
			values = WorkObjectImpl.em.createQuery(Sql).getResultList();
		}
		ActivityCount ac;
		if(values == null || values.isEmpty()){
			ac = new ActivityCount();
			ac.setCount(1);
			ac.setFlowId(flowId);
			ac.setNodeid(nodeid);
			synchronized (WorkObjectImpl.em) {
				try {
					WorkObjectImpl.em.getTransaction().begin();
					WorkObjectImpl.em.persist(ac);
					WorkObjectImpl.em.getTransaction().commit();
				} catch (Exception e) {
					WorkObjectImpl.em.getTransaction().rollback();
					e.printStackTrace();
				}
			}
		}else{
			ac = values.get(0);
			ac.setCount(ac.getCount()+1);
			synchronized (WorkObjectImpl.em) {
				try {
					WorkObjectImpl.em.getTransaction().begin();
					WorkObjectImpl.em.merge(ac);
					WorkObjectImpl.em.flush();
					WorkObjectImpl.em.getTransaction().commit();
				} catch (Exception e) {
					WorkObjectImpl.em.getTransaction().rollback();
					e.printStackTrace();
				}
			}
		}
	}
	
	public static int getCount(long flowId,String nodeid){
		List<ActivityCount> values = null;
		int ret = 0;
		String Sql = "select ac from ActivityCount ac where ac.flowId = "+flowId+" and ac.nodeid = '"+nodeid+"'";
		synchronized (WorkObjectImpl.em) {
			values = WorkObjectImpl.em.createQuery(Sql).getResultList();
		}
		if(values != null && !values.isEmpty()){
			ret = values.get(0).getCount();
		}
		return ret;
	}
	
	
}
