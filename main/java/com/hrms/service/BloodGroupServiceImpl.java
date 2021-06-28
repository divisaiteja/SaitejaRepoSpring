package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.BloodGroupDao;
import com.hrms.Dao.JobStatusDao;
import com.hrms.dtos.BloodGroupDTO;
import com.hrms.dtos.JobStatusDTO;
@Service
public class BloodGroupServiceImpl implements BloodGroupService {
	@Autowired
	private BloodGroupDao dao;

	@Override
	public List<BloodGroupDTO> getAllBgroup() {
		return dao.getAllBgroups();
	}

	@Override
	public void editBgroup(BloodGroupDTO bgroupDTO) {
		this.dao.editBgroup(bgroupDTO);
		
	}

	@Override
	public void deleteBgroup(Integer tranid) {
		dao.deleteBgroup(tranid);
		
	}

	@Override
	public void saveNewBgroup(BloodGroupDTO bgroupDTO) {
	 dao.saveNewBgroup(bgroupDTO);
		
	}

}
