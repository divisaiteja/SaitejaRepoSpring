package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.UserCompMappingDao;
import com.hrms.dtos.UserCompMappingDTO;

@Service
public class UserCompMappingServiceImpl implements UserCompMappingService {
 @Autowired
 private UserCompMappingDao dao;
	@Override
	public List<UserCompMappingDTO> getLoginUsers() {
		return dao.getLoginUsers();
	}
	@Override
	public List<UserCompMappingDTO> getLoginActivities() {
	    return dao.getLoginActivities();
	}
	@Override
	public List<UserCompMappingDTO> getUsermenuAccessList(int idno) {
		return dao.getUsermenuAccessList(idno);
		
	}
	@Override
	public void addnewReport(UserCompMappingDTO DTO) {
		dao.addnewReport(DTO);
	}
	@Override
	public void editUserReport(UserCompMappingDTO DTO) {
       this.dao.addnewReport(DTO);		
	}

}

