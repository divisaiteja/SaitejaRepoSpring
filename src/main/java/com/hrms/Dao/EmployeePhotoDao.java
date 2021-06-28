package com.hrms.Dao;

import org.springframework.web.multipart.MultipartFile;

import com.hrms.dtos.EmployeePhotoDTO;

public interface EmployeePhotoDao {
	
	public EmployeePhotoDTO getphotobasedonempid(Integer empid);
	
	public EmployeePhotoDTO displayimageandpdf(String filename);
	
	public void LoginPhoto(MultipartFile canvas);
	

}
