package com.hrms.service;

import java.util.List;

import com.hrms.dtos.UserCompMappingDTO;

public interface UserCompMappingService {

	public List<UserCompMappingDTO> getLoginUsers();

	public List<UserCompMappingDTO> getLoginActivities();

	public List<UserCompMappingDTO> getUsermenuAccessList(int idno);

	public void addnewReport(UserCompMappingDTO DTO);

	public String editUserReport(UserCompMappingDTO DTO);

	public List<UserCompMappingDTO> getAccessUpdateByTranid(int tranid);

	public List<UserCompMappingDTO> getDivisionByTranid(int tranid);

	public List<UserCompMappingDTO> getProjectByTranid(int tranid);

	public List<UserCompMappingDTO> getDepartmentByTranid(int tranid);

}
