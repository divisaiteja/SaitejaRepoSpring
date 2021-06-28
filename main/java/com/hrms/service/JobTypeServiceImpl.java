package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.JobTypeDao;
import com.hrms.dtos.JobTypeDTO;

@Service
public class JobTypeServiceImpl implements JobTypeService {
	@Autowired
	private JobTypeDao jobTypeDao;

	@Override
	public List<JobTypeDTO> getAllJobTypes() {
		return jobTypeDao.getAllJobTypes();
	}

	public List<JobTypeDTO> getJobTypeByTranid(int tranid) {
		
		return jobTypeDao.getJobTypeByTranid(tranid);
	}

	public String editJobType(JobTypeDTO jobtypedto) {
		return jobTypeDao.editJobType(jobtypedto);
		
	}

	public void deleteJobType(int tranid) {
		jobTypeDao.deleteJobType(tranid);
	}

	public String saveNewJobType(JobTypeDTO jobTypeDto) {
		return jobTypeDao.saveNewJobType(jobTypeDto);
	}
	

}
