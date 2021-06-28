package com.hrms.Dao;

import java.util.List;

import com.hrms.dtos.UserCompMappingDTO;

public interface UserCompMappingDao {
	public List<UserCompMappingDTO> getLoginUsers();
	public List<UserCompMappingDTO> getLoginActivities();
	public List<UserCompMappingDTO> getUsermenuAccessList(int idno);
	public void addnewReport(UserCompMappingDTO DTO);
	public void editUserReport(UserCompMappingDTO DTO);
	

}
