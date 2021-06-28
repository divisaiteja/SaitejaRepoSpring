package com.hrms.controller;

import java.util.ArrayList;
import java.util.Calendar;
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
import com.hrms.dtos.OthersDetailsDTO;
import com.hrms.dtos.SalaryDeductionsDTO;
import com.hrms.dtos.StandardDeductionsDTO;
import com.hrms.dtos.StandardPayDetectionsDTO;
import com.hrms.service.SalaryDeductionsService;
import com.hrms.service.StandarDeductionService;

@Controller
public class SalaryDeductionsController {
	@Autowired
	private SalaryDeductionsService salaryDeductionsService;
	@Autowired
	private StandarDeductionService standarDeductionService;

	@RequestMapping(value = "salaryDeductions", method = RequestMethod.GET)
	public ModelAndView salaryDeductions() {
		return new ModelAndView("SalaryDeductionsView");
	}

	@RequestMapping(value = "getSalaryDeductionInformation", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllSalaryDeductions(@RequestParam("division") int division,
			@RequestParam("tmonth") int tmonth, @RequestParam("tyear") int tyear,
			@RequestParam("project") int project) {

		List<SalaryDeductionsDTO> allSalaryDeductionsDetails = salaryDeductionsService
				.getAllSalaryDeductionsDetails(division, tmonth, tyear, project);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(allSalaryDeductionsDetails);
		return response;

	}

	@RequestMapping(value = "editSalaryDeductions", method = RequestMethod.POST, produces = "application/json")

	@ResponseBody
	public BaseResponseDTO editSalaryDeductions(@RequestBody SalaryDeductionsDTO salaryDeductionsDTO) {
		String editSalaryDeductions = salaryDeductionsService.editSalaryDeductions(salaryDeductionsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(editSalaryDeductions);
		return response;

	}

	@RequestMapping(value = "getSalaryDeductionInformationByIdno", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<SalaryDeductionsDTO> getSalaryDeductionInformationByIdno(@RequestParam(value = "tranid") int tranid,
			ModelMap map) {

		List<SalaryDeductionsDTO> salaryDeductionsDetailsInfoByIdno = salaryDeductionsService
				.getSalaryDeductionsDetailsInfoByIdno(tranid);

		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(salaryDeductionsDetailsInfoByIdno);
		response.setSuccessMessage("storedsucessfully");

		return salaryDeductionsDetailsInfoByIdno;
	}

	@RequestMapping(value = "getallStandardDeductions", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<StandardDeductionsDTO> getallStandardDeductions() {
		List<StandardDeductionsDTO> allStandardDeductions = standarDeductionService.getAllStandardDeductions();
		return allStandardDeductions;

	}

	@RequestMapping(value = "getStandardDeductionInformation", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getStandardDeductionInformation(
			@RequestParam(value = "standardDeductionFieldId") int standardDeductionFieldId,
			@RequestParam(value = "divisionid") int divisionid, @RequestParam(value = "standardproject") int project) {
		List<StandardPayDetectionsDTO> standardPayDetectionsDTOList = salaryDeductionsService
				.getStandardDeductionInformation(standardDeductionFieldId, divisionid, project);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(standardPayDetectionsDTOList);
		return response;

	}

	@RequestMapping(value = "getStandardDeductionInformationByIdno", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<StandardPayDetectionsDTO> getStandardDeductionInformationByIdno(
			@RequestParam(value = "tranid") int tranid,

			ModelMap map) {

		List<StandardPayDetectionsDTO> standardDeductionsDetailsInfoByIdno = salaryDeductionsService
				.getStandardDeductionsDetailsInfoByIdno(tranid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(standardDeductionsDetailsInfoByIdno);
		return standardDeductionsDetailsInfoByIdno;

	}

	@RequestMapping(value = "editStandardDeductions", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editStandardDeductions(@RequestBody StandardPayDetectionsDTO standardPayDetectionsDTO) {
		String editStandardDeductions = salaryDeductionsService.editStandardDeductions(standardPayDetectionsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(editStandardDeductions);
		return response;

	}

	@RequestMapping(value = "saveNewStandardDeductions", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveSection(@RequestBody StandardPayDetectionsDTO standardPayDetectionsDTO) {
		String saveStandardDeductions = salaryDeductionsService.saveStandardDeductions(standardPayDetectionsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(saveStandardDeductions);
		return response;

	}

	@RequestMapping(value = "getCandPMonths", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<OthersDetailsDTO> editStandardDeductions() {
		String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		Calendar cal = Calendar.getInstance();
		String currentmonthName = monthName[cal.get(Calendar.MONTH)];
		String prevMonthName = "";
		if (cal.get(Calendar.MONTH) == 0) {
			prevMonthName = monthName[11];
		} else {
			prevMonthName = monthName[cal.get(Calendar.MONTH) - 1];
		}
		int currentmonthid = cal.get(Calendar.MONTH) + 1;
		int prevmonthid = 0;
		if (cal.get(Calendar.MONTH) == 0) {
			prevmonthid = 12;

		} else {
			prevmonthid = cal.get(Calendar.MONTH);
		}
		List<OthersDetailsDTO> list = new ArrayList<OthersDetailsDTO>();
		OthersDetailsDTO othersDetailsDTO = new OthersDetailsDTO();
		othersDetailsDTO.setMonthid(currentmonthid);
		othersDetailsDTO.setMonthName(currentmonthName);
		list.add(othersDetailsDTO);
		OthersDetailsDTO othersDetailsDTO1 = new OthersDetailsDTO();
		othersDetailsDTO1.setMonthid(prevmonthid);
		othersDetailsDTO1.setMonthName(prevMonthName);
		list.add(othersDetailsDTO1);
		return list;

	}

}
