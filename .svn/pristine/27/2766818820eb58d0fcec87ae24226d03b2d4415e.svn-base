package com.hrms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.UserLoginDao;
import com.hrms.dtos.UserLoginDTO;
@Service
public class UserLoginServiceImpl implements UserLoginService {
	@Autowired
	private UserLoginDao userLoginDao;

	@Override
	public void SaveuserDetails(UserLoginDTO userLoginDTO) {
		userLoginDao.SaveuserDetails(userLoginDTO);
	

	}

}
