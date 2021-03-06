package com.hrms.service;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.Dao.EmployeeMasterDao;
import com.hrms.dtos.BankMasterDTO;
import com.hrms.dtos.CadreDTO;
import com.hrms.dtos.DivisionDTO;
import com.hrms.dtos.DocumentsDTO;
import com.hrms.dtos.EmployeeMasterDTO;
import com.hrms.dtos.HrDepartmentMaster;
import com.hrms.dtos.JobDetailsDTO;
import com.hrms.dtos.JobTypeDTO;
import com.hrms.dtos.ProjectDTO;

@Service
public class EmployeeMasterServicesImpl implements EmployeeMasterServices {

	@Autowired
	private EmployeeMasterDao employeeMasterDao;

	@Override
	public List<EmployeeMasterDTO> getAllEmployees(int division, int project) {
		return employeeMasterDao.getAllEmployees(division, project);
	}

	@Override
	public List<EmployeeMasterDTO> getAllEmployees1() {
		return employeeMasterDao.getAllEmployees1();
	}

	@Override
	public List<Map<String,Object>> getAllReportees() {
		return employeeMasterDao.getAllReportees();
	}

	@Override
	public void saveNewEmployee(EmployeeMasterDTO employeeMasterDTO) {
		this.employeeMasterDao.saveNewEmployee(employeeMasterDTO);
	}

	@Override
	public String editEmployee(EmployeeMasterDTO employeeMasterDTO) {
		return employeeMasterDao.editEmployee(employeeMasterDTO);
	}

	@Override
	public void deleteEmployee(Integer tranId) {
		employeeMasterDao.deleteEmployee(tranId);
	}

	@Override
	public String jobDetailsSave(JobDetailsDTO jobDetailsDTO) {
		return employeeMasterDao.jobDetailsSave(jobDetailsDTO);
	}

	@Override
	public List<EmployeeMasterDTO> getAllLeaves(int division, int project) {

		return employeeMasterDao.getAllLeaves(division, project);
	}

	@Override
	public List<CadreDTO> getAllcadre() {
		return employeeMasterDao.getAllcadre();
	}

	@Override
	public List<JobTypeDTO> getAlljobtype() {
		return employeeMasterDao.getAlljobtype();
	}

	@Override
	public List<DivisionDTO> getAllDivision(String fltStr) {
		return employeeMasterDao.getAllDivision(fltStr);
	}

	public List<ProjectDTO> getAllProjects(String fltStr) {
		return employeeMasterDao.getAllProjects(fltStr);
	}

	@Override
	public List<EmployeeMasterDTO> getEmpInfoByTranid(int tranid) {
		return employeeMasterDao.getEmpInfoByTranid(tranid);
	}

	@Override
	public List<EmployeeMasterDTO> getEmpInfoByIdno(int idno) {
		return employeeMasterDao.getEmpInfoByIdno(idno);
	}

	@Override
	public int getIdNumBasedOnDivision(int divid) {
		return employeeMasterDao.getIdNumBasedOnDivision(divid);
	}

	@Override
	public List<HrDepartmentMaster> getAllDepartment(String fltStr) {
		return employeeMasterDao.getAllDepartment(fltStr);
	}

	@Override
	public EmployeeMasterDTO getleave(int idno) {

		return employeeMasterDao.getleave(idno);
	}

	@Override
	public void storeDocuments(int idno, String fileName, MultipartFile photo, String description) {
		employeeMasterDao.storeDocuments(idno, fileName, photo, description);

	}

	@Override
	public void storeDoc1(int idno, BufferedImage photo) {
		employeeMasterDao.storeDoc1(idno, photo);

	}

	@Override
	public List<DocumentsDTO> getAllStoreDocumentByIdno(int idno) {
		return employeeMasterDao.getAllStoreDocumentByIdno(idno);
	}

	@Override
	public void deleteDocument(Integer tranid) {
		employeeMasterDao.deleteDocument(tranid);

	}

	@Override
	public List<Map<String,Object>> getAllEmployeeAndDepartment(int division, String otdate, String project) {
		return employeeMasterDao.getAllEmployeeAndDepartment(division, otdate, project);
	}

	@Override
	public DocumentsDTO getDocumentById(int tranid) {
		return employeeMasterDao.getDocumentById(tranid);

	}

	@Override
	public String editOtEntry(EmployeeMasterDTO employeemasterDTO) {
		return employeeMasterDao.editOtEntry(employeemasterDTO);

	}

	@Override
	public HashMap<String, Float> salaryCalculation(int division, Float basic) {

		return employeeMasterDao.salaryCalculation(division, basic);
	}

	@Override
	public HashMap<String, Float> salaryCalculationBasedonGrossSalary(int tranid, int division, Float grosssalary) {
		return employeeMasterDao.salaryCalculationBasedonGrossSalary(tranid, division, grosssalary);
	}

	@Override
	public HashMap<String, String> getUserAccess(String loginId) {
		return employeeMasterDao.getUserAccess(loginId); // To change body of generated methods, choose Tools |
															// Templates.
	}

	@Override
	public List<Map<String, Object>> getAllDesignationdropdown() {

		return employeeMasterDao.getAllDesignationdropdown();
	}

	@Override
	public List<BankMasterDTO> getAllBankMaster() {
		return employeeMasterDao.getAllBankMaster();
	}

	@Override
	public List<BankMasterDTO> getBankDetailsByIfsc(String ifsccode) {

		return employeeMasterDao.getBankDetailsByIfsc(ifsccode);
	}

	@Override
	public List<Map<String, Object>> getallcontractpersonnames() {

		return employeeMasterDao.getallcontractpersonnames();
	}

	@Override
	public int getIdNumBasedOnContract(int contractid) {

		return employeeMasterDao.getIdNumBasedOnContract(contractid);
	}

	@Override
	public void storeExcelDocuments(MultipartFile excel) {
		
		employeeMasterDao.storeExcelDocuments(excel);
	}

}
