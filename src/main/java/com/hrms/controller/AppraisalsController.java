package com.hrms.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.EmployeeMasterDTO;
import com.hrms.dtos.IncrementsDTO;
import com.hrms.service.EmployeeMasterServices;
import com.hrms.service.IncrementsAndPromotionsService;

@Controller
public class AppraisalsController {

	@Autowired
	EmployeeMasterServices employeeServices;
	@Autowired
	IncrementsAndPromotionsService incrementsAndPromotionsService;

	@RequestMapping(value = "appraisalsEmployeeInformation", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView displyPage() {

		return new ModelAndView("AppraisalsPage");
	}

	@RequestMapping(value = "getAppraisalsEmployeeInformation", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllEmployees(@RequestParam(value = "division") int division,
			@RequestParam(value = "project") int project) {
		List<EmployeeMasterDTO> empList = employeeServices.getAllEmployees(division, project);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(empList);
		return response;

	}

	@RequestMapping(value = "IncrementsAndPromotions", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ModelAndView EditEmployees(@RequestParam("tranid") int tranid, @RequestParam("idNumber") int idNumber,
			Model model) {
		model.addAttribute("tranid", tranid);
		model.addAttribute("idNumber", idNumber);
		return new ModelAndView("IncrementsAndPromotions");

	}

	@RequestMapping(value = "salaryCalculationBasedonGrossSalaryInAppraisals", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO salaryCalculationBasedonGrossSalary(@RequestParam(value = "idnumber") int idnumber,
			@RequestParam(value = "grosssalary") Float grosssalary) {
		BaseResponseDTO response = new BaseResponseDTO();
		HashMap<String, Float> calculatedMap = incrementsAndPromotionsService
				.salaryCalculationBasedonGrossSalary(idnumber, grosssalary);
		response.setDataBean(calculatedMap);
		return response;
	}

	@RequestMapping(value = "saveIncrementsDetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveIncrementsDetails(@RequestBody IncrementsDTO incrementsDTO) {

		String saveIncrements = incrementsAndPromotionsService.saveIncrements(incrementsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(saveIncrements);
		return response;

	}
}
