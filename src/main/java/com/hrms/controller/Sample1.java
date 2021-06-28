package com.hrms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Sample1 {
	

	@RequestMapping(value = "sample1", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView Divisions() {

		return new ModelAndView("sample1");
	}


}
