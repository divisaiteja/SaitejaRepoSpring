package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.ChartsDao;
import com.hrms.dtos.ChartsDTO;
import com.hrms.dtos.HrMusterDTO;

@Service
public class ChartsServicesImpl implements ChartsServices {

	@Autowired
	ChartsDao chartsDao;

	@Override
	public List<ChartsDTO> getBarGraphsOnDivisons() {
		return chartsDao.getBarGraphsOnDivisons();
	}

	@Override
	public List<ChartsDTO> getDivisionBarGraphs() {
		return chartsDao.getDivisionBarGraphs();
	}

	@Override
	public List<ChartsDTO> getAbsentsBasedOnDivision(String date) {
		
		return chartsDao.getAbsentsBasedOnDivision(date);
	}

}
