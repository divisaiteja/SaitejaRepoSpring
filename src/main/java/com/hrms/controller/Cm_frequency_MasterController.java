package com.hrms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrms.service.Cm_frequency_MasterService;

@Controller
public class Cm_frequency_MasterController {
	
	@Autowired
	private Cm_frequency_MasterService cm_frequency_MasterService;
	
	@RequestMapping(value="Allfrequencydropdown",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<Map<Object,Object>> allfrequencydropdown(){
		List<Map<Object,Object>> allfrequencydropdown = cm_frequency_MasterService.getAllfrequencydropdown();
		return allfrequencydropdown ;
		
	}

}
