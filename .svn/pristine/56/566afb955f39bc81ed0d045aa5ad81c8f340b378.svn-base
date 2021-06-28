package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.EducationDetailsDao;
import com.hrms.dtos.EducationDetailsDTO;
@Service
public class EducationDetailsServiceImpl implements EducationDetailsService {
	@Autowired
	private EducationDetailsDao educationDao;

	@Override
	public String saveEducationDetails(EducationDetailsDTO educationDetailsDTO) {
		return educationDao.saveEducationDetails(educationDetailsDTO);

	}

	@Override
	public String editEducationDetails(EducationDetailsDTO educationDetailsDTO) {
		return educationDao.editEducationDetails(educationDetailsDTO);

	}

	@Override
	public void deleteEducationDetails(Integer tranid) {
		educationDao.deleteEducationDetails(tranid);
	}

	@Override
	public List<EducationDetailsDTO> getAllEducationDetails(int parentid) {
		// TODO Auto-generated method stub
		return  educationDao.getAllEducationDetails(parentid) ;
	}

	@Override
	public List<EducationDetailsDTO> getEducationInfoByTranid(int tranid) {
		// TODO Auto-generated method stub
		return educationDao.getEducationInfoByTranid(tranid);
	}

}
