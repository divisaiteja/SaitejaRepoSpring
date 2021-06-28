package com.hrms.Dao;

import java.util.List;

import com.hrms.dtos.SalaryDetailsDTO;

public interface SalaryDetailsDao {

	public void saveSalaryDetails(SalaryDetailsDTO salaryDetailsDTO);

	public void editSalaryDetails(SalaryDetailsDTO salaryDetailsDTO);

	public void deleteSalaryDetails(Integer idno);

	public List<SalaryDetailsDTO> getSalaryInfoByTranid(int tranid);
}
