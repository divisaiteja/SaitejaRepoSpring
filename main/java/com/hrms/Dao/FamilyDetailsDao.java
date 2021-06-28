package com.hrms.Dao;

import java.util.List;

import com.hrms.dtos.EmployeeMasterDTO;
import com.hrms.dtos.FamilyDetailsDTO;

public interface FamilyDetailsDao {

	public String saveFamilyDetails(FamilyDetailsDTO familyDetailsDTO);

	public String editFamilyDetails(FamilyDetailsDTO familyDetailsDTO);

	public void deleteFamilyDetails(Integer tranid);

	public List<FamilyDetailsDTO> getAllFamilyDetails(int parentid);

	public List<FamilyDetailsDTO> getFamilyInfoByTranid(int tranid);

}
