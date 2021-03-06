package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.PersonalDetailsDao;
import com.hrms.dtos.PersonalDetailsDTO;

@Service
public class PersonalDetailsServiceImpl implements PersonalDetailsService {
	@Autowired
	private PersonalDetailsDao personalDetailsDao;

	@Override
	public String editPersonalDetails(PersonalDetailsDTO personalDetailsDTO) {
		return personalDetailsDao.editPersonalDetails(personalDetailsDTO);
	}

	@Override
	public List<PersonalDetailsDTO> getpersonalInfoByTranid(int tranid) {
		// TODO Auto-generated method stub
		return personalDetailsDao.getpersonalInfoByTranid(tranid);
	}

}
