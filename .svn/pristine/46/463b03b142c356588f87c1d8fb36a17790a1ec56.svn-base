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

import com.hrms.dtos.BankMasterDTO;
import com.hrms.dtos.BaseResponseDTO;
import com.hrms.service.BankMasterService;

@Controller
public class BankMasterController {
	@Autowired
	private BankMasterService bankMasterService;

	@RequestMapping(value = "bankmaster", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getBankmaster() {

		return new ModelAndView("BankMaster");

	}

	@RequestMapping(value = "savebank", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO savebank(@RequestBody BankMasterDTO bankMasterDTO) {
		String saveBankMaster = bankMasterService.saveBankMaster(bankMasterDTO);
		BaseResponseDTO dto = new BaseResponseDTO();
		dto.setSuccessMessage(saveBankMaster);
		return dto;
	}

	@RequestMapping(value = "getAllBankMaster", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllBankMaster() {
		List<BankMasterDTO> allBankMaster = bankMasterService.getAllBankMaster();
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(allBankMaster);
		return response;
	}

	@RequestMapping(value = "deletebank", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteFamilyDetails(@RequestParam("tranid") int tranid) {
		bankMasterService.deleteBankMaster(tranid);

	}

	@RequestMapping(value = "getAllBankByTranid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<BankMasterDTO> getAllBankByTranid(@RequestParam("tranid") int tranid) {
		List<BankMasterDTO> bankMasterByTranId = bankMasterService.getBankMasterByTranId(tranid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(bankMasterByTranId);
		response.setSuccessMessage("storedsucessfully");
		return bankMasterByTranId;
	}

	@RequestMapping(value = "editBankMaster", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editBankMaster(@RequestBody BankMasterDTO bankMasterDTO) {
		String editBankMaster = bankMasterService.editBankMaster(bankMasterDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(editBankMaster);
		return response;

	}
}
