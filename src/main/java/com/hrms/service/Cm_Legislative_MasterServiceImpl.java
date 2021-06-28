package com.hrms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.Cm_Legislative_MasterDao;
@Service
public class Cm_Legislative_MasterServiceImpl implements Cm_Legislative_MasterService {

	
	@Autowired
	private Cm_Legislative_MasterDao  cm_Legislative_MasterDao;
	
	@Override
	public List<Map<Object, Object>> getAllLegislativedropdown() {
		
		return cm_Legislative_MasterDao.getAllLegislativedropdown();
	}

}
