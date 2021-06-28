package com.hrms.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.IncrementsAndPromotionsDao;
import com.hrms.dtos.IncrementsDTO;

@Service
public class IncrementsAndPromotionsServiceImpl implements IncrementsAndPromotionsService {
	@Autowired
	private IncrementsAndPromotionsDao incrementsAndPromotionsDao;

	@Override

	public HashMap<String, Float> salaryCalculationBasedonGrossSalary(int idnumber, Float grosssalary) {
		return incrementsAndPromotionsDao.salaryCalculationBasedonGrossSalary(idnumber, grosssalary);
	}

	@Override
	public String saveIncrements(IncrementsDTO incrementsDTO) {
		return incrementsAndPromotionsDao.saveIncrements(incrementsDTO);
	}

}
