package com.hrms.service;

import java.util.List;
import java.util.Map;

import com.hrms.dtos.MenuMasterDTO;

public interface MenuMasterService {

	public List<MenuMasterDTO> getAllMenuMaster();
	
	public List<Map<Object,Object>>  getSidebarMenu();
	
}
