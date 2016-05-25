package com.june.implemented.control.decision;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import junit.framework.TestCase;

import com.june.common.control.Activity;
import com.june.implemented.common.application.Admin1WorkData;
import com.june.implemented.common.application.Process;
import com.june.implemented.common.application.WorkObjectImpl;
import com.june.implemented.common.authentication.User;

abstract public class AbstractActivityTester<T extends Activity> extends
		TestCase {

	private WorkObjectImpl testWO = new WorkObjectImpl();

	private Admin1WorkData testWD = new Admin1WorkData();

	private User testUser = new User();

	private Process testProcess = new Process();

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		testWO.setWorkDataInstance(testWD);
		testProcess.setActiveWorkObject(testWO);
		testProcess.setUser(testUser);
	}

	abstract protected void setTestData(T activity);

	abstract protected T newActivityInstance(WorkObjectImpl workObjectImpl,
			User user, Process process);

	public void testPerform() {

		T activity = newActivityInstance(testWO, testUser, testProcess);

		setTestData(activity);

		try {
			String result = activity.perform();

			if (PropertyUtils.isReadable(activity, "pageOutput")) {
				Object pageOut = PropertyUtils.getProperty(activity,
						"pageOutput");
				System.out.println("------------pageOutput数据-------------");

				Map<String, Object> valueMap = BeanUtils.describe(pageOut);

				for (Iterator<String> iterator = valueMap.keySet().iterator(); iterator
						.hasNext();) {
					String key = iterator.next();

					System.out.println(key + " = " + valueMap.get(key));

				}
				
				System.out.println("----------------------------------------");

			}

			System.out.println(activity.getName()
					+ "执行结果 : " + result);

			if (PropertyUtils.isReadable(activity, "userInput")) {
				Object pageOut = PropertyUtils.getProperty(activity,
						"userInput");
				System.out.println("------------userInput数据---------------");

				Map<String, Object> valueMap = BeanUtils.describe(pageOut);

				for (Iterator<String> iterator = valueMap.keySet().iterator(); iterator
						.hasNext();) {
					String key = iterator.next();

					System.out.println(key + " = " + valueMap.get(key));

				}

				System.out.println("----------------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}
}
