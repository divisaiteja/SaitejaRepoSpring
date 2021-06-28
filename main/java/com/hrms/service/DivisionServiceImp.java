package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.DivisionDao;
import com.hrms.dtos.DivisionDTO;
@Service
public class DivisionServiceImp implements DivisionService {
	@Autowired 
	private DivisionDao dao;

	@Override
	public List<DivisionDTO> getAllDivisons() {
		
		return dao.getAllDivisons();
	}

	@Override
	public String saveNewDivision(DivisionDTO divisionDTO) {
	return	dao.saveNewDivision(divisionDTO);
		
	}

	@Override
	public String editDivision(DivisionDTO divisionDTO) {
		return dao.editDivision(divisionDTO);
		
	}

	@Override
	public void deleteDivision(int divisionid) {
		dao.deleteDivision(divisionid);
		
	}

	@Override
	public List<DivisionDTO> getDivision(int divisionid) {
		// TODO Auto-generated method stub
		return dao.getdivision(divisionid);
	}

}
