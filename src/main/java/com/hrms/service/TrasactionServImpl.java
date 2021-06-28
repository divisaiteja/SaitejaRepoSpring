package com.hrms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.Dao.TransactionDao;
import com.hrms.dtos.ComplianceDTO;
import com.hrms.dtos.DocumentsDTO;

@Service
public class TrasactionServImpl implements TrasacServ {
	
	@Autowired
	private TransactionDao trasactionDao;

	@Override
	public List<ComplianceDTO> getAllTransaction() {
	
		return trasactionDao.getAllTransaction();
	}

	@Override
	public List<ComplianceDTO> getTranscationBasedOnTranid(int tranid) {
		
		return trasactionDao.getTranscationBasedOnTranid(tranid);
	}

	@Override
	public List<DocumentsDTO> getAllComplianceTransactionUploadsBasedOnTranid(int tranid) {
		
		return trasactionDao.getAllComplianceTransactionUploadsBasedOnTranid(tranid) ;
	}

	@Override
	public void TransactionstoreDocuments(int tranid, List<MultipartFile> files) {
	
		trasactionDao.TransactionstoreDocuments(tranid, files);
	}

	@Override
	public void TransactiondeleteDocuments(int tranid) {
		
		trasactionDao.TransactiondeleteDocuments(tranid);
	}

	@Override
	public void TransactionPhoto(int tranid, List<MultipartFile> files,String remarks, String duedate,String Remidiationplan,String complied) {
		
		trasactionDao.TransactionPhoto(tranid, files,remarks,duedate,Remidiationplan,complied);
		
	}

	@Override
	public List<Map<Object, Object>> getFilenamesBasedOnTransactionid(Integer transactiontranid) {
		
		return trasactionDao.getFilenamesBasedOnTransactionid(transactiontranid);
	}

	@Override
	public List<Map<Object, Object>> getComplianceTrasactionBasedTranid(Integer transactiontranid) {
		
		return trasactionDao.getComplianceTrasactionBasedTranid(transactiontranid);
	}

	@Override
	public List<Map<Object, Object>> getRemidiationBasedTranid(Integer transactiontranid) {
		
		return trasactionDao.getRemidiationBasedTranid(transactiontranid);
	}
	
	@Override
	public String ApproverStatus(Integer transactiontranid,String approvertext) {
		
		return trasactionDao.ApproverStatus(transactiontranid,approvertext);
	}

	@Override
	public String RejectedStatus(Integer transactiontranid,String rejectedtext) {
		
		return trasactionDao.RejectedStatus(transactiontranid, rejectedtext);
	}

	

	

	

	

}
