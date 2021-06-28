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
import com.hrms.dtos.SalaryDetailsDTO;
import com.hrms.service.SalaryDetailsService;

@Controller
public class SalaryDetailsController {

	@Autowired
	private SalaryDetailsService salaryDetailsService;

	@RequestMapping(value = "getsalaryInfoByTranid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<SalaryDetailsDTO> getsalaryInfoByTranid(@RequestParam(value = "parentid") int parentid) {
		List<SalaryDetailsDTO> salaryInfoByTranid = salaryDetailsService.getSalaryInfoByTranid(parentid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(salaryInfoByTranid);
		response.setSuccessMessage("storedsucessfully");
		return salaryInfoByTranid;
	}

	@RequestMapping(value = "editSalarydetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editEmployeeSalaryDetails(@RequestBody SalaryDetailsDTO salaryDetailsDTO) {
		salaryDetailsService.editSalaryDetails(salaryDetailsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage("EditedSucessfully");
		return response;

	}
}
