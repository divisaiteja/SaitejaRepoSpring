package com.hrms.service;

import java.util.List;

import com.hrms.dtos.JobStatusDTO;

public interface JobStatusService {
	
	public List<JobStatusDTO> getAllJobs();

	public String editJobs(JobStatusDTO jobstatusDTO);

	public void deleteJob(Integer jobstatusid);

	public String saveNewJob(JobStatusDTO jobstatusDTO);

	public List<JobStatusDTO> getJobStatusByStatusId(int jobstatusid);

}
