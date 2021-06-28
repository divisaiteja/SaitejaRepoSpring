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
import com.hrms.dtos.DivisionDTO;
import com.hrms.service.DivisionService;


@Controller
public class DivisionController {
	@Autowired
	private DivisionService service;
@RequestMapping(value="division", method=RequestMethod.GET)
@ResponseBody
public ModelAndView Divisions(){
	
	return new ModelAndView("division");
}
//for division list page
@RequestMapping(value="getdivision", method=RequestMethod.GET,produces="application/json")
@ResponseBody
public BaseResponseDTO getAllDivisions(){
	List<DivisionDTO> list= service.getAllDivisons();
	BaseResponseDTO response=new BaseResponseDTO();
	response.setDataBean(list);
	return response;
	
}

@RequestMapping(value="saveNewDivision", method=RequestMethod.POST, produces="application/json")
@ResponseBody
public BaseResponseDTO saveDivision(@RequestBody DivisionDTO divisionDTO) {
	String saveNewDivision = service.saveNewDivision(divisionDTO);
	BaseResponseDTO response=new BaseResponseDTO();
	response.setSuccessMessage(saveNewDivision);
	return response;
	
}
//for edit the division 
@RequestMapping(value="editDivision", method=RequestMethod.POST,produces="application/json")
@ResponseBody
public BaseResponseDTO  editDivisions(@RequestBody DivisionDTO divisionDTO){
	String editDivision = service.editDivision(divisionDTO);
	BaseResponseDTO response=new BaseResponseDTO();
	response.setSuccessMessage(editDivision);
	return response ;
	
}
//for division deletion
@RequestMapping(value="deleteDivision", method=RequestMethod.POST,produces="application/json")
@ResponseBody
public void deletedivision(@RequestParam("divisionid") int divisionid){
	service.deleteDivision(divisionid);
	
}

@RequestMapping(value = "getdivisions", method = RequestMethod.GET, produces = "application/json")
@ResponseBody
public List<DivisionDTO> getdivision(@RequestParam(value = "divisionid") int divisionid) {
	List<DivisionDTO> dto =service.getDivision(divisionid);
	return dto;
}
}
