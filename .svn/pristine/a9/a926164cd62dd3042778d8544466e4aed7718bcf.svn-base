package com.hrms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.MenuMasterDTO;
import com.hrms.service.MenuService;

@Controller
public class MenuController {
	
	@Autowired
	private MenuService service;
	/*
	 * @RequestMapping(value="home", method=RequestMethod.GET)
	 * 
	 * @ResponseBody public ModelAndView Home(@ModelAttribute ModelMap map){
	 * List<MenuMasterDTO> menuMaster = service. getMenuMaster();
	 * map.addAttribute("menuMaster", menuMaster); System.out.println(map); return
	 * new ModelAndView("home"); }
	 */
	
	  @RequestMapping(value="getAllMenuMaster",method=RequestMethod.GET,produces=
	  "application/json")
	  
	  @ResponseBody public List<MenuMasterDTO> getAllMenuMaster(@ModelAttribute
	  ModelMap map) {
		  List<MenuMasterDTO> menuMaster = service. getMenuMaster();
	  map.addAttribute("menuMaster", menuMaster);
	  System.out.println(menuMaster+""); return menuMaster ;
}
	 
}
