package com.hrms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.MonthlyAttendenceDao;

@Service
public class MonthlyAttendenceServiceImpl implements MonthlyAttendenceService {

	@Autowired
	private MonthlyAttendenceDao monthlyAttendenceDao;
	@Override
	public List<Map<Object, Object>> getMonthlyAttendence(int project,int division,int year,int month ,String fromdate,String todate) {
		return monthlyAttendenceDao.getMonthlyAttendence( project, division, year,month,fromdate,todate);
	}
	@Override
	public List<Object> getDateAndDayName(String fromdate, String todate) {
		
		return monthlyAttendenceDao.getDateAndDayName(fromdate, todate);
	}
	@Override
	public List<Object> GetCCount(int project,int division,String fromdate, String todate) {
		
		return monthlyAttendenceDao. GetCCount(project, division,fromdate, todate);
	}

}
