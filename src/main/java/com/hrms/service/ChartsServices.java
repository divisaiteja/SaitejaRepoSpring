package com.hrms.service;

import java.util.List;

import com.hrms.dtos.ChartsDTO;
import com.hrms.dtos.HrMusterDTO;

public interface ChartsServices {

	public List<ChartsDTO> getBarGraphsOnDivisons();

	public List<ChartsDTO> getDivisionBarGraphs();
	
	public List<ChartsDTO> getAbsentsBasedOnDivision(String date);

}
