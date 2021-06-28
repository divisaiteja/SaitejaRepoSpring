package com.hrms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrms.service.Cm_Legislative_MasterService;

@Controller
public class Cm_Legislative_MasterController {
	 
	
	@Autowired
	private Cm_Legislative_MasterService cm_Legislative_MasterService;
	
	@RequestMapping(value="AllLegislativedropdown",method=RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public List<Map<Object,Object>> allLegislativedropdown() {
		List<Map<Object, Object>> allLegislativedropdown = cm_Legislative_MasterService.getAllLegislativedropdown();
		return allLegislativedropdown;
	}

}
