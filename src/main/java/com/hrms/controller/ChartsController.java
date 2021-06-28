package com.hrms.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.ChartsDTO;
import com.hrms.service.ChartsServices;

@Controller
public class ChartsController {

	@Autowired
	ChartsServices chartsServices;

	@RequestMapping(value = "openDashBoard", method = RequestMethod.GET)
	public ModelAndView openDashBoard() throws IOException {
		return new ModelAndView("dashboardView");

	}
	
	@RequestMapping(value = "getBarGraphs", method = RequestMethod.GET)
	@ResponseBody
	public List<ChartsDTO> getBarGraphsOnDivisons() {
		List<ChartsDTO> data = chartsServices.getBarGraphsOnDivisons();
		return data;
	}

	@RequestMapping(value = "getDivisionBarGraphs", method = RequestMethod.GET)
	@ResponseBody
	public List<ChartsDTO> getDivisionBarGraphs() {
		List<ChartsDTO> divisionData = chartsServices.getDivisionBarGraphs();
		return divisionData;
	}
 

	@RequestMapping(value = "getAbsentsBasedOnDivision", method = RequestMethod.GET)
	@ResponseBody
	public List<ChartsDTO> getAbsentsBasedOnDivision(@RequestParam("date") String date) {
		 List<ChartsDTO> absentsBasedOnDivision = chartsServices.getAbsentsBasedOnDivision(date);
	//	System.out.println(">>>>getAbsentsBasedOnDivision>>>>>");
		 return absentsBasedOnDivision;
		
	}
	
	
}
