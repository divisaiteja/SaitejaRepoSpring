package com.hrms.service;

import java.util.List;

import com.hrms.dtos.ContractorMasterDTO;

public interface ContractorService {

	public List<ContractorMasterDTO> getAllContracts();

	public String saveNewContractor(ContractorMasterDTO contractorMasterDTO);

	public String editContractor(ContractorMasterDTO contractorMasterDTO);

	public void deleteContractor(int contractorId);

	public List<ContractorMasterDTO> getContractor(int contractorId);
}
