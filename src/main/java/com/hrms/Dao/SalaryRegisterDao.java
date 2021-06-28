package com.hrms.Dao;

import java.util.List;
import java.util.Map;

public interface SalaryRegisterDao {
	
	public List<Map<Object,Object>> GetSalaryRegister(int year,int month);

}
