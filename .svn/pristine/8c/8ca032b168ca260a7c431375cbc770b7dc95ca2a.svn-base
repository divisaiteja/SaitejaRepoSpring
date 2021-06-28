package com.hrms.controller;

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
import com.hrms.dtos.EmployeeStatusDTO;
import com.hrms.dtos.JobStatusDTO;
import com.hrms.service.EmployeeStatusService;

@Controller
public class EmployeeStatusController {
	@Autowired
	private EmployeeStatusService service;

	@RequestMapping(value = "empstatus", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView EmpStatus() {

		return new ModelAndView("EmpStatus");
	}

	@RequestMapping(value = "getEmpStatus", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllEmpstatus() {
		List<EmployeeStatusDTO> empList = service.getAllEmpStatus();
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(empList);
		return response;

	}

	@RequestMapping(value = "editEmpstatus", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editEmp(@RequestBody EmployeeStatusDTO employeestatusDTO) {
		String editEmpStatus = service.editEmpStatus(employeestatusDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(editEmpStatus);
		return response;

	}

	@RequestMapping(value = "deleteEmpStatus", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteEmp(@RequestParam("empstatusid") int empstatusid) {
		service.deleteEmpStatus(empstatusid);

	}

	@RequestMapping(value = "saveEmpstatus", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView saveEmpStatus() {

		return new ModelAndView("saveEmpStatus");

	}

	@RequestMapping(value = "saveNewEmpstatus", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveEmpStatus(@RequestBody EmployeeStatusDTO employeestatusDTO) {
		String saveNewEmpStatus = service.saveNewEmpStatus(employeestatusDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(saveNewEmpStatus);
		return response;

	}

	@RequestMapping(value = "employeStatusByStatusId", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<EmployeeStatusDTO> employeStatusByStatusId(@RequestParam(value = "empstatusid") int empstatusid) {
		List<EmployeeStatusDTO> employeStatusByStatusId = service.getEmployeStatusByStatusId(empstatusid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(employeStatusByStatusId);
		response.setSuccessMessage("storedsucessfully");
		return employeStatusByStatusId;

	}
}
