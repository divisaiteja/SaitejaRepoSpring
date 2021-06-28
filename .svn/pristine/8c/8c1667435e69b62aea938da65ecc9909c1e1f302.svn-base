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
import com.hrms.dtos.EducationDetailsDTO;
import com.hrms.service.EducationDetailsService;

@Controller
public class EducationDetailsController {
	@Autowired
	private EducationDetailsService educationDetailsService;

	@RequestMapping(value = "getEducationInformation", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllEducationDetails(@RequestParam("parentid") int parentid) {
		List<EducationDetailsDTO> allEducationDetails = educationDetailsService.getAllEducationDetails(parentid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(allEducationDetails);
		return response;

	}

	@RequestMapping(value = "saveEducationDetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveEducationDetails(@RequestBody EducationDetailsDTO educationDetailsDTO) {
		BaseResponseDTO response = new BaseResponseDTO();
		String displayMessage=educationDetailsService.saveEducationDetails(educationDetailsDTO);
		response.setSuccessMessage(displayMessage);
		return response;

	}

	@RequestMapping(value = "editEducationdetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editEmployee(@RequestBody EducationDetailsDTO educationDetailsDTO) {
		String displayMessage=educationDetailsService.editEducationDetails(educationDetailsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;

	}

	@RequestMapping(value = "deleteEducationDetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteEducationDetails(@RequestParam("tranid") int tranid) {
        educationDetailsService.deleteEducationDetails(tranid);

	}

	@RequestMapping(value = "getEducationInfoByTranid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<EducationDetailsDTO> getEducationInfoByTranid(@RequestParam(value = "tranid") int tranid) {
        List<EducationDetailsDTO> educationInfoByTranid = educationDetailsService.getEducationInfoByTranid(tranid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(educationInfoByTranid);
		response.setSuccessMessage("storedsucessfully");
        return educationInfoByTranid;
	}

}
