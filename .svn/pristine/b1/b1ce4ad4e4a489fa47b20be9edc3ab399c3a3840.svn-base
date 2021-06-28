package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.EmployeeMonthPay;
import com.hrms.service.PaySheetService;

@Controller
public class PaySheetController {
	
	@Autowired
	PaySheetService paySheetService;
	
	@RequestMapping(value="paySheetPageDisplay", method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public ModelAndView displayPaySheetPage(@RequestParam("division") int division, @RequestParam("tmonth") int tmonth, @RequestParam("tyear") int tyear, Model model) {
		model.addAttribute("division", division);
		model.addAttribute("tmonth", tmonth);
		model.addAttribute("tyear", tyear);
		return new ModelAndView("PaysheetGeneration");
		
	}
	@RequestMapping(value="paysheetcaluculation", method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public BaseResponseDTO paysheetcaluculation(@RequestParam("division") int division, @RequestParam("tmonth") int tmonth, @RequestParam("tyear") int tyear) {
	BaseResponseDTO response=new BaseResponseDTO();
	List<EmployeeMonthPay> li=paySheetService.paysheetcaluculation(division,tmonth,tyear);
	response.setDataBean(li);
	return response;
		
	}
	

}
