package com.hrms.Dao;

import java.util.List;

import com.hrms.dtos.ProfessionalTaxesDTO;
import com.hrms.dtos.SettingDTO;

public interface SettingDao {
	
public List<SettingDTO> getAllSetting(int divisionid );
public void editSetting(SettingDTO settingDTO);

public List<ProfessionalTaxesDTO> getAllProfessionalTax(ProfessionalTaxesDTO professionalTaxesDTO );
public void editProfessionalTax(ProfessionalTaxesDTO professionalTaxesDTO);
public List<ProfessionalTaxesDTO> getAllProfessionalTaxByTranId(int tranId);
}
