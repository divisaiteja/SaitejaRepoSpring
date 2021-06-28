package com.hrms.Dao;

import java.util.List;

import com.hrms.dtos.GradeListDTO;


public interface GradeListDao {
	public List<GradeListDTO> getAllGrades();
	public String editGrade(GradeListDTO gradelistDTO);
	public void deleteGrade(Integer gradeno);
	public String saveNewGrade(GradeListDTO gradelistDTO);
	public List<GradeListDTO> getGradeByGradeno(int gradeno);

}
