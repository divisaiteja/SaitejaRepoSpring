package com.hrms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.LoginLogoutDao;
import com.hrms.dtos.loginDto;

@Service
public class LoginLogoutServiceImpl implements LoginLogoutService {
	@Autowired
	private LoginLogoutDao loginLogoutDao;

	@Override
	public String getLoginDetails(loginDto logindto) {
		return loginLogoutDao.getLoginDetails(logindto);
	}

	@Override
	public String updatePassword(int idno, String confirmPassword) {
		return loginLogoutDao.updatePassword(idno, confirmPassword); 
	}

}
