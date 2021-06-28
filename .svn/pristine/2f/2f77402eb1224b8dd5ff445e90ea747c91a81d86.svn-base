package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.OthersDetailsDao;
import com.hrms.dtos.OthersDetailsDTO;

@Service

public class OthersDetailsServiceImpl implements OthersDetailsService {
	@Autowired
	private OthersDetailsDao othersDetailsDao;

	@Override
	public void saveOthersDetails(OthersDetailsDTO othersDetailsDTO) {
		othersDetailsDao.saveOthersDetails(othersDetailsDTO);

	}

	@Override
	public void editOthersDetails(OthersDetailsDTO othersDetailsDTO) {
		othersDetailsDao.editOthersDetails(othersDetailsDTO);
	}

	@Override
	public void deleteOthersDetails(Integer tranid) {
		othersDetailsDao.deleteOthersDetails(tranid);

	}

	@Override
	public List<OthersDetailsDTO> getAllDetails() {
		return othersDetailsDao.getAllDetails();
	}

	@Override
	public List<OthersDetailsDTO> getOtherDetailsInfoByTranid(int parentid) {
		return othersDetailsDao.getOtherDetailsInfoByTranid(parentid);
	}

}
