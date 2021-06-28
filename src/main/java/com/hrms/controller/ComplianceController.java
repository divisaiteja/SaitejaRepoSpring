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
import com.hrms.dtos.ComplianceDTO;
import com.hrms.service.ComplianceService;
@Controller
public class ComplianceController {
	
	@Autowired
	private ComplianceService complianceService;

	@RequestMapping(value = "compliance", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView Cadre() {
		return new ModelAndView("compliance");
	}
	@RequestMapping(value = "getAllCompliance", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllCompliance() {
     List<ComplianceDTO> allCompliance = complianceService.getAllCompliance();
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(allCompliance);
		return response;
	}
	@RequestMapping(value = "complianceByComplianceid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ComplianceDTO> complianceByComplianceid(@RequestParam(value = "complianceid") int complianceid) {
		  List<ComplianceDTO> complianceByComplianceid = complianceService.getComplianceByComplianceid(complianceid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(complianceByComplianceid);
		response.setSuccessMessage("storedsucessfully");
		return complianceByComplianceid   ;

	}

	@RequestMapping(value = "editCompliance", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editCompliance(@RequestBody ComplianceDTO complianceDTO) {
		String editCompliance = complianceService.editCompliance(complianceDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(editCompliance);
		return response;

	}

	@RequestMapping(value = "deleteCompliance", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteCompliance(@RequestParam("complianceid") int complianceid) {
		complianceService.deleteCompliance(complianceid);

	}

	@RequestMapping(value = "saveNewCompliance", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveNewCompliance(@RequestBody ComplianceDTO complianceDTO) {
		 String saveNewCompliance = complianceService.saveNewCompliance(complianceDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(saveNewCompliance);
		return response;

	}
	
	@RequestMapping(value = "generateTransaction", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void generateTransaction() {
		complianceService.generateTransaction();

	}
	
	@RequestMapping(value = "getownernames", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public  List<Map<Object, Object>> getownernames() {
		 List<Map<Object, Object>> ownername = complianceService.getOwnername();
		return ownername;

	}
	
}
