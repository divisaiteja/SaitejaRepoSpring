package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.SalaryDetailsDao;
import com.hrms.dtos.SalaryDetailsDTO;

@Service
public class SalaryDetailsServiceImpl implements SalaryDetailsService {

	@Autowired
	private SalaryDetailsDao salaryDetailsDao;

	@Override
	public void saveSalaryDetails(SalaryDetailsDTO salaryDetailsDTO) {
		salaryDetailsDao.saveSalaryDetails(salaryDetailsDTO);

	}

	@Override
	public void editSalaryDetails(SalaryDetailsDTO salaryDetailsDTO) {
		salaryDetailsDao.editSalaryDetails(salaryDetailsDTO);

	}

	@Override
	public void deleteSalaryDetails(Integer idno) {
		salaryDetailsDao.deleteSalaryDetails(idno);

	}

	@Override
	public List<SalaryDetailsDTO> getSalaryInfoByTranid(int parentid) {
		return salaryDetailsDao.getSalaryInfoByTranid(parentid);
	}

}
