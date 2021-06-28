package com.hrms.controller;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.MenuMasterDTO;
import com.hrms.service.MenuMasterService;

@Controller
public class MenuMasterController {
	@Autowired
	private MenuMasterService menuMasterService;

	@RequestMapping(value = "getAllMenumaster", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<MenuMasterDTO> getAllmenumaster() {
		List<MenuMasterDTO> allMenuMaster = menuMasterService.getAllMenuMaster();
		return allMenuMaster;

	}
	@RequestMapping(value = "getsiderbarmenu", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getsiderbarmenu() {
		List<Map<Object, Object>> sidebarMenu = menuMasterService.getSidebarMenu();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("sidebarMenu", sidebarMenu);
		//System.out.println("getsiderbarmenu   "+sidebarMenu);
		//System.out.println(">>>getsiderbarmenu>>>>");
		return new ModelAndView("sidebar");
	}
	
	
	
}