package com.hrms.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.loginDto;
import com.hrms.service.LoginLogoutService;
import com.hrms.utitlities.DBUtil;
import com.hrms.utitlities.requestUrlMapping;

@Controller
public class LoginLogoutController {

	@Autowired
	private  LoginLogoutService loginLogoutService;

	public LoginLogoutController() {
	}

	@RequestMapping(value = requestUrlMapping.adminLogin, method = RequestMethod.POST)
	public String doLoginForAdmin(HttpServletRequest request, loginDto logindto, ModelMap map) {
		String validation = loginLogoutService.getLoginDetails(logindto);
		{
			if (validation.equalsIgnoreCase("true")) {
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(5 * 60);
				session.setAttribute("username", logindto.getUid());

				return "RedirectionToHomePage";
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("username", null);
				map.addAttribute("message", "please enter correct username");
				return "login";
			}
		}

	}

	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public void logoutController(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		try {
			response.sendRedirect("AdminLogin");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "setsession", method = RequestMethod.POST)
	public void doSetSession(HttpServletRequest request, @RequestParam(value = "activityId") String activityId) {

		HttpSession session = request.getSession();
		String loginId = session.getAttribute("username").toString();
		session.setAttribute("access", "1");
		session.setAttribute("activityId", activityId);
		session.setAttribute("userrole", "admin");
		if (!loginId.equalsIgnoreCase("admin")) {
			// updating session variable on login success
			try {
				Connection con = DBUtil.getConnection();
				Statement stm = con.createStatement();

				String sql1 = "select user_role from user_admin where uid='" + loginId + "'";
				ResultSet rs1 = stm.executeQuery(sql1);
				if (rs1.next()) {
					session.setAttribute("userrole", rs1.getString("user_role"));
					if (session.getAttribute("userrole").toString().equalsIgnoreCase("user")) {
						session.setAttribute("access", "0");
					}
					;
				}
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "changePassword", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO storeDocDetails(@RequestParam(value = "idno") int idno,
			@RequestParam(value = "password") String password) {

		String updatepassword = loginLogoutService.updatePassword(idno, password);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(updatepassword);
		return response;

	}

}
