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
import com.hrms.dtos.EmployeeMasterDTO;
import com.hrms.dtos.PermissionsDTO;
import com.hrms.service.EmployeeMasterServices;
import com.hrms.service.PermissionService;

@Controller
public class PermissionsController {

	@Autowired
	EmployeeMasterServices employeeServices;

	@Autowired
	PermissionService permissionService;

	@RequestMapping(value = "EmployeePermissionsInformation", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView displyPage() {

		return new ModelAndView("Permissions");
	}

	@RequestMapping(value = "getEmployeeInformationBasedOnIdno", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<EmployeeMasterDTO> getEmpInfoByIdno(@RequestParam(value = "idno") int idno) {

		List<EmployeeMasterDTO> empInfoByIdno = employeeServices.getEmpInfoByIdno(idno);

		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(empInfoByIdno);
		response.setSuccessMessage("storedsucessfully");

		return empInfoByIdno;
	}

	@RequestMapping(value = "savePassel", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO savePassel(@RequestBody PermissionsDTO permissionsDTO) {
		String displayMessage = permissionService.passELSave(permissionsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;
	}

	@RequestMapping(value = "savePasssl", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO savePasssl(@RequestBody PermissionsDTO permissionsDTO) {
		String displayMessage = permissionService.passSLSave(permissionsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;
	}

	@RequestMapping(value = "savePasscl", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO savePasscl(@RequestBody PermissionsDTO permissionsDTO) {
		String displayMessage = permissionService.passCLSave(permissionsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;
	}

	@RequestMapping(value = "savePassLeave", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO savePassLeave(@RequestBody PermissionsDTO permissionsDTO) {
		String displayMessage = permissionService.passLeaveSave(permissionsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;
	}

	@RequestMapping(value = "saveForgetPunch", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveForgetPunch(@RequestBody PermissionsDTO permissionsDTO) {
		String displayMessage = permissionService.forgetPunchSave(permissionsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;
	}

	@RequestMapping(value = "saveLopIntimation", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveLopIntimation(@RequestBody PermissionsDTO permissionsDTO) {
		String displayMessage = permissionService.lopIntimationSave(permissionsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;
	}

	@RequestMapping(value = "saveAddPermission", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveAddPermission(@RequestBody PermissionsDTO permissionsDTO) {
		String displayMessage = permissionService.permissionSave(permissionsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;
	}

	@RequestMapping(value = "getPermissionsList", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getPermissionsList(@RequestParam("idno") int idno) {
		List<PermissionsDTO> permissionsList = permissionService.getPermissionsList(idno);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(permissionsList);
		return response;
	}
	
	@RequestMapping(value = "deletePermission", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteExpense(@RequestParam("tranid") int tranid) {

		permissionService.deletePermission(tranid);

	}
}
