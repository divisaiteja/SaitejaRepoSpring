package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.DepartmentDao;
import com.hrms.dtos.DepartmentDTO;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao deptDao;

	@Override
	public List<DepartmentDTO> getAllDepartment() {

		return deptDao.getAllDepartment();
	}

	@Override
	public List<DepartmentDTO> getDepartmentByDeptid(int deptId) {
		return deptDao.getDepartmentByDeptid(deptId);
	}

	@Override
	public String editDepartment(DepartmentDTO deptDto) {
		return deptDao.editDepartment(deptDto);

	}

	@Override
	public void deleteDepartment(int deptId) {
		deptDao.deleteDepartment(deptId);
	}

	@Override
	public String saveNewDepartment(DepartmentDTO deptDto) {
		return deptDao.saveNewDepartment(deptDto);
	}

}
