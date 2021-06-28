package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.JobStatusDao;
import com.hrms.dtos.JobStatusDTO;
@Service
public class JobStatusServiceImpl implements JobStatusService {
	@Autowired
	private JobStatusDao jobStatusDao;

	@Override
	public List<JobStatusDTO> getAllJobs() {
		return jobStatusDao.getAllJobs();
	}

	@Override
	public String editJobs(JobStatusDTO jobstatusDTO) {
		 return jobStatusDao.editJobs(jobstatusDTO);
		
	}

	@Override
	public void deleteJob(Integer jobstatusid) {
		jobStatusDao.deleteJob(jobstatusid);
		
	}

	@Override
	public String saveNewJob(JobStatusDTO jobstatusDTO) {
	 return jobStatusDao.saveNewJob(jobstatusDTO);
		
	}

	@Override
	public List<JobStatusDTO> getJobStatusByStatusId(int jobstatusid) {
		
		return jobStatusDao.getJobStatusByStatusId(jobstatusid);
	}

}
