package com.hrms.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.hrms.dtos.ComplianceDTO;
import com.hrms.dtos.DocumentsDTO;

public interface TrasacServ {

	public List<ComplianceDTO> getAllTransaction();

	public List<ComplianceDTO> getTranscationBasedOnTranid(int tranid);

	public List<DocumentsDTO> getAllComplianceTransactionUploadsBasedOnTranid(int tranid);

	public void TransactionstoreDocuments(int tranid, List<MultipartFile> files );

	public void TransactiondeleteDocuments(int tranid);
	
	public void TransactionPhoto(int tranid,List<MultipartFile> files,String remarks, String duedate,String Remidiationplan,String complied);
	
	public List<Map<Object, Object>> getFilenamesBasedOnTransactionid(Integer transactiontranid);

	public List<Map<Object, Object>> getComplianceTrasactionBasedTranid(Integer transactiontranid);
	
	public List<Map<Object, Object>> getRemidiationBasedTranid(Integer transactiontranid);
	
	public String ApproverStatus (Integer transactiontranid,String approvertext);
	
	public String RejectedStatus (Integer transactiontranid ,String rejectedtext);
	
}
