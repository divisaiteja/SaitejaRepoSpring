package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.StandardDeductionDao;
import com.hrms.dtos.StandardDeductionsDTO;

@Service
public class StandarDeductionServiceImpl implements StandarDeductionService {
	@Autowired
	private StandardDeductionDao standardDeductionDao;

	@Override
	public List<StandardDeductionsDTO> getAllStandardDeductions() {

		return standardDeductionDao.getAllStandardDeductions();
	}

}
