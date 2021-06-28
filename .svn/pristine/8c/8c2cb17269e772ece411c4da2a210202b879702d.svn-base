package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.ExperienceDetailsDTO;
import com.hrms.service.ExperienceDetailsService;

@Controller
public class ExperienceDetailsController {
	@Autowired
	private ExperienceDetailsService service;

	@RequestMapping(value = "getExperienceInformation", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllExperienceInformation(@RequestParam("parentid") int parentid) {
		List<ExperienceDetailsDTO> empList = service.getAllExperienceDetails(parentid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(empList);
        return response;

	}

	@RequestMapping(value = "saveExperienceDetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveExperienceDetails(@RequestBody ExperienceDetailsDTO experienceDetailsDTO) {
		BaseResponseDTO response = new BaseResponseDTO();
		String displayMessage=service.saveExperienceDetails(experienceDetailsDTO);
		response.setSuccessMessage(displayMessage);
		return response;

	}

	@RequestMapping(value = "editExperiencedetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editEmployee(@RequestBody ExperienceDetailsDTO experienceDetailsDTO) {
		String displayMessage=service.editExperienceDetails(experienceDetailsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;

	}

	@RequestMapping(value = "deleteExperienceDetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteExperienceDetails(@RequestParam("tranid") int tranid) {

		service.deleteExperienceDetails(tranid);

	}

	@RequestMapping(value = "getExperienceInfoByTranid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ExperienceDetailsDTO> getExperienceInfoByTranid(@RequestParam(value = "tranid") int tranid) {
        List<ExperienceDetailsDTO> experienceInfoByTranid = service.getExperienceInfoByTranid(tranid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(experienceInfoByTranid);
		response.setSuccessMessage("storedsucessfully");
        return experienceInfoByTranid;
	}

}
