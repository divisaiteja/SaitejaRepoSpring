package com.hrms.service;

import java.util.List;

import com.hrms.dtos.DivisionDTO;

public interface DivisionService {

	public List<DivisionDTO> getAllDivisons();

	public String saveNewDivision(DivisionDTO divisionDTO);

	public String editDivision(DivisionDTO divisionDTO);

	public void deleteDivision(int divisionid);

	public List<DivisionDTO> getDivision(int divisionid);
}
