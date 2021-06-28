package com.hrms.Dao;

import java.util.List;

import com.hrms.dtos.ChartsDTO;
import com.hrms.dtos.HrMusterDTO;

public interface ChartsDao {
	
	public List<ChartsDTO> getBarGraphsOnDivisons();

	public List<ChartsDTO> getDivisionBarGraphs();
	
    public List<ChartsDTO> getAbsentsBasedOnDivision(String date);
}
