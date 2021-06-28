package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.PaySheetDao;
import com.hrms.dtos.EmployeeMonthPay;

@Service
public class PaySheetServiceImpl implements PaySheetService {

	@Autowired
	PaySheetDao paySheetDao;

	@Override
	public List<EmployeeMonthPay> paysheetcaluculation(int division, int tmonth, int tyear) {
		return paySheetDao.paysheetcaluculation(division, tmonth, tyear);
	}

}
