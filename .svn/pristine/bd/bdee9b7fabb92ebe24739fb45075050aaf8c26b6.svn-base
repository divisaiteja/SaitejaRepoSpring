package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.BankMasterDao;
import com.hrms.dtos.BankMasterDTO;

@Service
public class BankMasterServiceImpl implements BankMasterService {
	@Autowired
	private BankMasterDao bankMasterDao;

	@Override
	public List<BankMasterDTO> getAllBankMaster() {

		return bankMasterDao.getAllBankMaster();
	}

	@Override
	public String editBankMaster(BankMasterDTO bankMasterDTO) {

		return bankMasterDao.editBankMaster(bankMasterDTO);
	}

	@Override
	public void deleteBankMaster(Integer tranid) {
		bankMasterDao.deleteBankMaster(tranid);

	}

	@Override
	public String saveBankMaster(BankMasterDTO bankMasterDTO) {

		return bankMasterDao.saveBankMaster(bankMasterDTO);
	}

	@Override
	public List<BankMasterDTO> getBankMasterByTranId(int tranid) {

		return bankMasterDao.getBankMasterByTranId(tranid);
	}

}
