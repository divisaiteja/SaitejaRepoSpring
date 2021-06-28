package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.SalaryDeductionsDao;
import com.hrms.dtos.SalaryDeductionsDTO;
import com.hrms.dtos.StandardPayDetectionsDTO;
@Service
public class SalaryDeductionsServiceImpl implements SalaryDeductionsService {
	@Autowired
	private SalaryDeductionsDao  salaryDeductionsDao;
	@Override
	public List<SalaryDeductionsDTO> getAllSalaryDeductionsDetails(int division,int tmonth,int tyear) {
		// TODO Auto-generated method stub
		return salaryDeductionsDao.getAllSalaryDeductionsDetails(division,tmonth,tyear);
	}
	@Override
	public List<SalaryDeductionsDTO> getSalaryDeductionsDetailsInfoByIdno(int idno) {
		// TODO Auto-generated method stub
		return salaryDeductionsDao.getSalaryDeductionsDetailsInfoByIdno(idno);
	}
	@Override
	public void editSalaryDeductions(SalaryDeductionsDTO salaryDeductionsDTO) {
		// TODO Auto-generated method stub
		salaryDeductionsDao.editSalaryDeductions(salaryDeductionsDTO);
	}
	@Override
	public List<StandardPayDetectionsDTO> getStandardDeductionInformation(int standardDeductionFieldId,int divisionid) {
		// TODO Auto-generated method stub
		return salaryDeductionsDao.getStandardDeductionInformation(standardDeductionFieldId,divisionid);
	}
	@Override
	public List<StandardPayDetectionsDTO> getStandardDeductionsDetailsInfoByIdno(int idno) {
		// TODO Auto-generated method stub
		return salaryDeductionsDao.getStandardDeductionsDetailsInfoByIdno(idno);
	}
	@Override
	public void editStandardDeductions(StandardPayDetectionsDTO standardPayDetectionsDTO) {
		// TODO Auto-generated method stub
		salaryDeductionsDao.editStandardDeductions(standardPayDetectionsDTO);
	}

}
