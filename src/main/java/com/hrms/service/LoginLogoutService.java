package com.hrms.service;

import com.hrms.dtos.loginDto;

public interface LoginLogoutService {

	public String getLoginDetails(loginDto logindto);

	public String updatePassword(int idno, String confirmPassword);
}
