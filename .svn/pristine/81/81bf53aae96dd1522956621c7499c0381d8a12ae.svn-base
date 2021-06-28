package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.EmployeeStatusDao;

import com.hrms.dtos.EmployeeStatusDTO;

@Service
public class EmployeeStatusServiceImpl implements EmployeeStatusService {
	@Autowired
	private EmployeeStatusDao dao;

	@Override
	public List<EmployeeStatusDTO> getAllEmpStatus() {
		return dao.getAllEmpStatus();
	}

	@Override
	public String editEmpStatus(EmployeeStatusDTO employeestatusDTO) {
		return dao.editEmpStatus(employeestatusDTO);

	}

	@Override
	public void deleteEmpStatus(Integer empstatusid) {
		dao.deleteEmpStatus(empstatusid);

	}

	@Override
	public String saveNewEmpStatus(EmployeeStatusDTO employeestatusDTO) {
		return dao.saveNewEmpStatus(employeestatusDTO);

	}

	@Override
	public List<EmployeeStatusDTO> getEmployeStatusByStatusId(Integer empstatusid) {
		return dao.getEmployeStatusByStatusId(empstatusid);
	}

}
