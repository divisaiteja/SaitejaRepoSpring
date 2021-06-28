package com.hrms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.PersonalDetailsDTO;
import com.hrms.service.PersonalDetailsService;

@Controller
public class PersonalDetailsController {
	@Autowired
	private PersonalDetailsService personalDetailsService;

	@RequestMapping(value = "personalInformation", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView displyPage() {
		return new ModelAndView("PersonalInformation");
	}

	@RequestMapping(value = "getpersonalInfoByParentid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<PersonalDetailsDTO> getExperienceInfoByParentid(@RequestParam(value = "parentid") int parentid) {
		List<PersonalDetailsDTO> getpersonalInfoByTranid = personalDetailsService.getpersonalInfoByParentid(parentid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(getpersonalInfoByTranid);
		response.setSuccessMessage("storedsucessfully");
		return getpersonalInfoByTranid;
	}

	@RequestMapping(value = "editPersonaldetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editEmployee(@RequestBody PersonalDetailsDTO personalDetailsDTO) {
		String displayMessage = personalDetailsService.editPersonalDetails(personalDetailsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;

	}
	@RequestMapping(value = "getAllCity", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<Object, Object>> getAllCity() {
		 List<Map<Object, Object>> allCity = personalDetailsService.getAllCity();
		return allCity  ;
	}
	
	@RequestMapping(value = "getAllDistrict", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<Object, Object>> getAllDistrict() {
		 List<Map<Object, Object>> getAllDistrict = personalDetailsService.getAllDistrict();
		return getAllDistrict   ;
	}

}
