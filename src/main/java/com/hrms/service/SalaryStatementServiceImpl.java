package com.hrms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.SalaryStatementDao;

@Service
public class SalaryStatementServiceImpl implements SalaryStatementService {

	@Autowired
	private SalaryStatementDao salaryStatementDao;

	@Override
	public List<Map<Object, Object>> getsalarystatement(int division, int project,int month,int year) {
		return salaryStatementDao.getsalarystatement(division, project, month, year);
	}

}
