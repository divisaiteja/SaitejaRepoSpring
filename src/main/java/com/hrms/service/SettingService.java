package com.hrms.service;

import java.util.List;

import com.hrms.dtos.ProfessionalTaxesDTO;
import com.hrms.dtos.SettingDTO;

public interface SettingService {
	public List<SettingDTO> getAllSetting(int divisionid );
	public void editSetting(SettingDTO settingDTO);
	public List<ProfessionalTaxesDTO> getAllProfessionalTax(ProfessionalTaxesDTO professionalTaxesDTO );
	public void editProfessionalTax(ProfessionalTaxesDTO professionalTaxesDTO);
	public List<ProfessionalTaxesDTO> getAllProfessionalTaxByTranId(int tranId);
	public String savenewTax(ProfessionalTaxesDTO professionalTaxesDTO);
}
