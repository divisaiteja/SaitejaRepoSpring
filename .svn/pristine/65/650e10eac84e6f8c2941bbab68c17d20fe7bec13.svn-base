package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.ChartsDao;
import com.hrms.dtos.ChartsDTO;

@Service
public class ChartsServicesImpl implements ChartsServices {

	@Autowired
	ChartsDao chartsDao;
	
	@Override
	public List<ChartsDTO> getBarGraphsOnDivisons() {
		// TODO Auto-generated method stub
		return chartsDao.getBarGraphsOnDivisons();
	}

}
