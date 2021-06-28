package com.hrms.Dao;

import java.util.List;

import com.hrms.dtos.JobTypeDTO;


public interface JobTypeDao {
	public List<JobTypeDTO> getAllJobTypes();

	public List<JobTypeDTO> getJobTypeByTranid(int tranid);

	public String editJobType(JobTypeDTO jobtypedto);

	public void deleteJobType(int tranid);

	public String saveNewJobType(JobTypeDTO jobTypeDto);

}
