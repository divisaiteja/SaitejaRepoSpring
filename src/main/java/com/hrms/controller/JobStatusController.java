package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.JobStatusDTO;
import com.hrms.service.JobStatusService;

@Controller
public class JobStatusController {
	@Autowired
	private JobStatusService jobStatusService;

	@RequestMapping(value = "jobstatus", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView Jobstatus() {

		return new ModelAndView("jobStatus");
	}

	@RequestMapping(value = "getjobStatus", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<JobStatusDTO> getJobTypeByTranid(@RequestParam(value = "jobstatusid") int jobstatusid, ModelMap map) {
		List<JobStatusDTO> jobtypebyTranid = jobStatusService.getJobStatusByStatusId(jobstatusid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(jobtypebyTranid);
		response.setSuccessMessage("storedsucessfully");
		return jobtypebyTranid;

	}

	@RequestMapping(value = "getjobstatus", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllJobs() {
		List<JobStatusDTO> jobList = jobStatusService.getAllJobs();
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(jobList);
		return response;

	}

	@RequestMapping(value = "editJobstatus", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editJobs(@RequestBody JobStatusDTO jobstatusDTO) {
		String editJobs = jobStatusService.editJobs(jobstatusDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(editJobs);
		return response;

	}

	@RequestMapping(value = "deleteJobstatus", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteJob(@RequestParam("jobstatusid") int jobstatusid) {
		jobStatusService.deleteJob(jobstatusid);

	}

	@RequestMapping(value = "saveNewjobstatus", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveJobStatus(@RequestBody JobStatusDTO jobstatusDTO) {
		String saveNewJob = jobStatusService.saveNewJob(jobstatusDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(saveNewJob);
		return response;

	}
}
