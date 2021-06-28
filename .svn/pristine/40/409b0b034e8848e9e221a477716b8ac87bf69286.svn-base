package com.hrms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.InnoInfotechDao;
import com.hrms.dtos.loginDto;


@Service
public class InnoInfotechServiceImpl implements InnoInfotechService {
	@Autowired
	private InnoInfotechDao innoInfotechDao;

	
	@Override
	public String getLoginDetails(loginDto logindto) {
		 return innoInfotechDao.getLoginDetails(logindto);
	}

}
