package com.june.common.control;

import com.june.common.api.WorkObject;

public interface Decision {
	 String getName();
	 void setOwner(WorkObject wo);
	 boolean perform();
}
