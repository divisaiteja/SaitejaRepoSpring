package com.hrms.Dao;

import java.util.List;

import com.hrms.dtos.ChartsDTO;

public interface ChartsDao {
	public List<ChartsDTO> getBarGraphsOnDivisons();
}
