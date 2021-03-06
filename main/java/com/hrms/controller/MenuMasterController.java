package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrms.dtos.MenuMasterDTO;
import com.hrms.service.MenuMasterService;

@Controller
public class MenuMasterController {
	@Autowired
	private MenuMasterService menuMasterService;
	@RequestMapping(value="getAllMenumaster",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<MenuMasterDTO> getAllmenumaster(){
		List<MenuMasterDTO> allMenuMaster = menuMasterService.getAllMenuMaster();
		return allMenuMaster ;
		
	}

}
