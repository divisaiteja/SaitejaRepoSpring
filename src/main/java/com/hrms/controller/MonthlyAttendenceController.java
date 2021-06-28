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

import com.hrms.service.MonthlyAttendenceService;

@Controller
public class MonthlyAttendenceController {

	@Autowired
	private MonthlyAttendenceService monthlyAttendenceService;

	@RequestMapping(value = "MonthlyAttendence", method = RequestMethod.GET)
	public ModelAndView MonthlyAttendence() {
		return new ModelAndView("MonthlyAttendence");
	}

	@RequestMapping(value = "GetMonthlyAttendence", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ModelAndView GetMonthlyAttendence(@RequestParam("project") int project,
			@RequestParam("division") int division, @RequestParam("year") int year, @RequestParam("month") int month) {
		ModelAndView modelAndView = new ModelAndView("salarystatement");
		String fromdate = null;
		String todate = null;
		List<Map<Object, Object>> getmonthlyAttendence = monthlyAttendenceService.getMonthlyAttendence(project,
				division, year, month, fromdate, todate);
		modelAndView.addObject("getmonthlyAttendence", getmonthlyAttendence);
		return modelAndView;

	}

	@RequestMapping(value = "getMonthlyAttendence", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void getMonthlyAttendence(@RequestParam("division") int division, @RequestParam("project") int project,
			@RequestParam("month") int month, @RequestParam("year") int year, HttpServletRequest request,
			HttpServletResponse response) {
		String fromdate = null;
		String todate = null;
		try {
			List<Map<Object, Object>> monthlyAttendence = monthlyAttendenceService.getMonthlyAttendence(project,
					division, year, month, fromdate, todate);
			request.setAttribute("monthlyAttendence", monthlyAttendence);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("GetMonthlyAttendance.jsp");
			requestDispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "GetFormTwelve", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void GetFormTwelve(@RequestParam("division") int division, @RequestParam("project") int project,
			@RequestParam("fromdate") String fromdate, @RequestParam("todate") String todate,
			HttpServletRequest request1, HttpServletResponse response1) {
		int month = 0;
		int year = 0;

		try {
			List<Map<Object, Object>> getFormTwelve = monthlyAttendenceService.getMonthlyAttendence(project, division,
					month, year, fromdate, todate);
			//System.out.println(">>>>");
			request1.setAttribute("getFormTwelve", getFormTwelve);
			List<Object> dateAndDayName = monthlyAttendenceService.getDateAndDayName(fromdate, todate);
			request1.setAttribute("dateAndDayName", dateAndDayName);
			List<Object> getCCount = monthlyAttendenceService. GetCCount(project, division,fromdate, todate);
			request1.setAttribute("getCCount", getCCount);
			RequestDispatcher requestDispatcher = request1.getRequestDispatcher("GetFormTwelve.jsp");
			requestDispatcher.forward(request1, response1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/* @RequestMapping(value = "GetFormTwelve", method = RequestMethod.GET, produces
	  = "application/json")
	 
	  @ResponseBody public List<Map<Object, Object>>
	  GetFormTwelve(@RequestParam("division") int division,
	
	  @RequestParam("project") int project, @RequestParam("todate") String todate,
	  
	  @RequestParam("fromdate") String fromdate) { int month=0; int year=0;
	  List<Map<Object, Object>> getFromTwelve =
	  monthlyAttendenceService.getMonthlyAttendence(project, division, month,
	  year,fromdate,todate); return getFromTwelve ; }
	 
*/
}