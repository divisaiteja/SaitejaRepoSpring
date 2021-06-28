package com.hrms.Dao;

import java.util.List;
import java.util.Map;

public interface MonthlyAttendenceDao {

	public List<Map<Object, Object>> getMonthlyAttendence(int project, int division, int year, int month,
			String fromdate, String todate);

	public List<Object> getDateAndDayName(String fromdate, String todate);
	
	
	public List<Object> GetCCount(int project,int division,String fromdate, String todate);
}
