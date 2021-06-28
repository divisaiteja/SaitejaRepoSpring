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
import com.hrms.dtos.FamilyDetailsDTO;
import com.hrms.service.FamilyDetailsService;

@Controller
public class FamilyDetailsController {
	@Autowired
	private FamilyDetailsService familyDetailsService;

	@RequestMapping(value = "getFamilyInformation", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllEmployees(@RequestParam("parentid") int parentid) {
		List<FamilyDetailsDTO> allFamilyDetails = familyDetailsService.getAllFamilyDetails(parentid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(allFamilyDetails);
		return response;

	}

	@RequestMapping(value = "saveFamilyDetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveExperienceDetails(@RequestBody FamilyDetailsDTO familyDetailsDTO) {
		BaseResponseDTO response = new BaseResponseDTO();
		String displayMessage = familyDetailsService.saveFamilyDetails(familyDetailsDTO);
		response.setSuccessMessage(displayMessage);
		return response;

	}

	@RequestMapping(value = "deleteFamilyDetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteFamilyDetails(@RequestParam("tranid") int tranid) {
		familyDetailsService.deleteFamilyDetails(tranid);

	}

	@RequestMapping(value = "editFamilydetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editFamily(@RequestBody FamilyDetailsDTO familyDetailsDTO) {
		String displayMessage = familyDetailsService.editFamilyDetails(familyDetailsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;

	}

	@RequestMapping(value = "getFamilyInfoByTranid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<FamilyDetailsDTO> getFamilyInfoByTranid(@RequestParam(value = "tranid") int tranid) {
		List<FamilyDetailsDTO> familyInfoByTranid = familyDetailsService.getFamilyInfoByTranid(tranid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(familyInfoByTranid);
		response.setSuccessMessage("storedsucessfully");
		return familyInfoByTranid;
	}

}
