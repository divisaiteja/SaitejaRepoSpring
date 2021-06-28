package com.hrms.Dao;

import java.util.List;
import java.util.Map;

import com.hrms.dtos.MenuMasterDTO;

public interface MenuMasterDao {

	public List<MenuMasterDTO> getAllMenuMaster();
	
	public List<Map<Object,Object>>  getSidebarMenu();
}
