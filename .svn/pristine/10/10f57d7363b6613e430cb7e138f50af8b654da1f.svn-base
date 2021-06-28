package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.FamilyDetailsDao;
import com.hrms.dtos.FamilyDetailsDTO;

@Service
public class FamilyDetailsServiceImpl implements FamilyDetailsService {
	@Autowired
	private FamilyDetailsDao familyDetailsDao;

	@Override
	public String saveFamilyDetails(FamilyDetailsDTO familyDetailsDTO) {
		return familyDetailsDao.saveFamilyDetails(familyDetailsDTO);

	}

	@Override
	public String editFamilyDetails(FamilyDetailsDTO familyDetailsDTO) {
		return familyDetailsDao.editFamilyDetails(familyDetailsDTO);

	}

	@Override
	public List<FamilyDetailsDTO> getAllFamilyDetails(int parentid) {

		return familyDetailsDao.getAllFamilyDetails(parentid);
	}

	@Override
	public void deleteFamilyDetails(Integer tranid) {
		familyDetailsDao.deleteFamilyDetails(tranid);

	}

	@Override
	public List<FamilyDetailsDTO> getFamilyInfoByTranid(int tranid) {
		return familyDetailsDao.getFamilyInfoByTranid(tranid);
	}

}
