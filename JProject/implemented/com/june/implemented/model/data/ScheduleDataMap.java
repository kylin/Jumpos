package com.june.implemented.model.data;

import java.util.HashMap;
import java.util.Map;

/*
 * scheduleid与data相匹配
 */
public class ScheduleDataMap {
	private static Map<String, String> scheduleData = new HashMap<String, String>();

	public static Map<String, String> getScheduleData() {
		return scheduleData;
	}

	public static void setScheduleData(Map<String, String> scheduleData) {
		ScheduleDataMap.scheduleData = scheduleData;
	}
	
	public static void addScheduleData(String data, String id) {
		scheduleData.put(data, id);
	}
	
	
}
