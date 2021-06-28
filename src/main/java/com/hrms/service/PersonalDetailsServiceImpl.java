package com.hrms.service;

import java.util.List;
import java.util.Map;

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
	public List<PersonalDetailsDTO> getpersonalInfoByParentid(int parentid) {
		return personalDetailsDao.getpersonalInfoByParentid(parentid);
	}

	@Override
	public List<Map<Object, Object>> getAllCity() {
		return personalDetailsDao.getAllCity();
	}

	@Override
	public List<Map<Object, Object>> getAllDistrict() {
		return personalDetailsDao.getAllDistrict();
	}

}
