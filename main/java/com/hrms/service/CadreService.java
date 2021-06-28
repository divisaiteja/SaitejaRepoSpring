package com.hrms.service;

import java.util.List;

import com.hrms.dtos.CadreDTO;

public interface CadreService {

 public	List<CadreDTO> getAllCadres();

public List<CadreDTO> getCadreByTranid(int tranid);

public String editCadre(CadreDTO cadreDto);

public void deleteCadre(int tranid);

public String saveNewCadre(CadreDTO cadreDto);

}
