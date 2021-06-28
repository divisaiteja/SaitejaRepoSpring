package com.hrms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.service.SalaryStatementService;

@Controller
public class SalaryStatementController {

	@Autowired
	private SalaryStatementService salaryStatementService;

	@RequestMapping(value = "salarystatement", method = RequestMethod.GET)
	public ModelAndView salarystatement() {
		return new ModelAndView("salarystatement");
	}

	@RequestMapping(value = "getsalarystatement", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ModelAndView getsalarystatement(@RequestParam("division") int division,
			@RequestParam("project") int project,@RequestParam("month") int month,
			@RequestParam("year") int year) {
		List<Map<Object, Object>> getsalarystatement = salaryStatementService.getsalarystatement(division, project,month,year);
		ModelAndView modelAndView = new ModelAndView("GetSalaryStatement");
		modelAndView.addObject("getsalarystatement", getsalarystatement);
		return modelAndView ;

	}
	
	@RequestMapping(value = "getsalarystatementreport", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void getsalarystatementreport(@RequestParam("division") int division,
			@RequestParam("project") int project,@RequestParam("month") int month,
			@RequestParam("year") int year,HttpServletRequest request,HttpServletResponse response) {
		try {
			
		List<Map<Object, Object>> getsalarystatement = salaryStatementService.getsalarystatement(division, project,month,year);
		request.setAttribute("getsalarystatement", getsalarystatement);
		if(project==1 || project==2) {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("getsalarystatementreport1.jsp");
		requestDispatcher.forward(request, response);
	}else {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("getsalarystatementreport2.jsp");
		requestDispatcher.forward(request, response);
	}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
}
}
