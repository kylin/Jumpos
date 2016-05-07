package com.june.implemented.control.decision;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import junit.framework.TestCase;

import com.june.common.control.Decision;
import com.june.implemented.common.application.Admin1WorkData;
import com.june.implemented.common.application.Process;
import com.june.implemented.common.application.WorkObjectImpl;
import com.june.implemented.common.authentication.User;

abstract public class AbstractDecisionTester<T extends Decision> extends
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

	abstract protected void setTestData(T decision);

	abstract protected T newDecisionInstance(WorkObjectImpl workObjectImpl,
			User user, Process process);

	public void testPerform() {

		T decision = newDecisionInstance(testWO, testUser, testProcess);

		setTestData(decision);

		try {
			boolean result = decision.perform();

			if (PropertyUtils.isReadable(decision, "pageOutput")) {
				Object pageOut = PropertyUtils.getProperty(decision,
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

			System.out.println(decision.getName()
					+ "执行结果 : " + result);

			if (PropertyUtils.isReadable(decision, "userInput")) {
				Object pageOut = PropertyUtils.getProperty(decision,
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
