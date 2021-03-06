package com.hrms.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hrms.dtos.ContractorDocumentsDTO;

public interface ContractorDocumentsService {

	public List<ContractorDocumentsDTO> getAllStoreDocumentByContractorId(int contractorId);

	public void storeDocuments(int contractorid, MultipartFile filecover,String documentdetails);

}
