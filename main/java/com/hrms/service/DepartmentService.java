package com.hrms.service;

import java.util.List;

import com.hrms.dtos.DepartmentDTO;

public interface DepartmentService {

	public List<DepartmentDTO> getAllDepartment();
	public List<DepartmentDTO> getDepartmentByDeptid(int deptId);
	public String editDepartment(DepartmentDTO deptDto);
	public void deleteDepartment(int deptId);
	public String saveNewDepartment(DepartmentDTO deptDto);

}
