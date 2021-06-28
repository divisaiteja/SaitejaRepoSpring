package com.hrms.Dao;

import java.util.List;
import java.util.Map;

public interface SalaryStatementDao {
	
	public List<Map<Object,Object>> getsalarystatement(int division,int project,int month,int year);

}
