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
	private SalaryDeductionsDao salaryDeductionsDao;

	@Override
	public List<SalaryDeductionsDTO> getAllSalaryDeductionsDetails(int division, int tmonth, int tyear, int project) {

		return salaryDeductionsDao.getAllSalaryDeductionsDetails(division, tmonth, tyear, project);
	}

	@Override
	public List<SalaryDeductionsDTO> getSalaryDeductionsDetailsInfoByIdno(int tranid) {

		return salaryDeductionsDao.getSalaryDeductionsDetailsInfoByIdno(tranid);
	}

	@Override
	public String editSalaryDeductions(SalaryDeductionsDTO salaryDeductionsDTO) {

		return salaryDeductionsDao.editSalaryDeductions(salaryDeductionsDTO);
	}

	@Override
	public List<StandardPayDetectionsDTO> getStandardDeductionInformation(int standardDeductionFieldId, int divisionid,
			int project) {

		return salaryDeductionsDao.getStandardDeductionInformation(standardDeductionFieldId, divisionid, project);
	}

	@Override
	public List<StandardPayDetectionsDTO> getStandardDeductionsDetailsInfoByIdno(int tranid) {

		return salaryDeductionsDao.getStandardDeductionsDetailsInfoByIdno(tranid);
	}

	@Override
	public String editStandardDeductions(StandardPayDetectionsDTO standardPayDetectionsDTO) {

		return salaryDeductionsDao.editStandardDeductions(standardPayDetectionsDTO);
	}

	@Override
	public String saveStandardDeductions(StandardPayDetectionsDTO standardPayDetectionsDTO) {

		return salaryDeductionsDao.saveStandardDeductions(standardPayDetectionsDTO);
	}

}
