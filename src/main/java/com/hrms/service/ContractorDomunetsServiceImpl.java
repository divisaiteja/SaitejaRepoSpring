package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.Dao.ContractorDocumentsDao;
import com.hrms.dtos.ContractorDocumentsDTO;

@Service
public class ContractorDomunetsServiceImpl implements ContractorDocumentsService {
	@Autowired
	private ContractorDocumentsDao contractorDocumentsDao;

	@Override
	public List<ContractorDocumentsDTO> getAllStoreDocumentByContractorId(int contractorId) {
		return contractorDocumentsDao.getAllStoreDocumentByContractorId(contractorId);
	}

	@Override
	public void storeDocuments(int contractorid, MultipartFile filecover,String documentdetails) {
		this.contractorDocumentsDao.storeDocuments(contractorid, filecover, documentdetails);

	}

}
