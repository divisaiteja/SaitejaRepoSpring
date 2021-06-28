package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.ExperienceDetailsDao;
import com.hrms.dtos.ExperienceDetailsDTO;

@Service
public class ExperienceDetailsServiceImpl implements ExperienceDetailsService {
	@Autowired
	private ExperienceDetailsDao experienceDetailsDao;

	@Override
	public String saveExperienceDetails(ExperienceDetailsDTO experienceDetailsDTO) {
		return experienceDetailsDao.saveExperienceDetails(experienceDetailsDTO);

	}

	@Override
	public String editExperienceDetails(ExperienceDetailsDTO experienceDetailsDTO) {
		return experienceDetailsDao.editExperienceDetails(experienceDetailsDTO);

	}

	@Override
	public void deleteExperienceDetails(Integer tranid) {
		experienceDetailsDao.deleteExperienceDetails(tranid);

	}

	@Override
	public List<ExperienceDetailsDTO> getAllExperienceDetails(int parentid) {
		return experienceDetailsDao.getAllExperienceDetails(parentid);
	}

	@Override
	public List<ExperienceDetailsDTO> getExperienceInfoByTranid(int tranid) {
		return experienceDetailsDao.getExperienceInfoByTranid(tranid);
	}

}
