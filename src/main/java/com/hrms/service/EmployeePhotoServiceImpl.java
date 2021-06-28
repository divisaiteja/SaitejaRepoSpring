package com.hrms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.Dao.EmployeePhotoDao;
import com.hrms.dtos.EmployeePhotoDTO;

@Service
public class EmployeePhotoServiceImpl implements EmployeePhotoService {

	@Autowired
	private EmployeePhotoDao employeePhotoDao;
	
	

	@Override
	public EmployeePhotoDTO getphotobasedonempid(Integer empid) {
		
		return employeePhotoDao.getphotobasedonempid(empid);
	}



	@Override
	public EmployeePhotoDTO displayimageandpdf(String filename) {
		
		return employeePhotoDao.displayimageandpdf(filename);
	}



	@Override
	public void LoginPhoto(MultipartFile canvas) {
		employeePhotoDao.LoginPhoto(canvas);
		
	}



	



	



	

	

}
