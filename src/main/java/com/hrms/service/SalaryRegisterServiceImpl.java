package com.hrms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.SalaryRegisterDao;

@Service
public class SalaryRegisterServiceImpl implements SalaryRegisterService {

	@Autowired
	private SalaryRegisterDao salaryRegisterDao;
	@Override
	public List<Map<Object, Object>> GetSalaryRegister(int year,int month) {
		
		return salaryRegisterDao.GetSalaryRegister(year,month);
	}

}
