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
import com.hrms.dtos.DepartmentDTO;
import com.hrms.dtos.DepartmentDTO;
import com.hrms.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService deptService;

	@RequestMapping(value = "department", method = RequestMethod.GET)

	@ResponseBody
	public ModelAndView Department() {

		return new ModelAndView("department");
	}

	@RequestMapping(value = "getdepartment", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllDepartment() {
		List<DepartmentDTO> departmentDto = deptService.getAllDepartment();
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(departmentDto);
		return response;

	}

	@RequestMapping(value = "getdeptByDeptId", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<DepartmentDTO> getDepartmentByDeptId(@RequestParam(value = "deptid") int deptId, ModelMap map) {
        List<DepartmentDTO> deptbydeptid = deptService.getDepartmentByDeptid(deptId);
        BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(deptbydeptid);
		response.setSuccessMessage("storedsucessfully");
		return deptbydeptid;

	}

	@RequestMapping(value = "editDepartment", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editDepartment(@RequestBody DepartmentDTO deptDto) {
		String editDepartment = deptService.editDepartment(deptDto);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(editDepartment);
		return response;

	}

	@RequestMapping(value = "deleteDepartment", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO deleteDepartment(@RequestParam("deptid") int deptId) {
		deptService.deleteDepartment(deptId);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage("deleted sucessfully");
		return response;

	}

	@RequestMapping(value = "saveDepartment", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveDepartment(@RequestBody DepartmentDTO deptDto) {
		String saveNewDepartment = deptService.saveNewDepartment(deptDto);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(saveNewDepartment);
		return response;
	}

}
