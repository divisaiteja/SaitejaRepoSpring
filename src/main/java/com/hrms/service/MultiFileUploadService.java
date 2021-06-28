package com.hrms.service;

import org.springframework.web.multipart.MultipartFile;

import com.hrms.dtos.MultiFileUploadDTO;

public interface MultiFileUploadService {
	
	public String multiplefilesave(MultiFileUploadDTO multiFileUpload);
	
	public void singlefilesave(Integer transactiontranid,String filename,MultipartFile document);

}
