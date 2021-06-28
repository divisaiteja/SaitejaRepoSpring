package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.SettingDao;
import com.hrms.dtos.ProfessionalTaxesDTO;
import com.hrms.dtos.SettingDTO;

@Service
public class SettingServiceImpl implements SettingService {

	@Autowired
	private SettingDao settingDao;

	@Override
	public List<SettingDTO> getAllSetting(int divisionid) {

		return settingDao.getAllSetting(divisionid);
	}

	@Override
	public void editSetting(SettingDTO settingDTO) {
		settingDao.editSetting(settingDTO);

	}

	@Override
	public List<ProfessionalTaxesDTO> getAllProfessionalTax(ProfessionalTaxesDTO professionalTaxesDTO) {
		
		return settingDao.getAllProfessionalTax(professionalTaxesDTO);
	}

	@Override
	public List<ProfessionalTaxesDTO> getAllProfessionalTaxByTranId(int tranId) {
		
		return settingDao.getAllProfessionalTaxByTranId(tranId);
	}
	
	@Override
	public void editProfessionalTax(ProfessionalTaxesDTO professionalTaxesDTO) {
		settingDao.editProfessionalTax(professionalTaxesDTO);
		
	}

	@Override
	public String savenewTax(ProfessionalTaxesDTO professionalTaxesDTO) {
		return settingDao.savenewTax(professionalTaxesDTO) ;
	}

}
