package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.ContractDao;
import com.hrms.dtos.ContractorMasterDTO;

@Service
public class ContractorServiceImpl implements ContractorService {
	@Autowired
	private ContractDao contractDao;

	@Override
	public List<ContractorMasterDTO> getAllContracts() {
		return contractDao.getAllContracts();
	}

	@Override
	public String saveNewContractor(ContractorMasterDTO contractorMasterDTO) {
		return contractDao.saveNewContractor(contractorMasterDTO);
	}

	@Override
	public String editContractor(ContractorMasterDTO contractorMasterDTO) {
		return contractDao.editContractor(contractorMasterDTO);
	}

	@Override
	public void deleteContractor(int contractorId) {
		this.contractDao.deleteContractor(contractorId);

	}

	@Override
	public List<ContractorMasterDTO> getContractor(int contractorId) {
		return contractDao.getContractor(contractorId);
	}

}
