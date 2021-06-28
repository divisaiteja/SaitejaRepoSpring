package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.Dao.EmployeeMasterDao;
import com.hrms.dtos.CadreDTO;
import com.hrms.dtos.DivisionDTO;
import com.hrms.dtos.DocumentsDTO;
import com.hrms.dtos.EmployeeMasterDTO;
import com.hrms.dtos.HrDepartmentMaster;
import com.hrms.dtos.JobDetailsDTO;
import com.hrms.dtos.JobTypeDTO;
import com.hrms.dtos.LeaveTypeDTO;
import com.hrms.dtos.ProjectDTO;
import com.hrms.dtos.SectionDTO;

@Service
public class EmployeeMasterServicesImpl implements EmployeeMasterServices {

	@Autowired
	private EmployeeMasterDao employeeMasterDao;

	@Override
	public List<EmployeeMasterDTO> getAllEmployees() {
		return employeeMasterDao.getAllEmployees();
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
	public List<EmployeeMasterDTO> getAllLeaves() {

		return employeeMasterDao.getAllLeaves();
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
	public List<DivisionDTO> getAllDivision() {
		// TODO Auto-generated method stub
		return employeeMasterDao.getAllDivision();
	}

	@Override
	public List<EmployeeMasterDTO> getEmpInfoByTranid(int tranid) {
		return employeeMasterDao.getEmpInfoByTranid(tranid);
	}

	@Override
	public int getIdNumBasedOnDivision(int divid) {
		// TODO Auto-generated method stub
		return employeeMasterDao.getIdNumBasedOnDivision(divid);
	}

	@Override
	public List<HrDepartmentMaster> getAllDepartment() {
		// TODO Auto-generated method stub
		return employeeMasterDao.getAllDepartment();
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
	public void storeDoc1(int idno,MultipartFile photo) {
		employeeMasterDao.storeDoc1(idno,photo);

	}

	@Override
	public List<DocumentsDTO> getAllStoreDocumentByIdno(int idno) {
		// TODO Auto-generated method stub
		return employeeMasterDao.getAllStoreDocumentByIdno(idno);
	}

	@Override
	public void deleteDocument(Integer tranid) {
		employeeMasterDao.deleteDocument(tranid);

	}

	@Override
	public List<EmployeeMasterDTO> getAllEmployeeAndDepartment(int division) {
		// TODO Auto-generated method stub
		return employeeMasterDao.getAllEmployeeAndDepartment(division);
	}

}
