package com.hrms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.ComplianceDao;
import com.hrms.dtos.ComplianceDTO;
@Service
public class ComplianceServiceImpl implements ComplianceService {

	@Autowired
	private ComplianceDao complianceDao;
	
	@Override
	public List<ComplianceDTO> getAllCompliance() {
		
		return complianceDao.getAllCompliance() ;
	}

	@Override
	public List<ComplianceDTO> getComplianceByComplianceid(int complianceid) {
	
		return complianceDao.getComplianceByComplianceid(complianceid);
	}

	@Override
	public String editCompliance(ComplianceDTO complianceDTO) {
		
		return complianceDao.editCompliance(complianceDTO);
	}

	@Override
	public void deleteCompliance(int complianceid) {
		complianceDao.deleteCompliance(complianceid);

	}

	@Override
	public String saveNewCompliance(ComplianceDTO complianceDTO) {
		
		return complianceDao.saveNewCompliance(complianceDTO);
	}

	@Override
	public void generateTransaction() {
		
		complianceDao.generateTransaction();
	}

	@Override
	public List<Map<Object, Object>> getOwnername() {
		
		return complianceDao.getOwnername();
	}

}
