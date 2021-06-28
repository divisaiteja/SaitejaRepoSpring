package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.CadreDao;
import com.hrms.dtos.CadreDTO;

@Service
public class CadreServiceImpl implements CadreService {
	@Autowired
	private CadreDao cadreDao;

	@Override
	public List<CadreDTO> getAllCadres() {
		
		return cadreDao.getAllCadres();
	}

	@Override
	public List<CadreDTO> getCadreByTranid(int tranid) {
		// TODO Auto-generated method stub
		return cadreDao.getCadreByTranid(tranid);
	}

	@Override
	public String editCadre(CadreDTO cadreDto) {
      return  cadreDao.editCadre(cadreDto);
	}

	@Override
	public void deleteCadre(int tranid) {
        cadreDao.deleteCadre(tranid);		
	}

	@Override
	public String saveNewCadre(CadreDTO cadreDto) {
       return cadreDao.saveNewCadre(cadreDto);		
	}
	

}
