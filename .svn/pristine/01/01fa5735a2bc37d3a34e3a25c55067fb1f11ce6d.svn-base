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
import com.hrms.dtos.GradeListDTO;
import com.hrms.dtos.JobTypeDTO;
import com.hrms.dtos.StandardPayDetectionsDTO;
import com.hrms.service.JobTypeServiceImpl;

@Controller
public class JobTypeController {
	@Autowired
	private JobTypeServiceImpl jobTypeService;

	@RequestMapping(value = "jobtype", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView JobType() {

		return new ModelAndView("jobType");
	}

	@RequestMapping(value = "getjobtype", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllJobTypes() {
		List<JobTypeDTO> jobtype = jobTypeService.getAllJobTypes();
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(jobtype);
		return response;

	}

	@RequestMapping(value = "getjobType", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<JobTypeDTO> getJobTypeByTranid(@RequestParam(value = "tranid") int tranid, ModelMap map) {
		List<JobTypeDTO> jobtypebyTranid = jobTypeService.getJobTypeByTranid(tranid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(jobtypebyTranid);
		response.setSuccessMessage("storedsucessfully");
		return jobtypebyTranid;

	}

	@RequestMapping(value = "editJobType", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editJobType(@RequestBody JobTypeDTO jobTypeDto) {
		String editJobType = jobTypeService.editJobType(jobTypeDto);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(editJobType);
		return response;

	}

	@RequestMapping(value = "deletejobtype", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteJobType(@RequestParam("tranid") int tranid) {
		jobTypeService.deleteJobType(tranid);

	}

	@RequestMapping(value = "saveJobType", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveJobType(@RequestBody JobTypeDTO jobTypeDto) {
		String saveNewJobType = jobTypeService.saveNewJobType(jobTypeDto);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(saveNewJobType);
		return response;

	}

}
