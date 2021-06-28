package com.hrms.service;

import java.util.List;
import java.util.Map;

public interface SalaryStatementService {
	
	public List<Map<Object,Object>> getsalarystatement(int division,int project,int month,int year);

}
