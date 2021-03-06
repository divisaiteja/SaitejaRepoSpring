package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.ProfessionalTaxesDTO;
import com.hrms.dtos.SettingDTO;
import com.hrms.dtos.StandardDeductionsDTO;
import com.hrms.service.SettingService;

@Controller
public class SettingController {
     
	@Autowired
	private SettingService settingService;
	
	@RequestMapping(value = "setting", method = RequestMethod.GET)
	public ModelAndView hrrepoter() {
		return new ModelAndView("Setting");
	}
	
	@RequestMapping(value = "getAllSetting", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllSetting(@RequestParam(value="division") int divisionid) {
		BaseResponseDTO response = new BaseResponseDTO();
		List<SettingDTO> allSetting = settingService.getAllSetting(divisionid);
		response.setDataBean(allSetting);
		return response  ;
	}
	
	@RequestMapping(value = "getAllProfessionalTax", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllProfessionalTax(ProfessionalTaxesDTO professionalTaxesDTO) {
		BaseResponseDTO response = new BaseResponseDTO();
		List<ProfessionalTaxesDTO> allProfessionalTax = settingService.getAllProfessionalTax(professionalTaxesDTO);
		response.setDataBean(allProfessionalTax);
		return response  ;
	}
	@RequestMapping(value = "getProfessionalTaxInformationByTranId", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ProfessionalTaxesDTO> getProfessionalTaxInformationByTranId(@RequestParam(value="tranId") int tranId) {
		BaseResponseDTO response = new BaseResponseDTO();
		 List<ProfessionalTaxesDTO> allProfessionalTaxByTranId = settingService.getAllProfessionalTaxByTranId(tranId);
		response.setDataBean(allProfessionalTaxByTranId);
		return allProfessionalTaxByTranId  ;
	}

	@RequestMapping(value = "editProfessionalTax", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editProfessionalTax(@RequestBody ProfessionalTaxesDTO professionalTaxesDTO) {
        settingService.editProfessionalTax(professionalTaxesDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage("EditedSucessfully");
		return response ; 

	}
@RequestMapping(value = "settingEdit", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO settingEdit(@RequestBody SettingDTO settingDTO) {
		settingService.editSetting(settingDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage("EditedSucessfully");
		return response ; 

	}
	
	
}
