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
	public String editUserReport(UserCompMappingDTO DTO) {
		return dao.editUserReport(DTO);

	}

	@Override
	public List<UserCompMappingDTO> getAccessUpdateByTranid(int tranid) {

		return dao.getAccessUpdateByTranid(tranid);
	}

	@Override
	public List<UserCompMappingDTO> getDivisionByTranid(int tranid) {

		return dao.getDivisionByTranid(tranid);
	}

	@Override
	public List<UserCompMappingDTO> getProjectByTranid(int tranid) {

		return dao.getProjectByTranid(tranid);
	}

	@Override
	public List<UserCompMappingDTO> getDepartmentByTranid(int tranid) {

		return dao.getDepartmentByTranid(tranid);
	}

}
