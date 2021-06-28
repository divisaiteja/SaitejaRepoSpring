package com.hrms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.Cm_frequency_MasterDao;
@Service
public class Cm_frequency_MasterServiceImpl implements Cm_frequency_MasterService {

	@Autowired
	private Cm_frequency_MasterDao cm_frequency_MasterDao;
	@Override
	public List<Map<Object, Object>> getAllfrequencydropdown() {
		
		return cm_frequency_MasterDao.getAllfrequencydropdown();
	}

}
