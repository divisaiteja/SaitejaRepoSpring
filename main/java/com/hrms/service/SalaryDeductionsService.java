package com.hrms.service;

import java.util.List;

import com.hrms.dtos.SalaryDeductionsDTO;
import com.hrms.dtos.StandardPayDetectionsDTO;

public interface SalaryDeductionsService {
 	public List<SalaryDeductionsDTO> getAllSalaryDeductionsDetails(int division,int tmonth,int tyear);
 	public List<SalaryDeductionsDTO> getSalaryDeductionsDetailsInfoByIdno(int idno);
 	public void editSalaryDeductions(SalaryDeductionsDTO salaryDeductionsDTO);
 	public List<StandardPayDetectionsDTO> getStandardDeductionInformation(int standardDeductionFieldId,int divisionid);
 	public List<StandardPayDetectionsDTO> getStandardDeductionsDetailsInfoByIdno(int idno);
 	public void editStandardDeductions(StandardPayDetectionsDTO standardPayDetectionsDTO);

}
