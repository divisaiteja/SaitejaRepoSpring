package com.hrms.service;

import java.util.List;

import com.hrms.dtos.GradeListDTO;

public interface GradeListService {
	
	public List<GradeListDTO> getAllGrades();

	public String editGrade(GradeListDTO gradelistDTO);

	public void deleteGrade(Integer gradeno);

	public String saveNewGrade(GradeListDTO gradelistDTO);

	public List<GradeListDTO> getGradeByGradeno(int gradeno);
}
