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
import com.hrms.dtos.BloodGroupDTO;
import com.hrms.service.BloodGroupService;

@Controller
public class BloodGroupController {
@Autowired
private BloodGroupService service;
@RequestMapping(value="bgroup", method=RequestMethod.GET)
@ResponseBody
public ModelAndView Jobstatus(){
	
	return new ModelAndView("BloodGroup");
}
	
@RequestMapping(value="getbgroup", method=RequestMethod.GET,produces="application/json")
@ResponseBody
public BaseResponseDTO getAllBgroups(){
	List<BloodGroupDTO> bList= service.getAllBgroup();
	BaseResponseDTO response=new BaseResponseDTO();
	response.setDataBean(bList);
	return response;
	
}
@RequestMapping(value="editbgroup", method=RequestMethod.POST,produces="application/json")
@ResponseBody
public  ModelAndView editJobs(@RequestBody BloodGroupDTO bgroupDTO){
	service.editBgroup(bgroupDTO);
	BaseResponseDTO response=new BaseResponseDTO();
	response.setSuccessMessage("EditedSucessfully");
	return new ModelAndView("BloodGroup");
	
}
@RequestMapping(value="deletebgroup", method=RequestMethod.POST,produces="application/json")
@ResponseBody
public void deleteJob(@RequestParam("tranid") int tranid){
	service.deleteBgroup(tranid);
	
}
@RequestMapping(value="savebgroup", method=RequestMethod.GET)
@ResponseBody
public ModelAndView saveBGroup() {

	return new ModelAndView("saveBloodGroup");
	
}

@RequestMapping(value="saveNewBgroup", method=RequestMethod.POST, produces="application/json")
@ResponseBody
public BaseResponseDTO saveBGroup(@RequestBody BloodGroupDTO bgroupDTO) {
	service.saveNewBgroup(bgroupDTO);
	BaseResponseDTO response=new BaseResponseDTO();
	response.setSuccessMessage("storedsucessfully");
    return response;
	
}
}
