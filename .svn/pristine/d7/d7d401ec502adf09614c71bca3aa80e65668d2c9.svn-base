package com.hrms.Dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hrms.dtos.CadreDTO;
import com.hrms.dtos.DivisionDTO;
import com.hrms.dtos.DocumentsDTO;
import com.hrms.dtos.EmployeeMasterDTO;

import com.hrms.dtos.HrDepartmentMaster;
import com.hrms.dtos.JobDetailsDTO;
import com.hrms.dtos.JobTypeDTO;
import com.hrms.dtos.ProjectDTO;
import com.hrms.dtos.SectionDTO;

public interface EmployeeMasterDao {
	
	public List<EmployeeMasterDTO> getAllEmployees();
	public List<EmployeeMasterDTO> getAllLeaves();
	public void saveNewEmployee(EmployeeMasterDTO employeeMasterDTO);
	public String editEmployee(EmployeeMasterDTO employeeMasterDTO);
	public void deleteEmployee(Integer tranId);
	public String jobDetailsSave(JobDetailsDTO jobDetailsDTO);
	public List<EmployeeMasterDTO> getEmpInfoByTranid(int tranid);
	public List<CadreDTO> getAllcadre();
	public List<JobTypeDTO> getAlljobtype();
	public List<DivisionDTO> getAllDivision();
	public int getIdNumBasedOnDivision(int divid);
	public List<HrDepartmentMaster> getAllDepartment();
	public EmployeeMasterDTO getleave(int idno);
	public void storeDocuments( int idno, String fileName,MultipartFile photo, String description);
	public void storeDoc1(int idno,MultipartFile photo);
	public void deleteDocument(Integer tranid);
	public List<DocumentsDTO> getAllStoreDocumentByIdno(int idno);
	public List<EmployeeMasterDTO> getAllEmployeeAndDepartment(int division);
}
