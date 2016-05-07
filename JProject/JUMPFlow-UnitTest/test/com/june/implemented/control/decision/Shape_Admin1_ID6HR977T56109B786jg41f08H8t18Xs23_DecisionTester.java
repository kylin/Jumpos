package com.june.implemented.control.decision;

import com.june.implemented.common.application.Process;
import com.june.implemented.common.application.WorkObjectImpl;
import com.june.implemented.common.authentication.User;

public class Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_DecisionTester
		extends AbstractDecisionTester<Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_Decision> {


	@Override
	protected void setTestData(
			Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_Decision decision) {
		
		decision.getPageOutput().setYonghuming16748("aaa");
		
//		System.out.println(decision.perform());
//		System.out.println(decision.getUserInput().getYonghuming16748());
	}

	@Override
	protected Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_Decision newDecisionInstance(
			WorkObjectImpl workObjectImpl, User user, Process process) {
		return  new Shape_Admin1_ID6HR977T56109B786jg41f08H8t18Xs23_Decision(
				workObjectImpl, user, process);
	}

}
