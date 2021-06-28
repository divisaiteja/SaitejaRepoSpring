package com.hrms.service;

import java.util.HashMap;

import com.hrms.dtos.IncrementsDTO;

public interface IncrementsAndPromotionsService {

	public HashMap<String, Float> salaryCalculationBasedonGrossSalary(int idnumber, Float grosssalary);

	public String saveIncrements(IncrementsDTO incrementsDTO);

}
