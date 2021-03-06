package com.hrms.Dao;

import java.util.List;

import com.hrms.dtos.SalaryDeductionsDTO;
import com.hrms.dtos.StandardPayDetectionsDTO;

public interface SalaryDeductionsDao {

	public List<SalaryDeductionsDTO> getAllSalaryDeductionsDetails(int division, int tmonth, int tyear, int project);

	public List<SalaryDeductionsDTO> getSalaryDeductionsDetailsInfoByIdno(int idno);

	public List<StandardPayDetectionsDTO> getStandardDeductionsDetailsInfoByIdno(int idno);

	public String editSalaryDeductions(SalaryDeductionsDTO salaryDeductionsDTO);

	public List<StandardPayDetectionsDTO> getStandardDeductionInformation(int standardDeductionFieldId, int divisionid,
			int project);

	public String editStandardDeductions(StandardPayDetectionsDTO standardPayDetectionsDTO);

	public String saveStandardDeductions(StandardPayDetectionsDTO standardPayDetectionsDTO);

}
