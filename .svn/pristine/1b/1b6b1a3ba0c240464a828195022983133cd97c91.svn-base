package com.hrms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.loginDto;
import com.hrms.dtos.visitorDetailsDTO;
import com.hrms.service.InnoInfotechService;
import com.hrms.utitlities.requestUrlMapping;

@Controller
public class LoginLogoutController {

	@Autowired
	InnoInfotechService innoInfotechService;

	public LoginLogoutController() {
		System.out.println("Requesting is coming to controller");
	}
	
	
	@RequestMapping(value = "visitormanagement", method = RequestMethod.GET)
	public ModelAndView goToVisitorManagement() throws IOException {
		return new ModelAndView("visitorManagementSystem");
	}
	
	@RequestMapping(value = "visitorDetails", method = RequestMethod.POST)
	@ResponseBody
	public String storeVisitorManagementDetails(@RequestBody visitorDetailsDTO visitordetailsDTO) throws IOException {
		System.out.println(">>>>>>>>>>>>>>>"+visitordetailsDTO.getDatepicker());
		//if successfully inserted return function should come from dao page
		
		return "storedsucessfully";
	}
	
	//
	
	@RequestMapping(value = requestUrlMapping.adminLogin, method = RequestMethod.POST)
	public String doLoginForAdmin(HttpServletRequest request,loginDto logindto, ModelMap map) {
		String validation=innoInfotechService.getLoginDetails(logindto);
		System.out.println(innoInfotechService.getLoginDetails(logindto));
		 {
			 if(validation.equalsIgnoreCase("true")) {
				 HttpSession session =request.getSession();
				 session.setMaxInactiveInterval(5*60);
				session.setAttribute("username", logindto.getUid());
					return "RedirectionToHomePage";
			 }
			 else {
				 HttpSession session =request.getSession();
					session.setAttribute("username", null);
					map.addAttribute("message", "please enter correct username");
					return "login";
			 }
		}
		/*else {
			map.addAttribute("message", "please enter correct username");
			return "login";
		}
	}*/
		

}
	
	@RequestMapping(value="logout",method = RequestMethod.POST)
	public void logoutController(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println(">>>>>>>>>>>>>>>>");
		request.getSession().invalidate();
		//return new ModelAndView( "RedirectionToHomePage");
		try {
			response.sendRedirect("AdminLogin");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return null;
		
	}
		
	
	
}
