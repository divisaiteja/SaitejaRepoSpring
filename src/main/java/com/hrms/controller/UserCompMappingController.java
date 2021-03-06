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
import com.hrms.dtos.UserCompMappingDTO;
import com.hrms.service.UserCompMappingService;

@Controller
public class UserCompMappingController {
	@Autowired
	private UserCompMappingService service;

	@RequestMapping(value = "usercompmapping", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView viewUserMapping() {
		return new ModelAndView("UserCompMapping");

	}

	@RequestMapping(value = "getloginuser", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<UserCompMappingDTO> getAllLoginUsers() {

		List<UserCompMappingDTO> list = service.getLoginUsers();
		return list;

	}

	@RequestMapping(value = "getloginactivity", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<UserCompMappingDTO> getAllLoginActivities() {

		List<UserCompMappingDTO> list = service.getLoginActivities();
		return list;

	}

	@RequestMapping(value = "getuseraccesslist", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getUserMenuAccessList(@RequestParam(value = "idno") int idno) {

		List<UserCompMappingDTO> list = service.getUsermenuAccessList(idno);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(list);
		return response;

	}

	@RequestMapping(value = "savenewactivity", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveUseraccessList(@RequestBody UserCompMappingDTO DTO) {

		service.addnewReport(DTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage("storedsucessfully");
		return response;
	}

	@RequestMapping(value = "editactivity", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editUseraccessList(@RequestBody UserCompMappingDTO DTO) {
		String menu = service.editUserReport(DTO);

		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(menu);
		return response;

	}

	@RequestMapping(value = "getAccessUpdateByTranid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<UserCompMappingDTO> getAccessUserDataByTranid(@RequestParam(value = "tranid") int tranid,
			ModelMap map) {
		List<UserCompMappingDTO> gradeNo = service.getAccessUpdateByTranid(tranid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(gradeNo);
		response.setSuccessMessage("storedsucessfully");
		return gradeNo;

	}

	@RequestMapping(value = "getdivisionBytranid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<UserCompMappingDTO> getDivisionByTranid(@RequestParam(value = "tranid") int tranid) {
		List<UserCompMappingDTO> divisionbyTranid = service.getDivisionByTranid(tranid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(divisionbyTranid);
		response.setSuccessMessage("storedsucessfully");
		return divisionbyTranid;
	}

	@RequestMapping(value = "getdeprtmentBytranid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<UserCompMappingDTO> getDepartmentByTranid(@RequestParam(value = "tranid") int tranid) {
		List<UserCompMappingDTO> divisionbyTranid = service.getDepartmentByTranid(tranid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(divisionbyTranid);
		response.setSuccessMessage("storedsucessfully");
		return divisionbyTranid;
	}

	@RequestMapping(value = "getprojectBytranid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<UserCompMappingDTO> getProjectByTranid(@RequestParam(value = "tranid") int tranid) {
		List<UserCompMappingDTO> divisionbyTranid = service.getProjectByTranid(tranid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(divisionbyTranid);
		response.setSuccessMessage("storedsucessfully");
		return divisionbyTranid;
	}

}
