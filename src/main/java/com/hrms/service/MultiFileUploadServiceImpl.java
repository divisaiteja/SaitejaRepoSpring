package com.hrms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.Dao.MultiFileUploadDao;
import com.hrms.dtos.MultiFileUploadDTO;

@Service
public class MultiFileUploadServiceImpl implements MultiFileUploadService {

	@Autowired
	private MultiFileUploadDao FileUploadDao;
	
	@Override
	public String multiplefilesave(MultiFileUploadDTO multiFileUpload ) {
	
		return FileUploadDao.multiplefilesave(multiFileUpload );
	}

	@Override
	public void singlefilesave(Integer transactiontranid,String filename, MultipartFile document) {
		
		FileUploadDao.singlefilesave(transactiontranid, filename, document);
	}

}
