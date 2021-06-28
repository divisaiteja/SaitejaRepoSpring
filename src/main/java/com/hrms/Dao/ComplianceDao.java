package com.hrms.Dao;

import java.util.List;
import java.util.Map;

import com.hrms.dtos.ComplianceDTO;


public interface ComplianceDao {

	public List<ComplianceDTO> getAllCompliance();

	public List<ComplianceDTO> getComplianceByComplianceid(int complianceid);

	public String editCompliance(ComplianceDTO complianceDTO );

	public void deleteCompliance(int complianceid);

	public String saveNewCompliance(ComplianceDTO complianceDTO );
	
	public void generateTransaction( );
	
	public List<Map<Object,Object>> getOwnername();
	
}
