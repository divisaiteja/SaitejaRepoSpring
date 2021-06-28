package com.hrms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportsController {

	@RequestMapping(value = "/AReport", method = RequestMethod.GET)
	public ModelAndView DisplayAllattendence() {
		return new ModelAndView("AReport");
	}
}
