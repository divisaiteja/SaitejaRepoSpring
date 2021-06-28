/*package com.hrms.controller;

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

import com.hrms.service.FromTwelveService;

@Controller
public class FormTwelveController {

	@Autowired
	private FromTwelveService formTwelveService;

	@RequestMapping(value = "getFormTwelve", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void GetFormTwelve(@RequestParam("division") int division,
			@RequestParam("project") int project,@RequestParam("month") int month,
			@RequestParam("year") int year,HttpServletRequest request,HttpServletResponse response) {
		try {
			List<Map<Object, Object>> getFromTwelve = formTwelveService.GetFromTwelve(division,project,month,year);
			request.setAttribute("getFromTwelve", getFromTwelve);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("GetFormTwelve.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
*/