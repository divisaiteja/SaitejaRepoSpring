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
import com.hrms.dtos.ContractorMasterDTO;
import com.hrms.service.ContractorService;

@Controller
public class ContractController {
	@Autowired
	private ContractorService contractorservice;

	@RequestMapping(value = "contractor", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView Contractor() {

		return new ModelAndView("contractor");
	}

	// for division list page
	@RequestMapping(value = "getAllContractors", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllContracts() {
		List<ContractorMasterDTO> list = contractorservice.getAllContracts();
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(list);
		return response;

	}

	@RequestMapping(value = "saveNewContractor", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveNewContractor(@RequestBody ContractorMasterDTO contractorMasterDTO) {
		String saveNewContractor = contractorservice.saveNewContractor(contractorMasterDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(saveNewContractor);
		return response;

	}

	// for edit the division
	@RequestMapping(value = "editContractor", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editContractor(@RequestBody ContractorMasterDTO contractorMasterDTO) {
		String editContractor = contractorservice.editContractor(contractorMasterDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(editContractor);
		return response;

	}

	// for division deletion
	@RequestMapping(value = "deleteContractor", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteContractor(@RequestParam("contractorId") int contractorId) {
		contractorservice.deleteContractor(contractorId);

	}

	@RequestMapping(value = "getContractor", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ContractorMasterDTO> getContractor(@RequestParam(value = "contractorId") int contractorId) {
		List<ContractorMasterDTO> getContractorById = contractorservice.getContractor(contractorId);
		return getContractorById;
	}
}
