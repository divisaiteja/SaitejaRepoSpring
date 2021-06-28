package com.hrms.Dao;

import java.util.List;

import com.hrms.dtos.DivisionDTO;

public interface DivisionDao {

	public List<DivisionDTO> getAllDivisons();

	public String saveNewDivision(DivisionDTO divisionDTO);

	public String editDivision(DivisionDTO divisionDTO);

	public void deleteDivision(int divisionid);

	public List<DivisionDTO> getdivision(int divisionid);

}
