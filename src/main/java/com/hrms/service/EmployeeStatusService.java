package com.hrms.service;

import java.util.List;

import com.hrms.dtos.EmployeeStatusDTO;

public interface EmployeeStatusService {
	
	public List<EmployeeStatusDTO> getAllEmpStatus();

	public String editEmpStatus(EmployeeStatusDTO employeestatusDTO);

	public void deleteEmpStatus(Integer empstatusid);

	public String saveNewEmpStatus(EmployeeStatusDTO employeestatusDTO);
	
	public List<EmployeeStatusDTO> getEmployeStatusByStatusId(Integer empstatusid);

}
