package com.hrms.Dao;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.hrms.dtos.BankMasterDTO;
import com.hrms.dtos.CadreDTO;
import com.hrms.dtos.DivisionDTO;
import com.hrms.dtos.DocumentsDTO;
import com.hrms.dtos.EmployeeMasterDTO;
import com.hrms.dtos.HrDepartmentMaster;
import com.hrms.dtos.JobDetailsDTO;
import com.hrms.dtos.JobTypeDTO;
import com.hrms.dtos.ProjectDTO;

public interface EmployeeMasterDao {

	public List<EmployeeMasterDTO> getAllEmployees(int division, int project);

	public List<EmployeeMasterDTO> getAllEmployees1();

	public List<Map<String,Object>> getAllReportees();

	public List<EmployeeMasterDTO> getAllLeaves(int division, int project);

	public void saveNewEmployee(EmployeeMasterDTO employeeMasterDTO);

	public String editEmployee(EmployeeMasterDTO employeeMasterDTO);

	public void deleteEmployee(Integer tranId);

	public String jobDetailsSave(JobDetailsDTO jobDetailsDTO);

	public List<EmployeeMasterDTO> getEmpInfoByTranid(int tranid);

	public List<EmployeeMasterDTO> getEmpInfoByIdno(int idno);

	public List<CadreDTO> getAllcadre();

	public List<JobTypeDTO> getAlljobtype();

	public List<Map<String, Object>> getAllDesignationdropdown();

	public List<DivisionDTO> getAllDivision(String fltStr);

	public int getIdNumBasedOnDivision(int divid);

	public List<HrDepartmentMaster> getAllDepartment(String fltStr);

	public EmployeeMasterDTO getleave(int idno);

	public void storeDocuments(int idno, String fileName, MultipartFile photo, String description);

	public void storeDoc1(int idno, BufferedImage photo);

	public void deleteDocument(Integer tranid);

	public List<DocumentsDTO> getAllStoreDocumentByIdno(int idno);

	public List<Map<String,Object>> getAllEmployeeAndDepartment(int division, String otdate, String project);

	public DocumentsDTO getDocumentById(int tranid);

	public List<ProjectDTO> getAllProjects(String fltStr);

	public String editOtEntry(EmployeeMasterDTO employeemasterDTO);

	public HashMap<String, Float> salaryCalculation(int division, Float basic);

	public HashMap<String, Float> salaryCalculationBasedonGrossSalary(int tranid, int division, Float grosssalary);

	public HashMap<String, String> getUserAccess(String loginId);

	public List<BankMasterDTO> getAllBankMaster();

	public List<BankMasterDTO> getBankDetailsByIfsc(String ifsccode);

	public List<Map<String, Object>> getallcontractpersonnames();

	public int getIdNumBasedOnContract(int contractid);

	public void storeExcelDocuments( MultipartFile excel);
}
