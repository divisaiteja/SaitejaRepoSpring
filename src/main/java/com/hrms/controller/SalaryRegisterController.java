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

import com.hrms.service.SalaryRegisterService;

@Controller
public class SalaryRegisterController {

	@Autowired
	private SalaryRegisterService salaryRegisterService;

	@RequestMapping(value = "getSalaryRegister", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void getSalaryRegister(@RequestParam(value = "year") int year, @RequestParam(value = "month") int month,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Map<Object, Object>> getSalaryRegister = salaryRegisterService.GetSalaryRegister(year, month);
			request.setAttribute("getSalaryRegister", getSalaryRegister);
			System.out.println(">>>>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("GetSalaryRegisterReport.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
