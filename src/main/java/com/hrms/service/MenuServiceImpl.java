package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.MenuDao;
import com.hrms.dtos.MenuMasterDTO;
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao dao;
	@Override
	public List<MenuMasterDTO> getMenuMaster() {
		
		return dao.getMenuMaster();
	}

}
