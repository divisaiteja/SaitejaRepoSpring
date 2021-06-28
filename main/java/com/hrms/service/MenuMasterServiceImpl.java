package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.MenuMasterDao;
import com.hrms.dtos.MenuMasterDTO;
@Service
public class MenuMasterServiceImpl implements MenuMasterService {
	@Autowired
	private MenuMasterDao menuMasterDao;

	@Override
	public List<MenuMasterDTO> getAllMenuMaster() {
		
		return menuMasterDao.getAllMenuMaster();
	}

}
