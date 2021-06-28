package com.hrms.Dao;

import org.springframework.web.multipart.MultipartFile;

import com.hrms.dtos.MultiFileUploadDTO;


public interface MultiFileUploadDao {
	
	public String multiplefilesave(MultiFileUploadDTO multiFileUpload);
	
	public void singlefilesave(Integer transactiontranid,String filename,MultipartFile document);

}
