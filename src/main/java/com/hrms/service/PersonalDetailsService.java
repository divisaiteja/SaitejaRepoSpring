package com.hrms.service;

import java.util.List;
import java.util.Map;

import com.hrms.dtos.PersonalDetailsDTO;

public interface PersonalDetailsService {
	
	public String editPersonalDetails(PersonalDetailsDTO personalDetailsDTO);

	public List<PersonalDetailsDTO> getpersonalInfoByParentid(int parentid);

	public List<Map<Object, Object>> getAllCity();

	public List<Map<Object, Object>> getAllDistrict();

}
