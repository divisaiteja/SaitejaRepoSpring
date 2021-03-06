package com.hrms.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.utitlities.requestUrlMapping;

@Controller
public class CommonRequestControllers {
	
	@RequestMapping(value = "login")
	public ModelAndView goToLogin() throws IOException {
		return new ModelAndView("login");
	}

	@RequestMapping(value = requestUrlMapping.adminLogin, method = RequestMethod.GET)
	public ModelAndView goToLogin1() throws IOException {
		return new ModelAndView("login");
	}
	@RequestMapping(value = requestUrlMapping.redirectNewEmployee, method = RequestMethod.GET)
	public ModelAndView saveEmployee() throws IOException {
		return new ModelAndView("CreateNewEmployee");
	}
	@RequestMapping(value = "openDashBoard", method = RequestMethod.GET)
	public ModelAndView openDashBoard() throws IOException {
		
		return new ModelAndView("dashboard");
		
	}
	
}
