package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.GradeListDao;
import com.hrms.dtos.GradeListDTO;

@Service
public class GradeListServiceImpl implements GradeListService {
	@Autowired
	private GradeListDao gradeDao;

	@Override
	public List<GradeListDTO> getAllGrades() {
		
		return gradeDao.getAllGrades();
	}

	@Override
	public String editGrade(GradeListDTO gradelistDTO) {
		return this.gradeDao.editGrade(gradelistDTO);
		
	}

	@Override
	public void deleteGrade(Integer gradeno) {
	gradeDao.deleteGrade(gradeno);
		
	}

	@Override
	public String saveNewGrade(GradeListDTO gradelistDTO) {
		return gradeDao.saveNewGrade(gradelistDTO);
		
	}

	@Override
	public List<GradeListDTO> getGradeByGradeno(int gradeno) {
		// TODO Auto-generated method stub
		return gradeDao.getGradeByGradeno(gradeno);
	}
	

}
